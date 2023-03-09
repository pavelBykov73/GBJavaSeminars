package org.example.hw3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Дан массив целых чисел. Заменить отрицательные элементы на сумму индексов двузначных элементов массива.
 * <p>
 * В данном решении массив задан в коде.
 */
public class Ex3 {
    public static void main(String[] args) {
        int[] array = {1, 2, 33, 55, 134, -33, -66, -1, -345, 44};
        System.out.println("Исходный массив:\n" + Arrays.toString(array));
        int sum = sumIndexes(array);
        System.out.println("Сумма индексов двузначных элементов=" + sum);
        replaceNegativeElements(array, sum);
        System.out.println("Результат:\n" + Arrays.toString(array));
    }

    private static int sumIndexes(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] >= 10 && arr[i] <= 99)
                    || (arr[i] <= -10 && arr[i] >= -99)
            ) {
                sum += i;
            }
        }
        return sum;
    }

    private static void replaceNegativeElements(int[] arr, int newValue) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                arr[i] = newValue;
            }
        }
    }
}
