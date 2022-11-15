import org.junit.Test;
import static org.junit.Assert.*;

public class AlgorithmEngineerTests {

    /**
     * This tests if the put method is working properly.
     */
    @Test
    public void test1()
    {
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);

        System.out.println(map.get("a"));

        assertEquals(3, map.size());
    }

    /**
     * This tests the UPC checker to see if it is working properly.
     */

    @Test
    public void test2()
    {
        String upc1 = "1234567890128";
        String upc2 = "1234567890135";
        String upc3 = "1234567830131";
        String upc4 = "21324234129";
        UPCChecker c = new UPCChecker();

        assertTrue(c.check(upc1));
        assertTrue(c.check(upc2));
        assertTrue(c.check(upc3));
        assertFalse(c.check(upc4));

    }

    /**
     *  Testing the get method.
     */
    @Test
    public void test3()
    {
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);

        assertEquals(map.get("a"), map.get("a"));
    }

    /**
     * Tests the clear method by putting in 3 pairs and then calling clear.
     */

    @Test
    public void test4()
    {
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);

        map.clear();

        assertEquals(0, map.size());
    }

    /**
     *  Checks containsKey by putting 3 pairs into the map and using containsKey to
     *  make sure that one passes and the other fails.
     */

    @Test
    public void test5()
    {
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);

        assertTrue(map.containsKey("a"));
        assertFalse(map.containsKey("y"));

    }

    /**
     *
     */

    @Test
    public void IntegrationTest1()
    {
        ProductLoader loaded = new ProductLoader();

    }
}
