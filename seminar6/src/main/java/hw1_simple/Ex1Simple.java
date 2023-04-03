package hw1_simple;

import hw1_simple.model.*;


/**
 * 03.04.2023 - доработка решения для использования ООП - интерфейс, абстрактный класс.
 * <p>
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
        NotebooksTable notebooksTable = new NotebooksTable();
        addSampleNotebooks(notebooksTable);
        System.out.println("Полный список ноутбуков:");
        System.out.println(notebooksTable);

        NotebookFilter filter = new NotebookFilter();
        filter.addItem(FilterKey.MODEL, "notebook1");
        filter.userFilterMenu();

        System.out.println("\nНоутбуки удовлетворяющие условию:");
        notebooksTable.printNotebooks(filter.getFilter());
//        Set<Notebook> notebookView = (notebooksTable).getNotebooks(filter.getFilter());
//        for (Notebook notebook : notebookView) {
//            System.out.println(notebook);
//        }
    }

    /**
     * Заполнение списка ноутбуков тестовыми данными
     *
     * @param nbs -  куда класть ноутбуки
     */
    private static void addSampleNotebooks(NotebooksTable nbs) {
        nbs.Add(new Notebook("HP", "fg-432", 14,
                "WINDOWS", "BLACK", 2, 4000, 43000));
        nbs.Add(new Notebook("Huawei", "KLVL-56", 13,
                "WINDOWS", "Silver", 16, 1000, 24500));
        nbs.Add(new Notebook("DELL", "fg-434", 17,
                "WINDOWS", "BLACK", 4, 4096, 66000));
        nbs.Add(new Notebook("Samsung", "Model 56", 15,
                "Linux", "Silver", 8, 1000, 14500));
        nbs.Add(new Notebook("HP", "rrrrr", 15,
                "LiNUX", "BLACK", 4, 4096, 43000));
        nbs.Add(new Notebook("Asus", "32876", 19,
                "DOS", "Silver", 6, 1000, 24500));
        nbs.Add(new Notebook("Acer", "fg-56", 14,
                "No OS", "BLACK", 4, 2000, 48000));
        nbs.Add(new Notebook("Huawei", "ddd-56", 13,
                "WINDOWS", "Silver", 16, 8096, 94500));
        nbs.Add(new Notebook("HP", "kzs-44", 15,
                "Lin", "BLACK", 8, 4096, 35000));
        nbs.Add(new Notebook("Asus", "KLVL-56", 13,
                "WINDOWS-10", "White", 16, 1000, 27800));
        nbs.Add(new Notebook("Asus", "KLVL-56", 13,
                "WINDOWS-11", "Silver", 16, 1000, 27800));
        nbs.Add(new Notebook("Asus", "KLVL-56", 13,
                "WINDOWS Mobile", "Silver", 16, 1000, 27800));
        // Данная запись не включится, как дубль
        nbs.Add(new Notebook("Asus", "KLVL-56", 13,
                "WINDOWS Mobile", "Silver", 16, 1000, 27800));
    }
}