package chapter_02;

import java.time.Duration;

public class Movie {

    private String title;
    private Duration runningTime;
    private Money fee;
    private DiscountPolicy discountPolicy;  // 특정한 할인 정책에 묶이지 않는다.
    // TODO 이는 합성 이라고 부른다. 인터페이스를 통해 약하게 결합된다. 인터페이스에 정의된 메세지를 통해서만 코드를 재사용한다.

    // 생성자의 파라미터를 통해, 초기화에 필요한 정보를 전달하도록 강제하면, 올바른 상태를 가진 객체 생성을 보장할 수 있다!
    public Movie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
    }

    public void changeDiscountPoilicy(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }

    public Money fee() {
        return fee;
    }

    public Money calculateMovieFee(Screening screening) { // 수신받은 메시지에 대한 적절한 메서드를 선택한다.
//        if (discountPolicy == null) {  // 이 방법은 좋지 않다. 일관성 있던 협력 방식이 무너지기 때문이다.
//            return fee;  // 할인 정책이 없을 때, 할인 금액이 0원이라는 사실은 DiscountPolicy가 정해야 한다.
//        }

        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }
}
