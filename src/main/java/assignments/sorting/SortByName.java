package assignments.sorting;

import java.util.Comparator;

public class SortByName extends SortStrategyTemplate {
    @Override
    protected Comparator<Student> getComparator() {
        return Comparator.comparing(Student::getName);
    }
}
