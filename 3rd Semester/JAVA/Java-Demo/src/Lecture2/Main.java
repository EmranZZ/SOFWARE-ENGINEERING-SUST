package Lecture2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Student shaekh = new Student();
//        shaekh.id = 1;
//        shaekh.age = 19;
//        shaekh.name = "Shaekh";
//
//        Student rakhik = new Student();
//        rakhik.id = 2;
//        rakhik.age = 19;
//        rakhik.name = "rahikh";
//
//        Student emon = new Student();
//        emon.id = 3;
//        emon.age = 20;
//        emon.name = "Emon";
//
//        if(emon.age > shaekh.age) System.out.println("Emon bura beta");
//        else if(shaekh.age > emon.age) System.out.println("Shaekh bura beta");
//        else System.out.println("2 tai bura beta");

//        int a[3]; c/c++
//        int[] a = new int[3]; //java

        Scanner scan = new Scanner(System.in);
        SRE[] sreResult = new SRE[3];

        for(int i=0; i<3; i++){
            sreResult[i] = new SRE();
            sreResult[i].name = scan.nextLine();
            sreResult[i].mark = scan.nextInt();
            scan.nextLine();
        }

        int max = -999;
        int index = -1;
        for(int i=0; i<3; i++){
            if(sreResult[i].mark > max) {
                max = sreResult[i].mark;
                index = i;
            }
        }
        System.out.println("Max scorere : " + sreResult[index].name);
    }
}

