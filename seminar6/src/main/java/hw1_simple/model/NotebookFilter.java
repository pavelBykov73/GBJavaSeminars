package hw1_simple.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NotebookFilter {
    Map<FilterKey, String> mapFilter;

    public NotebookFilter() {
        mapFilter = new HashMap<>();
    }

    public Map<FilterKey, String> getFilter() {
        return mapFilter;
    }

    public void addItem(FilterKey key, String value) {
        mapFilter.put(key, value);
    }

    public void clear() {
        mapFilter.clear();
    }

    /**
     * Пользовательское меню фильтра
     */
    public void userFilterMenu() {
        int menu0UserSelect;
        boolean endOfMenu = false;
        mapFilter.clear();
        while (!endOfMenu) {
            System.out.println("Выберите действие для установки фильтра:");
            for (int i = 0; i < FilterKey.values().length; i++) {
                System.out.println(i + ": " + FilterKey.values()[i]);
            }
            System.out.println(FilterKey.values().length + ": Exit");
            menu0UserSelect = inputIntegerLimit("->", 0, FilterKey.values().length);
            switch (menu0UserSelect) {
                case 0:
                    mapFilter.put(FilterKey.BRAND, inputString("Введите название бренда (можно часть):"));
                    break;
                case 1:
                    mapFilter.put(FilterKey.MODEL, inputString("Введите модель (можно часть):"));
                    break;
                case 2:
                    mapFilter.put(FilterKey.DIAGONAL, inputString("Введите минимальную диагональ экрана:"));
                    break;
                case 3:
                    mapFilter.put(FilterKey.OS, inputString("Введите ОС:"));
                    break;
                case 4:
                    mapFilter.put(FilterKey.RAM, inputString("Минимальный объем ОЗУ:"));
                    break;
                case 5:
                    mapFilter.put(FilterKey.HDD, inputString("Минимальный объем HDD:"));
                    break;
                case 6:
                    mapFilter.put(FilterKey.COLOR, inputString("Цвет:"));
                    break;
                case 7:
                    mapFilter.put(FilterKey.PRICE, inputString("Максимальная цена:"));
                    break;
                case 8:
                    endOfMenu = true;
                    break;
            }
        }
    }

    static String inputString(String msg) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(msg);
        return scanner.nextLine();
    }

    static int inputIntegerLimit(String msg, int min, int max) {
        msg += "(" + min + " - " + max + ")";
        int inNumber;
        do {
            inNumber = inputInteger(msg);
        }
        while (inNumber < min || inNumber > max);
        return inNumber;
    }

    static int inputInteger(String msg) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(msg);
        while (true) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                scanner.next();
                System.out.println("Необходимо ввести целое число:");
            }
        }
    }
}
