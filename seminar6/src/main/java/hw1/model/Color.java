package hw1.model;

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
