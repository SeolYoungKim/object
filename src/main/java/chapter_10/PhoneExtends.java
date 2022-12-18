package chapter_10;

import chapter_02.Money;
import java.util.ArrayList;
import java.util.List;

public abstract class PhoneExtends {
    private List<Call> calls = new ArrayList<>();

    public Money calculateFee() {
        Money result = Money.ZERO;

        for (Call call : calls) {
            result = result.plus(calculateCallFee(call));
        }

        return result;
    }

    //TODO 편의를 위해 기본 구현을 제공하는 메서드 "훅(hook) 메서드"
    protected Money afterCalculated(Money fee) {
        return fee;
    }

    public List<Call> calls() {
        return calls;
    }

    protected abstract Money calculateCallFee(Call call);
}
