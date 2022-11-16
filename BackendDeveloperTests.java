import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class BackendDeveloperTests {
    protected static InventoryBackend backend = new InventoryBackend();

    /**
     * tests that when a category filter is set the getCategoryFilter method returns the correct
     * filter
     */
    @Test
    public void testCategoryFilter() {
        Product beef = new Product("Beef", "Meats",
            5.0f, 1, "123456789");
        backend.setCategoryFilter("Meats");
        assertEquals("Meats", backend.getCategoryFilter());

    }

    /**
     * tests that when a price filter is set the getPriceFilter method returns the correct
     * filter
     */
    @Test
    public void testPriceFilter() {
        backend.setPriceFilter("5.0");
        assertEquals(5.0, backend.getPriceFilter());
        backend.resetPriceFilter();
        assertNull(backend.getPriceFilter());
    }

    /**
     * Tests when multiple products are added to cart they are added successfully in order
     */
    @Test
    public void testAddToCart() {
        Product chips = new Product("Chips", "Snacks",
            3.0f, 1, "123456788");
        Product beef = new Product("Beef", "Meats",
            5.0f, 1, "123456789");
        backend.addProductToCart(chips);
        backend.addProductToCart(beef);
        assertEquals(chips, backend.cart.get(0));
        assertEquals(beef, backend.cart.get(1));
    }

    /**
     * Tests when items are added to a cart, the cart has the correct items, then clears all items
     */
    @Test
    public void testClearCart() {
        Product chips = new Product("Chips", "Snacks",
            3.0f, 1, "123456788");
        Product beef = new Product("Beef", "Meats",
            5.0f, 1, "123456789");
        backend.addProductToCart(chips);
        backend.addProductToCart(beef);
        assertEquals(chips, backend.cart.get(0));
        assertEquals(beef, backend.cart.get(1));
        backend.removeAllFromCart();
        assertEquals(0, backend.cart.size());
    }

    /**
     * Tests when both category and price filters are set and then reset, they are "" and 0.0
     */
    @Test
    public void testResetFilters() {
        backend.setCategoryFilter("Meats");
        backend.setPriceFilter("5.0");
        assertEquals("Meats", backend.getCategoryFilter());
        assertEquals(5.0, backend.getPriceFilter());
        backend.resetCategoryFilter();
        backend.resetPriceFilter();
        assertEquals("", backend.getCategoryFilter());
        assertNull(backend.getPriceFilter());
    }
}
