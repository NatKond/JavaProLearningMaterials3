package org.tel.ran._2025_03_17;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static org.tel.ran.textFormatting.*;

public class MainDate {
    public static void main(String[] args) {
        Date date1 = new Date();
        System.out.println("Текущая дата = " + date1);
        System.out.println("Текущая дата (long)= " + date1.getTime());

        Date date2 = new Date(123484312228L);
        System.out.println("Текущая дата = " + date2);

        //Не рекомендуется к использованию
        Date date3 = new Date(125, 1, 19); // Год + 1970, месяц начиная с 0
        System.out.println("Текущая дата = " + date3);

        Date date4 = new Date();
        date4.setTime(date3.getTime());
        System.out.println("Текущая дата = " + date4);

        //Сравнение
        System.out.println("Сравнение милисекунд = " + (date4.getTime() >= date3.getTime()));

        boolean fl = date1.after(date2); // date1 после date2
        System.out.println("after -> " + fl);

        fl = date1.before(date2); // date1 перед date2
        System.out.println("before -> " + fl);

        int compare = date1.compareTo(date2); // сравнение 2х дат
        System.out.println("compareTo -> " + compare); // компаринг

        System.out.println("Equals = " + date1.equals(date3));
        System.out.println("Equals = " + date4.equals(date3));

        // Локализация
        Locale locale = new Locale("ru"); // de, ru, en
        Locale.setDefault(locale);
        Date now = new Date();
        System.out.println("Standard" + now);
        // Используем стандратные форматоеры
        String date = BLUE + String.format(locale, "%tc\n", now) + // длинная строка
                GREEN + String.format(locale, "%tD\n", now) + // (MM/DD/YY)
                String.format(locale, "%tF\n", now) + // (YYYY-MM-DD)
                String.format(locale, "%tr\n", now) + // Full 12-hour time
                String.format(locale, "%tz\n", now) + // Time zome GMT offset
                String.format(locale, "%tZ\n", now) + // Localized time zone abbreviation
                YELLOW + String.format(locale, "%te.%tm.%tY", now, now, now) + RESET; // Localized time zone abbreviation
        System.out.println(date);

        // Преобразование в строку
        String pattern = "dd.MM.yyyy HH:mm:ss";
        DateFormat df = new SimpleDateFormat(pattern);
        System.out.println("Пользовательский формат -> " + df.format(now));

        // Max Date
        Date dateMax = new Date(Long.MAX_VALUE);
        System.out.println("Max Date = " + dateMax);
    }
}
