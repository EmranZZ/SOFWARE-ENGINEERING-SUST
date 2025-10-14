package Lecture14.orderedThread;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Resource resource = new Resource();

        Producer producer = new Producer(resource);
        Consumer consumer = new Consumer(resource);

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();

    }
}
