package Homework_3;

import java.util.Arrays;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;




public class Main {

    public static void main(String[] args) throws ParseException {
        String input = "28.09.1984 Воробьев M Игорь Александрович 1488";
        String[] list = input.split(" ");
        
        System.out.println(Arrays.toString(list));
        
        if (list.length != 6) {
            throw new RuntimeException("Введены некорректные данные");
        }
        
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        
        String[] resultList = new String[6];
        for (int i = 0; i < list.length; i++) {
            try {
                Date birthday = (Date) df.parse(list[i]);
                System.out.println(birthday);
                // String dateOfBirth = list[i];
                // System.out.println(dateOfBirth);
                resultList[3] = list[i];
                list[i] = null;
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                // e.printStackTrace();
            }
        }
        for (int i = 0; i < list.length; i++) {
            try {
                int number = Integer.parseInt(list[i]);
                resultList[4] = list[i];
                list[i] = null;
                

            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        if (resultList[4] == null){

        }
        for (int i = 0; i < list.length; i++) {
            try {
                if (list[i].toLowerCase().equals("m") || list[i].toLowerCase().equals("f")) {
                    resultList[5] = list[i];
                    list[i] = null;
                }

            } catch (Exception e) {
            }

            
        }
        for (int i = 0; i < 3; i++) {
            for (int k = 0; k < list.length; k++) {

                if (list[k] != null) {
                    resultList[i] = list[k];
                    list[k] = null;
                    break;

                }

            }
        }
        for (int i = 0; i < resultList.length; i++) {
            if(resultList[i] == null){
                
                    throw new RuntimeException("Введены некорректные данные");
               
            }
        }

        System.out.println(Arrays.toString(resultList));
        System.out.println(Arrays.toString(list));
    }

}
