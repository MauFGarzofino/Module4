package usfx.sorting;

import java.util.Comparator;

public class SortByAge extends SortStrategyTemplate {
    @Override
    protected Comparator<Student> getComparator() {
        return Comparator.comparingInt(Student::getAge);
    }
}
