package numberlist.objectlist;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Class: MoneyTest
 * File:  MoneyTest.java
 * Description: A class to test the class Money.
 * @author Uyen Hoang
 * Environment: PC, Mac OS X, JDK 1.8, NetBeans 8.2
 * Date: 4/12/2018
 * @version: 1.1
 * History Log: Updated from 4/7/2018
 */
public class MoneyTest {
    
    Money money, money1, money2, money3;
    
    /**
     * <pre>
     * Method: MoneyTest()
     * Description: None.
     * @author: Uyen Hoang
     * Date: 4/7/2018
     * </pre>
     */
    public MoneyTest() 
    {
    }
    
    /**
     * <pre>
     * Method: setUp()
     * Description: Set up dollars and cents to test.
     * @author: Uyen Hoang
     * Date: 4/7/2018
     * </pre>
     */
    @Before
    public void setUp() 
    {
        money = new Money(2, (byte)50);
        money1 = new Money(1, (byte)-5);
        money2 = new Money(-4, (byte)-50);
        money3 = new Money(-2, (byte) 45);
        
    }

    /**
     * <pre>
     * Method: testGetDollars()
     * Description: Test of getDollars method, of class Money.
     * @author: Uyen Hoang
     * Date: 4/7/2018
     * </pre>
     */
    @Test
    public void testGetDollars() 
    {
        assertEquals(money.getDollars(), 2);
        assertEquals(money1.getDollars(), 0);
        assertEquals(money2.getDollars(), -4);
        assertEquals(money3.getDollars(), -1);
    }

    /**
     * <pre>
     * Method: testGetCents()
     * Description: Test of getCents method, of class Money.
     * @author: Uyen Hoang
     * Date: 4/7/2018
     * </pre>
     */
    @Test
    public void testGetCents() 
    {
        assertEquals(money.getCents(), (byte)50);
        assertEquals(money1.getCents(), (byte)95);
        assertEquals(money2.getCents(), (byte)-50);
        assertEquals(money3.getCents(), (byte)-55);
    }

    /**
     * <pre>
     * Method: testAdd()
     * Description: Test of add method, of class Money.
     * @author: Uyen Hoang
     * Date: 4/7/2018
     * </pre>
     */
    @Test
    public void testAdd() 
    {
        assertEquals((money.add(money1)).getDollars(), 3);
        assertEquals((money.add(money1)).getCents(), (byte)45);
        assertEquals((money1.add(money2)).getDollars(), -3);
        assertEquals((money1.add(money2)).getCents(), -55);
    }

    /**
     * <pre>
     * Method: testSubtract()
     * Description: Test of subtract method, of class Money.
     * @author: Uyen Hoang
     * Date: 4/7/2018
     * </pre>
     */
    @Test
    public void testSubtract() 
    {
        assertEquals((money3.subtract(money)).getDollars(), -4);
        assertEquals((money3.subtract(money)).getCents(), -5);
    }

    /**
     * <pre>
     * Method: testToString()
     * Description: Test of toString method, of class Money.
     * @author: Uyen Hoang
     * Date: 4/7/2018
     * </pre>
     */
    @Test
    public void testToString() 
    {
        assertEquals(money2.toString(), "-$4.50");
        assertEquals(money.toString(), "$2.50");
        assertEquals(money1.toString(), "$0.95");
        assertEquals(money3.toString(), "-$1.55");
    }

    /**
     * Test of deepCopy method, of class Money.
     */
    @Test
    public void testDeepCopy() {
        Money moneyCopy = money1.deepCopy();
        assertEquals(moneyCopy.getDollars(), money1.getDollars());
        assertEquals(moneyCopy.getCents(), money1.getCents());
    }

}
