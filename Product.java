public class Product implements IProduct {
    String name;
    String category;
    double price;
    int quantity;
    String UPC;

    public Product(String name, String category, double price, int quantity, String UPC) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.UPC = UPC;
    }

    public String getName() {
        return name;
    };

    public String getCategory() {
        return category;
    };

    public double getPrice() {
        return price;
    };

    public int getQuantity() {
        return quantity;
    };

    public String getUPC() {
        return UPC;
    };
}
