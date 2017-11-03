import java.util.HashMap;

//things to consider:
//I dont know if this auto allocates memory
//remind me to ask my dad

public class LRUCache<T,U> {

    private MyLinkedList<U> fList;
    private HashMap<T,Node<U>> fMap;
    private int fCapacity;
    private int fNumMisses;

    public LRUCache(int capacity) {
        fList = new MyLinkedList<U>();
        fMap = new HashMap<T, Node<U>>();
        fCapacity = capacity;
        fNumMisses = 0;
    }

    public U get(T key) {
        if (fMap.containsKey(key)){
            Node<U> node = fMap.get(key);
            U element = node.getElement();
            fList.addHead(node);
            node.remove();
            return element;
        } else {
            fNumMisses++;
            return this.retrieve(key);
        }
    }
    /**
     * Returns the number of cache misses since the object's instantiation.
     * @return the number of cache misses since the object's instantiation.
     */
    public int getNumMisses() {
        return fNumMisses;
    }
}

    //must be fully implement
    private U retrieve(T key) {

        //add some stuff to retrieve element, aka it should not be null
        U element = null;

        if (fMap.size() == fCapacity) {
            replace(key, element);
        } else {
            add(key, element);
        }
        return element;
    }

    private void add(T key, U element) {
        fList.addHead(element);
        fMap.put(key, fList.getHead());
    }

    private void replace(T key, U element) {
        fList.removeTail();
        fMap.remove(key);
        add(key, element);

}
