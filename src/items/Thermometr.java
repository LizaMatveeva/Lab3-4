package items;

import interfaces.Function;
import people.Human;

import java.util.Random;
import java.util.concurrent.Callable;

public class Thermometr {
    public int takeTemperature(Human human){
        Random randomGenerator = new Random(human.hashCode()); // генерация рандомизатора, в качестве seed числа испоьзуется hashCode человека
        Callable<Double> function = randomGenerator::nextDouble; // для Передачи нашей функции рандома используем функциональный интерфейс
        try {
            return ((Function.customRandom(function, 5) + 35) + ((int) errorRate())); // генерируем рандмную темпеатуру
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public double errorRate () {
        double errorRate;
        double randomFactor = Math.random();
        if (randomFactor >= 0.5) {
            errorRate = 0.5;
        }
        else {
            errorRate = -0.5;
        }
        return errorRate;
    }
}
