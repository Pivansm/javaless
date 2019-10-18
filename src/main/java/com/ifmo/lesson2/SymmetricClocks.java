package com.ifmo.lesson2;

public class SymmetricClocks {
    /*
    Электронные часы показывают время в формате от 00:00 до 23:59. Подсчитать сколько
    раз за сутки случается так, что слева от двоеточия показывается симметричная комбинация
    для той, что справа от двоеточия (например, 02:20, 11:11 или 15:51)
     */
    public static void main(String[] args) {
        System.out.println(symmetricTimes());
    }

    public static int symmetricTimes() {
        // TODO implement
        int n = 0;
        for(int i = 0; i<60; i++)
        {
            int p1 = i%10;
            int p2 = (i/10)%10;

            //System.out.print(p2 + " " + p1 + " : ");

            for(int j = 0; j<60; j++)
           {
               int p3 = j%10;
               int p4 = (j/10)%10;
               //System.out.println(p4 + " " + p3);

               if(p1 == p4)
                   if(p2 == p3)
                   {
                       //System.out.println(p2 + " " + p1 + " : " + p4 + " " + p3);
                       n++;
                   }
           }
        }

         return n;
    }
}
