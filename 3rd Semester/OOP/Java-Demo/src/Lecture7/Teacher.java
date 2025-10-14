package Lecture7;

public class Teacher extends Person{
    public int id;

    // method overriding
    @Override
    public void printName() {
        name = "Mr. " + name;
        System.out.println("Teacher is : " + name);
    }
}
