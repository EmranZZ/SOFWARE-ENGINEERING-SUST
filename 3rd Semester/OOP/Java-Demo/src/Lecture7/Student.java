package Lecture7;

public class Student extends Person{
    public int roll_no;


    @Override
    public void printName() {
        // some more changes
        System.out.println("Student is : " + name);
    }
}
