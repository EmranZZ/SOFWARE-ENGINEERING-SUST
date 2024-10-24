package Lecture13.Comparator;

public class Student {
    private String name;
    private int age;
    private int reg;

    public Student(String name, int age, int reg) {
        this.name = name;
        this.age = age;
        this.reg = reg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getReg() {
        return reg;
    }

    public void setReg(int reg) {
        this.reg = reg;
    }
}
