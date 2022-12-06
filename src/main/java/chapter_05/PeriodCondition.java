package chapter_05;

import java.time.DayOfWeek;
import java.time.LocalTime;

// 동일한 책임을 수행한다 == 동일한 역할이다
// 구현을 공유 -> 추상 클래스
// 구현을 공유할 필요 없이 역할을 대체하는 객체들의 책임만을 정의 -> 인터페이스
public class PeriodCondition implements DiscountCondition {
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    public PeriodCondition(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    // dayOfWeek, startTime, endTime만 사용
    public boolean isSatisfiedBy(Screening screening) {  // 서로 다른 이유로 변경되는 메서드
        return dayOfWeek.equals(screening.whenScreened().getDayOfWeek()) &&
                !startTime.isAfter(screening.whenScreened().toLocalTime()) &&
                endTime.isAfter(screening.whenScreened().toLocalTime());
    }
}
