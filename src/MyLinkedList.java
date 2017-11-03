/**
 * A linked list suitable for the assignment
 */
public class MyLinkedList<T, U> {

        private Node<T, U> fHead;
        private Node<T, U> fTail;
        private int fCapacity;

    /**
     * Initiates linked list of given capacity, size of list never changes
     * @param capacity the capacity
     */
    public MyLinkedList(int capacity){
        fHead = null;
        fTail = null;
        fCapacity = capacity;

        //fills list
        for(int i = 0; i < fCapacity; i++) {
            addHead(new Node(null, null, null, null));
        }
    }

    /**
     * Adds a node to the head of the linked list
     * @param node the node
     */
    protected void addHead(Node node) {
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
     * Removes the node at the tail of the list and replaces it at the head, but with a new key and element
     * @param key the new key
     * @param element the new element
     */
    protected void removeTail(T key, U element) {
        final Node newTail = fTail.getPrev();
        fTail.remove();
        fTail.setElement(element);
        fTail.setKey(key);
        this.addHead(fTail);
        fTail = newTail;
    }

    /**
     * Getter for head node
     * @return the head node
     */
    protected Node<T, U> getHead() {
        return fHead;
    }

    /**
     * Getter for tail node
     * @return the tail node
     */
    protected Node<T, U> getTail() {
        return fTail;
    }

}

