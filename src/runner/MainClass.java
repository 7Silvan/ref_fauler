package runner;

import example.Customer;
import example.Movie;
import example.Rental;

import java.util.ArrayList;
import java.util.List;

/**
 * User: roman.gural
 * Date: 17.10.12
 * Time: 13:47
 */
public class MainClass {
    
    public static void main(String[] args) {
        Customer customer = new Customer("Alan");
        List<Rental> rentals = new ArrayList<Rental>() {{
            add(new Rental(new Movie("Ratatoile", 0), 10));
            add(new Rental(new Movie("Wanhelsing",1), 20));
            add(new Rental(new Movie("Robocop",2),30));
            add(new Rental(new Movie("Dracula",0),2));
            add(new Rental(new Movie("Tom and Jerry",1),1));
            add(new Rental(new Movie("Revolver",2), 0));
        }};

        customer.setRentals(rentals);
        System.out.println(customer.statement());

        System.out.println("////////////////////////////////////////");

        System.out.println(customer.htmlStatement());

        System.out.println("////////////////////////////////////////");

        customer.setRentals(new ArrayList<Rental>());
        System.out.println(customer.statement());

        System.out.println("////////////////////////////////////////");
        System.out.println(customer.htmlStatement());
    }
}
