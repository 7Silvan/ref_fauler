package example;

/**
 * Класс, представляющий данные о прокате фильма.
 * User: roman.gural
 * Date: 16.10.12
 * Time: 16:26
 */
public class Rental {
    private Movie movie;
    private  int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public void setDaysRented(int daysRented) {
        this.daysRented = daysRented;
    }
}
