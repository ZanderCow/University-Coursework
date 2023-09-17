package Shopping;

/**
 * An Element Not Found Exception class
 * Exception handler for when an element isn't in a collection
 * For use in ITCS 2214 Data Structures & Algorithms
 * UNC Charlotte, 2016
 * @author clatulip
 * @version 0
 */
public class ElementNotFoundException extends Exception {
    public ElementNotFoundException(String el) {
        super("The element " + el + "was not found in the collection.");
    }
    
}
