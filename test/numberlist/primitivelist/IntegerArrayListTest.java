package numberlist.primitivelist;

import java.util.logging.Level;
import java.util.logging.Logger;
import numberlist.InvalidIndexException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Class: IntegerArrayListTest
 * File:  IntegerArrayListTest.java
 * Description: A class to test the class IntegerArrayList.
 * @author Uyen Hoang
 * Environment: PC, Mac OS X, JDK 1.8, NetBeans 8.2
 * Date: 4/12/2018
 * @version: 1.1
 * History Log: Updated from 4/7/2018
 */
public class IntegerArrayListTest {
    IntegerArrayList list1;
    
    /**
     * <pre>
     * Method: IntegerArrayListTest()
     * Description: None.
     * @author: Uyen Hoang
     * Date: 4/7/2018
     * </pre>
     */
    public IntegerArrayListTest() 
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
        list1 = new IntegerArrayList();
        list1.add(9);
        list1.add(3);
        list1.add(4);
        list1.add(6);
    }

    /**
     * <pre>
     * Method: testAdd()
     * Description: Test of add method, of class IntegerArrayList.
     * @author Uyen Hoang
     * Date: 4/7/2018
     * </pre>
     */
    @Test
    public void testAdd() 
    {
        try {
            assertEquals(list1.get(0), 9);
            assertEquals(list1.get(1), 3);
            assertEquals(list1.get(2), 4);
            assertEquals(list1.get(3), 6);
        } catch (InvalidIndexException ex) {
            Logger.getLogger(IntegerArrayListTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * <pre>
     * Method: testRemoveAll()
     * Description: Test of removeAll method, of class IntegerArrayList.
     * @author Uyen Hoang
     * Date: 4/7/2018
     * </pre>
     */
    @Test
    public void testRemoveAll() 
    {
        try {
            list1.add(4);
            list1.add(4);
            list1.removeAll(4);
            assertEquals(list1.get(2), 6);
            assertEquals(list1.get(4), 0);
            assertEquals(list1.get(5), 0);
        } catch (InvalidIndexException ex) {
            Logger.getLogger(IntegerArrayListTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * <pre>
     * Method: testLastIndexOf()
     * Description: Test of lastIndexOf method, of class IntegerArrayList.
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
