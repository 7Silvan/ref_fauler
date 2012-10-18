package example;

/**
 * User: Silvan
 * Date: 18.10.12
 * Time: 5:58
 */
public class RegularPrice extends Price{
    @Override
    int getPriceCode() {
        return Movie.REGULAR;
    }

    @Override
    double getCharge(int daysRented) {
        double result = 2;
        if (daysRented > 2)
            result += (daysRented - 2) * 1.5;
        return  result;
    }
}
