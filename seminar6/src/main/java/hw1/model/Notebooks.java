package hw1.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Класс "Ноутбуки" - таблица БД
 * Хранит список (набор) ноутбуков
 * Обеспечивает добавление / удаление и др. операции с поддержанием целостности и уникальности записей
 */
public class Notebooks {
    Set<Notebook> notebooks = new HashSet<>();
    Brands brands; // Справочник (набор) брендов - связанная таблица
    int idUnique; // уникальный идентификатор записей

    public Notebooks() {
        brands = new Brands();
        idUnique = 0;
    }

    public Brands getBrands() {
        return brands;
    }

    /**
     * Добавление ноутбука в таблицу (набор) с уникальным id
     * Название бренда конвертируется в идентификатор (при необходимости добавляется в таблицу брендов)
     * Добавляются только уникальные записи о ноутбуках
     *
     * @param brandName
     * @param model
     * @param diagonal
     * @param os
     * @param color
     * @param ram
     * @param hdd
     * @param price
     * @return
     */
    public int addNotebook(String brandName, String model, int diagonal, Os os, Color color,
                           int ram, int hdd, int price) {
        Notebook notebook = new Notebook(++idUnique, brands.addBrand(brandName), model, diagonal,
                os, color, ram, hdd, price);

        for (Notebook nb : notebooks) {
            if (nb.equals(notebook)) {
                idUnique--; // откат идентификатора при отмене вставки
                return nb.getId();
            }
        }
        notebooks.add(notebook);
        return idUnique;
    }

    public Notebook getNotebook(int id) {
        for (Notebook nb : notebooks) {
            if (nb.getId() == id) {
                return nb;
            }
        }
        return null;
    }

    /**
     * Печать полного списка ноутбуков
     */
    public void print() {
        for (Notebook nb : notebooks) {
            System.out.println(toString(nb));
        }
    }

    /**
     * Печать списка ноутбуков с учетом фильтра
     */
    public void print(Filter flt) {
        for (Notebook nb : notebooks) {
            if (
                    (flt.brandId == 0 || nb.getBrandId() == flt.brandId) &&
                            (flt.brandId == 0 && brands.getName(nb.getBrandId()).contains(flt.brandName)) &&
                            nb.getModel().contains(flt.model)
                            && nb.getRamGb() >= flt.ramGbMin
                            && nb.getHddGb() >= flt.hddGbMin
                            && nb.getDiagonal() >= flt.diagonalMin
                            && nb.getPrice() <= flt.priceMax
                            && (flt.os == Os.NOTKNOWN || nb.getOs() == flt.os)
                            && (flt.color == Color.NONE || nb.getColor() == flt.color)
            ) {
                System.out.println(toString(nb));
            }
        }
    }

    /**
     * Формирование строки записи о ноутбуке
     *
     * @param nb - ноутбук
     * @return строка
     * TODO использовать toString() класса Notebook, с инжекцией строки бренда
     */
    public String toString(Notebook nb) {
        return new String().format("id %d,\t Brand: %s,\t model %s,\t OS %s,\t RAM: %d GB," +
                        "\t HDD: %d GB,\t color: %s GB,\t price = %d",
                nb.getId(),
                brands.getName(nb.getBrandId()),
                nb.getModel(),
                nb.getOs(),
                nb.getRamGb(),
                nb.getHddGb(),
                nb.getColor(),
                nb.getPrice()
        );
    }
    // TODO Добавить функцию применения фильтра и выдачи набора отфильтрованных записей (вместо прямой печати)
    // TODO перегрузить метод toString() ?
}
