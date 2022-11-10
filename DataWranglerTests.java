import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class DataWranglerTests {

    @Test
    public void testProduct() {
        Product product = new Product(
            "Test Product",
            "Test Category",
            1.99,
            100,
            "123456789012"
        );

        assertEquals("Test Product", product.getName());
        assertEquals("Test Category", product.getCategory());
        assertEquals(1.99, product.getPrice(), 0.001);
        assertEquals(100, product.getQuantity());
        assertEquals("123456789012", product.getUPC());
    }

    @Test
    public void testLoadProductSuccess() {
        assertDoesNotThrow(() -> { new ProductLoader().loadProducts(); });
    }

    @Test
    public void testLoadProductSize() {
        ArrayList<IProduct> products = new ProductLoader().loadProducts();
        assertEquals(25, products.size());
    }

    @Test
    public void testLoadProductAccuracy() {
        ArrayList<IProduct> products = new ProductLoader().loadProducts();
        IProduct product = products.get(0);
        assertEquals("Chicken Breast", product.getName());
        assertEquals("Meats", product.getCategory());
        assertEquals(9.50, product.getPrice(), 0.001);
        assertEquals(10, product.getQuantity());
        assertEquals("8904319300894", product.getUPC());
    }

    @Test
    public void testLoadProductIntegrity() {
        ArrayList<IProduct> products = new ProductLoader().loadProducts();
        for (IProduct product : products) {
            assertNotNull(product.getName());
            assertNotNull(product.getCategory());
            assertTrue(product.getPrice() > 0);
            assertTrue(product.getQuantity() > 0);
            assertNotNull(product.getUPC());
        }
    }
}
