/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Maze_DS;
import DataStructures.EmptyCollectionException;
import DataStructures.StackADT;
import java.util.ArrayList;
/**
 * This class is used in the MazeRunner program and is a arrayList implementation of a stack.   
 * @author zander cowan
 * @param <T> the type of elements held in this stack
 */
public class ArrayListStack <T> implements StackADT<T> {
    private ArrayList<T> stack;
    private int numElements;
    private int nack;
    
    /**
     * constructor for the class.
     * creates the stack and sets the num elements to 0.
     */
    public ArrayListStack(){      
        stack = new ArrayList<T>();
        numElements = 0;
    }
    
    /**
     * Pushes the element onto the stack.
     * @param element (a generic element).
     */
    @Override
    public void push(T element) {
        stack.add(element);
        numElements++;
    }
    
    /**
     * Pops the last added item off the stack.
     * @return removedElement (the element deleted off the stack).
     * @throws EmptyCollectionException (when array list is 0).
     */
    @Override
    public T pop() throws EmptyCollectionException {
        if (numElements == 0){throw new EmptyCollectionException("list is empty");}
        T removedElement = stack.remove(stack.size() - 1); //remove last off
        numElements--; // decrement the size
        return removedElement;
    }
    
    /**
     * Looks at the element that was last added to the stack.
     * @return the first item).
     * @throws EmptyCollectionException.
     */
    @Override
    public T peek() throws EmptyCollectionException {
        if (this.isEmpty()){throw new EmptyCollectionException("list is empty");}
        return stack.get(stack.size() - 1);
    }
    
    /**
     * Checks and see if the stack is empty.
     * @return True (if stack is empty), False (if stack isnt empty).
     * 
     */
    @Override
    public boolean isEmpty() {
        if (numElements == 0){return true;}
        return false;
    }
    
    /**
     * Gets the size of the stack.
     * @return s.
     */
    @Override
    public int size() {
        return numElements;
    }

    @Override
    public String toString() {
        return "ArrayListStack{" + "stack=" + stack + ", numElements=" + numElements + '}';
    }
    
    
    
}
