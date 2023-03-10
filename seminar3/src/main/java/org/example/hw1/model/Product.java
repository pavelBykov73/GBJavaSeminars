package org.example.hw1.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Дан массив записей: наименование товара, цена, сорт.
 */
@Data
@AllArgsConstructor
public class Product {
    private String name;
    private double price;
    private int grade;
}
