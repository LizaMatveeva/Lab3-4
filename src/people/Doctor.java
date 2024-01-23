package people;

import interfaces.*;
import places.*;
import transport.*;
import exceptions.*;
import people.*;

public class Doctor extends Human implements AmbulanceDeliver {
    boolean countHealthy = false;
    public Doctor(String post) {
        super(post);
    }
    public void takePatient(boolean ill, Hospital hospital) {
        if (ill) {
            System.out.printf("%s забирает пациента в %s.\n", post, hospital);
            countHealthy = true;
        } else {
            System.out.printf("%s не забирает пациента в %s.\n", post, hospital);
        }
    }
    @Override
    public void ambulanceDeliver(AmbulanceCar type, Hospital hospital, Patient patient) {
        if (countHealthy) {
            System.out.printf("%s едет в %s с %s.\n", type, hospital, patient);
        } else {
            System.out.printf("%s едет в %s без %s.\n", type, hospital, patient);
        }
    }
}
