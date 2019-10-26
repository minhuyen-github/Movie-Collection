package numberlist.primitivelist;

import java.util.logging.Level;
import java.util.logging.Logger;
import numberlist.InvalidIndexException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Class: RealArrayListTest
 * File:  RealArrayListTest.java
 * Description: A class to test the class RealArrayList.
 * @author Uyen Hoang
 * Environment: PC, Mac OS X, JDK 1.8, NetBeans 8.2
 * Date: 4/12/2018
 * @version: 1.1
 * History Log: Updated from 4/7/2018
 */
public class RealArrayListTest {
    RealArrayList list1;
    
    /**
     * <pre>
     * Method: RealArrayListTest()
     * Description: None.
     * @author: Uyen Hoang
     * Date: 4/7/2018
     * </pre>
     */
    public RealArrayListTest() {
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
        list1 = new RealArrayList();
        list1.add(9.1);
        list1.add(3.6);
        list1.add(4.3);
        list1.add(6.2);
    }

    /**
     * <pre>
     * Method: testAdd()
     * Description: Test of add method, of class RealArrayList.
     * @author Uyen Hoang
     * Date: 4/7/2018
     * </pre>
     */
    @Test
    public void testAdd() 
    {
        try {
            assertEquals(9.1, list1.get(0), 0.0);
            assertEquals(3.6, list1.get(1), 0.0);
            assertEquals(4.3, list1.get(2), 0.0);
            assertEquals(6.2, list1.get(3), 0.0);
        } catch (InvalidIndexException ex) {
            Logger.getLogger(RealArrayListTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * <pre>
     * Method: testRemoveAll()
     * Description: Test of removeAll method, of class RealArrayList.
     * @author Uyen Hoang
     * Date: 4/7/2018
     * </pre>
     */
    @Test
    public void testRemoveAll() 
    {
        try {
            list1.add(4.0);
            list1.add(4.0);
            list1.removeAll(4.0);
            assertEquals(4.3, list1.get(2), 0.0);
            assertEquals(0.0, list1.get(4), 0.0);
            assertEquals(0.0, list1.get(5), 0.0);
        } catch (InvalidIndexException ex) {
            Logger.getLogger(RealArrayListTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * <pre>
     * Method: testLastIndexOf()
     * Description: Test of lastIndexOf method, of class RealArrayList.
     * @author Uyen Hoang
     * Date: 4/7/2018
     * </pre>
     */
    @Test
    public void testLastIndexOf() 
    {
        list1.add(3);
        assertEquals(list1.lastIndexOf(3), 4);
    }
    
}
