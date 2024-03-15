package usfx.sorting.anterior;

import java.util.Comparator;
import usfx.sorting.refactor.Student;


public class SortByGrade extends SortStrategyTemplate{
    @Override
    protected Comparator<Student> getComparator() {
        return Comparator.comparing(Student::getGrade);
    }
}
