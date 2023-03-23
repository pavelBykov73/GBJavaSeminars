package hw_test.model;

public class NotebookT {
    static int idUnique = 0;
    private int id;
    private String name;
    private int price;

    public NotebookT(String name, int price) {
        this.name = name;
        this.price = price;
        id = idUnique;
    }

    public String toString() {
        String str = new String();
        str = String.format("id %d, model %s, price = %d", id, name, price);
        return str;
    }

    @Override
    public boolean equals(Object o) {
        var t = (NotebookT) o;
        return t.id == id;// && t.name.equals(name);
    }

    @Override
    public int hashCode() {
        return id;
    }
}
