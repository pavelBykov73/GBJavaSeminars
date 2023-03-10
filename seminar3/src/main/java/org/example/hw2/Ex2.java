package org.example.hw2;

import org.example.hw2.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Получить наименования товаров заданного сорта с наименьшей ценой.
 */
public class Ex2 {
    public static void main(String[] args) {
        Product product1 = new Product("молоко", "Казахстан", 1000, 75.99, 2);
        Product product2 = new Product("молоко высший сорт", "Россия", 1000, 109.99, 1);
        Product product3 = new Product("масло", "Белоруссия", 200, 150.00, 1);
        Product product4 = new Product("масло так себе, но высший сорт 1кг", "Россия", 1000, 3505.99, 3);
        Product product5 = new Product("кефир супер", "Россия", 500, 75.99, 1);
        Product product6 = new Product("кефир высший", "Россия", 400, 75.99, 1);
        Product product7 = new Product("орехи", "Узбекистан", 500, 2750.50, 2);
        Product product8 = new Product("орехи высший сорт", "Россия", 200, 1890.00, 1);

        List<Product> productList = new ArrayList<Product>();
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productList.add(product5);
        productList.add(product6);
        productList.add(product7);
        productList.add(product8);

        Scanner scanner = new Scanner(System.in);
        int grade;
        System.out.println("Введите сорт товара (число):");
        grade = scanner.nextInt(); // не будем в этот раз делать проверку корректного ввода
        scanner.close();

        double minPrice = Double.MAX_VALUE;
        List<Product> resultProduct = new ArrayList<>();
        for (Product item : productList) {
            if (item.getGrade() == grade
                    && item.getPrice() < minPrice
            ) {
                minPrice = item.getPrice();
            }
        }
        /*
        сделаем выборку продуктов в отдельный список (может потребоваться для дальнейшей обработки)
         */
        for (Product item : productList) {
            if (item.getGrade() == grade
                    /* && item.getPrice() == minPrice */
                    && Math.abs(item.getPrice() - minPrice) < 0.01 // с точностью до копейки
            ) {
                resultProduct.add(item);
            }
        }
        if (resultProduct.size() > 0) {
            System.out.printf("Список товаров сорта %d с наименьшей ценой:\n", grade);
            for (Product item : resultProduct) {
                System.out.println(item.toString());
            }
        } else {
            System.out.println("не нашли такого товара");
        }
    }
}
