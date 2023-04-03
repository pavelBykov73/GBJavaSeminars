package hw1_simple.model;

public interface IDataTable<T> {
    public int Add(T item);

    public boolean Delete(int id);
}
