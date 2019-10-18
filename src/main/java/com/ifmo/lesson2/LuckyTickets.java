package com.ifmo.lesson2;

public class LuckyTickets {
    /*
    В городе N проезд в трамвае осуществляется по бумажным отрывным билетам. Каждую
    неделю трамвайное депо заказывает в местной типографии рулон билетов с номерами от
    000001 до 999999. «Счастливым» считается билетик у которого сумма первых трёх цифр
    номера равна сумме последних трёх цифр, как, например, в билетах с номерами 003102 или
    567576. Трамвайное депо решило подарить сувенир обладателю каждого счастливого билета
    и теперь раздумывает, как много сувениров потребуется. С помощью программы подсчитайте
    сколько счастливых билетов в одном рулоне?
     */
    public static void main(String[] args) {
        System.out.println(luckyTickets());
    }

    public static int luckyTickets() {
        // TODO implement
        String s;
        int cnt = 0;
        for(int i = 1; i<= 999999; i++)
        {
            s = String.format("%06d", i);
            //System.out.println(s);
            //System.out.println(s.substring(0,3) + " : " + s.substring(3));
            int n1 = Integer.parseInt(s.substring(0,3));
            int n2 = Integer.parseInt(s.substring(3));
            int s1 = 0;
            while(n1 != 0) {
                s1+= n1%10;
                n1 /=10;
            }

            int s2 = 0;
            while(n2 != 0) {
                s2+= n2%10;
                n2 /=10;
            }

            if(s1 == s2)
                cnt++;

        }
        return cnt;
    }
}
