package people;

import enums.*;
import interfaces.Coordinate;
import transport.Car;

import java.util.ArrayList;
import java.util.Objects;

import static enums.Feel.*;

public class Luice extends Person implements Coordinate {
    private int coordinate = 0;
    final ArrayList<String> imagination = new ArrayList<>();
    public ArrayList<String> emotion = new ArrayList<>();
    public ArrayList<String> luiceThought = new ArrayList<>();

    @Override
    public void addThought(String message) {
        luiceThought.add(message);
    }

    public Luice(String name, String post) {
        super(name, post);
    }

    @Override
    public void getThought(int numberMassiv) {
        if (Objects.equals(luiceThought.get(numberMassiv), "Где машина?")) {
            System.out.printf("Доброе утро. %s - сазал %s.\n", luiceThought.get(0), name);
        } else if (Objects.equals(luiceThought.get(1), "Когда мы получим ее обратно?")) {
            System.out.printf("%s - сазал %s.\n", luiceThought.get(1), name);
        }
    }

    public void driveToPlace(Car car, Place place) {
        car.parking(place);
    }

    public void choosingPlace(Car car, View view) {
        car.choosingAPlace(view);
    }

    public Brain brain = new Brain();

    public class Brain {
        public void mind(View view) {
            if (View.AMBULANCE_CAR == view) {
                imagination.add(String.valueOf(view));
                System.out.printf("%s не увидел %s и почувствовал %s.\n", name, view, Feel.IRRITATION);
            } else if (View.MOVEMENT == view || View.TRANSPORT == view) {
                imagination.add(String.valueOf(view));
                System.out.println(view);
            }
        }
        public void feel(View view) {
            switch (view) {
                case MOTORBIKER -> {
                    System.out.printf("%s чувствует %s.\n", name, Feel.IRRITATION);
                    emotion.add(String.valueOf(Feel.IRRITATION));
                }
                case AMBULANCE_CAR -> {
                    System.out.printf("%s чувствует %s, так как не увидел %s.\n", name, Feel.ALERTNESS, View.AMBULANCE_CAR);
                    emotion.add(String.valueOf(Feel.ALERTNESS));
                }
                case PEOPLE -> {
                    System.out.printf("-Жаль, - %s сказал, не чувствуя %s.\n", name, REGRET);
                    luiceThought.add(String.valueOf(REGRET));
                    emotion.add(String.valueOf(REGRET));
                }
            }
        }
    }
    @Override
    public void go(int number, Place place) {
        if (number == -1) {
            setCoordinate(getCoordinate() - number);
            System.out.printf("%s вышел из %s.\n", name, place);
        } else if (number == 1) {
            setCoordinate(getCoordinate() + number);
            System.out.printf("%s зашел в %s.\n", name, place);
        }
    }
    @Override
    public int getCoordinate() {
        return coordinate;
    }
    @Override
    public void setCoordinate(int coordinate) {
        this.coordinate = coordinate;
    }
}
