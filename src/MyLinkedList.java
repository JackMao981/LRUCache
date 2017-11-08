/**
 * A doubly linked list suitable for the assignment
 */
class MyLinkedList<T, U> {

        private Node<T, U> fHead;
        private Node<T, U> fTail;
        private int fCapacity;

    /**
     * Initiates doubly linked list of given capacity, size of list never changes
     * @param capacity the capacity
     */
    MyLinkedList(int capacity){
        fHead = null;
        fTail = null;
        fCapacity = capacity;

        //fills list with nodes with null values
        for(int i = 0; i < fCapacity; i++) {
            addHead(new Node(null, null, null, null));
        }
    }

    /**
     * Adds a node to the head of the linked list
     * @param node the node
     */
    void addHead(Node node) {
        node.setNext(fHead);
        node.setPrev(null);
        if (fHead != null) {
            fHead.setPrev(node);
        }
        fHead = node;
        if (fTail == null) {
            fTail = node;
        }
    }

    /**
     * Removes the node at the tail of the list and puts it at the head, but with the given key and element
     * @param key the new key
     * @param element the new element
     */
    void removeTail(T key, U element) {
        final Node newTail = fTail.getPrev();
        fTail.remove();
        fTail.setElement(element);
        fTail.setKey(key);
        this.addHead(fTail);
        fTail = newTail;
    }

    /**
     * Returns the head node
     * @return the head node
     */
    Node<T, U> getHead() {
        return fHead;
    }

    /**
     * Returns the tail node
     * @return the tail node
     */
    Node<T, U> getTail() {
        return fTail;
    }

}

