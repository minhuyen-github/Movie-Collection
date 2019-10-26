package numberlist.objectlist;

import java.util.logging.Level;
import java.util.logging.Logger;
import numberlist.InvalidIndexException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for NumericLinkedList
 *
 * @author Uyen Hoang
 */
public class NumericLinkedListTest {

    NumericLinkedList instance;
    Money money1 = new Money(5, (byte) 00);
    Money money2 = new Money(11, (byte) 11);
    Money money3 = new Money(34, (byte) 57);
    Money money4 = new Money(20, (byte) 75);
    Money money5 = new Money(25, (byte) 11);
    Money money6 = new Money(30, (byte) 23);
    Money money7 = new Money(35, (byte) 68);
    Money money8 = new Money(40, (byte) 22);
    Money money9 = new Money(45, (byte) 78);
    Money money10 = new Money(50, (byte) 67);

    public NumericLinkedListTest() {
        instance = new NumericLinkedList();
    }

    @Before
    public void setUp() {
        try {
            instance.add(0, money1);
            instance.add(1, money2);
            instance.add(2, money3);
            instance.add(3, money4);
            instance.add(4, money5);
            instance.add(5, money6);
            instance.add(6, money7);
            instance.add(7, money8);
            instance.add(8, money9);
            instance.add(9, money10);
        } catch (InvalidIndexException ex) {
            Logger.getLogger(NumericLinkedListTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of add method, of class NumericLinkedList.
     */
    @Test
    public void testAdd() {
        try {
            assertEquals(instance.get(0), money1);
            assertEquals(instance.get(1), money2);
            assertEquals(instance.get(2), money3);
            assertEquals(10, instance.getCount());
        } catch (InvalidIndexException ex) {
            Logger.getLogger(NumericLinkedListTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of removeAt method, of class NumericLinkedList.
     */
    @Test
    public void testRemoveAt() {
        try {
            assertEquals(money1, instance.removeAt(0));
            assertEquals(money2, instance.get(0));
            assertEquals(instance.getCount(), 9);
            assertEquals(money5, instance.removeAt(3));
        } catch (InvalidIndexException ex) {
            Logger.getLogger(NumericLinkedListTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Test of remove method, of class NumericLinkedList.
     */
    @Test
    public void testRemove() {
        try {
//            instance.remove(money1);
//            assertEquals(instance.getCount(), 9);
//            assertEquals(money2, instance.get(0));
//            instance.removeAt(15);
//            assertEquals(null, instance.get(15));
            instance.remove(money10);
            assertEquals(instance.getCount(), 9);
            assertEquals(instance.get(8), money9);
        } catch (InvalidIndexException ex) {
            Logger.getLogger(NumericLinkedListTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Test of get method, of class NumericLinkedList.
     */
    @Test
    public void testGet() throws InvalidIndexException {
        assertEquals(money4, instance.get(3));
        assertEquals(money5, instance.get(4));
        assertEquals(money6, instance.get(5));
    }

    /**
     * Test of indexOf method, of class NumericLinkedList.
     */
    @Test
    public void testIndexOf() {
        assertEquals(3, instance.indexOf(money4));
        assertEquals(4, instance.indexOf(money5));
        assertEquals(5, instance.indexOf(money6));
    }

    /**
     * Test of toString method, of class NumericLinkedList.
     */
    @Test
    public void testToString() throws InvalidIndexException {
        instance.removeAt(9);
        instance.removeAt(8);
        instance.removeAt(7);
        instance.removeAt(6);
        instance.removeAt(5);
        instance.removeAt(4);
        instance.removeAt(3);
        assertEquals("[ $5.00, $11.11, $34.57 ]", instance.toString());
    }

    /**
     * Test of deepCopy method, of class NumericLinkedList.
     */
    @Test
    public void testDeepCopy() throws InvalidIndexException {
        NumericLinkedList instanceCopy = new NumericLinkedList();
        instanceCopy = instance.deepCopy();
        assertEquals(money4.toString(), instanceCopy.get(3).toString());
        assertEquals(instance.getCount(), instanceCopy.getCount());
    }

    /**
     * Test of set method, of class NumericLinkedList.
     */
    @Test
    public void testSet() throws Exception {
        instance.set(8, money5);
        assertEquals(money5.toString(), instance.get(8).toString());
    }

}
