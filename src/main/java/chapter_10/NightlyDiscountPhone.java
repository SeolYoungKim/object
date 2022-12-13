package chapter_10;

import chapter_02.Money;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class NightlyDiscountPhone extends AbstractPhone {
    private static final int LATE_NIGHT_HOUR = 22;

    private Money nightlyAmount;
    private Money regularAmount;
    private Duration seconds;
    private List<Call> calls = new ArrayList<>();

    public NightlyDiscountPhone(Money nightlyAmount, Money regularAmount, Duration seconds) {
        this.nightlyAmount = nightlyAmount;
        this.regularAmount = regularAmount;
        this.seconds = seconds;
    }

    public void call(Call call) {
        calls.add(call);
    }

    public Money amount() {
        return regularAmount;
    }

    public Duration seconds() {
        return seconds;
    }

    public List<Call> calls() {
        return calls;
    }

    private Money calculateCallFee(Call call) {
        if (call.from().getHour() >= LATE_NIGHT_HOUR) {
            return nightlyAmount.times(call.getDuration().getSeconds() / seconds.getSeconds());
        }

        return regularAmount.times(call.getDuration().getSeconds() / seconds.getSeconds());
    }
}
