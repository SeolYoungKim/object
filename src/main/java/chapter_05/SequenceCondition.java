package chapter_05;

public class SequenceCondition implements DiscountCondition {

    private int sequence;

    public SequenceCondition(int sequence) {
        this.sequence = sequence;
    }

    // sequence만 사용
    public boolean isSatisfiedBy(Screening screening) {  // 서로 다른 이유로 변경되는 메서드
        return sequence == screening.sequence();
    }

}
