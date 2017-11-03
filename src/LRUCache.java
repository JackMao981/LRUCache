import java.util.HashMap;

//things to consider:
//I don't know if this auto allocates memory
//remind me to ask my dad

public class LRUCache<T,U> implements Cache<T,U> {

    private MyLinkedList<T, U> fList;
    private HashMap<T,Node<T, U>> fMap;
    private int fCapacity;
    private int fNumMisses;
    private DataProvider<T,U> fProvider;

    public LRUCache(DataProvider<T, U> provider, int capacity) {
        fList = new MyLinkedList<T, U>(fCapacity);
        fMap = new HashMap<T, Node<T, U>>(fCapacity);
        fCapacity = capacity;
        fNumMisses = 0;
        fProvider = provider;
    }

    public U get(T key) {
        if (fMap.containsKey(key)){
            Node<T, U> node = fMap.get(key);
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


    private U retrieve(T key) {
        U element = fProvider.get(key);
        add(key, element);
        return element;
    }

    private void add(T key, U element) {
        Node usedNode = fList.getTail();
        if (usedNode.getKey() != null) {
            fMap.remove(usedNode.getKey());
        }
        fList.removeTail();
        usedNode.setElement(element);
        usedNode.setKey(key);
        fList.addHead(usedNode);
        fMap.put(key, fList.getHead());
    }
}
