package Lecture8.abstract_class;

public class Student extends Person{

    @Override
    public boolean isVoter(int id) {
        System.out.println("Not a student election");
        return false;
    }
}
