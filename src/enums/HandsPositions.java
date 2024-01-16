package enums;

public enum HandsPositions {
    RAISED ("поднять"),
    OMMITED ("опуcтить"),
    WAVE ("машет");
    private String state;
    HandsPositions (String state){
        this.state = state;
    }
    public String toString (){
        return state;
    }
}
