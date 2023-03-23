package hw1.model;

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
