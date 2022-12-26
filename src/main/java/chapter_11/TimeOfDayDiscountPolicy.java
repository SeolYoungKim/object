package chapter_11;

import chapter_02.Money;
import chapter_10.Call;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TimeOfDayDiscountPolicy extends BasicRatePolicy {
    private final List<LocalTime> starts = new ArrayList<>();
    private final List<LocalTime> ends = new ArrayList<>();
    private final List<Duration> durations = new ArrayList<>();
    private final List<Money> amounts = new ArrayList<>();

    @Override
    protected Money calculateCallFee(Call call) {
        Money result = Money.ZERO;
        for (DateTimeInterval interval : call.splitByDay()) {
            for (int loop = 0; loop < starts.size(); loop++) {
                result.plus(amounts.get(loop).times(
                        (double) Duration.between(from(interval, starts.get(loop)), to(interval, ends.get(loop)))
                                .getSeconds() / durations.get(loop).getSeconds()
                ));
            }
        }

        return result;
    }

    private LocalTime from(DateTimeInterval interval, LocalTime from) {
        return interval.getFrom().toLocalTime().isBefore(from) ?
                from :
                interval.getFrom().toLocalTime();
    }

    private LocalTime to(DateTimeInterval interval, LocalTime to) {
        return interval.getTo().toLocalTime().isAfter(to) ?
                to :
                interval.getTo().toLocalTime();
    }
}
