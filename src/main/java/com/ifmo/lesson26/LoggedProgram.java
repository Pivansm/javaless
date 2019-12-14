package com.ifmo.lesson26;

import java.io.IOException;
import java.util.logging.*;
import java.util.*;

public class LoggedProgram {
    // Создаем логгер для нашего класса
    private static final Logger LOGGER = Logger.getLogger(LoggedProgram.class.getName());

    static {
// Устанавливаем уровень логирования (необязательно)
        LOGGER.setLevel(Level.ALL);

        try {
// Добавляем логирование в файл
            LOGGER.addHandler(new FileHandler("java.log"));

            // Добавим вывод в виде простого текста
            FileHandler simpleFileHandler = new FileHandler("java.log");
            simpleFileHandler.setFormatter(new SimpleFormatter());
            LOGGER.addHandler(simpleFileHandler);
        }
        catch (IOException e) {
            LOGGER.warning("Cannot configure file handler");
        }
    }
    public static void main(String[] args) {
// Выводим сообщение на уровне INFO
        LOGGER.info("Started with arguments: " + Arrays.toString(args));
        try {
            int res = 2 / 0; // ожидаем ArithmeticException
            LOGGER.info("This code should never be called");
        }
        catch (Exception e) {
// Выводим сообщение на уровне SEVERE как фатальная ошибка
            LOGGER.severe("Fatal error: " + e.getMessage());
        }
    }
}
