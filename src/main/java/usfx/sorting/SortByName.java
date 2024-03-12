package usfx.sorting;

import java.util.Comparator;
import java.util.List;

public class SortByName extends SortStrategyTemplate {
    @Override
    protected Comparator<Student> getComparator() {
        return Comparator.comparing(Student::getName);
    }
}
