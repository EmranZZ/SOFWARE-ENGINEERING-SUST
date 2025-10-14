package Lecture9;

public class Client {
    public static void main(String[] args) {
//        Shape shape = new Circle(5);
//        shape.show();
//
//        shape = new Square(5);
//        shape.show();

        Circle c = Circle.createCircle();
        c.show();

        Circle c_clone = c;
    }
}
