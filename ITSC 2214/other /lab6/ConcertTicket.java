/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dslab_SearchingSorting;

/**
 *
 * @author clatulip
 */
public class ConcertTicket implements Comparable<ConcertTicket> {

    private String name;
    private int price;
    private char row;
    private int seat;

    public ConcertTicket(String name, int price) {
        this.name = name;
        this.price = price;
        // randomly create a row and seat
        // assumes 60 seats across width of venue
        // seat 1 at far left
        seat = (int)(Math.random()*60 + 1);
        // assume 26 rows from front to back
        // row A at front
        row = (char)((int)(Math.random()*26) + 65); // 065 is ASCII code for 'A'
    }

    public ConcertTicket() {
        name = "";
        price = 0;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }


    public char getRow() {
        return row;
    }


    public int getSeat() {
        return seat;
    }

    @Override
    public String toString() {
        return "ConcertTicket{" +  "\t price=" + price + "\t row=" + row + "\t seat= " + seat + "\t name=" + name +'}';
    }
    
    /**
     * Compares concert tickets based on ticket price.
     * @param o 
     * @return  |1 (if price is greater)|-1 (if price is less than)| 0 (if they are equal)|
     */
    @Override
    public int compareTo(ConcertTicket o) {
        if (this.price > o.price){return 1;}
        else if (this.price < o.price){return -1;}
        else {return 0;}
      
    }

}
