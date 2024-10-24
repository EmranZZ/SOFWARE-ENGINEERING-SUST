package Lecture14.orderedThread;

public class Resource {
    volatile int n;
    volatile boolean flag = false;

     synchronized void put(int n){
         while (flag){
             try {
                 wait();
             }catch (Exception e){}
         }
         this.n = n;
         System.out.println("Produced : " + this.n);
         notify();
         flag = true;
    }

     synchronized int get(){
         while (!flag){
             try {
                 wait();
             }catch (Exception e){}
         }
         flag = false;
         System.out.println("Get : " + this.n);
         notify();
         return this.n;
    }
}
