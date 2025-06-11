import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class SortStudents {
    public static class Student {
        String name;
        int mathsGrade;
        int physicsGrade;

        public Student(String name, int mathsGrade, int physicsGrade) {
            this.name = name;
            this.mathsGrade = mathsGrade;
            this.physicsGrade = physicsGrade;
        }

        public String getName() {
            return this.name;
        }

        public int getTotalScore() {
            return this.mathsGrade + this.physicsGrade;
        }
    }

    public static void sortByTotalGrade(List<Student> students) {
        Collections.sort(students, (Student a, Student b) -> Integer.compare(a.getTotalScore(), b.getTotalScore()));
    }

    public static void printSortedStudents(List<Student> students) {
        sortByTotalGrade(students);
        System.out.println(students.stream().map(s -> s.getName()).collect(Collectors.joining(" ")));
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numStudents = Integer.parseInt(scanner.nextLine());
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < numStudents; i++) {
            List<String> line = splitWords(scanner.nextLine());
            Student student = new Student(line.get(0), Integer.parseInt(line.get(1)), Integer.parseInt(line.get(2)));
            students.add(student);
        }
        scanner.close();
        printSortedStudents(students);
    }
}