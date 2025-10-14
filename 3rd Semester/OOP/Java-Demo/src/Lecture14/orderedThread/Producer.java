package Lecture14.orderedThread;

public class Producer extends Thread{
    private Resource resource;
    public Producer(Resource resource){
        this.resource = resource;

    }

    @Override
    public void run() {
        for(int i=1; i<=5 ; i++){
            resource.put(i);
        }
    }
}
