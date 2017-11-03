public class Node<U> {
    U fElement;
    Node<U> fPrev;
    Node<U> fNext;

    public Node(U element, Node next, Node prev) {
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

    public Node getNext() {
        return fNext;
    }
}
