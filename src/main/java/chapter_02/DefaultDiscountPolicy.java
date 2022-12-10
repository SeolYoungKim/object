package chapter_02;

import java.util.List;

/**
 * 상속은 부모 클래스가 제공하는 모든 인터페이스를 자식 클래스가 물려받을 수 있다는 점에서 가치있다.
 * 인터페이스는 객체가 이해할 수 있는 메세지의 목록을 정의할 뿐이다.
 * 상속을 하게 되면, 자식 클래스는 부모 클래스의 인터페이스를 포함하게 된다.
 * 자식 클래스는 부모 클래스가 수신할 수 있는 모든 메시지를 수신할 수 있다.
 * 결과적으로, 외부 객체는 자식 클래스를 부모 클래스와 동일한 타입으로 간주할 수 있게 된다.
 * 즉, 자식 클래스는 부모 클래스 대신 사용될 수 있다. (업캐스팅)
 */
public abstract class DefaultDiscountPolicy implements DiscountPolicy {

    // 하나의 할인 정책은, 여러 개의 할인 조건을 포함할 수 있다.
    private final List<DiscountCondition> conditions;  // 특정한 할인 조건에 묶이지 않는다.

    public DefaultDiscountPolicy(DiscountCondition... conditions) {
        this.conditions = List.of(conditions);
    }

    // 부모 클래스에 기본적인 알고리즘의 흐름을 구현하고,
    public final chapter_05.Money calculateDiscountAmount(Screening screening) {
        for (DiscountCondition condition : conditions) {
            if (condition.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening);  // 메서드가 컴파일 시점이 아닌, 실행 시점에 결정된다.
            }
        }

        return Money.ZERO;
    }

    //  중간에 필요한 처리를 자식 클래스에게 위임 -> TODO "TEMPLATE METHOD 패턴"이라고 한다.
    // TODO 부모 클래스와 다른 부분만을 추가해서 새로운 클래스를 쉽고 빠르게 만드는 것을 "차이에 의한 프로그래밍"이라고 한다.
    abstract protected Money getDiscountAmount(Screening screening);
}
