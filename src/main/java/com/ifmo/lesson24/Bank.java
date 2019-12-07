package com.ifmo.lesson24;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.*;

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


    public static void main(String[] args) {
        // 1. Сгенерируйте пользователей и их аккаунты (все идентификаторы должны быть уникальны).
        // 2. Переводите деньги со случайного аккаунта на случайный в 100 потоках.
        // Другими словами, создайте 100 потоков или пул из 100 потоков, в которых
        // выполните перевод вызовом метода transferMoney().

        //int il = Runtime.getRuntime().availableProcessors();
        ExecutorService pool = Executors.newFixedThreadPool(100);

        List<Future<Map<String, Integer>>> futures = new ArrayList<>(100);

        Random rnd = new Random();
        List<String> NAME= List.of("Ivan", "Semen", "John", "Elena", "Alex");
        Bank bank = new Bank();

        //Генерация User
        for (int i = 0; i < 100; i++) {
            Bank.User user = new Bank.User(rnd.nextInt(i), NAME.get(rnd.nextInt(NAME.size())));
            Bank.Account account = new Bank.Account(rnd.nextInt(i), user.id, rnd.nextInt(i));
            bank.users.put((long)rnd.nextInt(i), user);
            bank.accounts.add(account);
        }


        for(int i = 0; i < 100; i++) {
            Bank.Account accountFrom = bank.accounts.get(i);
            Bank.Account accountTo = bank.accounts.get(i+1);

            Future future = pool.submit(() -> transferMoney(accountFrom, accountTo, 100));
            futures.add(future);
        }

    }


    // TODO Самая главная часть работы!
    public static void transferMoney(Account from, Account to, long amount) {
        // 1. Атомарно и потокобезопасно перевести деньги в количестве 'amount' со счёта 'from' на счёт 'to'.
        // 2. Создать объект Transaction, содержащий информацию об операции и отправить в очередь
        // потоку Logger, который проснётся и напечатает её.
        Bank bank = new Bank();
        Bank.Transaction tran = new Bank.Transaction(from.id, to.id, amount, true);

    }
}
