package enums;

public enum Place {
    UNIVERSITY("университет"),
    PARKING_HOSPITAL("парковка лазaрет"),
    STREET("улица"),
    HOSPITAL("лазарет"),
    WARD("палата"),
    OPERATING_ROOM("операционная");
    private String state;

    Place(String state) {
        this.state = state;
    }

    public String toString() {
        return state;
    }

}
