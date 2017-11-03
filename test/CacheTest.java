import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Code to test an LRUCache implementation.
 */
public class CacheTest {
    @Test
    public void leastRecentlyUsedIsCorrect () {
        DataProvider<Integer,String> provider = null; // Need to instantiate an actual DataProvider
        Cache<Integer,String> cache = new LRUCache<Integer,String>(provider, 5);
    }
}
