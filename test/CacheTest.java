import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Code to test an LRUCache implementation.
 */
public class CacheTest {

    public class StringLoader implements DataProvider<Integer, String> {
        public StringLoader() {
        }

        public String get(Integer key) {
            return key.toString();
        }
    }

    //keep it larger than 3
    public final int capacity = 5;

    public DataProvider<Integer,String> provider = new StringLoader();
    public Cache<Integer,String> cache = new LRUCache<Integer,String>(provider, capacity);

    @Test
    public void leastRecentlyUsedIsCorrect () {
        //uses keys 1 through one more than capacity
        for (int i = 1; i <= (capacity + 1); i++) {
            cache.get(i);
        }

        //each key called was new, and so each was a miss
        assertEquals(cache.getNumMisses(), capacity + 1);

        //calls key 1, which should no longer be in the cache since it was the one called longest ago, and so there should be another miss
        cache.get(1);
        assertEquals(cache.getNumMisses(), capacity + 2);

        //the call of key 1 should now be added to the hash and the one used the longest ago, key 2, should be removed
        cache.get(2);
        assertEquals(cache.getNumMisses(), capacity + 3);

        //calling something still in the cache (the last element put in by the for loop) should not lead to a miss
        cache.get(capacity + 1);
        assertEquals(cache.getNumMisses(), capacity + 3);
    }

    @Test
    public void keyToElementRetrievalIsCorrect() {
        //uses keys 1 through one more than capacity
        for (int i = 1; i <= (capacity + 1); i++) {
            cache.get(i);
        }

        //works for keys already in cache
        assertEquals(cache.get(1), "1");
        assertEquals(cache.get(2), "2");
        assertEquals(cache.get(3), "3");

        //works for keys not yet in cache
        assertEquals(cache.get(capacity + 2), ((Integer) (capacity + 2)).toString());
        assertEquals(cache.get(capacity + 3), ((Integer) (capacity + 3)).toString());
    }
}
