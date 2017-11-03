public class MyLinkedList<T, U> {

        private Node<T, U> fHead;
        private Node<T, U> fTail;
        private int fCapacity;

        public MyLinkedList(int capacity){
            fHead = null;
            fTail = null;
            fCapacity = capacity;
            //fills list
            for(int i = 0; i < fCapacity; i++) {
                addHead(new Node(null, null, null, null));
            }
        }

        public void addHead(Node node) {
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

