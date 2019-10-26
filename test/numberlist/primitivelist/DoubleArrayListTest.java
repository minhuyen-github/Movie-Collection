package numberlist.primitivelist;

import java.util.logging.Level;
import java.util.logging.Logger;
import numberlist.InvalidIndexException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Class: DoubleArrayListTest
 * File:  DoubleArrayListTest.java
 * Description: A class to test the class DoubleArrayList.
 * @author Uyen Hoang
 * Environment: PC, Mac OS X, JDK 1.8, NetBeans 8.2
 * Date: 4/12/2018
 * @version: 1.1
 * History Log: Updated from 4/7/2018
 */
public class DoubleArrayListTest {
    DoubleArrayList list1, list2;
    
    /**
     * <pre>
     * Method: DoubleArrayListTest()
     * Description: None.
     * @author: Uyen Hoang
     * Date: 4/7/2018
     * </pre>
     */
    public DoubleArrayListTest() {
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
            list1 = new DoubleArrayList();
            list2 = new DoubleArrayList();
            list1.add(0, 6.0);
            list1.add(1, 4.0);
            list1.add(2, 3.0);
            list1.add(3, 10.0);
            list2.add(0, 12.34);
            list2.add(1, 23.45);
            list2.add(2, 34.56);
        } catch (InvalidIndexException ex) {
            Logger.getLogger(DoubleArrayListTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * <pre>
     * Method: testAdd()
     * Description: Test of add method, of class DoubleArrayList.
     * @author Uyen Hoang
     * Date: 4/7/2018
     * </pre>
     */
    @Test
    public void testAdd() 
    {
        try {
            assertEquals(6.0, list1.get(0), 0.0);
            assertEquals(4.0, list1.get(1), 0.0);
            assertEquals(3.0, list1.get(2), 0.0);
            list1.add(1, 9);
            assertEquals(9.0, list1.get(1), 0.0);
            assertEquals(4.0, list1.get(2), 0.0);
            list1.add(4, 60.0);
            list1.add(5, 27.0);
            list1.add(6, 5.0);
            list1.add(7, 2.0);
            list1.add(8, 34.0);
            list1.add(9, 20.0);
            list1.add(10, 23.2);
            list1.add(11, 70.4);
            assertEquals(23.2, list1.get(10), 23.2);
            assertEquals(70.4, list1.get(11), 0.0);
            assertEquals(-0.0, list1.get(17), 0.0);
        } catch (InvalidIndexException ex) {
            Logger.getLogger(DoubleArrayListTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * <pre>
     * Method: testRemoveAt()
     * Description: Test of removeAt method, of class DoubleArrayList.
     * @author Uyen Hoang
     * Date: 4/7/2018
     * </pre>
     */
    @Test
    public void testRemoveAt() 
    {
        try {
            list1.removeAt(2);
            assertEquals(10.0, list1.get(2), 0.0);
            assertEquals(0.0, list1.get(3), 0.0);
            assertEquals(list1.getCount(), 3);
            list2.removeAt(1);
            assertEquals(list2.get(1), 34.56, 0.0);
        } catch (InvalidIndexException ex) {
            Logger.getLogger(DoubleArrayListTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * <pre>
     * Method: testRemove()
     * Description: Test of remove method, of class DoubleArrayList.
     * @author Uyen Hoang
     * Date: 4/7/2018
     * </pre>
     */
    @Test
    public void testRemove() 
    {
        try {
            list1.add(4, 67.1);
            list1.remove(3.0);
            assertEquals(list1.get(2), 10.0, 0.0);
            assertEquals(67.1, list1.get(3), 0.0);
            assertEquals(0.0, list1.get(4), 0.0);
            assertSame(list1.getCount(), 4);
            list1.add(5, 67.2);
            list1.remove(67.1);
            assertEquals(0.0, list1.get(3), 0.0);
            assertEquals(0.0, list1.get(5), 0.0);
        } catch (InvalidIndexException ex) {
            Logger.getLogger(DoubleArrayListTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * <pre>
     * Method: testGet()
     * Description: Test of get method, of class DoubleArrayList.
     * @author Uyen Hoang
     * Date: 4/7/2018
     * </pre>
     */
    @Test
    public void testGet() 
    {
        try {
            assertEquals(6.0, list1.get(0), 0.0);
            assertEquals(4.0, list1.get(1), 0.0);
        } catch (InvalidIndexException ex) {
            Logger.getLogger(DoubleArrayListTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * <pre>
     * Method: testIndexOf()
     * Description: Test of indexOf method, of class DoubleArrayList.
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
            Logger.getLogger(DoubleArrayListTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * <pre>
     * Method: testGetCount()
     * Description: Test of getCount method, of class DoubleArrayList.
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
     * Description: Test of toString method, of class DoubleArrayList.
     * @author Uyen Hoang
     * Date: 4/7/2018
     * </pre>
     */
    @Test
    public void testToString() 
    {
       assertEquals(list1.toString(), "[ 6.0, 4.0, 3.0, 10.0 ]");
       //assertEquals(list2.toString(), "[]");
    }

    /**
     * Test of set method, of class DoubleArrayList.
     */
    @Test
    public void testSet() throws Exception {
        list1.set(2, 5.0);
        assertEquals(5.0, list1.get(2), 0.0);
    }
    
}
