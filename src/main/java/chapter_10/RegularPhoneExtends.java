package chapter_10;

import chapter_02.Money;
import java.time.Duration;

public class RegularPhoneExtends extends PhoneExtends {
    private Money amount;
    private Duration seconds;

    public RegularPhoneExtends(double taxRate, Money amount, Duration seconds) {
        this.amount = amount;
        this.seconds = seconds;
    }

    public Money amount() {
        return amount;
    }

    public Duration seconds() {
        return seconds;
    }

    @Override
    protected Money calculateCallFee(Call call) {
        return amount.times(call.getDuration().getSeconds() / seconds.getSeconds());
    }
}
