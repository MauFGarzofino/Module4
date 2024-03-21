package assignments.sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        List<Student> students = initializeStudents();
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
        System.out.println("Enter the fields to sort by (name, grade desc, age desc)(asc por defecto):");
        String line = scanner.nextLine();
        return line.split(",");
    }

    private static List<Student> initializeStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Lau", 23, 99.1));
        students.add(new Student("Erick", 24, 90.5));
        students.add(new Student("Alex", 20, 61.5));
        students.add(new Student("Val", 19, 82.8));
        return students;
    }

    public static void printStudents(List<Student> students) {
    for(Student student : students) {
        System.out.println("Name: " + student.getName() + ", Age: " + student.getAge() + ", Grade: " + student.getGrade());
    }
    }
}

