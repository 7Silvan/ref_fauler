package example;

/**
 * User: Silvan
 * Date: 18.10.12
 * Time: 5:54
 */
public abstract class Price {

    abstract int getPriceCode();

    abstract double getCharge(int daysRented);

    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
