package usfx.sorting.anterior;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<usfx.sorting.refactor.Student> students = initializeStudents();
        String[] parts = getSortInstructions();

        SortStrategyFactory factory = new ConcreteSortStrategyFactory();
        StrategyBuilder builder = new StrategyBuilder(factory);
        SortStrategy strategy = builder.buildStrategy(parts);

        if (strategy != null) {
            strategy.sort(students);
            printStudents(students);
        } else {
            System.out.println("No sorting criteria provided.");
        }
    }

    private static String[] getSortInstructions() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the fields to sort by (name, grade desc, age desc):");
        String line = scanner.nextLine();
        String[] parts = line.split(",");
        return parts;
    }

    private static List<usfx.sorting.refactor.Student> initializeStudents() {
        List<usfx.sorting.refactor.Student> students = new ArrayList<>();
        students.add(new usfx.sorting.refactor.Student("Lau", 23, 99.1));
        students.add(new usfx.sorting.refactor.Student("Erick", 24, 90.5));
        students.add(new usfx.sorting.refactor.Student("Alex", 20, 61.5));
        students.add(new usfx.sorting.refactor.Student("Val", 19, 82.8));
        return students;
    }

//    public static void printStudents(List<Student> students) {
//        students.forEach(student ->
//                System.out.println("Name: " + student.getName() + ", Age: " + student.getAge() + ", Grade: " + student.getGrade())
//        );
//    }

    public static void printStudents(List<usfx.sorting.refactor.Student> students) {
    for(usfx.sorting.refactor.Student student : students) {
        System.out.println("Name: " + student.getName() + ", Age: " + student.getAge() + ", Grade: " + student.getGrade());
    }
    }
}

