/**
 * A node used in MyLinkedList. Is not a nested class in MyLinkedList because it must be used in the Hashmap of the LRUCache
 */
class Node<T, U> {
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
    Node(T key, U element, Node next, Node prev) {
        fElement = element;
        fPrev = prev;
        fNext = next;
    }

    /**
     * Removes itself from the MyLinkedList it is in
     */
    void remove() {
        if(fPrev != null)
            fPrev.setNext(fNext);
        if(fNext != null)
            fNext.setPrev(fPrev);
    }

    /**
     * Changes the node previous to the given node
     * @param newNode the node
     */
    void setPrev(Node newNode) {
        fPrev = newNode;
    }

    /**
     * Changes the next node to the given node
     * @param newNode the node
     */
    void setNext(Node newNode) {
        fNext = newNode;
    }

    /**
     * Gets the element associated with the node
     * @return fElement the element
     */
    U getElement() {
        return fElement;
    }

    /**
     * Gets the key associated with the node
     * @return fKey the key
     */
    T getKey() {
        return fKey;
    }

    /**
     * Gets the next node in the list, relative to the node it is called upon.
     * @return fNext, the next node.
     */
    Node getNext() {
        return fNext;
    }

    /**
     * Gets the previous node in the list, relative to the node it is called upon.
     * @return fPrev, the previous node.
     */
    Node getPrev() {
        return fPrev;
    }

    /**
     * Sets the element of the node
     * @param element the element
     */
    void setElement(U element) {
        fElement = element;
    }

    /**\
     * Sets the key for the node
     * @param key the key
     */
    void setKey(T key) {
        fKey = key;
    }
}
