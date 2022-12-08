package chapter_06;

import java.time.Duration;
import java.time.LocalDateTime;

public class Event {
    private String subject;
    private LocalDateTime from;
    private Duration duration;

    public Event(String subject, LocalDateTime from, Duration duration) {
        this.subject = subject;
        this.from = from;
        this.duration = duration;
    }

    //TODO 부수효과를 가지지 않는 순수한 쿼리
    public boolean isSatisfied(RecurringSchedule schedule) {
        return from.getDayOfWeek() == schedule.dayOfWeek() &&
                from.toLocalTime().equals(schedule.from()) &&
                duration.equals(schedule.duration());
    }

    //TODO 아래의 메서드는 명령과 쿼리, 두 가지 역할을 동시에 수행하고 있다.
    // 하지만, 이는 개념적으로 쿼리다.
//    public boolean isSatisfied(RecurringSchedule schedule) {
//        if (from.getDayOfWeek() != schedule.dayOfWeek() ||
//                !from.toLocalTime().equals(schedule.from()) ||
//                !duration.equals(schedule.duration())) {
//            reschedule(schedule);  // 내부에 상태를 바꾸는 로직이 있어, false -> true로 변경된다. 이는 개념적으로 명령이다.
//            return false;
//        }
//
//        return true;
//    }

    public void reschedule(RecurringSchedule schedule) {
        from = LocalDateTime.of(from.toLocalDate().plusDays(daysDistance(schedule)),
                schedule.from());
        duration = schedule.duration();
    }

    private long daysDistance(RecurringSchedule schedule) {
        return schedule.dayOfWeek().getValue() - from.getDayOfWeek().getValue();
    }
}
