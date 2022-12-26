package chapter_14;

import chapter_10.Call;
import chapter_11.DateTimeInterval;
import java.util.List;

public interface FeeCondition {
    List<DateTimeInterval> findTimeIntervals(Call call);
}
