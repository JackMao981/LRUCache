import java.util.HashMap;

/**
 * An implementation of <tt>Cache</tt> that uses a least-recently-used (LRU)
 * eviction policy.
 */
public class LRUCache<T,U> implements Cache<T,U> {

    private MyLinkedList<T, U> fList;
    private HashMap<T,Node<T, U>> fMap;
    private int fCapacity;
    private int fNumMisses;
    private DataProvider<T,U> fProvider;

    /**
     * @param provider the data provider to consult for a cache miss
     * @param capacity the exact number of (key,value) pairs to store in the cache
     */
    public LRUCache(DataProvider<T, U> provider, int capacity) {
        fList = new MyLinkedList<T, U>(fCapacity);
        fMap = new HashMap<T, Node<T, U>>(fCapacity);
        fCapacity = capacity;
        fNumMisses = 0;
        fProvider = provider;
    }

    /**
     * Returns the value associated with the specified key.
     * @param key the key
     * @return the value associated with the key
     */
    public U get(T key) {
        if (fMap.containsKey(key)){
            final Node<T, U> node = fMap.get(key);
            final U element = node.getElement();
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

    /**
     * Retrieves a value from provider based on key
     * @param key the key
     * @return the value associated with the key
     */
    private U retrieve(T key) {
        final U element = fProvider.get(key);
        add(key, element);
        return element;
    }

    /**
     * Adds a key and its associated value to the cache
     * @param key the key
     * @param element the corresponding value
     */
    private void add(T key, U element) {
        if (fList.getTail().getKey() != null) {
            fMap.remove(fList.getTail().getKey());
        }
        fList.removeTail(key, element);
        fMap.put(key, fList.getHead());
    }
}
