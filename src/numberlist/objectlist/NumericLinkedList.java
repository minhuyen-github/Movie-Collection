package numberlist.objectlist;

import java.util.logging.Level;
import java.util.logging.Logger;
import numberlist.InvalidIndexException;

/**
 * This class contains basic methods for a linked list such as adding, getting,
 * and removing an element at a specific position.
 *
 * @author Uyen Hoang
 * @version 1.1 5/5/2018
 */
public class NumericLinkedList extends NumericList implements Copiable {

    private Node firstNode;

    /**
     * This constructor is a no-arg constructor.
     */
    public NumericLinkedList() {
    }

    /**
     * This method adds a Copiable object to the list at a specific position.
     *
     * @param index the specified position.
     * @param obj the Copiable object that the user want to add.
     * @throws numberlist.InvalidIndexException
     */
    @Override
    public void add(int index, Copiable obj) throws InvalidIndexException {
        if (index < 0 || index > count) {
            throw new InvalidIndexException(0, count, index);
        }
        Node newNode = new Node(obj);
        if (index == 0) {
            newNode.setNext(firstNode);
            firstNode = newNode;
        } else {
            Node currNode = firstNode;
            for (int i = 0; i < index - 1; i++) {
                currNode = currNode.getNext();
            }
            newNode.setNext(currNode.getNext());
            currNode.setNext(newNode);
        }
        count++;
    }

    /**
     * This method gets a Copiable object at a given position.
     *
     * @param index the specified position.
     * @return the object at that index.
     * @throws numberlist.InvalidIndexException
     */
    @Override
    public Copiable get(int index) throws InvalidIndexException {
        if (index < 0 || index >= count) {
            throw new InvalidIndexException(0, count - 1, index);
        }
        Node currNode = firstNode;
        for (int i = 0; i < index; i++) {
            currNode = currNode.getNext();
        }
        return currNode.getValue();
    }

    /**
     * This method removes a Copiable object at a specific position in the list.
     *
     * @param index the specified position.
     * @return the value of the node.
     * @throws numberlist.InvalidIndexException
     */
    @Override
    public Copiable removeAt(int index) throws InvalidIndexException {
        Node previousNode = firstNode;
        if (index >= count || index < 0) {
            throw new InvalidIndexException(0, count - 1, index);
        }
        if (index == 0) {
            Copiable temp = firstNode.getValue();
            firstNode = firstNode.getNext();
            count--;
            return temp;
        } else {
            for (int i = 0; i < index - 1; i++) {
                previousNode = previousNode.getNext();
            }
            Copiable temp = (previousNode.getNext()).getValue();
            previousNode.setNext(previousNode.getNext().getNext());
            count--;
            return temp;
        }
    }

    /**
     * This method removes a given Copiable object.
     *
     * @param obj the object given by the user.
     */
    @Override
    public void remove(Copiable obj) {
        try {
            removeAt(indexOf(obj));
        } catch (InvalidIndexException ex) {
            Logger.getLogger(NumericLinkedList.class.getName()).log(Level.SEVERE, null, ex);
        } 
        /* 
        Another method (not sure if it's right or wrong)
        if(count == 0 || obj == null) {
            return;
        }
        if(obj.equals(firstNode.getValue())) {
            firstNode = firstNode.getNext();
            count--;
        } else {
            Node currNode = firstNode.getNext();
            Node previousNode = firstNode;
            while(currNode != null) {
                if(obj.equals(currNode.getValue())) {
                    previousNode.setNext(currNode.getNext());
                    count--;
                }
                previousNode = currNode;
                currNode = currNode.getNext();
            }
        }
        */
    }

    /**
     * This method gets the index of a given Copiable object.
     *
     * @param obj the object given by the user.
     * @return the index - position in the list - of that object.
     */
    @Override
    public int indexOf(Copiable obj) {
        Node currNode = firstNode;
        for (int i = 0; i < count; i++) {
            if (currNode.getValue().toString().equals(obj.toString())) {
                return i;
            }
            currNode = currNode.getNext();
        }
        return -1;
    }

    /**
     * This method display the linked list as a String.
     *
     * @return the String representation of the list.
     */
    @Override
    public String toString() {
        // Return nul if the String is empty
        if (count == 0) {
            return "[ ]";
        }
        StringBuilder string = new StringBuilder();
        Node currNode = firstNode;
        string.append("[ ");
        for (int i = 0; i < count - 1; i++) {
            string.append(currNode.getValue() + ", ");
            currNode = currNode.getNext();
        }
        string.append(currNode.getValue() + " ]");
        return string.toString();
    }

    /**
     * This method makes a deep copy of the list.
     *
     * @return the copy of the list.
     */
    @Override
    public NumericLinkedList deepCopy() {
        NumericLinkedList listCopy = new NumericLinkedList();
        for (int i = 0; i < count; i++) {
            try {
                listCopy.add(i, get(i).deepCopy());
            } catch (InvalidIndexException ex) {
                Logger.getLogger(NumericLinkedList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listCopy;
    }

    /**
     *
     * @param index
     * @param obj
     * @return
     * @throws numberlist.InvalidIndexException
     */
    @Override
    public Copiable set(int index, Copiable obj) throws InvalidIndexException {
        if (index < 0 || index >= count) {
            throw new InvalidIndexException(0, count - 1, index);
        } else {
            Copiable temp;
            Node currNode = firstNode;
            if (index == 0) {
                temp = currNode.getValue();
                currNode.setValue(obj);
            } else {
                for (int i = 0; i < index; i++) {
                    currNode = currNode.getNext();
                }
                temp = currNode.getValue();
                currNode.setValue(obj);
            }
            return temp;
        }
    }
}
