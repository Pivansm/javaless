package com.ifmo.lesson14.calc;


import com.ifmo.lesson7.Book;

import java.text.ParseException;
//import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.*;

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

        Map<String, Integer> map = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        Pattern p = Pattern.compile("^([a-zA-Z])+\\d*\\s*=\\s*-*\\d+$|^(\\d)+\\s*(\\+|-)+\\s*\\d+$");
        String ilin = scanner.nextLine();
        Matcher m = p.matcher(ilin);
        if(!m.matches()) {
            System.out.print("Кривая переменная! Имя переменной не может быть числом.");
        }
        else
        {
            String[] str1 = ilin.split("=");
            if(str1.length > 1) {
                map.put(str1[0].replace(" ", ""), Integer.parseInt(str1[1].replace(" ", "")));
                System.out.println("Answer is: " + str1[1]);
             }
            else
            {
                try {
                    System.out.println("Answer is: " + calculate(ilin));
                }
                catch (CalcException e) {
                    System.err.println("Error occurred: ");

                    e.printStackTrace();
                }
            }

        }

        while (true) {
            System.out.println("Enter expression: ");

            String line = scanner.nextLine();

            p = Pattern.compile("^([a-zA-Z])+\\d*\\s*(=|\\+|-)+\\s*\\d+$|^(\\d)*\\s*(\\+|-)+\\s*\\d+$||([a-zA-Z])+\\d*\\s*(\\+|-)+\\s*([a-zA-Z])+\\d*$|exit");
            m = p.matcher(line);
            if(!m.matches()) {
                System.out.print("Кривая переменная или значение!");
                continue;
            }
            else {
                p = Pattern.compile("^([a-zA-Z])+\\d*\\s*=+\\s*-*\\d+$");
                m = p.matcher(line);
                if(m.matches()) {
                    String[] str2 = line.split("=");
                    if (str2.length > 1) {
                        map.put(str2[0].replace(" ", ""), Integer.parseInt(str2[1].replace(" ", "")));
                        continue;
                    }
                }
                p = Pattern.compile("^([a-zA-Z])+\\d*\\s*(\\+|-)+\\s*\\d+$|^([a-zA-Z])+\\d*\\s*(\\+|-)+\\s*([a-zA-Z])+\\d*$");
                m = p.matcher(line);
                if(m.matches()) {
                    boolean flgfnd = false;
                    for(Map.Entry<String, Integer> item : map.entrySet()) {
                        String prmt = item.getKey();
                        int cntBook = item.getValue();
                        line = line.replace(prmt, "" + cntBook);
                    }
                    p = Pattern.compile("([a-zA-Z])+");
                    m = p.matcher(line);
                    if(m.find()) {
                        System.out.println("Нет переменной: '" + m.group() + "'");
                        continue;
                    }

                }

            }

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
