package chapter_10;

import chapter_02.Money;
import java.time.Duration;

public class NightlyDiscountPhone extends Phone {
    private static final int LATE_NIGHT_HOUR = 22;

    private Money nightlyAmount;

    public NightlyDiscountPhone(Money amount, Duration seconds, Money nightlyAmount) {
        super(amount, seconds);
        this.nightlyAmount = nightlyAmount;
    }

    @Override
    public Money calculateFee() {
        Money result = super.calculateFee();

        Money nightlyFee = Money.ZERO;
        for (Call call : calls()) {
            if (call.from().getHour() >= LATE_NIGHT_HOUR) {
                nightlyFee = nightlyFee.plus(
                        amount().minus(nightlyAmount).times(
                                call.getDuration().getSeconds() / seconds().getSeconds()
                        )
                );
            }
        }

        return result.minus(nightlyFee);
    }
}
