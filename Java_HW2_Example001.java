package Homework.JAVA_HW2;

import java.io.*;
/*
 * Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder.
Данные для фильтрации приведены ниже в виде json строки. Разберите строку, используя String.split.
Если значение null, то параметр не должен попадать в запрос.
Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
 */

public class Java_HW2_Example001 {
    public static String readFile(String addressFile,String nameFile) // Чтение файла
    {
        String str=null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(addressFile+nameFile));
            str = br.readLine();
            br.close();
        } catch (Exception ex) {
            System.out.printf("Ошибка: " + ex);
        }
        return str;

    }
    

    private static String requestSQL(String data)
    {
        String newData = data.replace(',', ':');
        newData = newData.replace("{", "");
        newData = newData.replace("}", "");
        newData = newData.replace('"', '#');
        newData = newData.replace("#", "");        

        String [] arrayData = newData.split(":");
        
        StringBuilder builder = new StringBuilder();
        builder.append("SELECT * FROM students WHERE ");
        
        for (int i = 1; i < arrayData.length-1; i+=2) 
        {
            if (arrayData[i]!="null")
            {   
                if (i>1) builder.append(" AND ");
                builder.append(arrayData[i-1]);
                builder.append(" = ");
                builder.append('"');
                builder.append(arrayData[i]);
                builder.append('"');
            }
        }

        return builder.toString();
    }

  
    public static void main(String[] args) throws IOException, InterruptedException
     { new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Очистка консоли
    String addressFile = "C:/Users/SBB2-Ермилов Артём/YandexDisk-artyomermiloff/GeegBrains/Programming/Java/Homework/JAVA_HW2/";
    String nameFile = "Java_HW2_Example001.txt";
    String data = readFile(addressFile,nameFile);
    
    System.out.println(data);

    String str = requestSQL(data);
    System.out.println(str);

    
    }
}
