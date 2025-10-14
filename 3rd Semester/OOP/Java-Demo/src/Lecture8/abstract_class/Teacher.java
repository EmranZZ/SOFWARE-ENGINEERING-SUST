package Lecture8.abstract_class;

public class Teacher extends Person{

    @Override
    public String getName() {
        return "Mr. " + name;
    }

    @Override
    public boolean isVoter(int id) {
        if(id % 2 == 0) return true;
        else return false;
    }
}
