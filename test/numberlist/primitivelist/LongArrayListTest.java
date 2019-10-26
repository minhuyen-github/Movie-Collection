package numberlist.primitivelist;

import java.util.logging.Level;
import java.util.logging.Logger;
import numberlist.InvalidIndexException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Class: LongArrayListTest
 * File:  LongArrayListTest.java
 * Description: A class to test the class LongArrayList.
 * @author Uyen Hoang
 * Environment: PC, Mac OS X, JDK 1.8, NetBeans 8.2
 * Date: 4/12/2018
 * @version: 1.1
 * History Log: Updated from 4/7/2018
 */
public class LongArrayListTest {
    
    LongArrayList list1, list2;
    
     /**
     * <pre>
     * Method: LongArrayListTest()
     * Description: None.
     * @author: Uyen Hoang
     * Date: 4/7/2018
     * </pre>
     */
    public LongArrayListTest() 
    {
    }
    
     /**
     * <pre>
     * Method: setUp()
     * Description: Set up an array to test.
     * @author: Uyen Hoang
     * Date: 4/7/2018
     * </pre>
     */
    @Before
    public void setUp()
    {
        try {
            list1 = new LongArrayList();
            list2 = new LongArrayList();
            list1.add(0, 6);
            list1.add(1, 4);
            list1.add(2, 3);
            list1.add(3, 10);
        } catch (InvalidIndexException ex) {
            Logger.getLogger(LongArrayListTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * <pre>
     * Method: testAdd()
     * Description: Test of add method, of class LongArrayList.
     * @author Uyen Hoang
     * Date: 4/7/2018
     * </pre>
     */
    @Test
    public void testAdd() 
    {
        try {
            assertEquals(list1.get(0), 6);
            assertEquals(list1.get(1), 4);
            assertEquals(list1.get(2), 3);
            list1.add(1, 9);
            assertEquals(list1.get(1), 9);
            assertEquals(list1.get(2), 4);
            list1.add(4, 60);
            list1.add(5, 27);
            list1.add(6, 5);
            list1.add(7, 2);
            list1.add(8, 34);
            list1.add(9, 20);
            list1.add(10, 23);
            list1.add(11, 70);
            assertEquals(list1.get(10), 23);
            assertEquals(list1.get(11), 70);
            assertEquals(list1.get(17), Long.MIN_VALUE);
        } catch (InvalidIndexException ex) {
            Logger.getLogger(LongArrayListTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * <pre>
     * Method: testRemoveAt()
     * Description: Test of removeAt method, of class LongArrayList.
     * @author Uyen Hoang
     * Date: 4/7/2018
     * </pre>
     */
    @Test
    public void testRemoveAt() 
    {
        try {
            list1.removeAt(2);
            assertEquals(list1.get(2), 10);
            assertEquals(list1.get(3), 0);
            assertEquals(list1.getCount(), 3);
        } catch (InvalidIndexException ex) {
            Logger.getLogger(LongArrayListTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * <pre>
     * Method: testRemove()
     * Description: Test of remove method, of class LongArrayList.
     * @author Uyen Hoang
     * Date: 4/7/2018
     * </pre>
     */
    @Test
    public void testRemove() 
    {
        try {
            list1.add(4, 67);
            list1.remove(3);
            assertEquals(list1.get(2), 10);
            assertEquals(list1.get(3), 67);
            assertEquals(list1.get(4), 0);
            assertSame(list1.getCount(), 4);
            list1.add(5, 67);
            list1.remove(67);
            assertEquals(list1.get(3), 0);
            assertEquals(list1.get(5), Long.MIN_VALUE);
        } catch (InvalidIndexException ex) {
            Logger.getLogger(LongArrayListTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * <pre>
     * Method: testGet()
     * Description: Test of get method, of class LongArrayList.
     * @author Uyen Hoang
     * Date: 4/7/2018
     * </pre>
     */
    @Test
    public void testGet() 
    {
        try {
            assertEquals(list1.get(0), 6);
            assertEquals(list1.get(1), 4);
        } catch (InvalidIndexException ex) {
            Logger.getLogger(LongArrayListTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * <pre>
     * Method: testIndexOf()
     * Description: Test of indexOf method, of class LongArrayList.
     * @author Uyen Hoang
     * Date: 4/7/2018
     * </pre>
     */
    @Test
    public void testIndexOf() 
    {
        try {
            list1.add(4, 60);
            list1.add(5, 27);
            list1.add(6, 5);
            list1.add(7, 2);
            list1.add(8, 34);
            list1.add(9, 20);
            assertEquals(list1.indexOf(2), 7);
            assertEquals(list1.indexOf(34), 8);
        } catch (InvalidIndexException ex) {
            Logger.getLogger(LongArrayListTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * <pre>
     * Method: testGetCount()
     * Description: Test of getCount method, of class LongArrayList.
     * @author Uyen Hoang
     * Date: 4/7/2018
     * </pre>
     */
    @Test
    public void testGetCount() 
    {
        assertEquals(list1.getCount(), 4);
    }

    /**
     * <pre>
     * Method: testToString()
     * Description: Test of toString method, of class LongArrayList.
     * @author Uyen Hoang
     * Date: 4/7/2018
     * </pre>
     */
    @Test
    public void testToString() 
    {
       assertEquals(list1.toString(), "[ 6, 4, 3, 10 ]");
       assertEquals(list2.toString(), "[ ]");
    }

    /**
     * Test of set method, of class LongArrayList.
     * @throws java.lang.Exception
     */
    @Test
    public void testSet() throws Exception {
        list1.set(2, 10);
        assertEquals(10, list1.get(2));
    }
    
}
