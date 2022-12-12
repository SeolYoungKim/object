package chapter_09;

import chapter_02.Money;
import chapter_02.Movie;
import chapter_02.NoneDiscountPolicy;
import java.time.Duration;

/**
 * Pure fabrication
 */
public class Factory {
    public Movie createAvatarMovie() {
        return new Movie("아바타",
                Duration.ofMinutes(120),
                Money.wons(10000),
                new NoneDiscountPolicy());
    }
}
