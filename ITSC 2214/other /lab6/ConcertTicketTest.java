/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dslab_SearchingSorting;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kyle
 */
public class ConcertTicketTest {
    
    ConcertTicket ct1;
    ConcertTicket ct2;
    ConcertTicket ct3;
    ConcertTicket ct4;
    
    public ConcertTicketTest() {
        ct1 = new ConcertTicket("Niche Artist", 5);
        ct2 = new ConcertTicket("Popular Artist", 6);
        ct3 = new ConcertTicket("International Superstar", 7);
        ct4 = new ConcertTicket("Pop Star", 7);
    }

    /**
     * Test of compareTo method, of class ConcertTicket.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        
        //ct1 is less than ct2
        assertTrue(ct1.compareTo(ct2) == -1);
        
        //ct2 is greater than ct1
        assertTrue(ct2.compareTo(ct1) == 1);
        
        //ct3 and ct4 are equal
        assertTrue(ct3.compareTo(ct4) == 0);

        

        
    }
    
}
