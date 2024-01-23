package transport;

import enums.*;
import exceptions.*;
import interfaces.*;
import people.*;

public class Car implements DriveCars, CarSpeed, Function {
    protected Drive state = Drive.STAND;
    protected Place place = Place.STREET;
    protected int speed = 0;
    private final int maxSpeed = 90;
    protected String typeTransport;

    public Car(String typeTransport) {
        this.typeTransport = typeTransport;
    }

    @Override
    public void parking(Place place) {
        if (place.equals(Place.STREET) || place.equals(Place.UNIVERSITY) || place.equals(Place.PARKING_HOSPITAL)) {
            setPlace(place);
            System.out.printf("%s находится на %s.\n", typeTransport, place);
        }
    }

    @Override
    public void choosingAPlace(View view) {
        int number = Function.function(35);
        if (view.equals(View.PARKING_PLACE) && (number <= 5 || number >= 30)) {
            throw new NoParkingException("!нет места для парковки!");
        }
        System.out.printf("%s припарковалась на парковочное место с номером %d и надписью %s.\n", typeTransport, number, view);
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    @Override
    public void stand() {
        setDriveState(Drive.STAND);
        System.out.printf("%s %s.\n", typeTransport, state);
    }

    @Override
    public void ride() {
        setDriveState(Drive.RIDE);
        setDriveSpeed(90);
        System.out.printf("%s %s, cкорость: %d.\n", typeTransport, state, speed);
    }

    @Override
    public void slowDown() {
        setDriveState(Drive.SLOW_DOWN);
        for (speed = 90; speed >= 0; speed -= 15) {
            setDriveSpeed(speed);
            System.out.printf("%s %s, скорость: %d.\n", typeTransport, state, speed);
        }
    }

    @Override
    public void gainSpeed() {
        setDriveState(Drive.GAIN_SPEED);
        for (speed = 0; speed <= maxSpeed; speed += 15) {
            setDriveSpeed(speed);
            System.out.printf("%s %s, скорость: %d.\n", typeTransport, state, speed);
        }
    }

    @Override
    public void fastSlowDown() {
        setDriveState(Drive.FAST_SLOW_DOWN);
        for (speed = 90; speed >= 0; speed -= 45) {
            setDriveSpeed(speed);
            System.out.printf("%s %s, скорость: %d.\n", typeTransport, state, speed);
        }
    }

    @Override
    public void setDriveState(Drive state) {
        this.state = state;
    }

    public void setDriveSpeed(int speed) {
        this.speed = speed;
    }

    public String toString() {
        return typeTransport;
    }
}
