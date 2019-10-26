package numberlist.objectlist;

/**
 * This class creates and represents a node which links objects and their values
 * together.
 *
 * @author Uyen Hoang
 * @version 1.1 5/5/2018
 */
class Node {

    private Node nextNode;
    private Copiable obj;

    /**
     * This constructor initializes the value of the given object to the object
     * variable.
     *
     * @param obj this is the object given by the user.
     */
    public Node(Copiable obj) {
        this.obj = obj;
    }

    /**
     * This method gets the value of the object variable which was initialized
     * with the given value.
     *
     * @return the value of the object variable.
     */
    public Copiable getValue() {
        return obj;
    }

    /**
     * This method sets the value of the given object to the object variable.
     *
     * @param obj the object given by the user.
     */
    public void setValue(Copiable obj) {
        this.obj = obj;
    }

    /**
     * This method gets the reference of the node that is adjacent to the
     * current node.
     *
     * @return the next node's reference.
     */
    public Node getNext() {
        return nextNode;
    }

    /**
     * This method sets the reference of the node that is adjacent to the
     * current node with the value of the given node.
     *
     * @param node this is the reference of the node that the user provides.
     */
    public void setNext(Node node) {
        nextNode = node;
    }
}
