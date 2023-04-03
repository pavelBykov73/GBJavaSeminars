package hw1_simple.model;

import java.util.HashSet;
import java.util.Set;

public class DataTable<T> implements IDataTable<T> {
    Set<TableRowWithUID> table = new HashSet<>();

    @Override
    public int Add(T item) {
        for (TableRowWithUID row : table) {
            if (row.item.equals(item)) {
                return row.getId();
            }
        }
        TableRowWithUID row = new TableRowWithUID(item);
        table.add(row);
        return row.getId();
    }

    @Override
    public boolean Delete(int id) {
        return false;
    }

    @Override
    public String toString() {
        String str = new String();
        for (TableRowWithUID row : table) {
            str += row.toString() + "\n";
        }
        return str;
    }

    public void print() {
        for (TableRowWithUID row : table) {
            System.out.println(row.toString());
        }
    }
}
