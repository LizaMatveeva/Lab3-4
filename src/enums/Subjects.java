package enums;

public enum Subjects {
    DRIVE_BOOK("Книга выездов скорой помощи"),
    THERMOMETR("термометр");
    private String name;

    Subjects(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}
