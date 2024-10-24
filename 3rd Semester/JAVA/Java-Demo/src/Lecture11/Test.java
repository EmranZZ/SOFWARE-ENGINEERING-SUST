package Lecture11;

import Lecture7.Person;

public class Test {
    public static void main(String[] args) {

        Test t = new Test();
        System.out.println("Before Exception");

        int b = 1;
        int c = 0;
        int a;
        try {

            a = b/c;

        }catch (Exception e){
          e.printStackTrace();
        }

        System.out.println("After Exception ");

        try {
            t.run();
        }catch (Exception e){
            e.printStackTrace();
        }


        System.out.println("After run");

    }


    void run() throws NullPointerException, ArithmeticException{

        String s = null;
        System.out.println(5 / s.length());

//        Person person = null;
//        person.printName();

//        throw new IllegalAccessError();
    }
}
