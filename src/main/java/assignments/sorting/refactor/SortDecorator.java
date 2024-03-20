package assignments.sorting.refactor;

import java.util.List;

import static assignments.sorting.anterior.Main.printStudents;

public class SortDecorator implements SortStrategy {
    private SortStrategy primaryStrategy;
    private SortStrategy secondaryStrategy;

    public SortDecorator(SortStrategy primary, SortStrategy secondary) {
        this.primaryStrategy = primary;
        this.secondaryStrategy = secondary;
    }

    @Override
    public void sort(List<Student> studentList) {
        primaryStrategy.sort(studentList);
        System.out.println("Ordenado por " + primaryStrategy.getClass().getSimpleName() + ":");
        printStudents(studentList);

        System.out.println("---------------------------------");

        secondaryStrategy.sort(studentList);
        System.out.println("Luego por " + secondaryStrategy.getClass().getSimpleName() + ":");
        printStudents(studentList);
        System.out.println("---------------------------------");
    }
}
