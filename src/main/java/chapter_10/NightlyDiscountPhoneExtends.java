package chapter_10;

import chapter_02.Money;
import java.time.Duration;

public class NightlyDiscountPhoneExtends extends PhoneExtends {
    private static final int LATE_NIGHT_HOUR = 22;

    private Money nightlyAmount;
    private Money regularAmount;
    private Duration seconds;

    public NightlyDiscountPhoneExtends(double taxRate, Money nightlyAmount, Money regularAmount,
            Duration seconds) {
        this.nightlyAmount = nightlyAmount;
        this.regularAmount = regularAmount;
        this.seconds = seconds;
    }

    public Money amount() {
        return regularAmount;
    }

    public Duration seconds() {
        return seconds;
    }


    @Override
    protected Money calculateCallFee(Call call) {
        if (call.from().getHour() >= LATE_NIGHT_HOUR) {
            return nightlyAmount.times(call.getDuration().getSeconds() / seconds.getSeconds());
        }

        return regularAmount.times(call.getDuration().getSeconds() / seconds.getSeconds());
    }
}
