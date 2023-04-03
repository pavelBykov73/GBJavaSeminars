package hw1_simple.model;

import java.util.Objects;

public class NotebookTableRow extends TableRow<Notebook1> {
    private static int rowUniqueId = 0;

    public NotebookTableRow(Notebook1 data) {
        setId(rowUniqueId++);
        setItem(data);
    }

    public int getId() {
        return super.uniqueId;
    }

    @Override
    public void setId(int id) {
        super.uniqueId = id;
    }

    @Override
    public Notebook1 getItem() {
        return super.item;
    }

    @Override
    public void setItem(Notebook1 item) {
        super.item = item;
    }

    @Override
    public String toString() {
        return String.format("%d %s %s", getId(), super.item.getBrand(), super.item.getModel());
//        return super.toString();
    }

    @Override
    public boolean equals(Object o) {
        var t = (NotebookTableRow) o;
        return t.item.equals(super.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.item);
    }
}
