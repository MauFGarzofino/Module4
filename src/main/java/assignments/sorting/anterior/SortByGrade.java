package assignments.sorting.anterior;

import java.util.Comparator;

import assignments.sorting.refactor.Student;


public class SortByGrade extends SortStrategyTemplate{
    @Override
    protected Comparator<assignments.sorting.refactor.Student> getComparator() {
        return Comparator.comparing(Student::getGrade);
    }
}
