package enums;

public enum Feel {
    IRRITATION("раздражение"),
    ALERTNESS("напряжение"),
    REGRET("сожаление");
    private String type;

    Feel(String type) {
        this.type = type;
    }

    public String toString() {
        return type;
    }
}
