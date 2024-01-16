package interfaces;

import java.util.concurrent.Callable;

public interface Function {
    static int function (int N){
        return (int) (Math.random()*N);
    }

    static int customRandom(Callable<Double> randomFunction, int N) throws Exception {
        return (int) (randomFunction.call()*N);
    }
}
