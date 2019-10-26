package numberlist.objectlist;

import java.util.logging.Level;
import java.util.logging.Logger;
import numberlist.InvalidIndexException;

/**
 * This class represents as an ArrayList - an array that is growable - type
 * numeric with all basic methods such as adding, getting and removing an
 * element at a specific position, etc.
 *
 * @author Uyen Hoang
 * @version 1.1 5/6/2018
 */
public class NumericArrayList extends NumericList implements Copiable {

    private Copiable[] list;

    /**
     * This constructor declares the array's size and initialize variable.
     */
    public NumericArrayList() {
        list = new Copiable[10];
        count = 0;
    }

    /**
     * This method adds a given value at a given index in the array.
     *
     * @param index the specified position.
     * @param obj the object that the user provides.
     * @throws numberlist.InvalidIndexException
     */
    @Override
    public void add(int index, Copiable obj) throws InvalidIndexException {
        if (index < 0 || index > count) {
            throw new InvalidIndexException(0, count, index);
        }
        if (count >= list.length) {
            Copiable[] listCopy = new Copiable[list.length * 2];
            for (int k = 0; k < list.length; k++) {
                listCopy[k] = list[k];
            }
            list = listCopy;
        }
        for (int a = count; a > index; a--) {
            list[a] = list[a - 1];
        }
        list[index] = obj;
        count++;
    }

    /**
     * This method removes the value at a given index in the array.
     *
     * @param index this is the specified position.
     * @return the removed value at the given index.
     * @throws numberlist.InvalidIndexException
     */
    @Override
    public Copiable removeAt(int index) throws InvalidIndexException {
        Copiable temp;
        if (index < 0 || index >= count) {
            throw new InvalidIndexException(0, count - 1, index);
        } else {
            temp = list[index];
            for (int i = index; i < count - 1; i++) {
                list[i] = list[i + 1];
            }
            //list[count - 1] = null;
            count--;
        }
        return temp;
    }

    /**
     * This method removes a given value in the array.
     *
     * @param obj the object given by the user.
     */
    @Override
    public void remove(Copiable obj) {
        int temp = indexOf(obj);
        if (temp == -1) {
            return;
        } else {
            try {
                removeAt(temp);
            } catch (InvalidIndexException ex) {
                Logger.getLogger(NumericArrayList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * This method gets the value at a given index in the array.
     *
     * @param index the specified position.
     * @return the value at the given index.
     * @throws numberlist.InvalidIndexException
     */
    @Override
    public Copiable get(int index) throws InvalidIndexException {
        if (index < 0 || index >= count) {
            throw new InvalidIndexException(0, count - 1, index);
        }
        return list[index];
    }

    /**
     * This method returns the index of a given value in the array.
     *
     * @param obj the object given by the user.
     * @return the index of the given value.
     */
    @Override
    public int indexOf(Copiable obj) {
        int index = -1;
        for (int j = 0; j < count && index < 0; j++) {
            if (list[j].toString().equals(obj.toString())) {
                index = j;
            }
        }
        return index;
    }

    /**
     * This method returns the String value of the array.
     *
     * @return the String value of the array.
     */
    @Override
    public String toString() {
        String arrayDisplay = "";
        arrayDisplay += "[ ";
        if (count == 0) {
            return "[ ]";
        } else {
            for (int l = 0; l < count - 1; l++) {
                arrayDisplay += String.valueOf(list[l]) + ", ";
            }
        }
        arrayDisplay += String.valueOf(list[count - 1]);
        arrayDisplay += " ]";
        return arrayDisplay;
    }

    /**
     * This method makes a deep copy of the array.
     *
     * @return a list which is a copy of the array.
     */
    @Override
    public NumericArrayList deepCopy() {
        NumericArrayList listCopy = new NumericArrayList();
        for (int i = 0; i < count; i++) {
            try {
                listCopy.add(i, get(i).deepCopy());
            } catch (InvalidIndexException ex) {
                Logger.getLogger(NumericArrayList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listCopy;
    }

    /**
     * This method will receive a position(index) and set the value that the
     * user want to put at that given position.
     *
     * @param index The position where the user want to put the value.
     * @param obj The given value.
     * @return The value which was originally at that index.
     * @throws InvalidIndexException
     */
    @Override
    public Copiable set(int index, Copiable obj) throws InvalidIndexException {
        if (index < 0 || index >= count) {
            throw new InvalidIndexException(0, count - 1, index);
        } else {
            Copiable temp = list[index];
            list[index] = obj;
            return temp;
        }
    }
}
