package chapter_09;

import chapter_02.Money;
import chapter_02.Movie;

public class Client {
    private Factory factory;

    public Client(Factory factory) {
        this.factory = factory;
    }

    public Money getAvatarFee() {
        Movie avatarMovie = factory.createAvatarMovie();
        return avatarMovie.fee();
    }
}
