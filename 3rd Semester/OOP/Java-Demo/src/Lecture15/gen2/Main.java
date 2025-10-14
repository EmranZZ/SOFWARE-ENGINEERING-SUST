package Lecture15.gen2;

public class Main {
    public static void main(String[] args) {

//        Data<Shape> data1 = new Data<>(new Triangle());
//        data1.show();
//
//        data1 = new Data<>(new Rectangle());
//        data1.show();

//        test(new Data<>(new Triangle()));

//        Data<Triangle> data1 = new Data<>(new Triangle());
//        test(data1);

        test(new Data<>(new Triangle()));
        test(new Data<>(new Rectangle()));

    }

    static void test(Data<? extends Shape> data){
        data.show();
    }
}
