package hw1.model;

/**
 * Перечисление цветов
 * NONE - цвет не определен
 */
public enum Color {
    NONE(""), SILVER("Silver"), BLACK("Black"), WHITE("White");
    private String code;

    Color(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
