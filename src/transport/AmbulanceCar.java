package transport;

import enums.Drive;
import interfaces.RandomDate;

import java.util.ArrayList;

public class AmbulanceCar extends Car implements RandomDate {
    private int countDrive = (int) (Math.random() * 38);
    public ArrayList<Integer> driveBook = new ArrayList<>();

    public AmbulanceCar(String typeTransport) {
        super(typeTransport);
    }

    public void ride() {
        setDriveState(Drive.RIDE);
    }

    public void setDriveState(Drive state) {
        this.state = state;
    }

    public void ambulanceCarDriveBook() {//смысл метода в том, что в книге записываются выезды машины, выводится количество этих выводов и дата последнего выезда
        for (int i = 0; i <= countDrive; i += 1) {
            driveBook.add(i);
            ride();
        }
        System.out.printf("%s выехала на выезд %d раз. Последний раз: ", typeTransport, driveBook.size());
        getDate();
    }
}
