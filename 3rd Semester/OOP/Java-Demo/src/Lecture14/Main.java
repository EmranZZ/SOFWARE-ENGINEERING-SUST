package Lecture14;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Resource resource = new Resource();
        DemoThread t0 = new DemoThread(resource);
        DemoThread t1 = new DemoThread(resource);


        t0.start();
        t1.start();

        t0.join();
        t1.join();


        System.out.println("Main ends here!");
    }
}
