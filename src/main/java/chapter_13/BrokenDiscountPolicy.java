package chapter_13;

import chapter_02.Money;
import chapter_02.Screening;
import java.time.LocalTime;

public class BrokenDiscountPolicy extends DiscountPolicyWithAssert {
    @Override
    public Money calculateDiscountAmount(Screening screening) {
        checkPreCondition(screening);
        checkStrongerPreCondition(screening);  // 강한 사전조건은 안된다.

        Money amount = Money.ZERO;
        // 메서드 구현

        amount = screening.getMovieFee();
        checkPostCondition(amount);
        checkStrongerPostCondition(amount);  // 더 강한 사후조건은 ㄱㅊ
        return amount;
    }

    private void checkStrongerPreCondition(Screening screening) {
        assert screening.getEndTime().toLocalTime().isBefore(LocalTime.MIDNIGHT);
    }

    private void checkStrongerPostCondition(Money amount) {
        assert amount.isGreaterThanOrEqual(Money.wons(1000));
    }
}
