package Lecture13.Comparable;

public class Movie implements Comparable<Movie>{

    private String title;
    private String year;
    private double ratings;

    public Movie(String title, String year, double ratings) {
        this.title = title;
        this.year = year;
        this.ratings = ratings;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public double getRatings() {
        return ratings;
    }

    public void setRatings(double ratings) {
        this.ratings = ratings;
    }

    @Override
    public int compareTo(Movie o) {
//        if(this.ratings < o.ratings) return -1;
//        else if (this.ratings > o.ratings) return 1;
//        else return 0;

        return Double.compare(this.ratings, o.ratings);
    }
}
