package numberlist.objectlist;

import java.util.logging.Level;
import java.util.logging.Logger;
import numberlist.InvalidIndexException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class NumericArrayListTest {
    NumericArrayList list1 = new NumericArrayList();
    
    Money money1, money2, money3, money4, money5, money6, money7, money8, money9,
    money10, money11;
    
    /**
     * Method: NumericArrayListTest()
     * Description: None.
     */
    public NumericArrayListTest() {
    }
    
    /**
     * Method: setUp()
     * Description: Set up an array to test.
     * @throws numberlist.InvalidIndexException
     */
    @Before
    public void setUp() throws InvalidIndexException 
    {
        money1 = new Money(5, (byte) 00);
        money2 = new Money(1, (byte) 25);
        money3 = new Money(15, (byte) 50);
        money4 = new Money(22, (byte) 75);
        money5 = new Money(25, (byte) 11);
        money6 = new Money(30, (byte) 23);
        money7 = new Money(37, (byte) 68);
        money8 = new Money(40, (byte) 22);
        money9 = new Money(46, (byte) 78);
        money10 = new Money(50, (byte) 67);
        list1.add(0, money1);
        list1.add(1, money2);
        list1.add(2, money3);
        list1.add(3, money4);
        list1.add(4, money5);
        list1.add(5, money6);
        list1.add(6, money7);
        list1.add(7, money8);
        list1.add(8, money9);
        list1.add(9, money10);
    }

    /**
     * Method: testAdd()
     * Description: Test of add method, of class NumericArrayList.
     */
    @Test
    public void testAdd() throws InvalidIndexException 
    {
        assertEquals(10, list1.getCount());
        money11 = new Money(31, (byte) 59);
        list1.add(5, money11);
        assertEquals(11, list1.getCount());
        assertEquals(money11, list1.get(5));
        assertEquals(money6, list1.get(6));
        assertEquals(money7, list1.get(7));
    }

    /**
     * Method: testRemoveAt()
     * Description: Test of removeAt method, of class NumericArrayList.
     */
    @Test
    public void testRemoveAt()  
    {
        try {
            list1.removeAt(-1);
            assertEquals(null, list1.get(-1));
            list1.removeAt(15);
            assertEquals(null, list1.get(15));
            list1.removeAt(1);
            assertEquals(money3, list1.get(1)); 
            assertEquals(money4, list1.get(2));
        } catch (InvalidIndexException ex) {
            Logger.getLogger(NumericArrayListTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Method: testRemove()
     * Description: Test of remove method, of class NumericArrayList.
     */
    @Test
    public void testRemove() throws InvalidIndexException 
    {
        list1.remove(money2);
        assertEquals(money3, list1.get(1));
        assertEquals(money4, list1.get(2)); 
    }

    /**
     * Method: testGet()
     * Description: Test of get method, of class NumericArrayList.
     */
    @Test
    public void testGet() 
    {
        try {
            assertEquals(money2, list1.get(1));
            assertEquals(money3, list1.get(2));
            assertEquals(null, list1.get(15));
        } catch (InvalidIndexException ex) {
            Logger.getLogger(NumericArrayListTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Method: testIndexOf()
     * Description: Test of indexOf method, of class NumericArrayList.
     */
    @Test
    public void testIndexOf() 
    {
        assertEquals(0, list1.indexOf(money1));
        assertEquals(1, list1.indexOf(money2));
        assertEquals(2, list1.indexOf(money3));
    }

    /**
     * <pre>
     * Method: testGetCount()
     * Description: Test of getCount method, of class NumericArrayList.
     * @author Uyen Hoang
     * Date: 4/7/2018
     * </pre>
     */
    @Test
    public void testGetCount() 
    {
        assertEquals(10, list1.getCount());
    }

    /**
     * <pre>
     * Method: testToString()
     * Description: Test of toString method, of class NumericArrayList.
     * @author Uyen Hoang
     * Date: 4/7/2018
     * </pre>
     */
    @Test
    public void testToString() 
    {
        assertEquals("[ $5.00, $1.25, $15.50, $22.75, $25.11, $30.23, $37.68"
                    + ", $40.22, $46.78, $50.67 ]", list1.toString());
    }

    /**
     * Test of deepCopy method, of class NumericArrayList.
     */
    @Test
    public void testDeepCopy() throws InvalidIndexException {
        NumericArrayList listCopy = list1.deepCopy();
        assertEquals(money3.toString(), listCopy.get(2).toString());
        assertEquals(listCopy.getCount(), list1.getCount());
    }

    /**
     * Test of set method, of class NumericArrayList.
     */
    @Test
    public void testSet() throws Exception {
        list1.set(4, money2);
        assertEquals(money2, list1.get(4));
    }
    
}
