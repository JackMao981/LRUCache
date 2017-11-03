public class MyLinkedList<U> {

        private Node<U> fHead;
        private Node<U> fTail;

        public MyLinkedList(){
            fHead = null;
            fTail = null;
        }

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

