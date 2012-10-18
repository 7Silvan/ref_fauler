package example;

/**
 * User: Silvan
 * Date: 18.10.12
 * Time: 5:58
 */
public class NewReleasePrice extends Price{
    @Override
    int getPriceCode() {
        return Movie.NEW_RELEASE;
    }
}
