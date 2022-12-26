package chapter_10;

import chapter_11.DateTimeInterval;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class Call {
    private LocalDateTime from;
    private LocalDateTime to;

    private final DateTimeInterval interval;

    public Call(LocalDateTime from, LocalDateTime to) {
        this.from = from;
        this.to = to;
        this.interval = DateTimeInterval.of(from, to);
    }

    public LocalDateTime from() {
        return from;
    }

    public Duration getDuration() {
        return interval.duration();
    }

    public LocalDateTime getFrom() {
        return interval.getFrom();
    }

    public LocalDateTime getTo() {
        return interval.getTo();
    }

    public DateTimeInterval getInterval() {
        return interval;
    }

    public List<DateTimeInterval> splitByDay() {
        return interval.splitByDay();
    }
}
