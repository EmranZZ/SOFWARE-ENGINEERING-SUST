package Lecture8.abstract_class;


public abstract class Person {

    public String name;
    public int age;

    public String getName(){
        return name;
    }

    public abstract boolean isVoter(int id);

}
