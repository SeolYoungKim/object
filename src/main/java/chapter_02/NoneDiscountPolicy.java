package chapter_02;

public class NoneDiscountPolicy implements DiscountPolicy {

    @Override
    public chapter_05.Money calculateDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
