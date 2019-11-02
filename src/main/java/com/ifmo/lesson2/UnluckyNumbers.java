package com.ifmo.lesson2;

public class UnluckyNumbers {
    /*
    В американской армии считается несчастливым число 13, а в японской — 4. Перед
    международными учениями штаб российской армии решил исключить номера боевой
    техники, содержащие числа 4 или 13 (например, 40123, 13313, 12345 или 13040), чтобы не
    смущать иностранных коллег. Если в распоряжении армии имеется 100 тыс. единиц боевой
    техники и каждая боевая машина имеет номер от 00001 до 99999, то сколько всего номеров
    придётся исключить?
     */
    public static void main(String[] args) {
        System.out.println(unluckyNumbersCount());
    }

    public static int unluckyNumbersCount() {
        // TODO implement
        int cnt = 0;
        String s;
        for(int i = 1; i<= 99999; i++)
        {
            s = String.format("%05d", i);
            //System.out.println(s);
            for(int j = 0; j <s.length(); j++) {
                if (s.charAt(j) == '4') {
                    cnt++;
                    //System.out.println(s);
                    break;
                }
                if (s.charAt(j) == '3' && (j - 1 >=0 && s.charAt(j-1) == '1')) {
                    cnt++;
                    break;
                }


            }


        }

        return cnt;
    }
}
