/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import Exceptions.EmptyCollectionException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author zandercowan
 */
public class LinkedStackTest {
    
    public LinkedStackTest() {
    }

    @Test
    public void testPush() {
        System.out.println("testPush");
        LinkedStack<String> testStack = new LinkedStack<>();
        
        //the new stack is empty
        assertTrue(testStack.isEmpty()); 
        
        //pushing elements onto the stack increases its size
        testStack.push("A"); 
        assertTrue(testStack.size() == 1); 
        
        //elements are pushed onto the top of the stack
        try{
            assertTrue(testStack.peek().equals("A"));
        } catch (Exception e){
            assertTrue(e instanceof EmptyCollectionException);
        }
        
        //elements are in the correct order on the stack
        try{
            String pop1 = testStack.pop();
            assertTrue(pop1.equals("A"));
            String pop2 = testStack.pop();
            assertTrue(pop2.equals("B"));
            
        } catch (Exception e ){
            assertTrue(e instanceof EmptyCollectionException);
        }
        
    }
    @Test
    public void testPop(){
        System.out.println("testPop");
        LinkedStack<String> testStack = new LinkedStack<>();
        
        //popping from an empty stack throws an empty collection exception
        try{
            String emptyStack = testStack.pop();
        } catch (Exception e){
            assertTrue(e instanceof EmptyCollectionException);
        }

        //popping from a stack that has elements decrements its size
        try{
            testStack.push("A");
            testStack.pop();
            assertTrue(testStack.size() == 0);
        } catch (Exception e){
            assertTrue(e instanceof EmptyCollectionException);
        }
       
        
        //popping returns the element at the top of the stack
        try{
            testStack.push("A");
            String pop2 = testStack.pop(); 
            assertTrue(pop2.equals("A"));  
        } catch (Exception e){
            assertTrue(e instanceof EmptyCollectionException);
        }
       
        //popping mutates the stack by removing the top element
        //empty collection exceptions are not thrown if the stack is not empty
        try{
            testStack.push("A");
            testStack.push("B");
            testStack.push("C");
            testStack.pop(); 
            assertTrue(testStack.peek().equals("B"));
        } catch (Exception e){
            assertFalse(e instanceof EmptyCollectionException); // if thrown, will fail
        }
    
       

        
    }
    @Test
    public void testPeek() {
        System.out.println("testPeek");
        LinkedStack<String> testStack = new LinkedStack<>();
        
        //peek from an empty stack should throw an exception (hint: add an assertion in the catch part of a try-catch)
        try{
            testStack.peek();
        } catch (Exception e){
            assertTrue(e instanceof EmptyCollectionException);
        } 
        
        //peek does not change the state of the stack (in terms of size, content, or order of elements)
        try{
            testStack.push("A");
            testStack.push("B");
            testStack.push("C");
            testStack.peek();
            assertTrue(testStack.size() == 3);
        } catch (Exception e){
            assertTrue(e instanceof EmptyCollectionException);
        } 
        
        //peek returns the element at the top of the stack
        try{
            String peekString = testStack.peek();
            assertTrue(peekString.equals("A"));
        } catch (Exception e){
            assertTrue(e instanceof EmptyCollectionException);
        } 
        
       
        //peek at a non-empty stack shouldn’t throw exception
        try{
            String peekString = testStack.peek();
        } catch (Exception e){
            assertFalse(e instanceof EmptyCollectionException); // fails if exception is thrown
        } 
    }
    
}
