package Homework_3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;

/* Здесь проверяем правильность данных и если все верно, создаем строку в правтльном формате */

public class DataTest {
    public static String[] dataScan(String[] list) {
        String[] resultList = new String[6];

        /* Проверяем есть ли строка которую можно представить датой */

        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd.MM.uuuu");

        for (int i = 0; i < list.length; i++) {
            try {
                LocalDate ld = LocalDate.parse(list[i], f);
                resultList[3] = list[i];
                list[i] = null;
            } catch (DateTimeParseException e) {
            }
        }

        /* проверяем есть ли в данных номер телефона */

        for (int i = 0; i < list.length; i++) {
            try {
                int number = Integer.parseInt(list[i]);
                resultList[4] = list[i];
                list[i] = null;

            } catch (Exception e) {
            }
        }

        /* проверяем введен ли пол */

        for (int i = 0; i < list.length; i++) {
            try {
                if (list[i].toLowerCase().equals("m") || list[i].toLowerCase().equals("f")) {
                    resultList[5] = list[i];
                    list[i] = null;
                }

            } catch (Exception e) {
            }
        }
        /*
         * Оставшиеся строки считаем за ФИО и вводим в первые три строки нового массива
         */

        for (int i = 0; i < 3; i++) {
            for (int k = 0; k < list.length; k++) {
                if (list[k] != null) {
                    resultList[i] = list[k];
                    list[k] = null;
                    break;
                }
            }
        }

        /*
         * при правильном вводе, все данные из входящего массива обнулялись, проверям
         * это здесь
         */
        for (int i = 0; i < resultList.length; i++) {
            if (resultList[i] == null) {

                throw new RuntimeException("Введены некорректные данные");
            }

        }

        return resultList;
    }
}
