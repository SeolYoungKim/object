package chapter_08;

import static chapter_05.Money.*;

import chapter_02.DiscountPolicy;
import chapter_02.Screening;
import chapter_05.Money;
import java.util.ArrayList;
import java.util.List;

public class OverlappedDiscountPolicy implements DiscountPolicy {
    private List<DiscountPolicy> discountPolicies = new ArrayList<>();

    public OverlappedDiscountPolicy(DiscountPolicy... discountPolicies) {
        this.discountPolicies = List.of(discountPolicies);
    }

    @Override
    public Money calculateDiscountAmount(Screening screening) {
        chapter_05.Money result = ZERO;
        for (DiscountPolicy each : discountPolicies) {
            result = result.plus(each.calculateDiscountAmount(screening));
        }
        return result;
    }
}
