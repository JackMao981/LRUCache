public class MyLinkedList<U> {

        private Node<U> fHead;
        private Node<U> fTail;

        public MyLinkedList(){
            fHead = null;
            fTail = null;
        }

    /**
     * Creates a new node with the given element, and adds the node to the head (most recent) position in the linked list.
     * @param element the element to add to the list.
     */
    public void addHead(U element) {
            Node<U> newHead = new Node<U>(element, fHead, null);
            if (fHead != null) {
                fHead.setPrev(newHead);
            }
            fHead = newHead;
            if (fTail == null) {
                fTail = newHead;
            }
        }

    /**
     *  Creates a new node, and adds the node to the head (most recent) position in the linked list.
     * @param node
     */
        public void addHead(Node node) {
            node.setNext(fHead);
            node.setPrev(null);
            if (fHead != null) {
                fHead.setPrev(node);
            }
            fHead = node;
        }

        public void removeTail() {
            fTail.remove();
        }

        public Node<U> getHead() {
            return fHead;
        }

    }

