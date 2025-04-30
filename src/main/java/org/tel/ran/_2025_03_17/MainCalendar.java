package org.tel.ran._2025_03_17;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.tel.ran.textFormatting.*;

public class MainCalendar {
    public static void main(String[] args) {
        Calendar calendar1 = new GregorianCalendar();
        System.out.println(YELLOW + calendar1);
        System.out.println(RESET + "calendar1 = " + calendar1.getTime());

        Calendar calendar2 = Calendar.getInstance();
        System.out.println(YELLOW + calendar2);
        System.out.println(RESET + "calendar2 = " + calendar2.getTime());

        GregorianCalendar calendar3 = new GregorianCalendar(2025, Calendar.OCTOBER, 12);
        System.out.println(YELLOW + calendar3);
        System.out.println(RESET + "calendar3 = " + calendar3.getTime());
        System.out.println(RESET + "calendar3 = " + calendar3.getTime().getTime());

        // установка конкретного элемента
        calendar3.set(Calendar.HOUR, 11);
        calendar3.set(Calendar.MINUTE, 50);

        // Добавление месяца
    }
}
