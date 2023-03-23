package hw1.model;

import java.io.Console;
import java.util.*;

/**
 * Настройки фильтра
 */
public class Filter {
    public int brandId; // если 0 - то не учитываем id и используем brandName
    public String brandName;
    public String model;
    public int diagonalMin;
    public Os os;
    public Color color;
    public int ramGbMin;
    public int hddGbMin;
    public int priceMax;

    public Filter() {
        brandId = 0;
        brandName = "";
        model = "";
        diagonalMin = 0;
        os = Os.NOTKNOWN;
        color = Color.NONE;
        ramGbMin = 0;
        hddGbMin = 0;
        priceMax = 1000000;
    }

    public int consoleInputBrandId(Brands brands) {
        int inNumber;
        Set<Integer> brandIds = new HashSet<>();
        for (Brand brand : brands.brands) {
            brandIds.add(brand.id);
            System.out.println(brand.id + ": " + brand.name);
        }
        do {
            inNumber = inputInteger("Выберите бренд (число):");
        }
        while (!brandIds.contains(inNumber) && inNumber != 0);
        return inNumber;
    }

    public Os consoleInputOs() {
        int inNumber;
        for (int i = 0; i < Os.values().length; i++) {
            System.out.println(i + ": " + Os.values()[i]);
        }
        inNumber = inputIntegerLimit("Выберите ОС (число):", 0, Os.values().length - 1);
        return Os.values()[inNumber];
    }

    public Color consoleInputColor() {
        int inNumber;
        for (int i = 0; i < Color.values().length; i++) {
            System.out.println(i + ": " + Color.values()[i]);
        }
        inNumber = inputIntegerLimit("Выберите цвет (число):", 0, Color.values().length - 1);
        return Color.values()[inNumber];
    }

    public int inputIntegerLimit(String msg, int min, int max) {
        msg += "(" + min + " - " + max + ")";
        int inNumber;
        do {
            inNumber = inputInteger(msg);
        }
        while (inNumber < min || inNumber > max);
        return inNumber;
    }

    public int inputInteger(String msg) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(msg);
        while (true) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                scanner.next();
                System.out.println("Необходимо ввести целое число:");
            }
        }
    }

    public String inputString(String msg) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(msg);
        return scanner.nextLine();
    }
}
