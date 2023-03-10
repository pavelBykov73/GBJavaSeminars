package org.example.hw3;

import org.example.hw3.model.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * Найти названия книг, в которых простое количество страниц,
 * фамилия автора содержит «А» и год издания после 2010 г, включительно.
 */
public class Ex3 {
    public static void main(String[] args) {
        Book book1 = new Book("Му-Му", "Тургенев", 1854, 75.99, 33);
        Book book2 = new Book("Книга 1", "Алексеев", 2010, 175.00, 10);
        Book book3 = new Book("Книга 2", "Пушкин", 2000, 100.99, 33);
        Book book4 = new Book("Книга 3", "ИвАнов", 2012, 350.00, 97);
        Book book5 = new Book("Книга 4", "Кто-то", 1956, 434.11, 33);
        Book book6 = new Book("Книга 5", "Автор 5", 2020, 585.22, 83);

        List<Book> bookList = new ArrayList<>();
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        bookList.add(book4);
        bookList.add(book5);
        bookList.add(book6);

        // в задании не указано треование к регистру, считаем, что ищем заглавную "А"
        for (Book item : bookList) {
            if (item.getAuthor().contains("А")
                    && item.getYear() >= 2010
                    && isPrimeNumber(item.getPages())
            ) {
                System.out.println(item.toString());
            }
        }
    }

    private static boolean isPrimeNumber(int number) {
        number = number < 0 ? -number : number;
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

}
