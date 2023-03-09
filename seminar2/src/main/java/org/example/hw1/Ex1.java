package org.example.hw1;

import java.util.Scanner;

/**
 * Дана последовательность N целых чисел. Найти сумму простых чисел.
 * <p>
 * В данном решении используем ввод последовательности с консоли "по числам"
 */
public class Ex1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean endOfInput = false;
        int number;
        int sum = 0;
        String str;
        System.out.println("Введите целые числа (завершение = пустой или некорректный ввод):");
        while (isInteger(str = scanner.nextLine().trim(), 10)) {
            if (isPrimeNumber(number = Integer.valueOf(str))) {
                sum += number;
            }
        }
        scanner.close();
        System.out.printf("сумма простых чисел = %d", sum);
    }

    /**
     * Тест наличия в строке целого числа
     *
     * @param s     - строка
     * @param radix - основание числа для проверки
     * @return true если в строке имеется целое число
     */
    public static boolean isInteger(String s, int radix) {
        boolean res = false;
        Scanner sc = new Scanner(s);
        if (sc.hasNextInt(radix)) {
            res = true;
        }
        sc.close();
        return res;
    }

    public static boolean isPrimeNumber(int number) {
        number = number < 0 ? -number : number;
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
