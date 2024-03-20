package assignments.sorting.anterior;

import java.util.Comparator;
import java.util.List;

import assignments.sorting.refactor.Student;

public abstract class SortStrategyTemplate implements SortStrategy {
    @Override
    public void sort(List<assignments.sorting.refactor.Student> studentList) {
        Comparator<assignments.sorting.refactor.Student> comparator = getComparator();
        if (isDescending()) {
            comparator = comparator.reversed();
        }
        studentList.sort(comparator);
    }

    // Método abstracto para obtener el Comparator específico.
    protected abstract Comparator<Student> getComparator();

    // Método que puede ser sobrescrito por subclases si el ordenamiento debe ser descendente.
    protected boolean isDescending() {
        return false; // Por defecto es ascendente.
    }
}
