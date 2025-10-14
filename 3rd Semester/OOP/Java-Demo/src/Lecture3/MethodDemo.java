package Lecture3;

public class MethodDemo {

    boolean isEligible(int numOfClasses, int attendedClasses){
        if((double) attendedClasses / numOfClasses < 0.5) return false;
        else return true;
    }

//    void consideration(){
//        isEligible(25, 15);
//    }

    public static void main(String[] args) {
        MethodDemo m1 = new MethodDemo();
        System.out.println(m1.isEligible(25,15));
    }
}
