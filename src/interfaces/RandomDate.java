package interfaces;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ThreadLocalRandom;

public interface RandomDate {
    LocalDate randomDate = getRandomDate();

    default void getDate(){
        System.out.println(randomDate);
    }
     static LocalDate getRandomDate() {
        LocalDate startDate = LocalDate.of(1983, 1, 1);
        long daysBetween = ChronoUnit.DAYS.between(startDate, LocalDate.now());
        long randomDays = ThreadLocalRandom.current().nextLong(daysBetween);

        return startDate.plusDays(randomDays);
     }
}
