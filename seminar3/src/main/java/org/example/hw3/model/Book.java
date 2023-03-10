package org.example.hw3.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Сведения о книге состоят из названия, фамилии автора, цены,
 * года издания и количества страниц.
 */
@Data
@AllArgsConstructor
public class Book {
    private String name;
    private String author;
    private int year;
    private double price;
    private int pages;

    public String toString() {
        String str = name + " ("
                + author
                + ", Цена=" + price
                + ", год=" + year
                + ", стр=" + pages
                + ")";
        return str;
    }

}
