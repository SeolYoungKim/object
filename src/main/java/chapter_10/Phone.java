package chapter_10;

import chapter_02.Money;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Phone extends AbstractPhone {
    private Money amount;
    private Duration seconds;
    private double taxRate;
    private List<Call> calls = new ArrayList<>();

    public Phone(Money amount, Duration seconds, double taxRate) {
        this.amount = amount;
        this.seconds = seconds;
        this.taxRate = taxRate;
    }

    public void call(Call call) {
        calls.add(call);
    }

    public Money amount() {
        return amount;
    }

    public Duration seconds() {
        return seconds;
    }

    public List<Call> calls() {
        return calls;
    }

    public double taxRate() {
        return taxRate;
    }

    private Money calculateCallFee(Call call) {
        return amount.times(call.getDuration().getSeconds() / seconds.getSeconds());
    }
}
