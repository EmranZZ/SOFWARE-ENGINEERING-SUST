package Lecture10;

public class Test {
    public static void main(String[] args) {
        StringBuilder s = new StringBuilder("hello");
        s.append("world");
        String sub = (String) s.subSequence(2, 5);
    }
}
