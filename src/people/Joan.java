package people;
import enums.*;
import items.Thermometr;
import transport.*;
import exceptions.TakeHandSubjectException;
import interfaces.Temperature;
import java.util.ArrayList;
import java.util.Objects;

public class Joan extends Person implements Temperature {
    public ArrayList<String> joanThought = new ArrayList<>();
    private Thermometr thermometr;
    public Joan(String name, String post, Thermometr thermometr)  {
        super(name, post);
        this.thermometr = thermometr;
    }
    @Override
    public void getThought (int numberMassiv){
      if (Objects.equals(joanThought.get(numberMassiv), "О, у нас тут настоящая трагедия!")){
          System.out.printf("%s - сазал %s.\n", joanThought.get(0), name);
        }
    }
    @Override
    public void addThought(String message) {
        joanThought.add(message);
    }
    @Override
    public void takeOffTemperature(Patient patient) throws Exception {
        int temperatureOfPatient = patient.measureTemperature(thermometr);
        if (temperatureOfPatient>= 36.0 && temperatureOfPatient <= 37.5){
            System.out.printf("Пациентка здорова.\n", name);
        }
        else if (temperatureOfPatient < 36.0) {
            System.out.printf("Низкая температура тела - сказала %s.\n", name);
        }
        else if (temperatureOfPatient > 37.5){
            System.out.printf("Высокая температура тела - сказала %s.\n", name);
        }
    }
    public Arm arm = new Arm("рука");
    public class Arm {
        private String type;
        public Arm (String type){
            this.type = type;
        }
        ArrayList<String> subjects = new ArrayList<>();
        int subjectCount = 0;
        public int getSubjectCount (){
            return subjectCount;
        }
        public void raiseSubject(Subjects subject){
            subjects.add(String.valueOf(subject));
            subjectCount += 1;
        }
        public void letSubjects(Subjects subject){
            subjects.remove(String.valueOf(subject));
            subjectCount -= 1;
        }
        public void takeSubject(int subjectCount, Subjects subject){
            if (subjectCount == 0) {
                raiseSubject(subject);
                System.out.printf("%s взяла %s в %s.\n", name, subject, type);
            } else if (subjectCount == 1) {
                letSubjects(subject);
                System.out.printf("%s отпустила %s из %s.\n", name, subject, type);
            } else if (subjectCount >1) throw new TakeHandSubjectException("!больше 1 предмета нельзя взять!");
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Joan joan = (Joan) o;
        return Objects.equals(joanThought, joan.joanThought) && Objects.equals(thermometr, joan.thermometr) && Objects.equals(arm, joan.arm);
    }
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), joanThought, thermometr, arm);
    }
}
