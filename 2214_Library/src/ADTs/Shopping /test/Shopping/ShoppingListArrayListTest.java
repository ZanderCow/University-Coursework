package Shopping;

import Shopping.ElementNotFoundException;
import Shopping.EmptyCollectionException;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * @version Spring 2019
 * @author Paul Franklin, Kyle Kiefer
 * Modified Fall 2022 by Bruce Long
 */
public class ShoppingListArrayListTest {

    private ShoppingListArrayList instance;

    /**
     * Initialize instance and entries
     */
    @Before
    public void setupTestCases() {
        instance = new ShoppingListArrayList();
    }

    /**
     * TODO To Complete the test of add method.
     */
    @Test
    public void testAdd() {
        //Create grocery objects and a shopping list instance
        Grocery item1 = new Grocery("Harry Potter", "book", 3, 15.5f, 2);
        Grocery item2 = new Grocery(item1);
        item2.setQuantity(3);
        int x = item1.compareTo(item2);

        instance = new ShoppingListArrayList();
        
        //size 0 test case (is the size of the instance equal to zero)
        assertEquals(0, instance.size());
        
        //null test case 
        instance.add(null);
        assertEquals(0, instance.size());
           
        instance.add(item1);
        
        // size of the instance is equal to one
        assertEquals(1, instance.size());
        
        //  item1 is inside the instance
        assertTrue(instance.contains(item1));
        
        //  item added to the instance is the same as in item1
        try{
           assertEquals(0, instance.find(0).compareTo(item1));
        }
        catch (EmptyCollectionException ece) {
            fail("Collection should not be empty in testAdd #1");
        }
        
        
        // ******Test combine feature**************
        
        instance.add(item2);
        
        //  item2 has the same entry name as item1.
        assertEquals(0, item2.getName().compareTo(item1.getName()));
        
        //size of the array didnt change (because of how .add() works)
        assertEquals(1,instance.size());
        
        // quantities are properly combined for the first item in the arraylist
        try {
            // Item at index 0 is still the entry1 Grocery object
            assertEquals(0, instance.find(0).compareTo(item1));
            // Quantity should be 5 now
            assertEquals(5, instance.find(0).getQuantity());
        } catch (EmptyCollectionException ece) {
            fail("Collection should not be empty in testAdd #2");
        }
       
        //***************************************

        
        // Test creating and adding a new grocery object to the list
        // Be sure that 1) the shopping list has a proper number of items
        //              2)the list item in the list is the same as in the newly
        //                created grocery object
        Grocery item3 = new Grocery("Laugh in the Rains", "book", 3, 35.5f, 1);
        instance.add(item3);
        System.out.println("Test..." + instance.size());
        assertEquals(2, instance.size());
        try {
            assertEquals(0, item3.compareTo(instance.find(1)));
            assertEquals(item3.getQuantity(), instance.find(1).getQuantity());
        } catch (Exception ex) {
            fail("Unexpected exception in testAdd" + ex.getMessage());
        }
    }

    /**
     * TODO To Complete the test of remove method.
     */
    @Test
    public void testRemove() {
        //Create grocery objects
        Grocery item1 = new Grocery("Harry Potter", "book", 3, 15.5f, 2);
        Grocery item2 = new Grocery("Hunger Game", "book", 3, 10.5f, 3);
        
        // Construct a shopping list
        instance = new ShoppingListArrayList();
        instance.add(item1);
        instance.add(item2);
        assertEquals(2, instance.size());
        boolean isRemoved;
        
        // is the returned value from the remove method true
        try{
            assertTrue(instance.remove(item1));
        } catch (Exception ex) {
            fail("Unexpected exception in testAdd" + ex.getMessage());
        }
        
        // has the shopping list been decreased by 1
        assertEquals(1,instance.size());

        // is the item that was removed not in the shopping list anymore
        assertFalse(instance.contains(item1));
     

        //****** remove method test for non-existing entry****************
       
        Grocery fakeEntry = new Grocery("Fake", "book", 3, 15.5f, 2);
        
        // returned value from  .remove() is false
        try {
             assertFalse(instance.remove(fakeEntry));
        } catch (Exception ex) {
            fail("Unexpected exception in testAdd" + ex.getMessage());
        }
        
        // shopping list didnt change
        assertEquals(1, instance.size());

                
       
        // Construct a case that the shopping list becomes empty
        try{
            assertTrue(instance.remove(item2));
            assertEquals(0, instance.size());

        }
        catch (Exception ex) {
            fail("Unexpected exception in testAdd" + ex.getMessage());
        }
    
        
        
        // Test the remove method when the shopping list is empty
        try{
            assertFalse(instance.remove(item2));
            assertEquals(0, instance.size());
            
        } catch (Exception ex) {
            fail("Unexpected exception in testAdd" + ex.getMessage());
        }
        
    }

    /**
     * 
     */
    @Test
    public void testFind() {
        //Create grocery objects
        Grocery item1 = new Grocery("Harry Potter", "book", 3, 15.5f, 2);
        Grocery item2 = new Grocery("Hunger Game", "book", 3, 10.5f, 3);
        
        // Construct an empty shopping list
        instance = new ShoppingListArrayList();
        
        // shopping list is empty
        assertEquals(0, instance.size());
        
        // .find() fails when the list is empty
        try{
            instance.find(0);
        } catch (EmptyCollectionException | IndexOutOfBoundsException e) {
            //EmptyCollectionException is thrown.
            assertTrue(e instanceof EmptyCollectionException);
        }
        


        
        // Add item1 and item2 into the shopping list
        instance.add(item1);
        instance.add(item2);
        
        // size of list is equal to 2
        assertEquals(2, instance.size());
        
        // .find() fails when index is bigger than the size of the shopping list
         try{
            instance.find(5);
        } catch (EmptyCollectionException | IndexOutOfBoundsException e) {
            //EmptyCollectionException is thrown.
            assertTrue(e instanceof IndexOutOfBoundsException);
        }

        // Test the case of finding a grocery object when the index is negative
        try {
            Grocery item = instance.find(-5);
            fail("Should not get here in testFind with index of " + item);
        } catch (IndexOutOfBoundsException e) {
            assertTrue(e instanceof IndexOutOfBoundsException);
        } catch (Exception ex) {
            fail("General exception should not occur in testFind - " + 
                    ex.getMessage());
        }
        
        // Test the case of finding a grocery object when the index is valid
        try {
            Grocery item = instance.find(0);
            assertEquals(0, item1.compareTo(item));
            assertEquals(2, instance.size());
        } catch (Exception ex) {
            fail("General exception should not occur in testFind - " + 
                    ex.getMessage());
        }
    }

    /**
     * Test of indexOf method.
     */
    @Test
    public void testIndexOf() {
        //Create grocery objects
        Grocery item1 = new Grocery("Harry Potter", "book", 3, 15.5f, 2);
        Grocery item2 = new Grocery("Hunger Game", "book", 3, 10.5f, 3);
        
        // Construct an empty shopping list
        instance = new ShoppingListArrayList();
        
        // Check the indexOf method when the shopping list is empty
        try {
            int index = instance.indexOf(item1);
        } catch (Exception e) {
            assertTrue(e instanceof ElementNotFoundException);
        }
        
        // Add grocery items into the shopping list
        instance.add(item1);
        instance.add(item2);
        
        // Check the indexOf method when the grocery item appears in the list
        try {
            assertEquals(1, instance.indexOf(item2));
            assertEquals(0, instance.indexOf(item1));
        } catch (Exception e1) {
            fail("Shouldn't get here in testIndexOf" + e1.getMessage());
        }
        
        // Check the indexOf method when the grocery item does not appear in 
        // the list
        try {
            Grocery item3 = new Grocery("Aladin", "book", 3, 15.5f, 2);
            int index = instance.indexOf(item3);
        } catch (Exception e2) {
            assertTrue(e2 instanceof ElementNotFoundException);
        }
        
        // Check the indexOf method when the grocery item is null
        try {
            Grocery obj = null;
            int index = instance.indexOf(obj);
        } catch (Exception e3) {
            assertTrue(e3 instanceof ElementNotFoundException);
        }
    }

    /**
     * Test of contains method.
     */
    @Test
    public void testContains() {
        //Create grocery objects
        Grocery item1 = new Grocery("Harry Potter", "book", 3, 15.5f, 2);
        Grocery item2 = new Grocery("Hunger Game", "book", 3, 10.5f, 3);
        
        // Construct a shopping list
        instance = new ShoppingListArrayList();
        
        // Check the contains method when the shopping list is empty
        assertFalse(instance.contains(item1));
        
        // Add grocery items into the shopping list
        instance.add(item1);
        instance.add(item2);
        
        // Check the contains method when the grocery item appears in the list
        assertEquals(2, instance.size());
        assertTrue(instance.contains(item2));
        
        // Check the contains method when the grocery item does not appear in the list
        Grocery item3 = new Grocery("Aladin", "book", 3, 15.5f, 2);
        assertFalse(instance.contains(item3));
        
        // Check the contains method when the grocery item is null
        Grocery obj = null;
        assertFalse(instance.contains(obj));
    }

    /**
     * Test of size method.
     */
    @Test
    public void testSize() {
        Grocery entry1 = new Grocery("Mayo", "Dressing / Mayo", 1, 2.99f, 1);
        instance = new ShoppingListArrayList();

        assertEquals(0, instance.size());

        instance.add(entry1);

        // Test increment
        assertEquals(1, instance.size());
        
        try{
            assertTrue(instance.remove(entry1));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        // Test decrement
        assertEquals(0, instance.size());
    }

    /**
     * Test of isEmpty method.
     */
    @Test
    public void testIsEmpty() {
        Grocery entry1 = new Grocery("Mayo", "Dressing / Mayo", 1, 2.99f, 1);
        instance = new ShoppingListArrayList();

        // Test empty
        assertTrue(instance.isEmpty());

        instance.add(entry1);

        // Test not empty
        assertFalse(instance.isEmpty());
    }

    private void AssertEquals(int i, int size) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}