package chapter_13;

import chapter_02.Money;
import chapter_02.Screening;
import java.time.LocalDateTime;

public abstract class DiscountPolicyWithAssert {
    public Money calculateDiscountAmount(Screening screening) {
        checkPreCondition(screening);

        Money amount = Money.ZERO;
        // 메서드 구현

        amount = screening.getMovieFee();
        checkPostCondition(amount);
        return amount;
    }

    protected void checkPreCondition(Screening screening) {
        assert screening != null && screening.getStartTime().isAfter(LocalDateTime.now());
    }

    protected void checkPostCondition(Money amount) {
        assert amount != null && amount.isGreaterThanOrEqual(Money.ZERO);
    }

}
