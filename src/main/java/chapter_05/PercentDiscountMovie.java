package chapter_05;

import chapter_02.Money;
import java.time.Duration;
import java.util.List;

public class PercentDiscountMovie extends Movie{

    private double percent;

    public PercentDiscountMovie(String title, Duration runningTime, Money fee, double percent,
            List<DiscountCondition> discountConditions) {
        super(title, runningTime, fee, discountConditions);
        this.percent = percent;
    }

    @Override
    protected Money calculateDiscountAmount() {
        return fee().times(percent);
    }
}
