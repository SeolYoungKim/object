package chapter_12;

import java.util.List;

public class Professor {
    private final String name;
    private final Lecture lecture;

    public Professor(String name, Lecture lecture) {
        this.name = name;
        this.lecture = lecture;
    }

    public String compileStatistics() {
        return String.format("[%s] %s - Avg: %.1f", name, lecture.evaluate(), lecture.average());
    }

    public static void main(String[] args) {
        Professor professor = new Professor("다익스트라",
                new Lecture(70, "알고리즘", List.of(81, 95, 65, 50, 45)));

        String statistics = professor.compileStatistics();
        System.out.println(statistics);
    }
}
