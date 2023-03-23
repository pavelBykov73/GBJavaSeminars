package hw1.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Класс "Бренды" - справочник БД
 * Хранит список (набор) брендов
 * Обеспечивает добавление / удаление и др. операции с поддержанием целостности и уникальности записей
 */
public class Brands {
    public Set<Brand> brands = new HashSet<>();
    int idUnique; // уникальный идентификатор

    public Brands() {
        idUnique = 0;
    }

    public int addBrand(String brandName) {
        for (Brand br : brands
        ) {
            // Добавляем новый бренд только в случае его отсутствия в наборе
            if (br.name.toLowerCase().equals(brandName.toLowerCase())) {
                return br.id;
            }
        }
        Brand brand = new Brand(++idUnique, brandName);
        brands.add(brand);
        return idUnique;
    }

    public String getName(int id) {
        for (Brand br : brands) {
            if (br.id == id) {
                return br.name;
            }
        }
        return "";
    }

    public void print() {
        for (Brand br : brands) {
            System.out.println(br.toString());
        }
    }
}
