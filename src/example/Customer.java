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
        int frequentRenterPoints = 0;
        Iterator rentals = this.rentals.iterator();
        String result = "Учет аренды для " + getName() + "\n";
        while (rentals.hasNext()) {
            Rental each = (Rental) rentals.next();
            frequentRenterPoints += each.getFrequentRenterPoints();


            // показать результаты для этой аренды
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
        }
        
        // добавить нижний колонтитул
        result += "Сумма задолженности составляет " +
                String.valueOf(getTotalCharge()) + "\n";
        result += "Вы заработали " + String.valueOf(frequentRenterPoints) +
                " очков за активность";
        return result;
    }

    private double getTotalCharge() {
        double result = 0;
        Iterator rentals = this.rentals.iterator();
        while (rentals.hasNext()) {
            Rental each = (Rental) rentals.next();
            result += each.getCharge();
        }
        return result;
    }


}
