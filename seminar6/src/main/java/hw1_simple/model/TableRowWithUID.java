package hw1_simple.model;

import java.util.Objects;

public class TableRowWithUID<T> extends TableRowBase<T> {
    private static int rowUniqueId = 0;

    public TableRowWithUID(T data) {
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
    public T getItem() {
        return super.item;
    }

    @Override
    public void setItem(T item) {
        super.item = item;
    }

    @Override
    public String toString() {
        return String.format("%d %s", getId(), getItem().toString());
    }

    @Override
    public boolean equals(Object o) {
        var t = (TableRowWithUID) o;
        return t.item.equals(super.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.item);
    }
}
