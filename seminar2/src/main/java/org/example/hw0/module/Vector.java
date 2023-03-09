package module;

/**
 * Проектирование и создание класса, описывающего 3D вектор
 * Задача:
 * <p>
 * Создайте класс, который описывает вектор (в трёхмерном пространстве).
 */
public class Vector {
    private double x;
    private double y;
    private double z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setXYZ(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public String toString() {
        return "{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                "}";
    }

    /**
     * @return Длина вектора
     */
    public double getLength() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    /**
     * Скалярное умножение векторов
     *
     * @param vector
     * @return РЕзультат скалярного умножения
     */
    public double scalarMultiplication(Vector vector) {
        return x * vector.x + y * vector.y + z * vector.z;
    }

    /**
     * Угол между векторами (COS)
     *
     * @param vector
     * @return Косинус угла между векторами
     */
    public double getAngle(Vector vector) {
        return scalarMultiplication(vector) / (this.getLength() * vector.getLength());
    }

    /**
     * Векторное умножение текущего вектора на вектор в параметре.
     * Результат сохраняется в текущем векторе
     *
     * @param vector
     * @return Результирующий вектор
     */
    public Vector vectorMultiplication(Vector vector) {
        x = y * vector.z - z * vector.y;
        y = z * vector.x - x * vector.z;
        z = x * vector.y - y * vector.x;
        return this;
    }

    /**
     * Сумма векторов (Результат сохраняется в текущем векторе)
     *
     * @param vector
     * @return результирующий вектор
     */
    public Vector sum(Vector vector) {
        x = x + vector.x;
        y = y + vector.y;
        z = z + vector.z;
        return this;
    }

    /**
     * Разность векторов (Результат сохраняется в текущем векторе)
     *
     * @param vector
     * @return результирующий вектор
     */
    public Vector sub(Vector vector) {
        x = x - vector.x;
        y = y - vector.y;
        z = z - vector.z;
        return this;
    }
}
