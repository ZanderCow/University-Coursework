/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Maze_DS;

import DataStructures.EmptyCollectionException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author zandercowan
 */
public class ArrayListStackTest {
    
    /**
     * constructor.
     */
    public ArrayListStackTest() {
    }

    /**
     * Test of push method, of class ArrayListStack.
     */
    @Test
    public void testPush() {
        ArrayListStack<String> stackTest = new ArrayListStack();
        System.out.println("test push");

        //new stack is empty
        assertTrue(stackTest.size() == 0);
        
        stackTest.push("A");
        stackTest.push("B");
        stackTest.push("C");
        
        //pushing changes the contents of the stack/ increments the size
        assertTrue(stackTest.size() == 3);
        
        //pushing elements are pushed at the end of the stack
        try{
            assertTrue(stackTest.peek().equals("C"));
        } catch (Exception e){
            assertTrue(e instanceof EmptyCollectionException);
        }
        
        //stack after a push operation is correct
        try{
            stackTest.push("D");
            assertTrue(stackTest.pop().equals("D"));  
            assertTrue(stackTest.pop().equals("C"));
            assertTrue(stackTest.pop().equals("B"));
            assertTrue(stackTest.pop().equals("A"));
        } catch (Exception e){
            assertTrue(e instanceof EmptyCollectionException);
        }
        
        
    }

    /**
     * Test of pop method, of class ArrayListStack.
     */
    @Test
    public void testPop() {
        ArrayListStack<String> stackTest  = new ArrayListStack();
        System.out.println("test pop");
        
        // popping with size 0 throws a EmptyCollectionException 
        try{
            assertTrue(stackTest.size() == 0);
            String popTest = stackTest.pop();
        }catch (Exception e){
            assertTrue(e instanceof EmptyCollectionException);
        }
        
        stackTest.push("A");
        stackTest.push("B");
        stackTest.push("C");
        stackTest.push("D");
        
        // popping decrements the size of the stack and changes the beginng value of the stack
        try{
            stackTest.pop(); // pop D
            assertTrue(stackTest.size() == 3);
        } catch (Exception e){
            assertTrue(e instanceof EmptyCollectionException);
        }
        
        // popping changes the beginning value of the stack 
        try{
            stackTest.pop(); // pop C
            assertTrue(stackTest.peek().equals("B")); 
        } catch (Exception e){
            assertTrue(e instanceof EmptyCollectionException);
        }
        // popping returns the correct element
        try{
            assertTrue(stackTest.pop().equals("B"));
        } catch (Exception e){
            assertTrue(e instanceof EmptyCollectionException);
        }
        
        // stack after popping is correct 
        try{
            stackTest.push("B");
            stackTest.push("C");
            stackTest.push("D");
            assertTrue(stackTest.pop().equals("D"));
            assertTrue(stackTest.pop().equals("C"));
            assertTrue(stackTest.pop().equals("B"));
            assertTrue(stackTest.pop().equals("A"));        
        } catch (Exception e){
            assertFalse(e instanceof EmptyCollectionException); // this shouldnt get triggered/break
        }
        
    }

    /**
     * Test of peek method, of class ArrayListStack.
     */
    @Test
    public void testPeek() {
        ArrayListStack<String> stackTest  = new ArrayListStack();
        System.out.println("test peek");
        // peeking with size 0 throws a EmptyCollectionException
        try{
            stackTest.peek();
        } catch (Exception e){
            assertTrue(e instanceof EmptyCollectionException);
        }

        stackTest.push("A");
        stackTest.push("B");
        stackTest.push("C");
        
        // peeking doesnt modify the contents of the stack, nor the size
        try{
            assertTrue(stackTest.peek().equals("C")); //peeking returns the correct element
            assertTrue(stackTest.size() == 3);
            assertTrue(stackTest.pop().equals("C"));
            assertTrue(stackTest.pop().equals("B"));
            assertTrue(stackTest.pop().equals("A"));
        }catch (Exception e){
            assertTrue(e instanceof EmptyCollectionException);
        }
        
    }

    /**
     * Test of isEmpty method, of class ArrayListStack.
     */
    @Test
    public void testIsEmpty() {
        ArrayListStack<String> stackTest = new ArrayListStack();
        System.out.println("test isEmpty");
        //returns true if stack is empty
        assertTrue(stackTest.isEmpty());
        
        // returns false if stack isnt empty  
        stackTest.push("A");
        stackTest.push("B");
        stackTest.push("C");
        
        assertFalse(stackTest.isEmpty());
        
    }

    /**
     * Test of size method, of class ArrayListStack.
     */
    @Test
    public void testSize() {
        ArrayListStack<String> stackTest  = new ArrayListStack();
        System.out.println("test size");
        stackTest.push("A");
        stackTest.push("B");
        stackTest.push("C");
        
        // method returns the correct size of the stack
        assertTrue(stackTest.size() == 3);
    }

    
}
