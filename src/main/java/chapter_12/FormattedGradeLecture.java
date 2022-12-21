package chapter_12;

import java.util.List;

public class FormattedGradeLecture extends GradeLecture{
    public FormattedGradeLecture(int pass, String title, List<Grade> grades) {
        super(pass, title, grades);
    }

    public String formatAverage() {
        return String.format("Avg: %1.1f", super.average());
    }
}
