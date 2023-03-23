package hw1.model;

/**
 * Класс "Бренд"
 */
public class Brand {
    int id;
    String name;

    public Brand(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%d %s", id, name);
    }

    @Override
    public boolean equals(Object o) {
        var t = (Brand) o;
        return id == t.id; // Не может быть несколько записей с одинаковым id
    }

    @Override
    public int hashCode() {
        return id;
    }
}
