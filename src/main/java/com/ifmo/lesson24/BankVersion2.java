package com.ifmo.lesson24;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankVersion2 {
    private Map<Long, BankVersion2.User> users = new ConcurrentHashMap<>();
    private List<BankVersion2.Account> accounts = new CopyOnWriteArrayList<>();

    private static class User {
        private final long id;
        private final String name;

        private User(long id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    private static class Account {
        private final long id;
        private final long userId;
        private long amount;

        private Account(long id, long userId, long amount) {
            this.id = id;
            this.userId = userId;
            this.amount = amount;
        }
    }

    private static class Transaction {
        private final BigInteger transactionId;
        private final long fromAccountId;
        private final long toAccountId;
        private final long amount;
        private final boolean success;

        private Transaction(long fromAccountId, long toAccountId, long amount, boolean success) {
            this.success = success;
            this.transactionId = new BigInteger("" + System.currentTimeMillis() + fromAccountId + toAccountId + amount);
            this.fromAccountId = fromAccountId;
            this.toAccountId = toAccountId;
            this.amount = amount;
        }

        @Override
        public String toString() {
            return "Transaction{" +
                    "transactionId=" + transactionId +
                    ", fromAccountId=" + fromAccountId +
                    ", toAccountId=" + toAccountId +
                    ", amount=" + amount +
                    ", success=" + success +
                    '}';
        }
    }

    public static Object object = new Object();
    private static List<String> NAME= List.of("Ivan", "Semen", "John", "Elena", "Alex", "Vasya");
    private static Lock lock = new ReentrantLock();
    private static boolean flag = false;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 1. Сгенерируйте пользователей и их аккаунты (все идентификаторы должны быть уникальны).
        // 2. Переводите деньги со случайного аккаунта на случайный в 100 потоках.
        // Другими словами, создайте 100 потоков или пул из 100 потоков, в которых
        // выполните перевод вызовом метода transferMoney().

        ExecutorService pool = Executors.newFixedThreadPool(100);

        Random rnd = new Random();
        BankVersion2 bank = new BankVersion2();
        //Bank.User user = null;

        //Генерация User
        for (int i = 0; i < 100; i++) {
            BankVersion2.User user = new BankVersion2.User(i, NAME.get(rnd.nextInt(NAME.size())));
            BankVersion2.Account account = new BankVersion2.Account(i, user.id, rnd.nextInt(1000));
            bank.users.put((long) i, user);
            bank.accounts.add(account);
        }
        //System.out.println("" + bank.accounts);

        List<Future<BankVersion2.Transaction>> futures = new ArrayList<>(100);
        for(int i = 0; i < 100; i++) {
            BankVersion2.Account accountFrom = bank.accounts.get(rnd.nextInt(100));
            BankVersion2.Account accountTo = bank.accounts.get(rnd.nextInt(100));
            //Future<Bank.Transaction> future = pool.submit(() -> transferMoney(accountFrom, accountTo, 100));
            Future<BankVersion2.Transaction> future = pool.submit(new BankVersion2.TransLogger(accountFrom, accountTo, rnd.nextInt(1000)));
            futures.add(future);
        }
        pool.shutdown();
        for (Future<BankVersion2.Transaction> future : futures) {
            BankVersion2.Transaction account = future.get();
            System.out.println("" + account.toString());
        }
        //pool.shutdown();
    }

    // TODO Самая главная часть работы!
    public static void transferMoney(BankVersion2.Account from, BankVersion2.Account to, long amount) {
        // 1. Атомарно и потокобезопасно перевести деньги в количестве 'amount' со счёта 'from' на счёт 'to'.
        // 2. Создать объект Transaction, содержащий информацию об операции и отправить в очередь
        // потоку Logger, который проснётся и напечатает её.
        Logger logger;

        //boolean flag = false;
        synchronized(Bank.class) {
            //synchronized(object) {
            if (from.amount - amount < 0) {
                flag = false;
                System.out.println("Acc from: " + from.id + " acc to " + to.id + " flag  " + flag);
            }
            else {
                from.amount -= amount;
                to.amount += amount;
                System.out.println("Acc from: " + from.id + " acc to " + to.id + " amount " + amount);
                flag = true;
            }

        }

    }

    private static class Logger implements Runnable {
        BankVersion2.Transaction tran;

        public Logger(BankVersion2.Transaction tran) {
            this.tran = tran;
        }

        @Override
        public void run() {
            System.out.println("Logger проснулся " + Thread.currentThread().getName());
            lock.lock();
            System.out.println("" + tran.toString());
            lock.unlock();

        }
    }

    private static class TransLogger implements Callable<BankVersion2.Transaction> {
        BankVersion2.Account from;
        BankVersion2.Account to;
        long amount;

        public TransLogger(BankVersion2.Account from, BankVersion2.Account to, long amount) {
            this.from = from;
            this.to = to;
            this.amount = amount;
            flag = false;
        }

        @Override
        public BankVersion2.Transaction call() throws Exception {

            transferMoney(from, to, amount);
            BankVersion2.Transaction tran = new BankVersion2.Transaction(from.id, to.id, amount, flag);
            return tran;
        }
    }
}
