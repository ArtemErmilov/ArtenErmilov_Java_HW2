package Homework.JAVA_HW2;
import java.io.IOException;//Очистка консоли
import java.util.logging.*;

 /*
     * Реализуйте алгоритм сортировки пузырьком числового массива, 
     * результат после каждой итерации запишите в лог-файл.
     */

public class Java_HW2_Example002 {
    private static int [] wrRandArrNumb(int [] array, int minNumbers, int maxNumbers) // Заполнение массива случайными числами
    {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random()*(maxNumbers-minNumbers))+minNumbers;
            
        }
            
        return array;
    }

    private static void printArray(int [] array) // Запись массива в консоль
    {
        int index = 0;
        System.out.print("[ ");
        for (index = 0;index < array.length-1; index++) 
        {
            System.out.print(array[index]+", ");
        }
        System.out.print(array[index]+" ]\n");
        
    }
    private static int[] bubbleSort(int [] array)throws IOException 
    {
        Logger logger = Logger.getLogger(Java_HW2_Example002.class.getName());
        FileHandler fh = new FileHandler("C:/Users/SBB2-Ермилов Артём/YandexDisk-artyomermiloff/GeegBrains/Programming/Java/Homework/JAVA_HW2/HW2_Example2_log.log");
        logger.addHandler(fh);
        
        
        int temp = 0;
        String mesText ="";
        logger.info("Старт программы");
        for (int i = 0; i < array.length; i++) 
        { logger.info("Новый проход по массиву");
            for (int j = 0; j < array.length-i-1; j++) 
            {
                if (array[j]>array[j+1])
                {   mesText = "Смена местами " + array[j] +" с "+array[j+1];
                    temp = array[j];
                    array[j]=array[j+1];
                    array[j+1] = temp;
                }
                else mesText = "Без смены " + array[j] +" на "+array[j+1];
                
                logger.info(mesText);
            }
            
        }
        return array;
        
    }
   
    public static void main(String[] args)throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Очистка консоли
        int [] array = new int [10];
        array=wrRandArrNumb(array,0,100);
        printArray( array);
        array = bubbleSort(array);
        printArray( array);
        
    }
}
