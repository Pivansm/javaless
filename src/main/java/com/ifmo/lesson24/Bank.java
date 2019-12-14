package com.ifmo.lesson24;

import com.ifmo.lesson4.LinkedList;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class Bank {


    private Map<Long, User> users = new ConcurrentHashMap<>();
    private List<Account> accounts = new CopyOnWriteArrayList<>();

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
    //private static ExecutorService pool = Executors.newFixedThreadPool(1);
    //private static ExecutorService pool = Executors.newSingleThreadExecutor();
    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 1. Сгенерируйте пользователей и их аккаунты (все идентификаторы должны быть уникальны).
        // 2. Переводите деньги со случайного аккаунта на случайный в 100 потоках.
        // Другими словами, создайте 100 потоков или пул из 100 потоков, в которых
        // выполните перевод вызовом метода transferMoney().

        ExecutorService pool = Executors.newFixedThreadPool(8);

        Random rnd = new Random();
        Bank bank = new Bank();
        //Bank.User user = null;

        //Генерация User
        for (int i = 0; i < 100; i++) {
            Bank.User user = new Bank.User(i, NAME.get(rnd.nextInt(NAME.size())));
            Bank.Account account = new Bank.Account(i, user.id, rnd.nextInt(1000));
            bank.users.put((long) i, user);
            bank.accounts.add(account);
        }

        System.out.println("" + bank.accounts);

        for (int i = 0; i < 100; i++) {
            pool.submit(() -> {
                System.out.println("--" + Thread.currentThread().getName());
                Account accountFrom = bank.accounts.get(rnd.nextInt(100));
                Account accountTo = bank.accounts.get(rnd.nextInt(100));
                transferMoney(accountFrom, accountTo, rnd.nextInt(1000));
              });
        }

        /*List<Future> futures = new ArrayList<>(100);

        for(int i = 0; i < 100; i++) {
            Bank.Account accountFrom = bank.accounts.get(rnd.nextInt(100));
            Bank.Account accountTo = bank.accounts.get(rnd.nextInt(100));
            Future future = pool.submit(() -> transferMoney(accountFrom, accountTo, 100));
            futures.add(future);
        }*/

        //for (Future<Bank.Transaction> future : futures) {
        //    Bank.Transaction account = future.get();
        //    counts.add(account);
        //}

        //System.out.println("" + counts.toString());

        pool.shutdown();

    }

    // TODO Самая главная часть работы!
    public static void transferMoney(Account from, Account to, long amount) {
        // 1. Атомарно и потокобезопасно перевести деньги в количестве 'amount' со счёта 'from' на счёт 'to'.
        // 2. Создать объект Transaction, содержащий информацию об операции и отправить в очередь
        // потоку Logger, который проснётся и напечатает её.
        Logger logger;

        boolean flag = false;
        //synchronized(Bank.Account.class) {
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

            //Транзакция
             lock.lock();
              Bank.Transaction tran = new Bank.Transaction(from.id, to.id, amount, flag);
              logger = new Logger(tran);
              new Thread(logger, "logger").start();
            lock.unlock();
         }

    }

    private static class Logger implements Runnable {
        Bank.Transaction tran;

        public Logger(Bank.Transaction tran) {
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
}
