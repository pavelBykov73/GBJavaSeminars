package hw2;

import java.io.*;
import java.util.*;

/**
 * Подсчитать количество искомого слова, через map
 * (наполнением значение, где искомое слово будет являться ключом), вносить все слова не нужно
 */
public class Ex2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя файла:");
        String fileName = scanner.nextLine();
        System.out.println("Что ищем? Введите слово:");
        String wordToSearch = scanner.nextLine();
        System.out.println("Количество вхождений слова = " + wordCountInFile(fileName, wordToSearch));
    }

    /**
     * Поиск и подсчет количества слов в файле
     *
     * @param filePathName
     * @param wordToSearch
     * @return число вхождений
     */
    public static int wordCountInFile(String filePathName, String wordToSearch) {
        int wordCount = 0;
        String inStr;
        File file = new File(filePathName);
        try {
            if (isFileExists(file)) {
                FileReader reader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(reader);
                while ((inStr = bufferedReader.readLine()) != null) {
                    wordCount += wordCountInString(inStr, wordToSearch);
                }
            } else {
                System.out.println("Файл не найден: " + filePathName);
            }
//        } catch (FileNotFoundException f) {
//            System.out.println("Ошибка. Файл не найден.");
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла.");
        }
        return wordCount;
    }

    /**
     * Метод проверки существования файла
     *
     * @param file
     * @return true if file exist
     */
    public static boolean isFileExists(File file) {
        return file.isFile();
    }

    /**
     * Поиск и подсчет количества слов в строке без учетов знаков припинания
     *
     * @param s - строка
     */
    private static int wordCountInString(String s, String searchWord) {
        Map<String, Integer> map = new HashMap<>();
        searchWord = searchWord.toLowerCase();
        map.put(searchWord, 0);
        // варианты регулярки:
        // [—!\"#$%&'()*+,-./:;<=>?@\\[\\]^_`{|}~–]
        // \\p{IsPunctuation}
        String str = s.replaceAll("\\p{IsPunctuation}", "");
        String[] words = str.split("\\s+");
        //System.out.println(str);
        for (String word : words
        ) {
            if (word.equalsIgnoreCase(searchWord)) {
                map.put(searchWord, map.get(searchWord) + 1);
            }
        }
        return map.get(searchWord);
    }
}
