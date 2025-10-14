package Lecture14;

public class DemoThread extends Thread{
//    private String className;
//
//    public DemoThread(String className){
//        this.className = className;
//    }

    Resource resource;

    public DemoThread(Resource resource){
        this.resource = resource;
    }
    @Override
    public void run() {
        resource.print(currentThread().getName());
    }

//    void print(){
//        for(int i=0; i<=5; i++){
//            System.out.println(this.className + " : " + i);
//        }
//    }
}
