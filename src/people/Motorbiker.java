package people;

import enums.*;
import transport.Motorbike;


public class Motorbiker extends Human {
    public Motorbiker(String post) {
        super(post);
    }

    public void driveDush(Motorbike motorbike) {
        motorbike.dush();
    }

    public Hands hands = new Hands();

    public class Hands {
        protected HandsPositions positions = HandsPositions.OMMITED;

        public void setStateHands(HandsPositions positions) {
            this.positions = positions;
        }

        public void waveHand() {
            setStateHands(HandsPositions.RAISED);
            setStateHands(HandsPositions.WAVE);
            setStateHands(HandsPositions.OMMITED);
            System.out.printf("%s %s рукой.\n", post, HandsPositions.WAVE);
        }
    }
}
