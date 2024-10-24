package Lecture13.Comparable;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<Movie> movies = new ArrayList<>();

        movies.add(new Movie("The Pursuit of Happiness", "2011", 8.7));
        movies.add(new Movie("Far and Away", "1992", 7.8));
        movies.add(new Movie("Little Woman", "2019", 8.5));
        movies.add(new Movie("Into the Wild", "2015", 8.2));
        movies.add(new Movie("Constantine", "2004", 8));

        Collections.sort(movies);

        for(Movie m : movies){
            System.out.println(m.getTitle() + " : " + m.getYear() + " " + m.getRatings());
        }
    }
}
