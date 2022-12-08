package chapter_06;

import java.io.FileNotFoundException;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class CommandAndQuery {
    public static void main(String[] args) throws FileNotFoundException {
        Event meeting = new Event("회의",
                LocalDateTime.of(2022, 12, 7, 10, 30),
                Duration.ofMinutes(30));

        RecurringSchedule schedule = new RecurringSchedule("회의",
                DayOfWeek.WEDNESDAY,
                LocalTime.of(10, 30),
                Duration.ofMinutes(30));

        System.out.println(meeting.isSatisfied(schedule));
    }
}
