package transport;
import enums.*;
import exceptions.*;
import interfaces.*;

public class Car implements DriveCars, CarSpeed, Function {
    protected Drive state = Drive.STAND;
    protected Place place = Place.STREET;
    protected int speed = 0;
    private final int maxSpeed = 90;
    protected String type;
    public Car (String type) {
        this.type = type;
    }
    @Override
    public void parking(Place place) {
        if (Place.STREET == place || Place.UNIVERSITY ==place || Place.PARKING_HOSPITAL == place){
            setPlace(place);
            System.out.printf("%s находится на %s.\n", type, place);
        }
    }
    @Override
    public void choosingAPlace (View view){
        int number = Function.function(38);
        if (view.equals(View.PARKING_PLACE) && (number <= 5 || number >= 30)){
            throw new NoParkingException("!нет места для парковки!");
        }
        System.out.printf("%s припарковалась на парковочное место с номером %d и надписью %s.\n", type, number, view);
    }

    public void setPlace(Place place){
        this.place = place;
    }
    @Override
    public void stand() {
        setDriveState(Drive.STAND);
        System.out.printf("%s %s.\n", type, state);
    }
    @Override
    public void ride() {
        setDriveState(Drive.RIDE);
        setDriveSpeed(90);
        System.out.printf("%s %s, cкорость: %d.\n", type, state, speed);
    }
    @Override
    public void slowDown() {
        setDriveState(Drive.SLOW_DOWN);
        for (speed = 90; speed >= 0; speed -= 15){
            setDriveSpeed(speed);
            System.out.printf("%s %s, скорость: %d.\n", type, state, speed);}
    }
    @Override
    public void gainSpeed() {
        setDriveState(Drive.GAIN_SPEED);
        for (speed = 0; speed <= maxSpeed; speed += 15){
            setDriveSpeed(speed);
            System.out.printf("%s %s, скорость: %d.\n", type, state, speed);}
    }
    @Override
    public void fastSlowDown() {
        setDriveState(Drive.FAST_SLOW_DOWN);
        for (speed = 90; speed >= 0; speed -= 45){
            setDriveSpeed(speed);
            System.out.printf("%s %s, скорость: %d.\n", type, state, speed);}
    }
    @Override
    public void setDriveState (Drive state){
        this.state = state;
    }
    public void setDriveSpeed (int speed){
        this.speed = speed;
    }
    public String toString (){
        return type;
    }
}
