package hw1.model;

/**
 * Перечисление Операционных систем
 * NOTKNOWN - не определена или не имеет значения (для фильтра)
 * TODO Перевести в формат таблицы т.к. может расширяться
 */

public enum Os {
    NOTKNOWN("Not known"), NOOS("NoOs"), WINDOWS("Windows"), LINUX("Linux");
    private String os;

    Os(String os) {
        this.os = os;
    }

    public String getOs() {
        return os;
    }
}
