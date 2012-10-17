package example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * User: roman.gural
 * Date: 16.10.12
 * Time: 17:35
 */
public class Customer {
    private String name;
    private List rentals = new ArrayList();
    
    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getRentals() {
        return rentals;
    }

    public void setRentals(List rentals) {
        this.rentals = rentals;
    }

    /**
     * Makes reports about how many paying have customer for renting movies
     * @return string as lines, separated with \n,
     * like:
     * Учет аренды для Alan
     *      Ratatoile	14.0
     *      Wanhelsing	60.0
     *      Robocop	42.0
     *      Dracula	2.0
     *      Tom and Jerry	3.0
     *      Revolver	1.5
     * Сумма задолженности составляет 122.5
     * Вы заработали 7 очков за активность
     * @should return lines of report
     * @should return empty template if there is no rentals
     */
    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Iterator rentals = this.rentals.iterator();
        String result = "Учет аренды для " + getName() + "\n";
        while (rentals.hasNext()) {
            double thisAmount = 0;
            Rental each = (Rental) rentals.next();
            
            thisAmount = amountFor(each);

            // добавить очки для активного арендатора
            frequentRenterPoints++;
            // бонус за аренду новинки на два дня
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
                    each.getDaysRented() > 1)
                frequentRenterPoints++;
            
            // показать результаты для этой аренды
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }
        
        // добавить нижний колонтитул
        result += "Сумма задолженности составляет " +
                String.valueOf(totalAmount) + "\n";
        result += "Вы заработали " + String.valueOf(frequentRenterPoints) +
                " очков за активность";
        return result;
    }

    private double amountFor(Rental aRental) {
        double result = 0;
        switch (aRental.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                result += 2;
                if (aRental.getDaysRented() > 2)
                    result += (aRental.getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                result += aRental.getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                result += 1.5;
                if (aRental.getDaysRented() > 3)
                    result += (aRental.getDaysRented() - 3) * 1.5;
                break;
        }

        return result;
    }
}
