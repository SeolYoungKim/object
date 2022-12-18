package chapter_11;

import chapter_02.Money;

public interface RatePolicy {
    Money calculateFee(Phone phone);
}
