package chapter_10;

import chapter_02.Money;
import java.time.Duration;
import java.time.LocalDateTime;

public class Application {
    public static void main(String[] args) {
        Phone phone = new Phone(Money.wons(5), Duration.ofSeconds(10));
        phone.call(new Call(LocalDateTime.of(2022, 12, 13, 10, 0),
                LocalDateTime.of(2022, 12, 13, 11, 0)));

        phone.call(new Call(LocalDateTime.of(2022, 12, 14, 10, 0),
                LocalDateTime.of(2022, 12, 14, 12, 0)));

        Money money = phone.calculateFee();
        System.out.println(money);
    }
}
