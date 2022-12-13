package chapter_10;

import chapter_02.Money;
import java.util.ArrayList;
import java.util.List;

public abstract class Phone {
    private double taxRate;  //TODO 인스턴스 필드는 잠재적인 결합을 유발한다!
    private List<Call> calls = new ArrayList<>();

    public Phone(double taxRate) {  //TODO 생성 로직이 변경되기 때문이다.
        this.taxRate = taxRate;
    }

    public Money calculateFee() {
        Money result = Money.ZERO;

        for (Call call : calls) {
            result = result.plus(calculateCallFee(call));
        }

        return result.plus(result.times(taxRate));
    }

    abstract protected Money calculateCallFee(Call call);
}
