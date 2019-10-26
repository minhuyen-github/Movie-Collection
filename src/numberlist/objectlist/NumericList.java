package numberlist.objectlist;

import numberlist.InvalidIndexException;

/**
 * This class is an abstract class, which contains some abstract methods that
 * will be implemented by child classes.
 *
 * @author Uyen Hoang
 */
abstract class NumericList {

    int count;

    /**
     * This method is abstract and is overridden by the child classes' methods,
     * but it adds a given object to a specifiec position in the list/array.
     *
     * @param index the specified position.
     * @param obj the object given by the user.
     */
    abstract void add(int index, Copiable obj) throws InvalidIndexException;

    /**
     * This method adds a given object at the end of list/array.
     *
     * @param obj the object given by the user.
     * @return the index that the object was added at.
     */
    public int add(Copiable obj) {
        try {
            add(count, obj);
        } catch (InvalidIndexException ex) {
        }
        return indexOf(obj);
    }

    /**
     * This method is abstract and overridden, but it removes an object at a
     * specified position.
     *
     * @param index the specified position.
     * @return the object that was removed.
     */
    abstract Copiable removeAt(int index) throws InvalidIndexException;

    /**
     * This method is abstract and overridden, but it removes a given object
     * from the list/array.
     *
     * @param obj the object given by the user.
     */
    abstract void remove(Copiable obj);

    /**
     * This method is abstract and overridden, but it gets an object at a
     * specified position.
     *
     * @param index the specified position.
     * @return
     */
    abstract Copiable get(int index) throws InvalidIndexException;

    /**
     * This method is abstract and overridden, but it gets the position/index of
     * a given object.
     *
     * @param obj the object given by the user.
     * @return the index/position.
     */
    abstract int indexOf(Copiable obj);

    /**
     * This method keeps track of how many values that are in the array/list.
     *
     * @return
     */
    public int getCount() {
        return count;
    }

    abstract Copiable set(int index, Copiable obj) throws InvalidIndexException;
}
