package Lecture1;

import java.util.Scanner;
//struct Student{
//    int age;
//    char[999] name;
//}s1, s2;
//s1.age
public class Lecture1 {
    public static void main(String[] args) {
        int a;
        Scanner scan = new Scanner(System.in); //
        a = scan.nextInt(); // scanf("%d", &a);

        boolean flag = false;

        for(int i=2; i<=Math.sqrt(a); i++){
            if(a % i == 0){
                flag = true;
                break;
            }
        }

        if(flag) System.out.println("Not Prime");
        else System.out.println("Prime");

    }
}
