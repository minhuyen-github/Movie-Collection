package numberlist.primitivelist;

import java.util.logging.Level;
import java.util.logging.Logger;
import numberlist.InvalidIndexException;

/**
 * This class represents as an ArrayList - an array that is growable - type real
 * with all basic methods such as adding, getting and removing an element at a
 * specific position, etc.
 *
 * @author Uyen Hoang
 * @version 1.1 5/5/2018
 */
public class RealArrayList extends DoubleArrayList {

    /**
     * This method adds a given value to the array but start from the end of the
     * array.
     *
     * @param value the value that the user want to add to the array
     * @return the last index it was added at.
     */
    public int add(double value) {
        try {
            super.add(getCount(), value);
        } catch (InvalidIndexException ex) {
            Logger.getLogger(RealArrayList.class.getName()).log(Level.SEVERE, null, ex);
        }
        return indexOf(value);
    }

    /**
     * This method removes a given value at every position in the array.
     *
     * @param value the value that the user want to remove.
     */
    public void removeAll(double value) {
        for (int i = getCount() - 1; i >= 0; i--) {
            try {
                if (get(i) == value) {
                    removeAt(i);
                }
            } catch (InvalidIndexException ex) {
                Logger.getLogger(RealArrayList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * This method returns the last index found of the given value in the array.
     *
     * @param value the given value
     * @return the last index of, possibly, many index of the given value
     */
    public int lastIndexOf(double value) {
        for (int a = getCount() - 1; a > -1; a--) {
            try {
                if (super.get(a) == value) {
                    return a;
                }
            } catch (InvalidIndexException ex) {
                Logger.getLogger(RealArrayList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return -1;
    }
}
