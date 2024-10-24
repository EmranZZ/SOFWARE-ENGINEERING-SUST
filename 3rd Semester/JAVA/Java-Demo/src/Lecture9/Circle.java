package Lecture9;

public class Circle implements Shape{
    private double radius;
    private Circle(double radius){
        this.radius = radius;
    }

    public static Circle createCircle(){
        return new Circle(5);
    }


    @Override
    public double getArea() {
        return 3.1416 * radius * radius;
    }
}
