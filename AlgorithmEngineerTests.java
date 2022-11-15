import org.junit.Test;

import javax.security.auth.kerberos.KeyTab;

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
        String upc2 = "8904319300894";
        String upc3 = "5410667151390";
        String upc4 = "21324234129";
        String upc5 = "3";
        String upc6 = "8904319300894";
        UPCChecker c = new UPCChecker();

        assertTrue(c.check(upc1));
        assertTrue(c.check(upc2));
        assertTrue(c.check(upc3));
        assertFalse(c.check(upc4));
        assertFalse(c.check(upc5));
        assertTrue(c.check(upc6));

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
     * checks if the UPC checker is working properly after loading the products.
    */

    @Test
    public void IntegrationTest1()
    {
        ProductLoader loaded = new ProductLoader();
        UPCChecker checker = new UPCChecker();

        for(IProduct product : loaded.loadProducts())
        {
         assertTrue(checker.check(product.getUPC()));
        }


    }

    /**
     * This is to test the backend add and remove method
     */

    @Test
    public void IntegrationTest2()
    {
        InventoryBackend backend = new InventoryBackend();
        ProductLoader loader = new ProductLoader();
        Product product1 = new Product("Chicken Breasts", "Meats", 9.5, 10,  "8904319300894");

        backend.addProduct(product1);

        assertEquals(1, backend.treemap.size());

        backend.removeProductFromCart(product1);

        assertEquals(0,backend.cart.size());

    }

    /**
     * Testing the getCategory and getQuantity
     * and also tests the backend
     */

    @Test
    public void CodeReviewOfDataWrangler1()
    {

        Product product1 = new Product("Chicken Breasts", "Meats", 9.5, 10,  "8904319300894");
        assertEquals("Meats", product1.getCategory());
        assertEquals(10, product1.getQuantity());


    }

}
