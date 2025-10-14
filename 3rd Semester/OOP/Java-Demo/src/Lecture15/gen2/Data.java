package Lecture15.gen2;

public class Data <T extends Shape>{
    private T obj;

    public Data(T obj){
        this.obj = obj;
    }

    void show(){
        obj.draw();
    }
}
