package Lecture14;

public class Resource {

    synchronized void print(String threadName){
        for(int i=0; i<=5; i++){
            System.out.println(threadName + " : " + i);
        }
    }
}
