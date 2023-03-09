package org.example.hw2;

import java.util.Scanner;

/**
 * Дана последовательность из N целых чисел.
 * Верно ли, что последовательность является возрастающей.
 * <p>
 * В данном решении используем ввод последовательности с консоли в строке с пробелами
 */
public class Ex2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите целые числа в строку через пробел:");
        if (isAscendingSequence(scanner.nextLine())) {
            System.out.printf("\nПоследовательность является возрастающей");
        } else {
            System.out.printf("\nПоследовательность не является возрастающей");
        }
    }

    public static boolean isAscendingSequence(String str) {
        int number;
        int prevNumber = Integer.MIN_VALUE;
        Scanner scannerString = new Scanner(str);
        while (scannerString.hasNextInt()) {
            number = scannerString.nextInt();
            System.out.printf("%d ", number);
            if (number <= prevNumber) {
                scannerString.close();
                return false;
            }
            prevNumber = number;
        }
        scannerString.close();
        return true;
    }
}
