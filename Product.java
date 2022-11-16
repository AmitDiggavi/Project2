/**
 * Represents a product
 */
public class Product implements IProduct {
    String name;
    String category;
    double price;
    int quantity;
    String UPC;

    /**
     * Creates a new product, ensuring there is a name, category, and UPC
     * @param name name of product
     * @param category category of product
     * @param price price of product
     * @param quantity quantity of product
     * @param UPC UPC of product
     * @throws IllegalArgumentException if name, category, or UPC is null
     */
    public Product(String name, String category, double price, int quantity, String UPC)
        throws IllegalArgumentException {
        if (name == null || category == null || UPC == null) {
            throw new IllegalArgumentException("Name, Category, or UPC is null");
        }

        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.UPC = UPC;
    }

    /**
     * Gets the name of the product
     * @return name of product
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the category of the product
     * @return category of product
     */
    public String getCategory() {
        return category;
    }

    /**
     * Gets the price of the product
     * @return price of product
     */
    public double getPrice() {
        return price;
    }

    /**
     * Gets the quantity of the product
     * @return quantity of product
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Gets the UPC of the product
     * @return UPC of product
     */
    public String getUPC() {
        return UPC;
    }
}
