package chapter_02;

import java.time.LocalDateTime;

/**
 * 객체는 자율적인 존재이다! 외부 간섭을 최소화 하자! 외부는 객체의 상세 내용을 몰라야 한다.
 * 데이터와 기능을 한 덩어리로 묶어라. -> 캡슐화라고 한다.
 * 필요한 부분만 공개하고, 나머지는 꽁꽁 숨기자! -> 구현 은닉이라고 한다. (변경이 쉬워짐)
 * 인터페이스와 구현을 깔끔하게 분리하기 위해 노력하라!
 */
public class Screening {

    /**
     * 인스턴스 변수의 가시성은 private이다. -> 외부에서 접근이 불가능하고, 내부에서만 접근 가능한 "구현"이다.
     * 인스턴스 변수는 상태이다. 숨겨야 한다.
     */
    private final Movie movie;
    private final int sequence;
    private final LocalDateTime whenScreened;

    public Screening(Movie movie, int sequence, LocalDateTime whenScreened) {
        this.movie = movie;
        this.sequence = sequence;
        this.whenScreened = whenScreened;
    }

    /**
     * 메서드의 가시성은 public이다. -> 외부에서 접근 가능한 인터페이스이다.
     * public 영역을 변경하지 않는 한 외부에 미치는 영향을 걱정하지 않고도 내부 구현을 맘대로 변경할 수 있다.
     * 메서드는 행동이다. 수신한 메세지를 처리하기 위한 자신만의 방법이다.
     * 메서드도 private, protected로 선언할 수 있는데, 이 때는 "구현"에 속한다.
     */
    public LocalDateTime getStartTime() {
        return whenScreened;
    }

    public boolean isSequence(int sequence) {
        return this.sequence == sequence;
    }

    public Money getMovieFee() {
        return movie.fee();
    }

    public Reservation reserve(Customer customer, int audienceCount) {
        return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
    }

    private Money calculateFee(int audienceCount) {
        return movie.calculateMovieFee(this).times(audienceCount);  // Screening은 Movie에게 calculateMovieFee라는 메세지를 전송한다.
    }

    public LocalDateTime getEndTime() {
        //TODO 이건 걍 가라로 만들어둔거임
        return whenScreened;
    }
}
