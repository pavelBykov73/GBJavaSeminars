package hw1_simple.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.Objects;


/**
 * Класс Ноутбук. Содержит необходимые характеристики ноутбуков и методы работы с ними
 * Фактически представляет собой запись в таблицы БД "ноутбуки"
 * !!! Нормализации нет! Бренды, цвета, ОС лежат как строки !!!
 */
@Data
@AllArgsConstructor
@Getter
public class Notebook {
    private String brand;
    private String model;
    private int diagonal;
    private String os;
    private String color;
    private int ramGb;
    private int hddGb;
    private int price;


    public String toString() {
        return String.format("Brand: %s,\t model %s,\t diagonal %d,\t OS %s,\t RAM: %d GB,\t price = %d",
                brand,
                model,
                diagonal,
                os,
                ramGb,
                price
        );
    }

    @Override
    public boolean equals(Object o) {
        var t = (Notebook) o;
        return t.brand == brand
                && t.model == model
                && t.os == os
                && t.color == color
                && t.hddGb == hddGb
                && t.ramGb == ramGb
                && t.diagonal == diagonal;
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, diagonal, os, color, ramGb, hddGb, price);
    }
}
