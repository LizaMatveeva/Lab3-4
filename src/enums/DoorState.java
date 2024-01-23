package enums;

public enum DoorState {
    OPEN("Дверь в помещение открыта"),
    CLOSED("Дверь в помещение закрыта");
    private String state;

    DoorState(String state) {
        this.state = state;
    }

    public String toString() {
        return state;
    }
}
