package places;
import enums.DoorState;


public class Hospital {
    private String name;
    public Hospital (String name){
        this.name = name;
    }
    public Ward ward = new Ward ("палата", 1);
    public class Ward {
        boolean openWard = false;
        final int bedCount = 15;
        private String name;
        int wardNumber;
        public Ward (String name, int wardNumber){
            this.name = name;
            this.wardNumber = wardNumber;
        }
        public String toString() {
            return name;
        }
        public void openWard (DoorState state){
            switch (state){
                case OPEN -> {
                    openWard = true;
                    System.out.printf("%s: %s номер %d c %d кроватями.\n", state, name, wardNumber, bedCount);
                }
                case CLOSED -> {
                    openWard = false;
                    System.out.printf("%s: %s номер %d c %d кроватями.\n", state, name, wardNumber, bedCount);
                }
            }
        }
    }
    public OperatingRoom operatingRoom = new OperatingRoom("операционная");
    public class OperatingRoom {
        boolean openOperatingRoom = false;
        private String name;
        public OperatingRoom (String name){
            this.name = name;
        }
        public String toString() {
            return name;
        }
        public void openOperatingRoom (DoorState state){
            switch (state){
                case OPEN -> {
                    openOperatingRoom = true;
                    System.out.println(state + ".");
                }
                case CLOSED -> {
                    openOperatingRoom = false;
                    System.out.println(state + ".");
                }
            }
        }
    }
    public String toString(){
        return name;}
}
