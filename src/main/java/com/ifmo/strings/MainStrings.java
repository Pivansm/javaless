package com.itmo.strings;

import java.util.Arrays;

/**
 * Created by xmitya on 11.09.16.
 */
public class MainStrings {
    public static void main(String[] args) {
        if (!MainStrings.class.desiredAssertionStatus())
            throw new AssertionError("Assertions are not enabled. To enable set '-ea' JVM argument");

        // Declare and create string
        String s1 = "string";
        String s2 = "string";

        assert s1 == s2;

        String s3 = new String("string");

        assert s1 != s3;
        assert s1.equals(s3);

        assert "23".equals(String.valueOf(23));
        assert "23.1234".equals(String.valueOf(23.1234));

        // Concatenation
        String s4 = "str" + "ing";

        assert "string".equals(s4);
        assert "string".equals("str" + "ing");

        assert "string2".equals("string" + 2);
        assert "stringstring".equals(s1.concat(s1));

        String s5 = "";
        s5 += "s";
        s5 += "tring";

        assert "string".equals(s5);

        // Formatting string
        assert "Formatted string with 10 values".equals(String.format("Formatted string with %s values", 10));

        // Week operations
        // Hash code of the same strings is always equal (Actually it ss general contract for equals()/hashCode())
        assert s1.hashCode() == s2.hashCode();

        // Length of string (number of chars)
        assert s1.length() == 6;

        // Position of chars
        assert s1.indexOf('i') == 3;
        assert 'i' == s1.charAt(3);

        // String comparison
        assert "string".compareTo("string") == 0;
        assert "string0".compareTo("string1") < 0;
        assert "String".compareTo("string") < 0;
        assert "String".compareToIgnoreCase("string") == 0;

        assert "StRinG".equalsIgnoreCase("string");

        String[] strings = {"Nick", "Fred", "Jack", "Michael", "Josh", "Zack"};

        // Use string comparison for sorting
        Arrays.sort(strings);

        assert "[Fred, Jack, Josh, Michael, Nick, Zack]".equals(Arrays.toString(strings));

        // Search substrings
        assert "string".startsWith("st");
        assert "string".endsWith("ing");

        assert "Hello world!".contains("world");
        assert "Hello world world!".indexOf("world") == 6;
        assert "Hello world world!".lastIndexOf("world") == 12;
        assert "Hello world!".substring(6, 11).equals("world");

        // Create large strings in loops
        // String builder helps to save system resources
        StringBuilder sb = new StringBuilder();
        String largeString = "";

        for (int i = 0; i < 10; i++) {
            sb.append("num: ").append(i).append(", ");

            // much more expensive operation
            largeString += "num: " + i + ", ";
        }

        assert largeString.equals(sb.toString());
    }


    /*
    * Tasks:
    * - Write method that compares two strings.
    * - Write contains() method.
    * - Write countChars() method.
    * */

    public static boolean compareStrings(String string1, String string2) {
        // TODO implement
        // Hint: use loop over string chars and compare one-by-one.
        // Use length() and charAt() methods.

        return false;
    }

    public static boolean containsString(String string, String substring) {
        // TODO implement
        // Hint: use two loops over strings and compare chars one-by-one.
        // Use length() and charAt() methods.

        return false;
    }

    public static int countChars(String string, char c) {
        // TODO implement
        // Hint: Use loop over string chars. Use charAt() method

        return 0;
    }
}
