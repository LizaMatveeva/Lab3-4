package interfaces;
import enums.*;

public interface CarSpeed {
    void stand();
    void ride();
    void slowDown();
    void gainSpeed();
    void fastSlowDown();
    void setDriveState(Drive state);
}
