package transport;

import interfaces.RandomDate;

import java.util.ArrayList;

public class AmbulanceCar extends Car implements RandomDate {
    private int countDrive = (int) (Math.random()*38);
    public ArrayList<Integer> driveBook = new ArrayList<>();
    public AmbulanceCar(String type) {
        super(type);
    }
    public void ambulanceCarDrive (){
        for (int i = 0; i <= countDrive; i += 1 ){
            driveBook.add(i);
        }
        System.out.printf("%s выехала на выезд %d раз. Последний раз: ", type, driveBook.size());
        getDate();
    }
}
