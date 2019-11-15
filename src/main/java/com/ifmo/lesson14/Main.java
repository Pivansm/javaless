package com.ifmo.lesson14;

public class Main {
    public static void main(String[] args) {

    }


    public class MyCoolUncheckedException extends RuntimeException {
        public MyCoolUncheckedException(String message) {
            super(message);
        }
        public MyCoolUncheckedException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public class MyCoolCheckedException extends Exception {
        public MyCoolCheckedException(String message) {
            super(message);
        }
        public MyCoolCheckedException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
