package chapter_10;

import chapter_02.Money;

public class AbstractPhone {
    public Money calculateFee() {
        Money result = Money.ZERO;

        for (Call call : calls) {
            result = result.plus(calculateCallFee(call));
        }

        return result;
    }
}
