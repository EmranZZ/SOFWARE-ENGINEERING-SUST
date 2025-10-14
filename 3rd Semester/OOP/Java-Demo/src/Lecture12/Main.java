package Lecture12;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> myList = new ArrayList<>();

        myList.add(10);
        myList.add(105);
        myList.add(205);

        myList.remove(2);

        myList.get(0);

        ArrayList<String> myList2 = new ArrayList<>();

        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }

        // ================================================

        for (Integer a : myList) { //lambda expression
            System.out.println(a);
        }

        // ===============================================

        Iterator<Integer> it = myList.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }


        HashSet<String> mySet = new HashSet<>();

        mySet.add("Hello");
        mySet.add("World");
        mySet.add("Hello");
        mySet.add("Universe");

        Iterator<String> iterator = mySet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
//
//        for(int i=0; i< mySet.size(); i++){\
//            System.out.println(mySet.get(i));
//
//    }}
    }
}
