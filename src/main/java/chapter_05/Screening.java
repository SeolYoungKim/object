package chapter_05;

import chapter_02.Money;
import java.time.LocalDateTime;

public class Screening {

    private Movie movie;
    private int sequence;
    private LocalDateTime whenScreened;

    public Reservation reserve(Customer customer, int audienceCount) {
        return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
    }

    private Money calculateFee(int audienceCount) {
        return movie.calculateMovieFee(this).times(audienceCount);  // Screening의 의도를 드러낸다. (어떤 지식도 없이 전송할 메시지 결정)
    }

    public int sequence() {
        return sequence;
    }

    public LocalDateTime whenScreened() {
        return whenScreened;
    }
}
