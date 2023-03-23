package hw1.model;

import java.util.HashSet;
import java.util.Set;

public class Notebooks {
    public Set<Notebook> notebooks = new HashSet<>();
    Brands brands;
    int idUnique;

    public Notebooks() {
        brands = new Brands();
        idUnique = 0;
    }

    public Brands getBrands() {
        return brands;
    }

    public int addNotebook(String brandName, String model, int diagonal, Os os, Color color,
                           int ram, int hdd, int price) {
        Notebook notebook = new Notebook(++idUnique, brands.addBrand(brandName), model, diagonal,
                os, color, ram, hdd, price);

        for (Notebook nb : notebooks) {
            if (nb.equals(notebook)) {
                idUnique--;
                return nb.getId();
            }
        }
        notebooks.add(notebook);
        return idUnique;
    }

    public Notebook getNotebook(int id) {
        for (Notebook nb : notebooks) {
            if (nb.getId() == id) {
                return nb;
            }
        }
        return null;
    }

    public void print() {
        for (Notebook nb : notebooks) {
            System.out.println(toString(nb));
        }
    }

    public void print(Filter flt) {
        for (Notebook nb : notebooks) {
            if (
                    (flt.brandId == 0 || nb.getBrandId() == flt.brandId) &&
                            (flt.brandId == 0 && brands.getName(nb.getBrandId()).contains(flt.brandName)) &&
                            nb.getModel().contains(flt.model)
                            && nb.getRamGb() >= flt.ramGbMin
                            && nb.getHddGb() >= flt.hddGbMin
                            && nb.getDiagonal() >= flt.diagonalMin
                            && nb.getPrice() <= flt.priceMax
                            && (flt.os == Os.NOTKNOWN || nb.getOs() == flt.os)
                            && (flt.color == Color.NONE || nb.getColor() == flt.color)
            ) {
                System.out.println(toString(nb));
            }
        }
    }

    public String toString(Notebook nb) {
        return new String().format("id %d,\t Brand: %s,\t model %s,\t OS %s,\t RAM: %d GB," +
                        "\t HDD: %d GB,\t color: %s GB,\t price = %d",
                nb.getId(),
                brands.getName(nb.getBrandId()),
                nb.getModel(),
                nb.getOs(),
                nb.getRamGb(),
                nb.getHddGb(),
                nb.getColor(),
                nb.getPrice()
        );
    }
}
// hset.stream().filter(data -> Objects.equals(data, "Tim")).findFirst().get()
//Stream<String> citiesStream = Stream.of("Париж", "Лондон", "Мадрид","Берлин", "Брюссель");
//citiesStream.filter(s->s.length()==6).forEach(s->System.out.println(s));

