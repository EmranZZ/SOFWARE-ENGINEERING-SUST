package Lecture14.orderedThread;

public class Consumer extends Thread{
    private Resource resource;

    public Consumer(Resource resource){
        this.resource = resource;
    }

    @Override
    public void run() {
        for(int i=1; i<=5; i++){
            resource.get();
        }
    }
}
