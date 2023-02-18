// 2. Реализуйте алгоритм сортировки пузырьком числового массива,
// результат после каждой итерации запишите в лог-файл.

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
import java.util.logging.ConsoleHandler;
import java.util.logging.*;
import java.io.IOException;

public class Ex_02 {
    public static void main(String[] args) throws IOException {
        int[] randomNumbers = createRandomArray(0, 30, 10);
        int[] sortArray = bubbleSort(randomNumbers);
        System.out.print("Начальный массив:\n");
        System.out.println(printArray(randomNumbers));
        System.out.print("Отсортированный массив:\n");
        System.out.println(printArray(sortArray));
    }
    static int[] createRandomArray(int from, int to, int size) {
        Random rand = new Random();
        int[] randomNumbers = new int[size];
        for(int i = 0; i < size; i++){
            randomNumbers[i] = rand.nextInt(to) + from;
        }
        return randomNumbers;
    }

    static String printArray(int[] arr) {
        return Arrays.toString(arr);
    }

    static int[] bubbleSort(int[] arrUnsort) throws IOException {
        boolean unsorted = true;
        int temp;
        Logger logger = log_result();
        int[] sortArray = Arrays.copyOf(arrUnsort, arrUnsort.length);
        while (unsorted) {
            unsorted = false;
            for (int i = 0; i < sortArray.length - 1; i++){
                if (sortArray[i] > sortArray[i + 1]) {
                    temp = sortArray[i];
                    sortArray[i] = sortArray[i + 1];
                    sortArray[i + 1] = temp;
                    unsorted = true;

                    logger.log(Level.INFO, printArray(sortArray) + "\n");
                }
            }
        }
        return sortArray;
    }
    static Logger log_result() throws IOException {
        Logger logger = Logger.getLogger(Ex_02.class.getName());
        FileHandler fh = new FileHandler("logSort.txt", true);
        logger.addHandler(fh);
        logger.setUseParentHandlers(false);

        SimpleFormatter sf = new SimpleFormatter();
        fh.setFormatter(sf);
        return logger;
    }
}
