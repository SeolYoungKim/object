package chapter_10;

import chapter_02.Money;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Phone {
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

    public Money calculateFee() {
        Money result = Money.ZERO;

        for (Call call : calls) {
            result = result.plus(
                    amount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
        }

        return result.plus(result.times(taxRate));  //TODO 누군가 실수했다고 가정하자
    }
}
