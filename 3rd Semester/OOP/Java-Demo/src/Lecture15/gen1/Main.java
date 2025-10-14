package Lecture15.gen1;

public class Main {
    public static void main(String[] args) {

        Data<String> data1 = new Data<>("String data");
        System.out.println(data1.getValue1());

        Data<Integer> data2 = new Data<>(1056);
        System.out.println(data1.getValue1());

        Student s1 = new Student(25, "Rakib");
        Data<Student> data3 = new Data<>(s1);
        System.out.println(data3.getValue1().getName());

        s1.print("String data");
        s1.print(25.5);

    }
}
