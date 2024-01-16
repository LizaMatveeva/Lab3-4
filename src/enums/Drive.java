package enums;

public enum Drive {
    STAND ("стоит на месте."),
    RIDE ("едет"),
    SLOW_DOWN ("тормозит"),
    DUSH ("мчится"),
    FAST_SLOW_DOWN ("резко тормозит"),
    GAIN_SPEED ("разгоняется");
    private String state;
    Drive (String state){
        this.state = state;
    }
    public String toString(){
        return state;
    }

}
