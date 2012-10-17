package example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * User: roman.gural
 * Date: 17.10.12
 * Time: 14:53
 */
public class CustomerTest {

    private final String exampleOfStatement =
            "Учет аренды для Alan\n" +
            "\tRatatoile\t14.0\n" +
            "\tWanhelsing\t60.0\n" +
            "\tRobocop\t42.0\n" +
            "\tDracula\t2.0\n" +
            "\tTom and Jerry\t3.0\n" +
            "\tRevolver\t1.5\n" +
            "Сумма задолженности составляет 122.5\n" +
            "Вы заработали 7 очков за активность";
    private final String exampleOfEmptyStatement =
            "Учет аренды для EmptyCustomer\n" +
            "Сумма задолженности составляет 0.0\n" +
            "Вы заработали 0 очков за активность";


    private Customer customer;

    @Before
    public void prepare() {
        customer = new Customer("Alan");
        customer.setRentals(
                new ArrayList<Rental>() {{
            add(new Rental(new Movie("Ratatoile", 0), 10));
            add(new Rental(new Movie("Wanhelsing",1), 20));
            add(new Rental(new Movie("Robocop",2),30));
            add(new Rental(new Movie("Dracula",0),2));
            add(new Rental(new Movie("Tom and Jerry",1),1));
            add(new Rental(new Movie("Revolver",2), 0));
                }}
        );
    }

    @After
    public void clean() {
        customer = null;
    }


    /**
     * @verifies return lines of report
     * @see Customer#statement()
     */
    @Test
    public void statement_shouldReturnLinesOfReport() throws Exception {
        Assert.assertEquals("Returning lines of report properly", exampleOfStatement, customer.statement());
    }

    /**
     * @verifies return empty template if there is no rentals
     * @see Customer#statement()
     */
    @Test
    public void statement_shouldReturnEmptyTemplateIfThereIsNoRentals() throws Exception {
        Customer customer1 = new Customer("EmptyCustomer");
        Assert.assertEquals("Returning lines of empty report properly", exampleOfEmptyStatement, customer1.statement());
    }
}
