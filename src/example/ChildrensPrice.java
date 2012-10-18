package example;

/**
 * User: Silvan
 * Date: 18.10.12
 * Time: 5:55
 */
public class ChildrensPrice extends Price{

    @Override
    int getPriceCode() {
        return Movie.CHILDRENS;
    }
}
