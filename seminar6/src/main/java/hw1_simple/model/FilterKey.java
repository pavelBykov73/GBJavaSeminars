package hw1_simple.model;

/**
 * Ключи для фильтра
 */
public enum FilterKey {
    BRAND(0), MODEL(1), DIAGONAL(2),
    OS(3), RAM(4), HDD(5), COLOR(6), PRICE(7);
    private int code;

    FilterKey(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
