package people;

import enums.*;
import interfaces.*;
import exceptions.*;
import items.Thermometr;

public class Patient extends Human {
    private boolean ill;

    public Patient(String post) {
        super("Пациентка");
    }

    public void ill(int randomhealthy) {
        try {
            if (randomhealthy == 0) {
                this.ill = false;
                throw new HealthyException(String.format("Пациентка %sа", Illness.HEALING));
            } else {
                this.ill = true;
                System.out.printf("%s %s.\n", post, Illness.SICK);
            }
        } catch (HealthyException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public String toString() {
        return post;
    }

    public boolean getIll() {
        return ill;
    }

    public int measureTemperature(Thermometr thermometr) throws Exception {
        return thermometr.takeTemperature(this);
    }
}
