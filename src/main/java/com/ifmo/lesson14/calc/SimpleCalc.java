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
        String startLine = scanner.nextLine();
        try {
            String curr = parsLine(startLine, map);
        }
        catch (ParseException ex)
        {
            System.out.println("Неправильная переменная : " + startLine);
            ex.printStackTrace();
        }


        while (true) {
            System.out.println("Enter expression: ");

            String line = scanner.nextLine();

            try {
                line = parsLine(line, map);
                if(line.contains("=")) continue;
            }
            catch (ParseException ex)
            {
                System.out.println("Неправильная переменная : " + startLine);
                ex.printStackTrace();
                continue;
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

    private void parsLineRegx(String scan, Map map) throws ParseException
    {
        Pattern p = Pattern.compile("^([a-zA-Z])+\\d*\\s*=\\s*-*\\d+$|^(\\d)+\\s*(\\+|-)+\\s*\\d+$");

        Matcher m = p.matcher(scan);
        if(!m.matches()) {
            System.out.print("Кривая переменная! Имя переменной не может быть числом.");
        }
        else
        {
            String[] str1 = scan.split("=");
            if(str1.length > 1) {
                map.put(str1[0].replace(" ", ""), Integer.parseInt(str1[1].replace(" ", "")));
                System.out.println("Answer is: " + str1[1]);
            }
            else
            {
                try {
                    System.out.println("Answer is: " + calculate(scan));
                }
                catch (CalcException e) {
                    System.err.println("Error occurred: ");

                    e.printStackTrace();
                }
            }

        }
    }

    private void parsLineRgx2(String scan, Map map ) {
        Pattern p = Pattern.compile("^([a-zA-Z])+\\d*\\s*(=|\\+|-)+\\s*-*\\d+$|^(\\d)*\\s*(\\+|-)+\\s*\\d+$|([a-zA-Z])+\\d*\\s*(\\+|-)+\\s*([a-zA-Z])+\\d*$|exit");
        Matcher m = p.matcher(scan);
        if(!m.matches()) {
            System.out.println("Кривая переменная или значение!");
            //return null;
        }
        else {
            p = Pattern.compile("^([a-zA-Z])+\\d*\\s*=+\\s*-*\\d+$");
            m = p.matcher(scan);
            if(m.matches()) {
                String[] str2 = scan.split("=");
                if (str2.length > 1) {
                    map.put(str2[0].replace(" ", ""), Integer.parseInt(str2[1].replace(" ", "")));
                }
            }
            p = Pattern.compile("^([a-zA-Z])+\\d*\\s*(\\+|-)+\\s*\\d+$|^([a-zA-Z])+\\d*\\s*(\\+|-)+\\s*([a-zA-Z])+\\d*$");
            m = p.matcher(scan);
            if(m.matches()) {
                String[] operands = scan.split(" ");

                if(map.containsKey(operands[0])) operands[0] = map.get(operands[0]).toString();
                if(map.containsKey(operands[2])) operands[2] = map.get(operands[2]).toString();

                scan = operands[0] + " " + operands[1] + " " + operands[2];
                //System.out.println(": " + line);
                p = Pattern.compile("([a-zA-Z])+");
                m = p.matcher(scan);
                if(m.find()) {
                    System.out.println("Нет переменной: '" + m.group() + "'");
                    //continue;
                }

            }

        }
    }

    private static String parsLine(String scan, Map map) throws ParseException
    {
        int oui = 0;
        Pattern p;
        Matcher m;
        if(scan.length() == 0)  throw new ParseException("Пустая строка", 0);

         String[] operands = scan.split(" ");
         if(operands[1].contains("="))
         {
             p = Pattern.compile("([a-zA-Z])+");
             m = p.matcher(operands[0]);
             if(m.find()) {

                 oui = Integer.parseInt(operands[2].replace(" ", ""));

                 map.put(operands[0].replace(" ", ""), oui);
                 System.out.println("Answer is: " + oui);
                 return scan;
             }
             else
             {
                 throw new ParseException("Нет переменной: '" + m.group() + "'", 0);
             }

         }
         else
         {
             p = Pattern.compile("^([a-zA-Z])+\\d*\\s*(\\+|-)+\\s*\\d+$|^([a-zA-Z])+\\d*\\s*(\\+|-)+\\s*([a-zA-Z])+\\d*$");
             m = p.matcher(scan);
             if(m.matches()) {
                 String[] str2 = scan.split(" ");

                 if(map.containsKey(str2[0])) str2[0] = map.get(str2[0]).toString();
                 if(map.containsKey(str2[2])) str2[2] = map.get(str2[2]).toString();

                 scan = str2[0] + " " + str2[1] + " " + str2[2];
                 //System.out.println(": " + line);
                 p = Pattern.compile("([a-zA-Z])+");
                 m = p.matcher(scan);
                 if(m.find()) {
                     throw new ParseException("Нет переменной: '" + m.group() + "'", 0);
                  }

                 return scan;

             }
         }

        return scan;
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
