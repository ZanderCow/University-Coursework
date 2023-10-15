package DataStructures;

import ADTs.StackADT;
import Exceptions.EmptyCollectionException;

/**
 * A linked Stack implementation.
 * @author clatulip.  toString() modified for Fall 2022 by nblong
 * @version 1
 * @since 2022-10-02
 */
public class LinkedStack<T> implements StackADT<T> {

    private int count;
    private LinearNode<T> top;

    public LinkedStack() {
        count = 0;
        top = null;

    }

    @Override
    public T pop() throws EmptyCollectionException {
        T result;
        if (count != 0) {
            result = top.getElement();
            top = top.getNext();
            count--;
        } else {
            throw new EmptyCollectionException("Linked List Stack");
        }
        return result;

    }

    @Override
    /**
     * NOTE: THIS DOESNT TAKE IN ACCOUNT FOR A NEGATIVE STACK SIZE
     */
    public void push(T element) {        
        // if count is 0, create the node, and point top to the node
        if (count == 0){
            top = new LinearNode(element);     
            count++;
        }
        
        // if size is 1 or greater
        else{
            LinearNode<T> newNode = new LinearNode(element);  //create a new node
            
            LinearNode<T> nodePointer = top; 
            while (nodePointer.getNext() != null){nodePointer = nodePointer.getNext();} // iterate to the end of the list
            nodePointer.setNext(newNode); //set the end nodes .next() to be the new node
            count++;
        }
        
    }

    @Override
    public T peek() throws EmptyCollectionException {
        // if size is 0 throw EmptyCollectionException
        if (count == 0){throw new EmptyCollectionException("theres nothing in the list");}
        
        // if size is 1 or greater, get the top element
        else{
            return top.getElement();
        }
    }

    @Override
    public boolean isEmpty() {
        if (count == 0) {
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public String toString() {
        String result = null;
        if (top == null) {
            result = "LinkedListStack is empty";
        } else {
            result = "LinkedListStack{" + "count=" + count + ", top=";
            LinearNode<T> temp = top;
            for (int i = 0; i < count; i++) {
                result = result + temp.getElement();
                if (i < count - 1) {
                    result = result + ", ";
                }
                temp = temp.getNext();
            }
            result = result + "}";
        }
        return result;
    }

}
