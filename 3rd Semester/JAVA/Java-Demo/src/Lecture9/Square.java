package Lecture9;

public class Square implements Shape{
    double side;
    public Square(double side){
        this.side = side;
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public void show() {
        System.out.println("Not default implementation for Square class");
    }
}
