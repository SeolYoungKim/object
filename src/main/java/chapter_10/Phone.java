package chapter_10;

import chapter_02.Money;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Phone {
    private Money amount;
    private Duration seconds;
    private List<Call> calls = new ArrayList<>();

    public Phone(Money amount, Duration seconds) {
        this.amount = amount;
        this.seconds = seconds;
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

        return result;
    }
}
