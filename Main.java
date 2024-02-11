package Homework_3;

import java.util.Arrays;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Main {

    public static void main(String[] args) throws ParseException, IOException {

        String list1 = enter();

        String[] list = list1.split(" ");

        test2(test(list));

        // System.out.println(Arrays.toString(list));
        String[] resultList = DataTest.dataScan(list);

        
        // System.out.println(Arrays.toString(resultList));

        writeToFile(resultList[0], resultList);
    }

    public static String enter() {
        String encoding = System.getProperty("console.encoding", "Cp866");
        Scanner scanner = new Scanner(System.in, encoding);
        System.out.println("Введите ФИО, телефон, дату рождения (dd.MM.yyyy) и пол (m/f) через пробел: ");
        System.out.println(">>> ");
        String input = scanner.nextLine();
        return input;
    }

    /* проверяем количество введенных данных */
    public static int test(String[] input) {

        if (input.length > 6)
            return -1;
        if (input.length < 6)
            return -2;
        return 0;

    }

    public static void test2(int num) {

        if (num == -1) {
            throw new RuntimeException("Введено слишком много данных ");
        }
        if (num == -2) {
            throw new RuntimeException("Введено слишком мало данных ");
        }
    }

    static void writeToFile(String fileName, String[] list) throws IOException {
        try (FileWriter writer = new FileWriter(fileName, true)) {

            // writer.write(Arrays.asList(list).toString());
            writer.write(String.join(" ", list));
            writer.write("\n");
        }

    }

}
