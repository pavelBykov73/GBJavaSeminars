package hw1_simple.model;

public abstract class TableRowBase<T> {
    int uniqueId;
    T item;

    public abstract int getId();

    public abstract void setId(int id);

    public abstract T getItem();

    public abstract void setItem(T item);
}
