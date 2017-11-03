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
    private int fSize;

    public LRUCache(DataProvider<T, U> provider, int capacity) {
        fList = new MyLinkedList<T, U>();
        fMap = new HashMap<T, Node<T, U>>(fCapacity);
        fCapacity = capacity;
        fNumMisses = 0;
        fSize = 0;
        fProvider = provider;
    }

    public U get(T key) {
        if (fMap.containsKey(key)){
            Node<T, U> node = fMap.get(key);
            U element = node.getElement();
            fList.addHead(node);
            node.remove();
            fSize++;
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

        if (fSize == fCapacity) {
            replace(key, element);
            fSize++;
        } else {
            add(key, element);
            fSize++;
        }
        return element;
    }

    private void add(T key, U element) {
        fList.addHead(key, element);
        fMap.put(key, fList.getHead());
    }

    private void replace(T key, U element) {
        fMap.remove(fList.getTail().getKey());
        fList.removeTail();
        add(key, element);
    }
}
