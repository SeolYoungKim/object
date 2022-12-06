package chapter_05;

public class SequenceCondition {

    private int sequence;

    public SequenceCondition(int sequence) {
        this.sequence = sequence;
    }

    // sequence만 사용
    private boolean isSatisfiedBySequence(Screening screening) {  // 서로 다른 이유로 변경되는 메서드
        return sequence == screening.sequence();
    }

}
