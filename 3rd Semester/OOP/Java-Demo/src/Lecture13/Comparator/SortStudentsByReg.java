package Lecture13.Comparator;

import java.util.Comparator;

public class SortStudentsByReg implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getReg() - o2.getReg();
    }
}
