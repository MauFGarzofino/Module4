package usfx.sorting.refactor;

import java.util.Comparator;
import java.util.List;

public abstract class SortStrategyTemplate implements SortStrategy {
    @Override
    public void sort(List<Student> studentList) {
        Comparator<Student> comparator = getComparator();
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
