package hw1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;


/**
 * Класс Ноутбук. Содержит необходимые характеристики ноутбуков и методы работы с ними
 * Фактически представляет собой запись в таблицы БД "ноутбуки"
 */
@Data
@AllArgsConstructor
@Getter
public class Notebook {
    private int id;
    private int brandId;    // связь с набором брендов по ключу
    private String model;
    private int diagonal;
    private Os os;
    private Color color;
    private int ramGb;
    private int hddGb;
    private int price;


    public String toString() {
        return String.format("Brand: %d,\t model %s,\t OS %s,\t RAM: %d GB,\t price = %d",
                brandId,
                model,
                os.getOs(),
                ramGb,
                price
        );
    }

    @Override
    public boolean equals(Object o) {
        var t = (Notebook) o;
        return t.brandId == brandId
                && t.model == model
                && t.os == os
                && t.color == color
                && t.hddGb == hddGb
                && t.ramGb == ramGb
                && t.diagonal == diagonal;
    }

}
