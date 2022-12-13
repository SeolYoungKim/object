package chapter_02;

import java.math.BigDecimal;

/**
 * 인상 깊은 점
 * - static 메서드를 먼저 선언하고, 생성자를 나중에 선언하였다.
 * - Money 객체에 모든 계산 식을 몰아주었다. -> Long을 그대로 사용할 경우, 로직 중복을 막을 수 없기 때문이다.
 * - 계산 후 새로운 객체를 만들어주었다.
 */
public class Money {

    public static final Money ZERO = Money.wons(0);

    private final BigDecimal amount;

    public static Money wons(long amount) {
        return new Money(BigDecimal.valueOf(amount));
    }

    public static Money wons(double amount) {
        return new Money(BigDecimal.valueOf(amount));
    }

    // 조영호님은 static 메서드를 먼저 선언하고, 생성자를 나중에 선언하였다.
    public Money(BigDecimal amount) {
        this.amount = amount;
    }

    public Money plus(Money amount) {
        return new Money(this.amount.add(amount.amount));
    }

    public Money minus(Money amount) {
        return new Money(this.amount.subtract(amount.amount));
    }

    public Money times(double percent) {
        return new Money(this.amount.multiply(
                BigDecimal.valueOf(percent)));
    }

    public boolean isLessThan(Money other) {
        return amount.compareTo(other.amount) < 0;
    }

    public boolean isGreaterThanOrEqual(Money other) {
        return amount.compareTo(other.amount) >= 0;
    }

    @Override
    public String toString() {
        return amount.toString() + "원";
    }
}
