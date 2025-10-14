package Lecture13.Comparator;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student("Maruf", 25, 12));
        students.add(new Student("Rakib", 24, 10));
        students.add(new Student("Emon", 26, 9));
        students.add(new Student("Rumi", 26, 16));

        Collections.sort(students, new SortStudentsByAge());

        for(Student s : students)
            System.out.println(s.getName() + " : " + s.getReg() + " : " + s.getAge());

        System.out.println("\n ================================================== \n");


        Collections.sort(students, new SortStudentsByReg());

        for(Student s : students)
            System.out.println(s.getName() + " : " + s.getReg() + " : " + s.getAge());
    }
}
