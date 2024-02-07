package Homework_3;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

public class Main {
    

    public static void main(String[] args) {
        String input = "Воробьев Игорь Александрович 28.09.1984 1488 m";
        String[] list = input.split(" ");
        List<String> arrInput = new LinkedList<>();
        for (String s : list) {
            arrInput.add(s);

        }
        System.out.println(arrInput);
        if (arrInput.size() != 6){
            throw new RuntimeException("Введены некорректные данные");
        }
        String date = "28.09.84";
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        try {
            Date birthday = (Date) df.parse(date);
            System.out.println(birthday);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        


    }

}
