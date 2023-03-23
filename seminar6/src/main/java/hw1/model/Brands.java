package hw1.model;

import java.util.HashSet;
import java.util.Set;

public class Brands {
    public Set<Brand> brands = new HashSet<>();
    int idUnique;

    public Brands() {
        idUnique = 0;
    }

    public int addBrand(String brandName) {
        for (Brand br : brands
        ) {
            if (br.name.toLowerCase().equals(brandName.toLowerCase())) {
                return br.id;
            }
        }
        Brand brand = new Brand(++idUnique, brandName);
        brands.add(brand);
        return idUnique;
    }

    public String getName(int id) {
        for (Brand br : brands) {
            if (br.id == id) {
                return br.name;
            }
        }
        return "";
    }

    public void print() {
        for (Brand br : brands) {
            System.out.println(br.toString());
        }
    }
}
