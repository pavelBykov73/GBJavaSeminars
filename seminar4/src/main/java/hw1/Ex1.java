package hw1;

import java.util.LinkedList;
import java.util.Random;

/**
 * Вывести список на экран в перевернутом виде (без массивов и ArrayList)
 * Пример:
 * 1 -> 2->3->4
 * Вывод:
 * 4->3->2->1
 */
public class Ex1 {
    public static void main(String[] args) {
        LinkedList<Integer> numberList = new LinkedList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            numberList.add(i, random.nextInt(20));
        }
        System.out.println(numberList);
        System.out.println(reverseList(numberList));
    }

    private static LinkedList<Integer> reverseList(LinkedList<Integer> list) {
        for (int i = 0, j = list.size() - 1; i < j; i++) {
            list.add(i, list.remove(j));
        }
        return list;
    }
}
