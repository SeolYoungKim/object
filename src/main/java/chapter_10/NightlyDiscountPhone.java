package chapter_10;

import chapter_02.Money;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class NightlyDiscountPhone {
    private static final int LATE_NIGHT_HOUR = 22;

    private Money nightlyAmount;
    private Money regularAmount;
    private Duration seconds;
    private double taxRate;
    private List<Call> calls = new ArrayList<>();

    public NightlyDiscountPhone(Money nightlyAmount, Money regularAmount, Duration seconds,
            double taxRate) {
        this.nightlyAmount = nightlyAmount;
        this.regularAmount = regularAmount;
        this.seconds = seconds;
        this.taxRate = taxRate;
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

    public Money calculateFee() {
        Money result = Money.ZERO;

        for (Call call : calls) {
            if (call.from().getHour() >= LATE_NIGHT_HOUR) {
                result = result.plus(
                        nightlyAmount.times(call.getDuration().getSeconds() / seconds.getSeconds()));

                continue;
            }

            result = result.plus(
                    regularAmount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
        }

        return result.minus(result.times(taxRate));
    }
}
