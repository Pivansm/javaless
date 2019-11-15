package com.ifmo.lesson14.calc;

import java.text.ParseException;
import java.util.Scanner;

/*
 * Добавьте поддержку переменных.
 * Синтаксис следующий.
 * Объявление переменной через символ '=':
 * x = 8
 *
 * Имя переменной не может быть числом.
 *
 * Использование в выражении вместо одного или двух аргументов:
 * x + 2
 * Результат: 10.
 *
 * Калькулятор должен выбрасывать соответствующие исключения с
 * подробными описаниями ошибок и как их исправить. Например,
 * если имя переменной не найдено или использовался неверный синтаксис.
 */
public class SimpleCalc {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try
        {
           parsPermn(scanner.nextLine());
        }
        catch (ParseException ex) {
            System.out.print("Кривая переменная!");
            ex.printStackTrace();
        }


        while (true) {
            System.out.println("Enter expression: ");

            String line = scanner.nextLine();

            if ("exit".equals(line))
                break;

            try {
                System.out.println("Answer is: " + calculate(line));
            }
            catch (CalcException e) {
                System.err.println("Error occurred: ");

                e.printStackTrace();
            }
        }
    }

    private static void parsPermn(String scan) throws ParseException
    {
         if(scan.length() == 0)  throw new ParseException("Errvff", 0);
         String os = scan.replace(" ", "");
         boolean flg = false;
         int oui = 0;
         String cif = "0";
        if (os.contains("=")) {

        for(int i = 0; i<os.length(); i++)
         {
             if(Character.isDigit(os.charAt(0))) {
                 throw new ParseException("Errvff", 0);
             }

             if(flg) {
                 cif = os.substring(i, os.length());
                 break;
             }

             if(os.charAt(i) == '=')  flg = true;

         }

        }

        try
        {
            oui = Integer.parseInt(cif);
            System.out.println("Asnswer is: " + cif);
        }
        catch (Exception ex)
        {
            System.out.print("кривое значение");
        }


    }

    static int calculate(String line) throws CalcException {
        if (!line.contains("+") && !line.contains("-"))
            throw new CalcException("Expression must contain '+' or '-': " + line);

        String[] operands = line.split(" ");

        if (operands.length != 3)
            throw new CalcException("Expression must have only 3 operands separated with space (e.g. 2 + 4): " + line);

        OPERATOR operator = OPERATOR.parse(operands[1]);

        int op1 = parseOperand(operands[0]);
        int op2 = parseOperand(operands[2]);

        return operator.apply(op1, op2);
    }

    private static int parseOperand(String string) throws CalcException {
        try {
            return Integer.parseInt(string);
        }
        catch (NumberFormatException e) {
            throw new CalcException("Wrong operand, must be only integer number: " + string, e);
        }
    }

    private enum OPERATOR {
        PLUS, MINUS;

        int apply(int arg1, int arg2) throws CalcException {
            switch (this) {

                case PLUS:
                    return arg1 + arg2;

                case MINUS:
                    return arg1 - arg2;
            }

            throw new CalcException("Unsupported operator: " + this);
        }

        static OPERATOR parse(String str) throws CalcException {
            switch (str) {
                case "+":
                    return PLUS;

                case "-":
                    return MINUS;
            }

            throw new CalcException("Incorrect operator: " + str);
        }
    }
}
