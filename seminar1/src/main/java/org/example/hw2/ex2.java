package org.example.hw2;

import java.util.Scanner;

/**
 * Дана последовательность целых чисел, оканчивающаяся нулем.
 * Найти сумму положительных чисел, после которых следует отрицательное число.
 * Пример ввода:
 * 1 2 1 2 -1 1 3 1 3 -1 0
 * Логика расчета:
 * 2 -1 переход -> 2 в сумму
 * 3 -1 переход -> 3 в сумму
 * Пример вывода: 5
 */
public class ex2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean endOfInput = false;
        int number;
        int prevNumber = 0;
        int sum = 0;
        System.out.println("Введите целые числа (0 - завершить):");
        while (!endOfInput) {
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                if (number == 0) {
                    endOfInput = true;
                }
                if (prevNumber > 0 && number < 0) {
                    sum += prevNumber;
                }
                prevNumber = number;
            } else {
                scanner.next();
            }
        }
        System.out.printf("Иcкомая сумма = %d", sum);
    }
}
