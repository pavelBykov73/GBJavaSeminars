package org.example.hw1;

import org.example.hw1.model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Дан массив записей: наименование товара, цена, сорт.
 * Найти наибольшую цену товаров 1го или 2го сорта среди товаров,
 * название которых содержит «высший»
 */
public class Ex1 {
    public static void main(String[] args) {
        Product product1 = new Product("молоко", 75.99, 2);
        Product product2 = new Product("молоко высший сорт", 109.99, 1);
        Product product3 = new Product("масло", 150.00, 1);
        Product product4 = new Product("масло так себе, но высший сорт 1кг", 3505.99, 3);
        Product product5 = new Product("кефир супер", 77.99, 1);
        Product product6 = new Product("кефир высший", 75.99, 1);
        Product product7 = new Product("орехи", 2750.50, 2);
        Product product8 = new Product("орехи высший сорт", 1890.00, 1);

        List<Product> productList = new ArrayList<Product>();
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productList.add(product5);
        productList.add(product6);
        productList.add(product7);
        productList.add(product8);

        double maxPrice = 0;
        Product resultProduct = null;
        for (Product item : productList
        ) {
            if ((item.getGrade() == 1
                    || item.getGrade() == 2)
                    && item.getName().lastIndexOf("высший") > 0
                    && item.getPrice() > maxPrice
            ) {
                maxPrice = item.getPrice();
                resultProduct = item;
            }
        }
        if (resultProduct != null) {
            System.out.printf(
                    "Товар 1 или 2 сорта с максимальной ценой и \"высший\" в названии\n%s (сорт %d цена = %.2f р.)",
                    resultProduct.getName(),
                    resultProduct.getGrade(),
                    resultProduct.getPrice()
            );
        } else {
            System.out.println("Странно, но не нашли такого товара");
        }
    }
}
