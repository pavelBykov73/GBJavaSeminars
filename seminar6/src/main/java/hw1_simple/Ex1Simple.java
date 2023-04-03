package hw1_simple;

import hw1_simple.model.FilterKey;
import hw1_simple.model.Notebook;
import hw1_simple.model.Notebook1;
import hw1_simple.model.NotebooksTable;

import java.util.*;

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
 * <p>
 * В данном решении использована архитектура аналогичная БД с таблицами справочников.
 * Это привело к усложнению кода в части работы с такого рода данными
 */
public class Ex1Simple {

    public static void main(String[] args) {
        NotebooksTable<Notebook1> notebooksTable = new NotebooksTable();
        notebooksTable.Add(new Notebook1("HP", "notebook1"));
        notebooksTable.Add(new Notebook1("HP", "notebook1"));
        notebooksTable.Add(new Notebook1("HP", "notebook1"));
        notebooksTable.Add(new Notebook1("HP", "notebook3"));
        notebooksTable.Add(new Notebook1("ASUS", "notebook1"));
        notebooksTable.Add(new Notebook1("Acer", "notebook1"));
        System.out.println(notebooksTable);
        notebooksTable.print();
//        Set<Notebook> notebooks = new HashSet<>();
//
//        addSampleNotebooks(notebooks);
//        System.out.println("Полный список ноутбуков:");
//        for (Notebook notebook : notebooks) {
//            System.out.println(notebook.toString());
//        }
//        Map<FilterKey, String> mapFilter = userFilterMenu();
//        System.out.println("Ноутбуки удовлетворяющие условию:");
//        printFiltered(notebooks, mapFilter);
    }

    /**
     * Заполнение списка ноутбуков тестовыми данными
     *
     * @param nbs - набор куда класть ноутбуки
     */
//    private static void addSampleNotebooks(Set<Notebook> nbs) {
//        nbs.add(new Notebook(1, "HP", "fg-432", 14,
//                "WINDOWS", "BLACK", 2, 4000, 43000));
//        nbs.add(new Notebook(2, "Huawei", "KLVL-56", 13,
//                "WINDOWS", "Silver", 16, 1000, 24500));
//        nbs.add(new Notebook(3, "DELL", "fg-434", 17,
//                "WINDOWS", "BLACK", 4, 4096, 66000));
//        nbs.add(new Notebook(4, "Samsung", "Model 56", 15,
//                "Linux", "Silver", 8, 1000, 14500));
//        nbs.add(new Notebook(5, "HP", "rrrrr", 15,
//                "LiNUX", "BLACK", 4, 4096, 43000));
//        nbs.add(new Notebook(6, "Asus", "32876", 19,
//                "DOS", "Silver", 6, 1000, 24500));
//        nbs.add(new Notebook(7, "Acer", "fg-56", 14,
//                "No OS", "BLACK", 4, 2000, 48000));
//        nbs.add(new Notebook(8, "Huawei", "ddd-56", 13,
//                "WINDOWS", "Silver", 16, 8096, 94500));
//        nbs.add(new Notebook(9, "HP", "kzs-44", 15,
//                "Lin", "BLACK", 8, 4096, 35000));
//        nbs.add(new Notebook(10, "Asus", "KLVL-56", 13,
//                "WINDOWS-10", "White", 16, 1000, 27800));
//        nbs.add(new Notebook(11, "Asus", "KLVL-56", 13,
//                "WINDOWS-11", "Silver", 16, 1000, 27800));
//        nbs.add(new Notebook(12, "Asus", "KLVL-56", 13,
//                "WINDOWS Mobile", "Silver", 16, 1000, 27800));
//        // Данная запись не включится, как дубль
//        nbs.add(new Notebook(13, "Asus", "KLVL-56", 13,
//                "WINDOWS Mobile", "Silver", 16, 1000, 27800));
//        // Тест работы эквивалентности
////        Notebook n1 = new Notebook(13, "Asus", "KLVL-56", 13,
////                "WINDOWS Mobile", "Silver", 16, 1000, 27800);
////        Notebook n2 = new Notebook(14, "Asus", "KLVL-56", 13,
////                "WINDOWS Mobile", "Silver", 16, 1000, 27800);
////        System.out.println(n1.equals(n2));
//    }


    /**
     * Пользовательское меню фильтра
     *
     * @return сформированный набор параметров фильтра
     */
//    public static Map<FilterKey, String> userFilterMenu() {
//        Map<FilterKey, String> mapFilter = new HashMap<>();
//        int menu0UserSelect;
//        boolean endOfMenu = false;
//        mapFilter.clear();
//        while (!endOfMenu) {
//            System.out.println("Выберите действие для установки фильтра:");
//            for (int i = 0; i < FilterKey.values().length; i++) {
//                System.out.println(i + ": " + FilterKey.values()[i]);
//            }
//            System.out.println(FilterKey.values().length + ": Exit");
//            menu0UserSelect = inputIntegerLimit("->", 0, FilterKey.values().length);
//            switch (menu0UserSelect) {
//                case 0:
//                    mapFilter.put(FilterKey.BRAND, inputString("Введите название бренда (можно часть):"));
//                    break;
//                case 1:
//                    mapFilter.put(FilterKey.MODEL, inputString("Введите модель (можно часть):"));
//                    break;
//                case 2:
//                    mapFilter.put(FilterKey.DIAGONAL, inputString("Введите минимальную диагональ экрана:"));
//                    break;
//                case 3:
//                    mapFilter.put(FilterKey.OS, inputString("Введите ОС:"));
//                    break;
//                case 4:
//                    mapFilter.put(FilterKey.RAM, inputString("Минимальный объем ОЗУ:"));
//                    break;
//                case 5:
//                    mapFilter.put(FilterKey.HDD, inputString("Минимальный объем HDD:"));
//                    break;
//                case 6:
//                    mapFilter.put(FilterKey.COLOR, inputString("Цвет:"));
//                    break;
//                case 7:
//                    mapFilter.put(FilterKey.PRICE, inputString("Максимальная цена:"));
//                    break;
//                case 8:
//                    endOfMenu = true;
//                    break;
//            }
//        }
//        return mapFilter;
//    }
//
//    public static void printFiltered(Set<Notebook> notebooks, Map<FilterKey, String> mapFilter) {
//        Set<FilterKey> keys = mapFilter.keySet();
//        for (Notebook notebook : notebooks) {
//            if (!(mapFilter.containsKey(FilterKey.BRAND) && !notebook.getBrand().contains(mapFilter.get(FilterKey.BRAND)))
//                    && !(mapFilter.containsKey(FilterKey.MODEL) && !notebook.getModel().contains(mapFilter.get(FilterKey.MODEL)))
//                    && !(mapFilter.containsKey(FilterKey.OS) && !notebook.getOs().contains(mapFilter.get(FilterKey.OS)))
//                    && !(mapFilter.containsKey(FilterKey.COLOR) && !notebook.getColor().contains(mapFilter.get(FilterKey.COLOR)))
//                    && !(mapFilter.containsKey(FilterKey.DIAGONAL) && notebook.getDiagonal() < getInteger(mapFilter.get(FilterKey.DIAGONAL)))
//                    && !(mapFilter.containsKey(FilterKey.RAM) && notebook.getRamGb() < getInteger(mapFilter.get(FilterKey.RAM)))
//                    && !(mapFilter.containsKey(FilterKey.HDD) && notebook.getHddGb() < getInteger(mapFilter.get(FilterKey.HDD)))
//                    && !(mapFilter.containsKey(FilterKey.PRICE) && notebook.getPrice() > getInteger(mapFilter.get(FilterKey.PRICE)))
//            ) {
//                System.out.println(notebook.toString());
//            }
//        }
//    }
//
//    public static String inputString(String msg) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println(msg);
//        return scanner.nextLine();
//    }
//
//    public static int inputIntegerLimit(String msg, int min, int max) {
//        msg += "(" + min + " - " + max + ")";
//        int inNumber;
//        do {
//            inNumber = inputInteger(msg);
//        }
//        while (inNumber < min || inNumber > max);
//        return inNumber;
//    }
//
//    public static int inputInteger(String msg) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println(msg);
//        while (true) {
//            if (scanner.hasNextInt()) {
//                return scanner.nextInt();
//            } else {
//                scanner.next();
//                System.out.println("Необходимо ввести целое число:");
//            }
//        }
//    }

    /**
     * Тест наличия в строке целого числа
     *
     * @param s - строка
     * @return true если в строке имеется целое число
     */
//    public static boolean isInteger(String s) {
//        boolean res = false;
//        Scanner sc = new Scanner(s);
//        if (sc.hasNextInt(10)) {
//            res = true;
//        }
//        sc.close();
//        return res;
//    }

    /**
     * Из строки в целое без обработки исключений
     *
     * @param s - строка
     * @return 0, если ошибка преобразования
     */
//    public static int getInteger(String s) {
//        if (isInteger(s)) {
//            return Integer.valueOf(s);
//        }
//        return 0;
//    }

}