package interfaces;

import places.*;
import people.*;
import transport.*;

public interface AmbulanceDeliver {
    void takePatient(boolean ill, Hospital hospital);
    void ambulanceDeliver(AmbulanceCar type, Hospital hospital, Patient patient);
}
