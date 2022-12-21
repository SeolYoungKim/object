package chapter_12;

import java.util.List;
import java.util.stream.Collectors;

public class GradeLecture extends Lecture {
    private List<Grade> grades;

    public GradeLecture(int pass, String title, List<Grade> grades) {
        super(pass, title);
        this.grades = grades;
    }

    @Override
    public String getEvaluationMethod() {
        return "Grade";
    }

    @Override
    public String evaluate() {
        return super.evaluate() + ", " + gradesStatistics();
    }

    private String gradesStatistics() {
        return grades.stream()
                .map(grade -> format(grade))
                .collect(Collectors.joining(" "));
    }

    private String format(Grade grade) {
        return String.format("%s:%d", grade.getName(), gradeCount(grade));
    }

    private long gradeCount(Grade grade) {
        return getScores().stream()
                .filter(grade::include)
                .count();
    }

    public double average(String gradeName) {
        return grades.stream()
                .filter(each -> each.isName(gradeName))
                .findFirst()
                .map(grade -> gradeAverage(grade))
                .orElse(0d);
    }

    private double gradeAverage(Grade grade) {
        return getScores().stream()
                .filter(grade::include)
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);
    }
}
