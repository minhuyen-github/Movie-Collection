package numberlist.objectlist;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Class: ComplexTest
 * File:  ComplexTest.java
 * Description: A class to test the class Complex.
 * @author Uyen Hoang
 * Environment: PC, Mac OS X, JDK 1.8, NetBeans 8.2
 * Date: 4/12/2018
 * @version: 1.1
 * History Log: Updated from 4/7/2018
 */
public class ComplexTest {
    Complex complex, complex1, complex2, complex3;
    
    /**
     * <pre>
     * Method: MoneyTest()
     * Description: None.
     * @author: Uyen Hoang
     * Date: 4/7/2018
     * </pre>
     */
    public ComplexTest() 
    {
    }
    
    /**
     * <pre>
     * Method: setUp()
     * Description: Set up real and imaginary to test.
     * @author: Uyen Hoang
     * Date: 4/7/2018
     * </pre>
     */
    @Before
    public void setUp() 
    {
        complex = new Complex(2, 50);
        complex1 = new Complex(1.2, -5);
        complex2 = new Complex(-4.6, -50);
        complex3 = new Complex(-2.1, 45);
    }

    /**
     * <pre>
     * Method: testGetReal()
     * Description: Test of getReal method, of class Complex.
     * @author: Uyen Hoang
     * Date: 4/7/2018
     * </pre>
     */
    @Test
    public void testGetReal() 
    {
        assertEquals(2.0, complex.getReal(), 0.0);
        assertEquals(1.2, complex1.getReal(), 0.0);
        assertEquals(-4.6, complex2.getReal(), 0.0);
        assertEquals(-2.1, complex3.getReal(), 0.0);
    }

    /**
     * <pre>
     * Method: testGetImaginary()
     * Description: Test of getImaginary method, of class Complex.
     * @author: Uyen Hoang
     * Date: 4/7/2018
     * </pre>
     */
    @Test
    public void testGetImaginary() 
    {
        assertEquals(50, complex.getImaginary(), 0.0);
        assertEquals(-5, complex1.getImaginary(), 0.0);
        assertEquals(-50, complex2.getImaginary(), 0.0);
        assertEquals(45, complex3.getImaginary(), 0.0);
    }

    /**
     * <pre>
     * Method: testAdd()
     * Description: Test of add method, of class Complex.
     * @author: Uyen Hoang
     * Date: 4/7/2018
     * </pre>
     */
    @Test
    public void testAdd() 
    {
        assertEquals(3.2, (complex.add(complex1)).getReal(), 0.0);
        assertEquals(45, (complex.add(complex1)).getImaginary(), 0.0);
        
    }

    /**
     * <pre>
     * Method: testSubtract()
     * Description: Test of subtract method, of class Complex.
     * @author: Uyen Hoang
     * Date: 4/7/2018
     * </pre>
     */
    @Test
    public void testSubtract() 
    {
        assertEquals(0.8, (complex.subtract(complex1)).getReal(), 0.0);
        assertEquals(55, (complex.subtract(complex1)).getImaginary(), 0.0);
    }

    /**
     * <pre>
     * Method: testToString()
     * Description: Test of toString method, of class Complex.
     * @author: Uyen Hoang
     * Date: 4/7/2018
     * </pre>
     */
    @Test
    public void testToString() 
    {
        assertEquals(complex1.toString(), "1.2 - 5.0i");
    }

    /**
     * Test of deepCopy method, of class Complex.
     */
    @Test
    public void testDeepCopy() {
        Complex complexCopy = complex1.deepCopy();
        assertEquals(complexCopy.getReal(), complex1.getReal(), 0.0);
        assertEquals(complexCopy.getImaginary(), complex1.getImaginary(), 0.0);
    }
    
}
