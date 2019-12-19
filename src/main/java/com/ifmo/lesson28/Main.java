package com.ifmo.lesson28;

import java.time.*;

public class Main {
    public static void main(String[] args) {
        //Сколько пятниц 13
        LocalDate friday13 = getFriday13(2019);

        //Обратный отчет до нового года. До Нового года осталось дней часов минут секунд
        getNewYear();
        //сколько секунд прожилии
        getAge(1963);

    }

    public static LocalDate getFriday13(int year) {
        LocalDate dateInit = LocalDate.of(year, 1, 1);
        while (dateInit.getYear() != year+1) {
            if (dateInit.getDayOfWeek() == DayOfWeek.FRIDAY && dateInit.getDayOfMonth() == 13) {
                System.out.println(dateInit.toString());
            }
            dateInit = dateInit.plusDays(1);
        }
        return dateInit;
    }

    public static void getNewYear() {
        try {
            LocalDate from = LocalDate.now();
            LocalDate to = LocalDate.of(2019, 12, 31);
            Period period = Period.between(from, to);

            LocalDateTime dateTimeFrom = LocalDateTime.now();
            //LocalDateTime dateTimeTo = LocalDateTime.now().plusDays(period.getDays());
            LocalDateTime dateTimeTo = LocalDateTime.of(2020, Month.JANUARY, 1, 0, 0, 0);
            Duration duration = Duration.between(dateTimeFrom, dateTimeTo);

            System.out.println("day: " + period.getDays() + " hour: " +  duration.toHours() + " minutes: " + duration.toMinutes());
        } catch (Exception e) {
            System.out.println(-1);
        }
    }

    public static void getAge(int year) {
        LocalDate to = LocalDate.of(year, 9, 8);
        LocalDate from = LocalDate.now();
        Period period = Period.between(to, from);

        LocalDateTime dateTimeFrom = LocalDateTime.now();
        LocalDateTime dateTimeTo = LocalDateTime.now().minusDays(period.getDays() * period.getYears());
        Duration duration = Duration.between(dateTimeTo, dateTimeFrom);

        System.out.println(period.getYears() + " : " +period.getDays() + " : " + duration.toHours() + " : " + duration.toMillis() );
    }

}
