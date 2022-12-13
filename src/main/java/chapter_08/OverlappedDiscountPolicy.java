package chapter_08;


import static chapter_02.Money.ZERO;

import chapter_02.DiscountPolicy;
import chapter_02.Money;
import chapter_02.Screening;
import java.util.ArrayList;
import java.util.List;

public class OverlappedDiscountPolicy implements DiscountPolicy {
    private List<DiscountPolicy> discountPolicies = new ArrayList<>();

    public OverlappedDiscountPolicy(DiscountPolicy... discountPolicies) {
        this.discountPolicies = List.of(discountPolicies);
    }

    @Override
    public Money calculateDiscountAmount(Screening screening) {
        Money result = ZERO;
        for (DiscountPolicy each : discountPolicies) {
            result = result.plus(each.calculateDiscountAmount(screening));
        }
        return result;
    }
}
