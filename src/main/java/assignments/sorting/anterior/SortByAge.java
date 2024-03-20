package assignments.sorting.anterior;

import java.util.Comparator;
import assignments.sorting.refactor.Student;


public class SortByAge extends SortStrategyTemplate {
    @Override
    protected Comparator<Student> getComparator() {
        return Comparator.comparingInt(Student::getAge);
    }
}
