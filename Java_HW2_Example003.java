package Homework.JAVA_HW2;
import java.io.*;
/*
 * Дана строка json:
[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"}, {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
Написать метод, который распарсит json и, используя StringBuilder, создаст строки вида:

Студент [фамилия] получил [оценка] по предмету [предмет]. Например:

Студент Иванов получил 5 по предмету Математика.
Студент Петрова получил 4 по предмету Информатика.
Студент Краснов получил 5 по предмету Физика.
 */

public class Java_HW2_Example003 {

    public static String readFile(String addressFile,String nameFile) // Чтение файла
    {
        String str;
        try {
            BufferedReader br = new BufferedReader(new FileReader(addressFile+nameFile));
            StringBuilder builder = new StringBuilder();
            while ((str = br.readLine())!=null) 
            {
                builder.append(str);
            }
            br.close();
            return builder.toString();
        } catch (Exception ex) {
            System.out.printf("Ошибка: " + ex);
        }
        return null;

    }

    private static String raspJson(String data)
    {
        String newData = data.replace("}", "");
        newData = newData.replace("{", "");
        newData = newData.replace(",", ":");
        newData = newData.replace('"', '#');
        newData = newData.replace("#", "");

                

        String [] arrayData = newData.split(":");
        
        StringBuilder builder = new StringBuilder();
        
        for (int i = 0; i < arrayData.length; i+=6) 
        {
              builder.append("Студент ");
                builder.append(arrayData[i+1]);
                builder.append(" ");
                builder.append("получил ");
                builder.append(arrayData[i+3]);
                builder.append(" ");
                builder.append("по предмету ");
                builder.append(arrayData[i+5]);
                builder.append("\n");        
        }

        return builder.toString();
    }
    public static void main(String[] args)throws IOException, InterruptedException
    { new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Очистка консоли
        String addressFile = "C:/Users/SBB2-Ермилов Артём/YandexDisk-artyomermiloff/GeegBrains/Programming/Java/Homework/JAVA_HW2/";
        String nameFile = "Java_HW2_Example003.txt";
        
        String str = readFile(addressFile,nameFile);
        System.out.println(str+"\n");
        
        System.out.println(raspJson(str));

    }
    
}
