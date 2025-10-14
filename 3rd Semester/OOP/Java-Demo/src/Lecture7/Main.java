package Lecture7;

public class Main {
    public static void main(String[] args) {
        Teacher t1 = new Teacher();
        t1.name = "Partha";

        Student s1 = new Student();
        s1.name = "Avik";

        Person p = new Person();
        p.name = "Rahik";
        p.printName();

        p = t1;
        p.printName();

        p = s1;
        p.printName();
    }
}
