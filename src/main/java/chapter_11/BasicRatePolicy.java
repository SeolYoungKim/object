package chapter_11;

import chapter_02.Money;
import chapter_10.Call;
import chapter_14.FeeRule;
import java.util.ArrayList;
import java.util.List;

public abstract class BasicRatePolicy implements RatePolicy {
    private List<FeeRule> feeRules = new ArrayList<>();

    public BasicRatePolicy(FeeRule... feeRules) {
        this.feeRules = List.of(feeRules);
    }

    @Override
    public Money calculateFee(Phone phone) {
        return phone.calls()
                .stream()
                .map(call -> calculate(call))
                .reduce(Money.ZERO, (first, second) -> first.plus(second));
    }

    private Money calculate(Call call) {
        return feeRules.stream()
                .map(rule -> rule.calculateFee(call))
                .reduce(Money.ZERO, (first, second) -> first.plus(second));
    }

    protected abstract Money calculateCallFee(Call call);
}
