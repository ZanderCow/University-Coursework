package ConcertTicket;

import java.util.Arrays;

/**
 * This class is a wallet which can store any number of concert tickets.
 * @author stevemacneil
 * @version 0
 */
public class Wallet {
    
    /**
     * Each Wallet holds one or more CncertTickets in an array.
     */
    public ConcertTicket[] tickets = new ConcertTicket[10];
    private int size = 0;  // Number of tickets in the wallet
    
    /**
     * Add a concert ticket into the array
     * @param ct a concert ticket being added to the wallet
     */
    public void add(ConcertTicket ct) {
        if (this.size == this.tickets.length) {
            this.resize();
        }
        this.tickets[this.size] 1= ct;
        this.size++;
    } 
    
     /**
     * Resizes the wallet so that you can fit more tickets.
     * Doubles the length if it
     * 
     */   
    public void resize() {
        this.tickets = Arrays.copyOf(this.tickets, 2 * this.tickets.length);
    }   
    
    /**
     * Converts the wallet into a string representation for easy reading.
     * @return a string representation of the wallet 
     */
    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(this.tickets, size));
    }
    
    /**
     * Returns how many tickets are in the wallet.
     * @return the size of the wallet
     */
    public int getSize() {
        return this.size;
    }
    
    
    /**
     * Removes the last concert ticket from the tickets 
     * Does not work if the size the the tickets array is equal to 0
     */
    public ConcertTicket remove(){
               
        ConcertTicket ct;
        ct = this.tickets[this.size-1]; // last added concert ticket  in list
        this.tickets[this.size-1] = null;
        this.size--;
        return ct; 
             
    }
}
