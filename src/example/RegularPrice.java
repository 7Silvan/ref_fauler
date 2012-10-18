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
}
