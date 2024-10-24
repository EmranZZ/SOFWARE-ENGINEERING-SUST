package Lecture3.ConstructorDemo;

public class Student {
    private int roll;
    String name;
    private int age;

    String session;

    public Student(int roll, String name){
        this.roll = roll;
        this.name = name;
    }

    public Student(int roll, String name, int age){
        this.roll = roll;
        this.name = name;
        this.age = age;
    }

    public void setInfo(String session){
        this.session = session;
    }

    public void setInfo(String session, int age){
        this.session = session;
        this.age = age;
    }

    public void setInfo(int age){
        this.age = age;
    }



}
