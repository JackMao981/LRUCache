public class Node<T, U> {
    U fElement;
    T fKey;
    Node<T, U> fPrev;
    Node<T, U> fNext;

    public Node(T key, U element, Node next, Node prev) {
        fElement = element;
        fPrev = prev;
        fNext = next;
    }

    /**
     * Removes a node from the linked list by setting the fPrev and fNext of the nodes in front fo and behind it.
     */
    public void remove() {
        if(fPrev != null)
            fPrev.setNext(fNext);
        if(fNext != null)
            fNext.setPrev(fPrev);
    }

    /**
     * Changes the node previous to the node that setPrev is called upon.
     * @param newNode the node to set as the previous node.
     */
    public void setPrev(Node newNode) {
        fPrev = newNode;
    }
    /**
     * Changes the node ahead of the node that setNext is called upon.
     * @param newNode the node to set as the previous node.
     */
    public void setNext(Node newNode) {
        fNext = newNode;
    }

    /**
     * Gets the element associated with a node.
     * @return fElement, the element associated with a node.
     */
    public U getElement() {
        return fElement;
    }


    /**
     * Gets the next node in the list, relative to the node it is called upon.
     * @return fNext, the next node.
     */

    public T getKey() {
        return fKey;
    }

    public Node getNext() {
        return fNext;
    }

    public void setElement(U element) {
        fElement = element;
    }

    public void setKey(T key) {
        fKey = key;
    }
}
