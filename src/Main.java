import enums.*;
import exceptions.*;
import interfaces.Function;
import items.Thermometr;
import places.*;
import transport.*;
import people.*;

public class Main implements Function {

    public static void main (String[] args) throws Exception {
        Thermometr thermometr = new Thermometr();
        Luice luice = new Luice("Луис", "доктор");
        Doctor doctor = new Doctor("Доктор");
        Patient patient = new Patient("Пациентка");
        Stiv stiv = new Stiv("Стив Мастертон", "помощник врача");
        Joan joan = new Joan("Джоан Чарлтон", "медсестра", thermometr);
        Motorbiker motorbiker = new Motorbiker( "Мотоциклист");
        Hospital hospital = new Hospital("лазарет");


        Motorbike motorbike = new Motorbike("Mотоцикл");
        Car car = new Car("Машина Луиса");
        AmbulanceCar ambulanceCar = new AmbulanceCar("скорая помощь");
        car.ride();
        car.slowDown();
        luice.driveToPlace(car, Place.UNIVERSITY);
        car.stand();
        car.gainSpeed();
        car.ride();
        luice.brain.mind(View.MOVEMENT);
        luice.brain.mind(View.TRANSPORT);
        car.fastSlowDown();
        motorbiker.driveDush(motorbike);
        motorbiker.hands.waveHand();
        luice.brain.feel(View.MOTORBIKER);
        car.gainSpeed();
        car.ride();
        car.slowDown();
        luice.driveToPlace(car, Place.PARKING_HOSPITAL);
        luice.choosingPlace(car, View.PARKING_PLACE);
        luice.brain.feel(View.AMBULANCE_CAR);
        luice.go(1, Place.HOSPITAL);
        hospital.operatingRoom.openOperatingRoom(DoorState.OPEN);
        luice.go(1, Place.OPERATING_ROOM);
        luice.go(-1, Place.OPERATING_ROOM);
        hospital.operatingRoom.openOperatingRoom(DoorState.CLOSED);
        hospital.ward.openWard(DoorState.OPEN);
        luice.go(1, Place.WARD);
        joan.arm.takeSubject(joan.arm.getSubjectCount(), Subjects.THERMOMETR);
        joan.takeOffTemperature(patient);
        joan.arm.takeSubject(joan.arm.getSubjectCount(),Subjects.THERMOMETR);

        stiv.arm.takeSubject(stiv.arm.getSubjectCount(), Subjects.DRIVE_BOOK);
        ambulanceCar.ambulanceCarDrive();


        int randomhealthy = Function.function(2);
//        try {patient.ill(randomhealthy);}
//        catch (HealthyException ex){
//            System.out.println(ex.getMessage());
//        }
        patient.ill(randomhealthy);
        boolean stateAmbulanceCar = patient.getIll();
        doctor.takePatient(stateAmbulanceCar,  hospital);
        doctor.ambulanceDeliver(ambulanceCar, hospital, patient);
        stiv.arm.takeSubject(stiv.arm.getSubjectCount(), Subjects.DRIVE_BOOK);
        luice.addThought("Где машина?");
        luice.getThought(0);
        joan.addThought("О, у нас тут настоящая трагедия!");
        joan.getThought(0);
        stiv.addThought("Радиатор полетел - машина в ремонте!");
        stiv.getThought(0);
        luice.brain.feel(View.PEOPLE);
        luice.addThought("Когда мы получим ее обратно?");
        luice.getThought(1);
    }
}