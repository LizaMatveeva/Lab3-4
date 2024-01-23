package people;

import enums.Subjects;
import exceptions.TakeHandSubjectException;

import java.util.ArrayList;
import java.util.Objects;

public class Stiv extends Person {
    public ArrayList<String> stivThought = new ArrayList<>();

    public Stiv(String name, String post) {
        super(name, post);
    }

    @Override
    public void getThought(int numberMassiv) {
        if (Objects.equals(stivThought.get(numberMassiv), "Радиатор полетел")) {
            System.out.printf("%s - сазал %s.\n", stivThought.get(0), name);
        }
    }

    @Override
    public void addThought(String message) {
        stivThought.add(message);
    }

    public Arm arm = new Arm("рука");

    public class Arm {
        private String type;

        public Arm(String type) {
            this.type = type;
        }

        ArrayList<String> subjects = new ArrayList<>();
        int subjectCount = 0;

        public int getSubjectCount() {
            return subjectCount;
        }

        public void raiseSubject(Subjects subject) {
            subjects.add(String.valueOf(subject));
            subjectCount += 1;
        }

        public void letSubjects(Subjects subject) {
            subjects.remove(String.valueOf(subject));
            subjectCount -= 1;
        }

        public void takeSubject(int subjectCount, Subjects subject) {
            if (subjectCount == 0) {
                raiseSubject(subject);
                System.out.printf("%s взял %s в %s.\n", name, subject, type);
            } else if (subjectCount == 1) {
                letSubjects(subject);
                System.out.printf("%s отпустил %s из %s.\n", name, subject, type);
            } else if (subjectCount > 1) throw new TakeHandSubjectException("!больше 1 предмета нельзя взять!");
        }
    }
}
