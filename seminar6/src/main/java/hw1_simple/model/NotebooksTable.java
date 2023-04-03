package hw1_simple.model;

import java.util.HashSet;
import java.util.Set;

public class NotebooksTable<T> implements IDataTable<T> {
    Set<NotebookTableRow> notebooks = new HashSet<>();

    @Override
    public int Add(T item) {
        for (NotebookTableRow row : notebooks) {
            if (row.item.equals(item)) {
                return row.getId();
            }
        }
        NotebookTableRow row = new NotebookTableRow(item);
        notebooks.add(row);
        return row.getId();
    }

    @Override
    public boolean Delete(int id) {
        return false;
    }

    @Override
    public String toString() {
        String str = new String();
        for (NotebookTableRow row : notebooks) {
            //System.out.println(row);
            str += row.toString() + "\n";
        }
        return str;
    }

    public void print() {
        for (NotebookTableRow row : notebooks) {
            //System.out.println(row.data + row.getId());
            System.out.println(row.toString());
        }
    }
}
