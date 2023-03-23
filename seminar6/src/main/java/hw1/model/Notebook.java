package hw1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;


/**
 *
 */
@Data
@AllArgsConstructor
@Getter
public class Notebook {
    private int id;
    private int brandId;
    private String model;
    private int diagonal;
    private Os os;
    private Color color;
    private int ramGb;
    private int hddGb;
    private int price;

//    public Notebook(int id, int brandId, String model, int diagonal, Os os, Color color, int ramGb, int hddGb, int price) {
//        this.id = id;
//        this.brandId = brandId;
//        this.model = model;
//        this.diagonal = diagonal;
//        this.os = os;
//        this.color = color;
//        this.ramGb = ramGb;
//        this.hddGb = hddGb;
//        this.price = price;
//    }

    public String toString() {
        String str = new String();
        str = String.format("Brand: %d,\t model %s,\t OS %s,\t RAM: %d GB,\t price = %d",
                brandId,
                model,
                os.getOs(),
                ramGb,
                price
        );
        return str;
    }

    @Override
    public boolean equals(Object o) {
        var t = (Notebook) o;
        return t.brandId == brandId
                && t.model == model
                && t.os == os
                && t.color == color
                && t.hddGb == hddGb
                && t.ramGb == ramGb
                && t.diagonal == diagonal;
    }

}
