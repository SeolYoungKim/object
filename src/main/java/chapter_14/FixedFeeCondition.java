package chapter_14;

import chapter_10.Call;
import chapter_11.DateTimeInterval;
import java.util.List;

public class FixedFeeCondition implements FeeCondition {
    @Override
    public List<DateTimeInterval> findTimeIntervals(Call call) {
        return List.of(call.getInterval());
    }
}
