package numberlist.objectlist;

import static java.lang.Math.abs;

/**
 * This class represents the basic function and representation of money with
 * dollars, and cents.
 *
 * @author Uyen Hoang
 * @version 1.1 5/5/2018
 */
public final class Money implements Copiable {

    private final long dollars;
    private final byte cents;

    /**
     * This constructor declares the variable for dollars, and cents.
     */
    public Money() {
        dollars = 0;
        cents = 0;
    }

    /**
     * This constructor declares the variable for dollars and cents that the
     * user provides, and it overloads the above constructor.
     *
     * @param dollars a dollar's value given by the user.
     * @param cents a cent's value given by the user.
     */
    public Money(long dollars, byte cents) {
        //Convert dollars and cents
        long convert = (dollars * 100) + cents;
        dollars = convert / 100;
        cents = (byte) (convert % 100);

        this.dollars = dollars;
        this.cents = cents;
    }

    /**
     * This method gets the dollars.
     *
     * @return a long value of the dollar.
     */
    public long getDollars() {
        return dollars;
    }

    /**
     * This method gets the cents.
     *
     * @return a byte value of the cents.
     */
    public byte getCents() {
        return cents;
    }

    /**
     * This method adds a money object to another.
     *
     * @param other this is the other Money object that the user provides.
     * @return a Money object which is the sum.
     */
    public Money add(Money other) {
        //Declare variables
        long sum = (dollars * 100) + cents;
        //Add the new value to the sum
        sum += (other.getDollars() * 100) + other.getCents();

        long sumDollars = sum / 100;
        byte sumCents = (byte) (sum % 100);

        Money result = new Money(sumDollars, sumCents);
        return result;
    }

    /**
     * This method subtracts a Money object with another.
     *
     * @param other the Money object that the user provides.
     * @return a Money object which is the result after the subtraction.
     */
    public Money subtract(Money other) {
        //Declare variables
        long minus = (dollars * 100) + cents;
        //Minus the new value to the minus
        minus -= (other.getDollars() * 100) + other.getCents();

        long minusDollars = minus / 100;
        byte minusCents = (byte) (minus % 100);

        Money result = new Money(minusDollars, minusCents);
        return result;
    }

    /**
     * This method displays the String representation of the Money object.
     *
     * @return a String value of the money.
     */
    @Override
    public String toString() {
        if (dollars < 0 || cents < 0) {
            return "-$" + String.valueOf(abs(dollars)) + "."
                    + String.format("%02d", abs(cents));
        }
        return "$" + String.valueOf(dollars) + "."
                + String.format("%02d", cents);
    }

    /**
     * This method makes a deep copy of a Money object.
     *
     * @return the Money object which is a copy.
     */
    @Override
    public Money deepCopy() {
        return new Money(dollars, cents);
    }

}
