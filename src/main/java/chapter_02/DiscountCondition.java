package chapter_02;

/**
 * 내부 구현은 필요 없고, 순수하게 인터페이스만 공유하고 싶을 때 사용.
 * TODO 구현에 대한 고려 없이, 다형적인 협력에 참여하는 클래스들이 공유 가능한 외부 인터페이스를 정의한 것.
 * 구현 : private, protected로 선언된 것
 * 인터페이스 : public으로 공개된 것
 */
public interface DiscountCondition {  // 추상 클래스보다 인터페이스가 더 추상적이다.

    boolean isSatisfiedBy(Screening screening);
}
