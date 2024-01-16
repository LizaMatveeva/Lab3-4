package transport;
import enums.*;
import interfaces.*;
public class Motorbike extends Car {
    final int maxSpeed = 120;
    protected Place place = Place.STREET;
    public Motorbike(String type) {
        super(type);
    }
    public void dush () {
        setDriveState(Drive.DUSH);
        setDriveSpeed(maxSpeed);
        System.out.printf("%s %s по %s, скорость: %d.\n", type, state, place, speed);
    }
    public void setPlace(Place place){
        this.place = place;
    }
}
