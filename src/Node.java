/**
 * node for MyLinkedList
 */
public class Node<T, U> {
    U fElement;
    T fKey;
    Node<T, U> fPrev;
    Node<T, U> fNext;

    /**
     * @param key the key
     * @param element the element
     * @param next the next node in MyLinkedList
     * @param prev the previous node in MyLinkedList
     */
    public Node(T key, U element, Node next, Node prev) {
        fElement = element;
        fPrev = prev;
        fNext = next;
    }

    /**
     * Removes itself from the MyLinkedList it is in
     */
    protected void remove() {
        if(fPrev != null)
            fPrev.setNext(fNext);
        if(fNext != null)
            fNext.setPrev(fPrev);
    }

    /**
     * Changes the node previous to the node that setPrev is called upon.
     * @param newNode the node to set as the previous node.
     */
    protected void setPrev(Node newNode) {
        fPrev = newNode;
    }
    /**
     * Changes the node ahead of the node that setNext is called upon.
     * @param newNode the node to set as the previous node.
     */
    protected void setNext(Node newNode) {
        fNext = newNode;
    }

    /**
     * Gets the element associated with the node
     * @return fElement the element
     */
    protected U getElement() {
        return fElement;
    }

    /**
     * Gets the key associated with the node
     * @return fKey the key
     */
    protected T getKey() {
        return fKey;
    }

    /**
     * Gets the next node in the list, relative to the node it is called upon.
     * @return fNext, the next node.
     */
    protected Node getNext() {
        return fNext;
    }

    /**
     * Gets the previous node in the list, relative to the node it is called upon.
     * @return fPrev, the previous node.
     */
    protected Node getPrev() {
        return fPrev;
    }

    /**
     * Sets the element of the node
     * @param element the element
     */
    protected void setElement(U element) {
        fElement = element;
    }

    /**\
     * Sets the key for the node
     * @param key the key
     */
    protected void setKey(T key) {
        fKey = key;
    }
}
