/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dslab_SearchingSorting;

import Algorithms.Searching;
import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author clatulip
 */
public class ConcertManager {

    private ConcertTicket[] concertTickets;


    public ConcertManager() {
        readConcerts();
    }

    // private helper method to increase array capacity if needed
    private void expandCapacity() {
        Arrays.copyOf(concertTickets, concertTickets.length * 2);
    }

    // private helper method to initialize data
    private void readConcerts() {
        
        concertTickets = new ConcertTicket[9];
        concertTickets[0] = new ConcertTicket("Jason Aldean", 18);
        concertTickets[1] = new ConcertTicket("Panic at the Disco", 40);
        concertTickets[2] = new ConcertTicket("Phish", 20);
        concertTickets[3] = new ConcertTicket("Carrie Underwood", 35);
        concertTickets[4] = new ConcertTicket("Bonnie Raitt", 18);
        concertTickets[5] = new ConcertTicket("Needtobreathe", 50);
        concertTickets[6] = new ConcertTicket("Dolly Parton", 80);
        concertTickets[7] = new ConcertTicket("Trans-Siberian Orchestra", 75);
        concertTickets[8] = new ConcertTicket("Twney One Pilots", 45);

    }

    /**
     * Prints out info about the first ticket found that matches price specified
     *
     * @param price int
     */
    public void findTicketByPrice_Linear(int price) {
        ConcertTicket target = new ConcertTicket("", price);

        ConcertTicket resultTicket = Searching.linearSearch2(concertTickets, target);
        if (resultTicket != null) {
            System.out.println("Linear Search. Found concert with $" + price + " tickets:");
            System.out.println("\t" + resultTicket.toString());
        } else {
            System.out.println("Linear Search. Didn't find concert with $" + price + " tickets");
        }
    }



    /**
     * Prints out whether or not a ticket with specified price exists.
     *
     * @param price int
     */
    public void existsTicketWithPrice_Linear(int price) {
        ConcertTicket target = new ConcertTicket("", price);

        if (Searching.linearSearch(concertTickets, target)) {
            System.out.println("Linear Search. Concert with $" + price + " tickets exists.");
        } else {
            System.out.println("Linear Search. Didn't find concert with $" + price + " tickets");
        }
    }

    /**
     * Sorts the concertTickets stored by this ConcertManager by price,
     * ascending.Doesn't print or return anything. 
     */
    public void sortByPrice() {
        Arrays.sort(concertTickets);
    }

    /**
     * Sorts the concertTickets stored by this ConcertManager by name,
     * ascending. Letter case is ignored. Doe«sn't print or return anything.
     */
    public void sortByName() {
        Arrays.sort(concertTickets, new ConcertTicketNameComparator());
        
    }
    
    /**«
     * Sorts the concertTickets stored by this ConcertManager by row,
     * ascending. Doesn't print or return anything.
     */
    public void sortByRow() {
        Arrays.sort(concertTickets, new ConcertTicketRowComparator());
    }

    /**
     * Generates a string to represent the concertTickets stored by this
     * ConcertManager.
     *
     * @return a string representing the concertTickets stored
     */
    @Override
    public String toString() {
        //return Arrays.toString(concertTickets);
        String list = new String();
        for (ConcertTicket t : concertTickets) {
            list = list.concat("\t" + t.toString() + "\n" );
        }
        return list;
    }

    /**
     * Comparator implementation of ConcertTickets to compare by name and ignore
     * letter casing.
     */
    private class ConcertTicketNameComparator implements
            Comparator<ConcertTicket> {

        @Override
        public int compare(ConcertTicket o1, ConcertTicket o2) {
            return o1.getName().compareToIgnoreCase(o2.getName());
        }

    }
    /**
     * Comparator implementation of ConcertTickets to compare by row
     * letter casing.
     */
    private class ConcertTicketRowComparator implements
            Comparator<ConcertTicket> {

        @Override
        public int compare(ConcertTicket o1, ConcertTicket o2) {
            if (o1.getRow() > o2.getRow()){return 1;}
            if (o1.getRow() < o2.getRow()){return -1;}
            else {return 0;}
        }

    }
    
    
    

}
