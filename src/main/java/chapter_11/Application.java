package chapter_11;

import chapter_02.Money;
import java.time.Duration;

public class Application {
    public static void main(String[] args) {
        Phone phone = new Phone(
                new TaxablePolicy(new FixedFeePolicy(
                        Money.wons(1000),
                        Duration.ofSeconds(30)
                ), 0.05)
        );

        Phone phone1 = new Phone(
                new RateDiscountablePolicy(new TaxablePolicy(
                        new FixedFeePolicy(Money.wons(1000), Duration.ofSeconds(30)),
                        0.05), Money.wons(1000)));

    }
}
