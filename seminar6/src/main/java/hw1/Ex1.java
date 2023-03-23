package hw1;

import hw1.model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * • Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
 * • Создать множество ноутбуков.
 * • Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации
 * и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например:
 * “Введите цифру, соответствующую необходимому критерию:
 * 1 - ОЗУ
 * 2 - Объем ЖД
 * 3 - Операционная система
 * 4 - Цвет …
 * • Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры
 * фильтрации можно также в Map.
 * • Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.
 */
public class Ex1 {

    public static void main(String[] args) {
        Notebooks notebooks = new Notebooks();
        // addSampleBrands(notebooks.getBrands()); // Необязательно. Бренды добавятся в список внутри движка
        System.out.println("Полный список ноутбуков:");
        addSampleNotebooks(notebooks);
        //notebooks.getBrands().print();
        notebooks.print();
        Filter filter = new Filter();
        userMenu(filter, notebooks.getBrands());
//        filter.model = filter.inputString("Название модели:");
//        filter.color = filter.consoleInputColor(); // Color.BLACK;
//        filter.os = filter.consoleInputOs();
//        filter.brandId = filter.consoleInputBrandId(notebooks.getBrands());
//        filter.brandName = filter.inputString("Название бренда:");
//        filter.ramGbMin = filter.inputIntegerLimit("Минимальный объем ОЗУ:", 0, 128);
//        filter.hddGbMin = filter.inputIntegerLimit("Минимальный объем HDD:", 0, 100000);
        System.out.println("Ноутбуки удовлетворяющие условию:");
        notebooks.print(filter);
    }

    private static void addSampleNotebooks(Notebooks nbs) {
        nbs.addNotebook("HP", "fg-432", 14,
                Os.WINDOWS, Color.BLACK, 2, 4000, 43000);
        nbs.addNotebook("Huawei", "KLVL-56", 13,
                Os.WINDOWS, Color.SILVER, 16, 1000, 24500);
        nbs.addNotebook("DELL", "fg-434", 17,
                Os.WINDOWS, Color.BLACK, 4, 4096, 66000);
        nbs.addNotebook("Samsung", "Model 56", 15,
                Os.WINDOWS, Color.SILVER, 8, 1000, 14500);
        nbs.addNotebook("HP", "rrrrr", 15,
                Os.WINDOWS, Color.BLACK, 4, 4096, 43000);
        nbs.addNotebook("Asus", "32876", 19,
                Os.WINDOWS, Color.SILVER, 6, 1000, 24500);
        nbs.addNotebook("Acer", "fg-56", 14,
                Os.WINDOWS, Color.BLACK, 4, 2000, 48000);
        nbs.addNotebook("Huawei", "ddd-56", 13,
                Os.WINDOWS, Color.SILVER, 16, 8096, 94500);
        nbs.addNotebook("HP", "kzs-44", 15,
                Os.WINDOWS, Color.BLACK, 8, 4096, 35000);
        nbs.addNotebook("Asus", "KLVL-56", 13,
                Os.WINDOWS, Color.SILVER, 16, 1000, 27800);
        nbs.addNotebook("Asus", "KLVL-56", 13,
                Os.WINDOWS, Color.SILVER, 16, 1000, 27800);
        nbs.addNotebook("Asus", "KLVL-56", 13,
                Os.WINDOWS, Color.SILVER, 16, 1000, 27800);
    }

    private static void addSampleBrands(Brands brands) {
        brands.addBrand("Asus");
        brands.addBrand("Acer");
        brands.addBrand("HP");
        brands.addBrand("Dell");
        brands.addBrand("Samsung");
        brands.addBrand("Huawei");
        brands.addBrand("Asus");
        brands.addBrand("Asus");
    }

    public static Filter userMenu(Filter flt, Brands brands) {
        int menu0UserSelect;
        boolean endOfMenu = false;
        List<String> menu0 = new ArrayList<>(List.of(
                "Brand Id", "Brand Name", "Model", "OS", "RAM", "HDD", "COLOR", "Price", "Exit", ""));
        while (!endOfMenu) {
            System.out.println("Выберите действие для установки фильтра:");
            for (int i = 0; i < menu0.size(); i++) {
                System.out.println(i + ": " + menu0.get(i));
            }
            menu0UserSelect = flt.inputIntegerLimit("->", 0, menu0.size() - 1);
            // TODO подумать можно ли использовать карту ссылок или интерфейсы для более общей записи вызова функций
            switch (menu0UserSelect) {
                case 0:
                    flt.brandId = flt.consoleInputBrandId(brands);
                    break;
                case 1:
                    flt.brandName = flt.inputString("Введите название бренда (можно часть):");
                    break;
                case 2:
                    flt.model = flt.inputString("Введите модель (можно часть):");
                    break;
                case 3:
                    flt.os = flt.consoleInputOs();
                    break;
                case 4:
                    flt.ramGbMin = flt.inputIntegerLimit("Минимальный объем ОЗУ:", 0, 128);
                    break;
                case 5:
                    flt.hddGbMin = flt.inputIntegerLimit("Минимальный объем HDD:", 0, 100000);
                    break;
                case 6:
                    flt.color = flt.consoleInputColor();
                    break;
                case 7:
                    flt.priceMax = flt.inputIntegerLimit("Максимальная цена:", 0, 1000000);
                    break;
                case 8:
                    endOfMenu = true;
                    break;
            }
        }
        return flt;
    }

}