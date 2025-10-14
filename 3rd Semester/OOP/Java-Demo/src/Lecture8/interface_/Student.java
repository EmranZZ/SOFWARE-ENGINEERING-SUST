package Lecture8.interface_;

public class Student implements Person, Registration{

    public String name;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean isVoter(int id) {
        System.out.println("Not a student election");
        return false;
    }

    @Override
    public boolean isEligibleForNextSemester(int roll_no) {
        return false;
    }

    @Override
    public double totalCreditCompleted(int roll_no) {
        return 0;
    }
}
