package org.tel.ran._2025_03_17;

import javax.swing.text.DateFormatter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import static org.tel.ran.textFormatting.*;

public class MainCalendar {
    public static void main(String[] args) {
        Calendar calendar1 = new GregorianCalendar();
        System.out.println(YELLOW + calendar1);
        System.out.println(RESET + "calendar1 = " + calendar1.getTime());

        Calendar calendar2 = Calendar.getInstance(); // текущая дата
        System.out.println(YELLOW + calendar2);
        System.out.println(RESET + "calendar2 = " + calendar2.getTime()); // возврат в Data

        GregorianCalendar calendar3 = new GregorianCalendar(2025, Calendar.OCTOBER, 12);
        Date time3 = calendar3.getTime();
        System.out.println(YELLOW + calendar3);
        System.out.println(RESET + "calendar3 = " + time3);
        System.out.println(RESET + "calendar3 = " + time3.getTime());

        // установка конкретного элемента
        calendar3.set(Calendar.HOUR, 11);
        calendar3.set(Calendar.MINUTE, 50);
        // получение конкретного элемента
        System.out.println(calendar3.get(Calendar.HOUR));
        System.out.println(calendar3.get(Calendar.MONTH));
        System.out.println("calendar3 = " + calendar3.getTime()); // возврат в Date

        // добавление конкретного элемента
        System.out.println(" --- Добавление конкретного элемента");
        calendar3.add(Calendar.MONTH, 4);
        System.out.println(calendar3.get(Calendar.MONTH));
        System.out.println("calendar3 = " + calendar3.getTime()); // возврат в Date

        calendar3.add(Calendar.MONTH, -4);
        System.out.println(calendar3.get(Calendar.MONTH));
        System.out.println("calendar3 = " + calendar3.getTime()); // возврат в Date

        System.out.println();
        // не меняет связанные значения (не используйте!!!)
        calendar3.roll(Calendar.MONTH, 4);
        System.out.println("calendar3 = " + calendar3.getTime()); // возврат в Date

        calendar3.roll(Calendar.DAY_OF_MONTH, -12);
        System.out.println("calendar3 = " + calendar3.getTime()); // возврат в Date

        System.out.println();

        // === Форматирование строки при выводе даты Date
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss.SSS");
        String dateStr = simpleDateFormat.format(new Date());
        System.out.println(dateStr);

        //Использовать Calendar
        simpleDateFormat = new SimpleDateFormat("dd MMMM yyyy");
        dateStr = simpleDateFormat.format(calendar1.getTime());
        System.out.println(dateStr);

        Locale locale = new Locale("ru");
        simpleDateFormat = new SimpleDateFormat("dd MMM yy, d, D, K:m a", locale);
        dateStr = simpleDateFormat.format(calendar1.getTime());
        System.out.println(dateStr);
    }
}
