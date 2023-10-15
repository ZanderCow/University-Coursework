/**
 * SortingLab.java
 *
 * @author Latulipe/Perez Quinones
 */
package dslab_SearchingSorting;

public class SearchingSortingLab {

    public static void main(String args[]) {
        ConcertManager cm = new ConcertManager();

        // test finding tickets with linear search
        cm.findTicketByPrice_Linear(15);
        cm.findTicketByPrice_Linear(75);
        cm.findTicketByPrice_Linear(20);
        cm.findTicketByPrice_Linear(68);

        // test seeing if tickets exist with linear search
        cm.existsTicketWithPrice_Linear(40);
        cm.existsTicketWithPrice_Linear(13);
        cm.existsTicketWithPrice_Linear(47);
        cm.existsTicketWithPrice_Linear(34);


        
        
        
        // Unsorted
        System.out.println("Unsorted: \n" + cm.toString());

        // Sort by price
        cm.sortByPrice();
        System.out.println("Sorted by price: \n" + cm.toString());
        
        // Sort by name
        cm.sortByName();
        System.out.println("Sorted by name: \n" + cm.toString());

        
        // Sort by row
        cm.sortByRow();
        System.out.println("Sorted by row: \n" + cm.toString());
    }
}
