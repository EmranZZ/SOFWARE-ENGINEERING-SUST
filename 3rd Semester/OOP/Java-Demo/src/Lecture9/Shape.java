package Lecture9;

public interface Shape {

    public double getArea();

    default void show(){
        System.out.println("Default implementation");
    }
}
