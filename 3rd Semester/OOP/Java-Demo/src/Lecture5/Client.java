package Lecture5;

public class Client {
    private int id;
    private String name;
    private int age;
    private int bonusPoint = 100;

    public Client(int id) {
        this.id = id;
    }

    public Client(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int addBonus(int bonusPoint){
        this.bonusPoint += bonusPoint;
        return this.bonusPoint;
    }

    public int withDrawBonusPoint(int point){
        if(bonusPoint - point < 0){
            System.out.println("Not enough point");
            return bonusPoint;
        }
        else {
            bonusPoint -= point;
            System.out.println("Bonus Point Withdrawn");
            return bonusPoint;
        }
    }
}
