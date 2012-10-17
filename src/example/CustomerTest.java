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
    private final String exampleOfHtmlStatement = 
            "<H1>Операции аренды для <EM>Alan</EM></H1><P>\n" +
            "Ratatoile: 14.0<BR>\n" +
            "Wanhelsing: 60.0<BR>\n" +
            "Robocop: 42.0<BR>\n" +
            "Dracula: 2.0<BR>\n" +
            "Tom and Jerry: 3.0<BR>\n" +
            "Revolver: 1.5<BR>\n" +
            "<P>Ваша задолженность составляет <EM>122.5</EM><P>\n" +
            "На этой аренде вы заработали <EM>7<EM> очков за активность<P>";
    private final String exampleOfEmptyHtmlStatement =
            "<H1>Операции аренды для <EM>EmptyCustomer</EM></H1><P>\n" +
            "<P>Ваша задолженность составляет <EM>0.0</EM><P>\n" +
            "На этой аренде вы заработали <EM>0<EM> очков за активность<P>";


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

    /**
     * @verifies return lines of report
     * @see Customer#htmlStatement()
     */
    @Test
    public void htmlStatement_shouldReturnLinesOfReport() throws Exception {
        Assert.assertEquals("Returning lines of html report properly", exampleOfHtmlStatement, customer.htmlStatement());
    }

    /**
     * @verifies return empty template if there is no rentals
     * @see Customer#htmlStatement()
     */
    @Test
    public void htmlStatement_shouldReturnEmptyTemplateIfThereIsNoRentals() throws Exception {
        Customer customer1 = new Customer("EmptyCustomer");
        Assert.assertEquals("Returning lines of empty html report properly", exampleOfEmptyHtmlStatement, customer1.htmlStatement());
    }
}
