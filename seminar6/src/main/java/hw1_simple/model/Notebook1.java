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
public class Notebook1 {
    private String brand;    // связь с набором брендов по ключу
    private String model;


    public String toString() {
        return String.format("Brand: %s,\t model: %s",
                brand,
                model
        );
    }

    @Override
    public boolean equals(Object o) {
        var t = (Notebook1) o;
        return t.brand == brand
                && t.model == model;
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model);
    }
}
