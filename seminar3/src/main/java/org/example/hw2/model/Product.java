package org.example.hw2.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Сведения о товаре состоят из наименования, страны-производителя, веса, цены, сорта
 */
@Data
@AllArgsConstructor
public class Product {
    private String name;
    private String country;
    private double weight;
    private double price;
    private int grade;

    public String toString() {
        String str = name + " ("
                + country
                + ", Цена=" + price
                + ", вес=" + weight
                + ", сорт=" + grade
                + ")";
        return str;
    }

}
