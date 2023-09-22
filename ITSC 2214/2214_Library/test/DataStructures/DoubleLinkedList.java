/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import Exceptions.*;
import ADTs.*;

/**
 *
 * @author clatulip
 */
public class DoubleLinkedList<T extends Comparable> implements ListADT<T> {

    protected LinearNode<T> first;  // Points to the first LinearNode in the list
    protected LinearNode<T> last;   // Points to the last LinearNode in the list
    protected int numNodes;         // The number of LinearNodes in the list

    public DoubleLinkedList() {
        first = null;
        last = null;
        numNodes = 0;
    }

    @Override
    public void addFirst(T element) {
        LinearNode<T> temp = new LinearNode<>(element);
        if (numNodes == 0) {
            first = temp;
            last = temp;
            numNodes++;
            return;
        }
        temp.setNext(first);
        first.setPrev(temp);
        first = temp;
        numNodes++;
    }

    @Override
    public void addLast(T element) {
        LinearNode<T> temp = new LinearNode<>(element);
        if (numNodes == 0) {
            first = temp;
            last = temp;
            numNodes++;
            return;
        }
        temp.setPrev(last);
        last.setNext(temp);
        last = temp;
        numNodes++;
    }

    @Override
    public void addAfter(T existing, T element) throws ElementNotFoundException {
        LinearNode<T> temp = new LinearNode<>(element);
        LinearNode<T> curr = first;
        while (curr != null) {
            if (curr.getElement().compareTo(existing) == 0) {
                // found existing element, add temp after this
                temp.setNext(curr.getNext());
                temp.setPrev(curr);
                if (curr.getNext() != null) {
                    curr.getNext().setPrev(temp);
                } else {
                    // adding at the end
                    last = temp;
                }
                curr.setNext(temp);
                numNodes++;
                return;
            } else {
                curr = curr.getNext();
            }
        }
        // iterated through and didn't find existing element
        throw new ElementNotFoundException("DoubleLinkedList: addAfter(..) method");
    
    }

    @Override
    public T remove(T element) throws EmptyCollectionException, ElementNotFoundException {
        if (numNodes == 0)
            throw new EmptyCollectionException("DoubleLinkedList");
        T result = null;
        LinearNode<T> curr = first;
        while (curr != null) {
            if (curr.getElement().compareTo(element) == 0) {
                // found the element, so remove this node
                result = curr.getElement();
                // check special case of removing only element
                if ((curr == first) && (curr == last)) {
                    first = null;
                    last = null;
                    numNodes--;
                    return result;
                }
                // check special case of removing first element
                if (curr == first) {
                    first = curr.getNext();
                    first.setPrev(null);
                    numNodes--;
                    return result;
                }
                // check special case of removing last element
                if (curr == last) {
                    last = curr.getPrev();
                    last.setNext(null);
                    numNodes--;
                    return result;
                }
                // normal case, removing in middle
                curr.getPrev().setNext(curr.getNext());
                curr.getNext().setPrev(curr.getPrev());
                numNodes--;
                return result;
            } // end if
            curr = curr.getNext();
        } // end iteration through list
        throw new ElementNotFoundException("DoubleLinkedList, remove(element) method");
        
    }
    /**
     * <p> removes the the first object in the list and returns its element
     * @return the Object element of the first item in the list
     * @throws EmptyCollectionException 
     */
    @Override
    public T removeFirst() throws EmptyCollectionException {

        if (numNodes == 0){throw new EmptyCollectionException("list is empty");} // if list is empty throw exception
        
        
        LinearNode<T> nodeTemp = first; // create a temperary pointer that points at first to handle the operations

        
        //if list only has one element
        if (numNodes == 1){ 
            T tempElement = first.getElement(); // store its element inside a variable 
            this.first = null; // set first and last equal to null
            this.last = null;
            this.numNodes--;
            return tempElement; // return the element removed
        }

  
        
        // if list has more than one element
        else {     
            nodeTemp = this.first;
            T nodeRemoved = first.getElement();
            nodeTemp = nodeTemp.getNext(); // iterate to the next link after the first one
            this.first = nodeTemp;  // point this.first at the next link after the first
            this.numNodes--;
            return nodeRemoved; // return the element of the index thats removed
        }

    }
    
    /**
     * <p> removes the last item in the list and returns its element
     * @return the Object element of the last item in the list
     * @throws EmptyCollectionException 
     */
    @Override
    public T removeLast() throws EmptyCollectionException {
        if (numNodes == 0 ){throw new EmptyCollectionException("list is empty");} //if list is 0, throw exception
        
        
        
        LinearNode<T> nodeTemp = first; // create a temperary pointer that points at first to handle the operations
        
        //if list only has one element
        if (numNodes == 1){
            T tempElement = first.getElement(); // store its element inside a variable 
            this.first = null; // set first and last equal to null
            this.last = null;
            this.numNodes--;
            return tempElement; // return the element removed
            
            
        }
        else{
            nodeTemp = this.last.getPrev(); // go to second to last last link
            this.last = nodeTemp; // point this.last at it
            nodeTemp = this.last.getNext(); // go to the last object 
            T tempElement = nodeTemp.getElement(); // put its object inside a element 
            nodeTemp.setPrev(null);
            nodeTemp.setNext(null);
            //  set its prev and next to null
            nodeTemp = this.last; // go back through the second to last link witch is now the first one, through .last
            nodeTemp.setNext(this.last); // set its next value to be this.last 
            this.numNodes--; //decrement the number of nodes value
            return tempElement; // return the element that was removed that was refrenced from above          
        }
    }



    @Override
    public T first() throws EmptyCollectionException {
        if (numNodes == 0)
            throw new EmptyCollectionException("DoubleLinkedList");
        T element = first.getElement();
        return element;
    }

    @Override
    public T last() throws EmptyCollectionException {
        if (numNodes == 0)
            throw new EmptyCollectionException("DoubleLinkedList");
        T element = last.getElement();
        return element;
    }

    @Override
    public boolean isEmpty() {
        return numNodes == 0;
    }

    @Override
    public int size() {
        return numNodes;
    }




    
    
    
    
}
