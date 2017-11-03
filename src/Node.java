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

    public U getElement() {
        return fElement;
    }

    public T getKey() {
        return fKey;
    }

    public Node getNext() {
        return fNext;
    }
}
