import module.Vector;

/**
 * Приложение тестирующее класс Vector
 */
public class Ex0 {
    public static void main(String[] args) {
        Vector vector1 = new Vector(1, 3, 5);
        Vector vector2 = new Vector(2, 4, 6);
        System.out.println("Вектор 1: " + vector1.toString());
        System.out.println("Вектор 2: " + vector2.toString());
        System.out.println("Длина вектора 1: " + vector1.getLength());
        System.out.println("Скалярное умножение векторов: " + vector1.scalarMultiplication(vector2));
        System.out.println("Векторное умножение векторов: " + vector1.vectorMultiplication(vector2).toString());
        vector1.setXYZ(1, 3, 5);
        System.out.println("Косинус угла между векторами: " + vector1.getAngle(vector2));
        System.out.println("Сумма векторов: " + vector1.sum(vector2).toString());
        vector1.setXYZ(1, 3, 5);
        System.out.println("Разность векторов: " + vector1.sub(vector2).toString());
    }
}

