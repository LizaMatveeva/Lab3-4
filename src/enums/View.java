package enums;

public enum View {
    MOVEMENT("Оживленное движение."),
    TRANSPORT("Машины, велосипеды, мотоциклы."),
    MOTORBIKER("мотоциклист"),
    PEOPLE("люди"),
    PARKING_PLACE("место Доктора Крида"),
    AMBULANCE_CAR("скорая помощь");
    private String view;

    View(String view) {
        this.view = view;
    }

    public String toString() {
        return view;
    }
}
