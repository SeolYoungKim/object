package chapter_06;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;

public class RecurringSchedule {
    private String subject;
    private DayOfWeek dayOfWeek;
    private LocalTime from;
    private Duration duration;

    public RecurringSchedule(String subject, DayOfWeek dayOfWeek, LocalTime from,
            Duration duration) {
        this.subject = subject;
        this.dayOfWeek = dayOfWeek;
        this.from = from;
        this.duration = duration;
    }

    public String subject() {
        return subject;
    }

    public DayOfWeek dayOfWeek() {
        return dayOfWeek;
    }

    public LocalTime from() {
        return from;
    }

    public Duration duration() {
        return duration;
    }
}
