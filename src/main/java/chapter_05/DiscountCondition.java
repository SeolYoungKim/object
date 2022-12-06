package chapter_05;

/**
 * 변경에 취약한 클래스
 * - 수정해야 하는 이유가 3개다
 *    - 새로운 할인 조건 추가 -> if~else 구문 수정
 *    - 순번 조건을 판단하는 로직 변경
 *    - 기간 조건을 판단하는 로직 변경
 * - 변경 이유가 하나 이상이기 떄문에 응집도가 낮음.
 * - 응집도가 낮다 == 서로 연관성이 없는 기능이나 데이터가 하나의 클래스 안에 뭉쳐져있다
 * - 따라서, 변경의 이유에 따라 클래스를 분리해야 함.
 */
public interface DiscountCondition {

    boolean isSatisfiedBy(Screening screening);



//    private DiscountConditionType type;
//    private int sequence;  // 순번 condition일 때만 초기화
//    private DayOfWeek dayOfWeek;  // 기간 condition일 때만 초기화
//    private LocalTime startTime;  // 기간 condition일 때만 초기화
//    private LocalTime endTime;    // 기간 condition일 때만 초기화
//
//    public boolean isSatisfiedBy(Screening screening) {
//        if (type == DiscountConditionType.PERIOD) {
//            return isSatisfiedByPeriod(screening);
//        }
//
//        return isSatisfiedBySequence(screening);
//    }


    // dayOfWeek, startTime, endTime만 사용
//    private boolean isSatisfiedByPeriod(Screening screening) {  // 서로 다른 이유로 변경되는 메서드
//        return dayOfWeek.equals(screening.whenScreened().getDayOfWeek()) &&
//                !startTime.isAfter(screening.whenScreened().toLocalTime()) &&
//                endTime.isAfter(screening.whenScreened().toLocalTime());
//    }

//    // sequence만 사용
//    private boolean isSatisfiedBySequence(Screening screening) {  // 서로 다른 이유로 변경되는 메서드
//        return sequence == screening.sequence();
//    }
}
