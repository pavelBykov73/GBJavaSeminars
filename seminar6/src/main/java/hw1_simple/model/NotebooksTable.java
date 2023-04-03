package hw1_simple.model;

import java.util.*;


public class NotebooksTable extends DataTable<Notebook> implements INotebooksTable {

    public Set<Notebook> getNotebooks(Map<FilterKey, String> mapFilter) {
        Set<Notebook> filtered = new HashSet<>();
        for (TableRowWithUID<Notebook> notebook : table) {
            if (mapFilter == null
                    || checkFilterCondition(notebook.getItem(), mapFilter)
            ) {
                //System.out.println(notebook.toString());
                filtered.add(notebook.getItem());
            }
        }
        return filtered;
    }

    public void printNotebooks(Map<FilterKey, String> mapFilter) {
        for (TableRowWithUID<Notebook> notebook : table) {
            if (mapFilter == null
                    || checkFilterCondition(notebook.getItem(), mapFilter)
            ) {
                System.out.println(notebook.toString());
            }
        }
    }

    boolean checkFilterCondition(Notebook notebook, Map<FilterKey, String> mapFilter) {
        if (!(mapFilter.containsKey(FilterKey.BRAND) && !notebook.getBrand().contains(mapFilter.get(FilterKey.BRAND)))
                && !(mapFilter.containsKey(FilterKey.MODEL) && !notebook.getModel().contains(mapFilter.get(FilterKey.MODEL)))
                && !(mapFilter.containsKey(FilterKey.OS) && !notebook.getOs().contains(mapFilter.get(FilterKey.OS)))
                && !(mapFilter.containsKey(FilterKey.COLOR) && !notebook.getColor().contains(mapFilter.get(FilterKey.COLOR)))
                && !(mapFilter.containsKey(FilterKey.DIAGONAL) && notebook.getDiagonal() < getInteger(mapFilter.get(FilterKey.DIAGONAL)))
                && !(mapFilter.containsKey(FilterKey.RAM) && notebook.getRamGb() < getInteger(mapFilter.get(FilterKey.RAM)))
                && !(mapFilter.containsKey(FilterKey.HDD) && notebook.getHddGb() < getInteger(mapFilter.get(FilterKey.HDD)))
                && !(mapFilter.containsKey(FilterKey.PRICE) && notebook.getPrice() > getInteger(mapFilter.get(FilterKey.PRICE)))
        ) {
            return true;
        }
        return false;
    }

    /**
     * Тест наличия в строке целого числа
     *
     * @param s - строка
     * @return true если в строке имеется целое число
     */
    static boolean isInteger(String s) {
        boolean res = false;
        Scanner sc = new Scanner(s);
        if (sc.hasNextInt(10)) {
            res = true;
        }
        sc.close();
        return res;
    }

    /**
     * Из строки в целое без обработки исключений
     *
     * @param s - строка
     * @return 0, если ошибка преобразования
     */
    static int getInteger(String s) {
        if (isInteger(s)) {
            return Integer.valueOf(s);
        }
        return 0;
    }

}
