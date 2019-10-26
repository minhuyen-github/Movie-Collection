package numberlist.primitivelist;

import java.util.logging.Level;
import java.util.logging.Logger;
import numberlist.InvalidIndexException;

/**
 * This class represents as an ArrayList - an array that is growable - type long
 * with all basic methods such as adding, getting and removing an element at a
 * specific position, etc.
 *
 * @author Uyen Hoang
 * @version 1.1 5/5/2018
 */
class LongArrayList {

    private long[] list;
    private int count; //variable to count the useable elements.

    /**
     * This constructor declares the size of the array and initialize the count
     * to be 0.
     */
    public LongArrayList() {
        //Declare array's size and variable
        list = new long[10];
        count = 0;
    }

    /**
     * This method adds a given value at a given index in the array.
     *
     * @param index the given position in the array given by the user.
     * @param value the value to be added given by the user.
     */
    public void add(int index, long value) throws InvalidIndexException {
        if (index < 0 || index > count) {
            throw new InvalidIndexException(0, count, index);
        }
        if (count >= list.length) {
            long[] listCopy = new long[list.length * 2];
            for (int k = 0; k < list.length; k++) {
                listCopy[k] = list[k];
            }
            list = listCopy;
        }
        for (int a = count; a > index; a--) {
            list[a] = list[a - 1];
        }
        list[index] = value;
        count++;
    }

    /**
     * This method removes a value at a given index in the array.
     *
     * @param index the given position in the array given by the user.
     * @return the value which is removed at the given index.
     */
    public long removeAt(int index) throws InvalidIndexException {
        long temp;
        if (index < 0 || index >= count) {
            throw new InvalidIndexException(0, count - 1, index);
        } else {
            temp = list[index];
            for (int i = index; i < count - 1; i++) {
                list[i] = list[i + 1];
            }
            //list[count - 1] = 0;
            count--;
        }
        return temp;
    }

    /**
     * This method removes a given value in the array.
     *
     * @param value the value which the user want to remove.
     */
    public void remove(long value) {
        //find the index of that value, then use the removeAt method to remove 
        //that value which index is found.
        int temp = indexOf(value);
        if (temp == -1) {
            return;
        } else {
            try {
                removeAt(temp);
            } catch (InvalidIndexException ex) {
                Logger.getLogger(LongArrayList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * This method gets the value at a given index in the array.
     *
     * @param index the position in the array
     * @return the value at the given index.
     */
    public long get(int index) throws InvalidIndexException {
        if (index < 0 || index >= count) {
            throw new InvalidIndexException(0, count - 1, index);
        }
        return list[index];
    }

    /**
     * This method returns the index of a given value in the array.
     *
     * @param value the value which the user want to know its index.
     * @return the index of the given value.
     */
    public int indexOf(long value) {
        int index = -1;
        for (int j = 0; j < count && index < 0; j++) {
            if (list[j] == value) {
                index = j;
            }
        }
        return index;
    }

    /**
     * This method returns the value of variable count.
     *
     * @return the value of variable count.
     */
    public int getCount() {
        return count;
    }

    /**
     * This method returns the String value/representation of the array.
     *
     * @return the String value/representation of the array.
     */
    @Override
    public String toString() {
        String arrayDisplay = "";
        arrayDisplay += "[ ";
        if (count == 0) {
            return "[ ]";
        } else {
            for (int l = 0; l < count - 1; l++) {
                arrayDisplay += Long.toString(list[l]) + ", ";
            }
        }
        arrayDisplay += Long.toString(list[count - 1]);
        arrayDisplay += " ]";
        return arrayDisplay;
    }
    
    /**
     * This method will receive a position(index) and set the value that the
     * user want to put at that given position.
     *
     * @param index The position where the user want to put the value.
     * @param value The given value.
     * @return The value which was originally at that index.
     * @throws InvalidIndexException
     */
    public long set(int index, long value) throws InvalidIndexException {
        if (index < 0 || index >= count) {
            throw new InvalidIndexException(0, count - 1, index);
        } else {
            long temp = list[index];
            list[index] = value;
            return temp;
        }
    }
}
