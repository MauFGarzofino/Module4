package assignments.sorting;

import java.util.Comparator;

public class SortByGrade extends SortStrategyTemplate {
    @Override
    protected Comparator<Student> getComparator() {
        return Comparator.comparing(Student::getGrade);
    }
}
