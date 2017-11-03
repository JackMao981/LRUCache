public class Node<E> {
    E fElement;
    Node<E> fPrev;
    Node<E> fNext;

    public Node(E element, Node next, Node prev) {
        fElement = element;
        fPrev = prev;
        fNext = next;
    }

    public void remove() {
        if(fPrev != null)
            fPrev.setNext(fNext);
        if(fNext != null)
            fNext.setPrev(fPrev);
    }

    public void setPrev(Node newNode) {
        fPrev = newNode;
    }

    public void setNext(Node newNode) {
        fNext = newNode;
    }

    public E getElement() {
        return fElement;
    }

    public Node getNext() {
        return fNext;
    }
}
