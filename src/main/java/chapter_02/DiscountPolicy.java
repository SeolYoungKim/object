package chapter_02;

import chapter_05.Money;

public interface DiscountPolicy {

    Money calculateDiscountAmount(Screening screening);
}
