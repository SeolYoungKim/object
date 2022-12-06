package chapter_05;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class PeriodCondition {
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    public PeriodCondition(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    // dayOfWeek, startTime, endTime만 사용
    private boolean isSatisfiedByPeriod(Screening screening) {  // 서로 다른 이유로 변경되는 메서드
        return dayOfWeek.equals(screening.whenScreened().getDayOfWeek()) &&
                !startTime.isAfter(screening.whenScreened().toLocalTime()) &&
                endTime.isAfter(screening.whenScreened().toLocalTime());
    }
}
