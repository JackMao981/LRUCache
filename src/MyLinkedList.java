public class MyLinkedList<T, U> {

        private Node<T, U> fHead;
        private Node<T, U> fTail;

        public MyLinkedList(){
            fHead = null;
            fTail = null;
        }

        public void addHead(T key, U element) {
            Node<T, U> newHead = new Node<T, U>(key, element, fHead, null);
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

        public Node<T, U> getHead() {
            return fHead;
        }

        public Node<T, U> getTail() {
        return fTail;
    }

    }

