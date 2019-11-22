package com.ifmo.lesson14.calc;


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

    private static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {

        //map = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter expression: ");

            String line = scanner.nextLine();
            if ("exit".equals(line))
                break;

            /*try {
                line = parsLine2(line, map);
                if(line.contains("=")) continue;
            }
            catch (ParseException ex)
            {
                System.out.println("Неправильная переменная : " + line);
                ex.printStackTrace();
                continue;
            }*/

            try {
                System.out.println("Answer is: " + calculate(line));
            }
            catch (CalcException e) {
                System.err.println("Error occurred: ");
                e.printStackTrace();
            }
        }
    }

    private static String parsLine2(String scan, Map map) throws ParseException {

        if(scan.length() == 0)  throw new ParseException("Пустая строка", 0);
        String[] str1 = scan.split(" ");
         if (str1.length != 3)
            throw new ParseException("Expression must have only 3 operands separated with space (e.g. 2 + 4): " + scan, 0);
         if(scan.contains("=")) {
             try {
                int param = Integer.parseInt(str1[0]);
                System.out.print("Параметр не должен быть целым числом!");
                throw new ParseException("Параметр не должен быть целым числом! " + scan, 0);

            } catch (NumberFormatException ex)
            {
                 System.out.print("");
            }
            map.put(str1[0], Integer.parseInt(str1[2]));
            return scan;
        }
        else
        {
            if(map.containsKey(str1[0])) str1[0] = map.get(str1[0]).toString();
            if(map.containsKey(str1[2])) str1[2] = map.get(str1[2]).toString();
            scan = str1[0] + " " + str1[1] + " " + str1[2];
            try {
                int param = Integer.parseInt(str1[0]);

            } catch (NumberFormatException ex)
            {
                throw new ParseException("Параметр не должен быть целым числом! " + scan, 0);
            }
        }

        return scan;
    }

    private static String parsLine(String scan, Map map) throws ParseException
    {
        int oui = 0;
        Pattern p;
        Matcher m;
        if(scan.length() == 0)  throw new ParseException("Пустая строка", 0);

         String[] operands = scan.split(" ");
         if(operands.length > 1 && operands[1].contains("="))
         {
             p = Pattern.compile("([a-zA-Z])+");
             m = p.matcher(operands[0]);
             if(m.find()) {

                 try {
                     oui = Integer.parseInt(operands[2]);
                 }
                 catch (Exception e)
                 {
                     System.out.println("Неверное значение в строке : '" + scan + "'");
                     throw new ParseException("Неверное значение в строке : '" + scan + "'", 0);
                 }

                 map.put(operands[0], oui);
                 System.out.println("Answer is: " + oui);
                 return scan;
             }
             else
             {
                 throw new ParseException("Нет переменной в строке : '" + scan + "'", 0);
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
         /*try {
                line = parsLine2(line, map);
                if(line.contains("=")) {
                    String[] str2 = line.split(" ");
                    line = "0" + " " + "+" + " " + str2[2];
                }
            }
            catch (ParseException ex) {
                System.out.println("Неправильная переменная : " + line);
                throw new CalcException("Expression must contain '+' or '-': " + line);
            }*/
        //if(line.contains("=")) throw new CalcException("Expression must contain '+' or '-': " + line);
        if(line.matches("^([a-zA-Z])+\\d*\\s*=\\s*-*\\d+$")) {
            String[] str2 = line.split(" ");
            try {
                map.put(str2[0], Integer.parseInt(str2[2]));
            }
            catch (Exception ex)
            {
                throw new CalcException("Нет переменной: '" +  line + "'");
            }
            line = "0" + " " + "+" + " " + str2[2];
        }
        if(line.matches("^([a-zA-Z])+\\d*\\s*(\\+|-)+\\s*\\d+$|^([a-zA-Z])+\\d*\\s*(\\+|-)+\\s*([a-zA-Z])+\\d*$")) {
            String[] str2 = line.split(" ");
            if(map.containsKey(str2[0])) str2[0] = map.get(str2[0]).toString();
            if(map.containsKey(str2[2])) str2[2] = map.get(str2[2]).toString();
            line =  str2[0] + " " + str2[1] + " " + str2[2];
            Pattern pattern = Pattern.compile("([a-zA-Z])+");
            Matcher matcher = pattern.matcher(line);
            if(matcher.find()) {
                throw new CalcException("Нет переменной: '" + matcher.group() + "'");
            }
        }


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
