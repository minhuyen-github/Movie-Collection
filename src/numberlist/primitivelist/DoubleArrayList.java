package numberlist.primitivelist;

import java.util.logging.Level;
import java.util.logging.Logger;
import numberlist.InvalidIndexException;

/**
 * This class represents as an ArrayList - an array that is growable - type
 * double with all basic methods such as adding, getting and removing an element
 * at a specific position, etc.
 *
 * @author Uyen Hoang
 * @version 1.1 5/5/2018
 */
class DoubleArrayList {

    private final LongArrayList longArray;

    /**
     * This constructor initializes the LongArrayList object by calling the
     * LongArrayList's constructor.
     */
    public DoubleArrayList() {
        longArray = new LongArrayList();
    }

    /**
     * This method adds a given value at a given index in the array by calling
     * the LongArrayList's add method.
     *
     * @param index the given position in the array given by the user.
     * @param value the value to be added given by the user.
     */
    public void add(int index, double value) throws InvalidIndexException {
        long value1 = Double.doubleToRawLongBits(value);
        longArray.add(index, value1);
    }

    /**
     * This method removes a value at a given index in the array by calling the
     * LongArrayList's removeAt method.
     *
     * @param index the given position in the array given by the user.
     * @return the value which is removed at the given index.
     */
    public double removeAt(int index) throws InvalidIndexException {
        long value1 = longArray.removeAt(index);
        return Double.longBitsToDouble(value1);
    }

    /**
     * This method removes a given value in the array by calling the
     * LongArrayList's remove method.
     *
     * @param value the value which the user want to remove.
     */
    public void remove(double value) {
        long value1 = Double.doubleToRawLongBits(value);
        longArray.remove(value1);
    }

    /**
     * This method gets the value at a given index in the array by calling the
     * LongArrayList's get method.
     *
     * @param index the position in the array
     * @return the value at the given index.
     */
    public double get(int index) throws InvalidIndexException {
        double value = Double.longBitsToDouble(longArray.get(index));
        return value;
    }

    /**
     * This method returns the index of a given value in the array by calling
     * the LongArrayList's indexOf method.
     *
     * @param value the value which the user want to know its index.
     * @return the index of the given value.
     */
    public int indexOf(double value) {
        long value1 = Double.doubleToRawLongBits(value);
        int index = longArray.indexOf(value1);
        return index;
    }

    /**
     * This method returns the value of variable count by calling the
     * LongArrayList's getCount method.
     *
     * @return the value of variable count.
     */
    public int getCount() {
        return longArray.getCount();
    }

    /**
     * This method returns the String value/representation of the array by
     * calling the LongArrayList's toString method.
     *
     * @return the String value/representation of the array.
     */
    @Override
    public String toString() {
        String arrayDisplay = "";
        arrayDisplay += "[ ";
        if (longArray.getCount() == 0) {
            return "[ ]";
        } else {
            for (int l = 0; l < longArray.getCount() - 1; l++) {
                try {
                    arrayDisplay += Double.toString(Double.longBitsToDouble(longArray.get(l))) + ", ";
                } catch (InvalidIndexException ex) {
                    Logger.getLogger(DoubleArrayList.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        try {
            arrayDisplay += Double.toString(Double.longBitsToDouble(longArray.get(longArray.getCount() - 1)));
        } catch (InvalidIndexException ex) {
            Logger.getLogger(DoubleArrayList.class.getName()).log(Level.SEVERE, null, ex);
        }
        arrayDisplay += " ]";
        return arrayDisplay;
    }

    public double set(int index, double value) throws InvalidIndexException {
        long value1 = Double.doubleToRawLongBits(value);
        return Double.longBitsToDouble(longArray.set(index, value1));
    }
}
