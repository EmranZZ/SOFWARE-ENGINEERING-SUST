package Lecture6;

public class Main {
    public static void main(String[] args) {
        Student s = new Student(21, "Anik", 1);
        System.out.println(s.age + " " + s.name + " " + s.roll);

        Person p1 = s;
//        Person p2 = new Teacher(25, "Alex", 22);

        System.out.println(p1.age + " " + p1.name + " ");
    }
}
