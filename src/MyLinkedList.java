public class MyLinkedList<E> {

        private Node<E> fHead;
        private Node<E> fTail;

        public MyLinkedList(){
            fHead = null;
            fTail = null;
        }

        public void addHead(E element) {
            Node<E> newHead = new Node<E>(element, fHead, null);
            if (fHead != null) {
                fHead.setPrev(newHead);
            }
            fHead = newHead;
            if (fTail == null) {
                fTail = newHead;
            }
        }

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

        public Node<E> getHead() {
            return fHead;
        }

    }

