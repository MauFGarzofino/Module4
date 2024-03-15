package usfx.sorting.anterior;

import usfx.sorting.refactor.Student;

import java.util.List;

public interface SortStrategy {
    void sort(List<Student> studentList);
}
