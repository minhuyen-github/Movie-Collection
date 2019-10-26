package numberlist.objectlist;

import static java.lang.Math.abs;
import java.math.BigDecimal;
import java.math.MathContext;

/**
 * This class represents the basic function and representation of complex
 * numbers.
 *
 * @author Uyen Hoang
 * @version 1.1 5/5/2018
 */
public final class Complex implements Copiable {

    private double real;
    private double imaginary;

    /**
     * This constructor declares the variable for real number and imaginary one.
     */
    public Complex() {
        real = 0;
        imaginary = 0;
    }

    /**
     * This constructor - overload the first one - declares the variable for
     * real number and imaginary one.
     *
     * @param real the real number that the user provide.
     * @param imaginary the imaginary number that the user provide.
     */
    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    /**
     * This method gets the real number.
     *
     * @return a double value - the value that the user input.
     */
    public double getReal() {
        return real;
    }

    /**
     * This method gets the imaginary number.
     *
     * @return a double value - the value that the user input.
     */
    public double getImaginary() {
        return imaginary;
    }

    /**
     * This method adds two complex numbers.
     *
     * @param other another complex number that the user want to add to the
     * first one.
     * @return a Complex object which has real and imaginary numbers.
     */
    public Complex add(Complex other) {
        double realOther = other.getReal();
        double imaginaryOther = other.getImaginary();

        double sumReal = real + realOther;
        double sumImaginary = imaginary + imaginaryOther;

        Complex output = new Complex(sumReal, sumImaginary);
        return output;
    }

    /**
     * This method subtracts two complex numbers.
     *
     * @param other another complex number that the user want to subtract from
     * the first one.
     * @return a Complex object which has real and imaginary numbers.
     */
    public Complex subtract(Complex other) {
        double realOther = other.getReal();
        double imaginaryOther = other.getImaginary();

        double minusReal = real - realOther;
        double minusImaginary = imaginary - imaginaryOther;

        Complex output = new Complex(minusReal, minusImaginary);
        return output;
    }

    /**
     * This method displays the complex numbers.
     *
     * @return a String representation of the complex number.
     */
    @Override
    public String toString() {
        BigDecimal bd = new BigDecimal(real);
        bd = bd.round(new MathContext(4));
        real = bd.doubleValue();

        BigDecimal bdMore = new BigDecimal(imaginary);
        bdMore = bdMore.round(new MathContext(4));
        imaginary = bdMore.doubleValue();

        if (real == 0 && imaginary == 0) {
            return "0.0";
        } else if (real == 0) {
            return String.valueOf(imaginary) + "i";
        } else if (imaginary == 0) {
            return String.valueOf(real);
        } else if (imaginary < 0) {
            return String.valueOf(real) + " - " + String.valueOf(abs(imaginary)) + "i";
        }
        return String.valueOf(real) + " + " + String.valueOf(imaginary) + "i";
    }

    /**
     * This method makes a deep copy - a copy of data but with different address
     * - of a Complex object.
     *
     * @return the deep copy of a Complex object.
     */
    @Override
    public Complex deepCopy() {
        return new Complex(real, imaginary);
    }

}
