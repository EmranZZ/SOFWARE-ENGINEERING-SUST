package Lecture5;

public class Main {
    public static void main(String[] args) {
        Client c1 = new Client(1);
        Client c2 = new Client(2, "naim", 20);

        int remainingBonuspoint = c1.withDrawBonusPoint(80);
        System.out.println(remainingBonuspoint);

        System.out.println(c1.withDrawBonusPoint(50));
    }
}
