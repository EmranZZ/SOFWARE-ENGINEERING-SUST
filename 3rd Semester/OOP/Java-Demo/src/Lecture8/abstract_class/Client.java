package Lecture8.abstract_class;

public class Client {
    public static void main(String[] args) {
        Person t1 = new Teacher();
        t1.name = "Partha";
        t1.age = 25;

        Student s1 = new Student();
        s1.name = "maruf";
        s1.age = 20;

        System.out.println(s1.isVoter(1));
        System.out.println(t1.isVoter(15));
        System.out.println(s1.getName());
        System.out.println(t1.getName());
    }
}
