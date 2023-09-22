package Shopping;

import Shopping.ElementNotFoundException;
import Shopping.EmptyCollectionException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @version Fall 2019
 * @author ITCS 2214
 */
public class ShoppingListArrayList implements ShoppingListADT {

    private ArrayList<Grocery> shoppingList;

    /**
     * Default constructor of ShoppingArray object.
     */
    public ShoppingListArrayList() {
        this.shoppingList = new ArrayList<>();
    }

    /**
     * Constructor of ShoppingArray object that parses from a file.
     *
     * @param filename the name of the file to parse
     * @throws FileNotFoundException if an error occurs when parsing the file
     */
    public ShoppingListArrayList(String filename) throws FileNotFoundException {
        this.shoppingList = new ArrayList<>();
        scanFile(filename);
    }

    /**
     * Method to add a new entry. Only new entries can be added. Combines
     * quantities if entry already exists.
     *
     * @param entry the entry to be added
     */
    @Override
    public void add(Grocery entry) {
        if (entry == null) {
            return;
        }

        // Check if this item already exists
        if (this.contains(entry) ) {
            //Merge the quantity of new entry into existing entry
            combineQuantity(entry);
            return;
        }

        shoppingList.add(entry);
    }

    /** 
     * Method to remove an entry.
     * (Should throw ElementNotFound exception is parameter doesn't exist.)
     *
     * @param ent to be removed
     * @return true when entry was removed
     * 
     * @NOTE: if there's two elements that have the exact same value, it will remove the one that is 
     * first seen fin the list 
     */
    @Override
    public boolean remove(Grocery ent) throws ElementNotFoundException{
        boolean found = false;

        // throws an expcetions if the arrayList size is 0
        if (this.shoppingList.size() == 0){ 
            return found;
        }
        // throws an expcetion if ent is null
        if (ent == null){ 
            throw new ElementNotFoundException(ent.getName());
        }
        else{  
            int i = 0; 
            for (; i < this.shoppingList.size(); i++){
                if (this.shoppingList.get(i).compareTo(ent) == 0){  // if it is found, please remove it and set the value of `found`.
                    found = true;
                    this.shoppingList.remove(i);
                    return found; /// ends the method if the element is found
                    }
                }     
            return found;         // Return false if not found        
            }      
        }
    

    /**
     * Method to find an entry.
     *
     * @param index to find
     * @return the entry if found
     * @throws Exceptions.EmptyCollectionException
     */
    @Override
    public Grocery find(int index) throws IndexOutOfBoundsException,
            EmptyCollectionException {
        
        // throws error if list is empty
        if (this.isEmpty()) {throw new EmptyCollectionException("ECE - find");}
        
        // throws error if index is greater than the length of the array List
        if (index > (this.shoppingList.size() - 1) | index < 0) {throw new IndexOutOfBoundsException();} 
        
     
        else{return (Grocery) this.shoppingList.get(index);}  // return the corresponding entry in the shoppingList  
    }

    /**
     * Method to locate the index of an entry.
     *
     * @param ent to find the index
     * @return the index of the entry
     * @throws ElementNotFoundException if no entry was found
     */
    @Override
    public int indexOf(Grocery ent) throws ElementNotFoundException {
        if (ent != null) {
            for (int i = 0; i < shoppingList.size(); i++) {
                if (shoppingList.get(i).compareTo(ent) == 0) {
                    return i;
                }
            }
        }
        throw new ElementNotFoundException("indexOf");
    }

    /**
     * Method to determine whether the object contains an entry.
     *
     * @param ent to find
     * @return true if and only if the entry is found
     * 
     * NOTE: IF THE @ OBJECTS HAVE THE SAME NAMES BUT DIFFRENT VALUES FOR OTHER VALUES, THIS COULD BREAK THE CODE
     * 
     */
    @Override
    public boolean contains(Grocery ent) {
        boolean hasItem = false;

        if (ent != null) {
            int i = 0;
            for (; i < shoppingList.size(); i++){
                // are the objects equal 
                if (ent.compareTo( this.shoppingList.get(i)) == 0){
                    hasItem = true;
                    return hasItem; //returns to break the code faster
                } 
            }
        }
        return hasItem;  // if the loop goes through all the way and finds no object 
    }

    /**
     * Gets the size of the collection.
     *
     * @return the size of the collection
     */
    @Override
    public int size() {
        return shoppingList.size();
    }

    /**
     * Gets whether the collection is empty.
     *
     * @return true if and only if the collection is empty
     */
    @Override
    public boolean isEmpty() {
        return shoppingList.isEmpty();
    }

    /**
     * Returns a string representing this object.
     *
     * @return a string representation of this object
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(String.format("%-25s", "NAME"));
        s.append(String.format("%-18s", "CATEGORY"));
        s.append(String.format("%-10s", "AISLE"));
        s.append(String.format("%-10s", "QUANTITY"));
        s.append(String.format("%-10s", "PRICE"));
        s.append('\n');
        s.append("------------------------------------------------------------"
                + "-------------");
        s.append('\n');
        for (int i = 0; i < shoppingList.size(); i++) {
            s.append(String.format("%-25s", shoppingList.get(i).getName()));
            s.append(String.format("%-18s", shoppingList.get(i).getCategory()));
            s.append(String.format("%-10s", shoppingList.get(i).getAisle()));
            s.append(String.format("%-10s", shoppingList.get(i).getQuantity()));
            s.append(String.format("%-10s", shoppingList.get(i).getPrice()));
            s.append('\n');
            s.append("--------------------------------------------------------"
                    + "-----------------");
            s.append('\n');
        }

        return s.toString();
    }

    /**
     * Add the quantity of a duplicate entry into the existing
     *
     * @param entry duplicate
     */
    private void combineQuantity(Grocery entry) {
        try {
            int index = this.indexOf(entry);
            shoppingList.get(index).setQuantity(
                    shoppingList.get(index).getQuantity()
                    + entry.getQuantity());
        } catch (ElementNotFoundException e) {
            System.out.println("combineQuantity - ECE");
        }

    }

    /**
     * Scans the specified file to add items to the collection.
     *
     * @param filename the name of the file to scan
     * @throws FileNotFoundException if the file is not found
     */
    private void scanFile(String filename) throws FileNotFoundException {
        Scanner scanner = new Scanner(getClass().getResourceAsStream(filename))
                .useDelimiter("(,|\r\n)");

        while (scanner.hasNext()) {
            Grocery temp = new Grocery(scanner.next(), scanner.next(),
                    Integer.parseInt(scanner.next()),
                    Float.parseFloat(scanner.next()),
                    Integer.parseInt(scanner.next()));

            add(temp);
        }
    }
    

}
