package hw1;

import java.util.*;

/**
 * Подсчитать количество вхождения каждого слова
 * Пример:
 * Россия идет вперед всей планеты. Планета — это не Россия.
 * toLoverCase().
 * (Усложнение - игнорировать пунктуацию)*
 */
public class Ex1 {

    public static void main(String[] args) {
        String text1 = "Россия идет вперед всей планеты. Планета — это не Россия.";
        String text2 = "После того как Matcher дошел до конца текста и закончил " +
                "проверку для части шаблона «А.+», Matcher начинает ";
        String text3 = " Matcher начинает проверку для оставшейся части шаблона – символ буквы а.   ";
        String text4 = "Так как текст в прямом направлении закончился, проверка происходит в обратном направлении, " +
                "начиная с последнего символа: текст в прямом направлении";
        System.out.printf("\ntest 1: %s\n", text1);
        printWordCount(text1);
        System.out.printf("\ntest 2: %s\n", text2);
        printWordCount(text2);
        System.out.printf("\ntest 3: %s\n", text3);
        printWordCount(text3);
        System.out.printf("\ntest 4: %s\n", text4);
        printWordCount(text4);
    }


    /**
     * Подсчет и печать количества слов в строке без учетов знаков припинания
     *
     * @param s - строка
     */
    private static void printWordCount(String s) {
        Map<String, Integer> map = new HashMap<>();
        // варианты регулярки:
        // [—!\"#$%&'()*+,-./:;<=>?@\\[\\]^_`{|}~–]
        // \\p{IsPunctuation}
        String str = s.trim().toLowerCase()
                .replaceAll("\\p{IsPunctuation}", " ");
        String[] words = str.split("\\s+");
        //System.out.println(str);
        for (String word : words
        ) {
            // Союзы и частицы из одной буквы исключаем из рассмотрения.
            // Если частицы "не" и подобные также надо исключать, что надо
            // делать дополнительные проверки
            if (word.length() > 1 && map.putIfAbsent(word, 1) != null) {
                //map.replace(word, map.get(word), map.get(word) + 1);
                map.put(word, map.get(word) + 1);
            }
        }
        System.out.println(map);
    }
}
