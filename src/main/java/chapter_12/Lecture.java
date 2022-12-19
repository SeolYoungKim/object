package chapter_12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lecture {
    private final int pass;
    private final String title;
    private final List<Integer> scores = new ArrayList<>();

    public Lecture(int pass, String title) {
        this.pass = pass;
        this.title = title;

    }

    public double average() {
        return scores.stream()
                .mapToInt(Integer::intValue)
                .average().orElse(0);
    }

    public List<Integer> getScores() {
        return Collections.unmodifiableList(scores);
    }

    public String evaluate() {
        return String.format("Pass:%d Fail:%d", passCount(), failCount());
    }

    private long passCount() {
        return scores.stream().filter(score -> score >= pass).count();
    }

    private long failCount() {
        return scores.size() - passCount();
    }



}
