import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class InventoryBackend implements IGSTBackend {
    ArrayList<IProduct> cart = new ArrayList<>();
    protected TreeMap<String, IProduct> treemap = new TreeMap<>();
    protected String priceFilter = "";
    protected String categoryFilter = "";


    /**
     * Adds a product to cart
     * @param product the product to add
     */
    public void addProductToCart(IProduct product){
        cart.add(product);
    }

    /**
     * Removess a product from cart
     * @param product the product to remove
     */
    public void removeProductFromCart(IProduct product){
        cart.remove(product);
    }

    /**
     * returns the cart
     * @return List of products in the cart
     */
    public ArrayList<IProduct> getCart(){
        return cart;
    }


    /**
     * This method can be used to set a filter for the category
     * contained in the search results.
     * @param filterBy the string that the product's category must equal
     */
    public void setCategoryFilter(String filterBy){
        categoryFilter = filterBy;
    }

    /**
     * Returns the string used as the category filter, null if no category
     * filter is currently set.
     * @return the string used as the category filter, or null if none is set
     */
    public String getCategoryFilter(){
        return categoryFilter;
    }

    /**
     * Resets the category filter to null (no filter).
     */
    public void resetCategoryFilter(){
        categoryFilter = "";
    }

    /**
     * Search through all the products in the title base and return products whose
     * title contains the string word (and that satisfies the category and price filter,
     * if category filter or price filter is set).
     * @param word word that must be contained in a product's title in result set
     * @return list of products found
     */
    public IProduct[] searchByProductName(String word){

    }

    /**
     * Return the product uniquely identified by the UPC, or null if UPC is not
     * present in the dataset.
     * @param UPC the product's UPC number
     * @return the product identified by the UPC, or null if UPC not in database
     */
    public IProduct getByUPC(String UPC){
        for (IProduct product : treemap) {
            if (product.getUPC().equals(UPC)) {
                return product;
            }
        }

        return null;
    }

    /**
     * This method can be used to set a filter for the price
     * contained in the search results.  it also contains the string filterBy
     * @param filterBy the string that the product's price must be less than or equal to
     */
    public void setPriceFilter(String filterBy){
        priceFilter = filterBy;
    }

    /**
     * Returns the string used as the price filter, null if no price
     * filter is currently set.
     * @return the string used as the price filter, or null if none is set
     */
    public String getPriceFilter(){
        return priceFilter;
    }

    /**
     * Resets the price filter to null (no filter).
     */
    public void resetPriceFilter(){
        priceFilter = "";
    }

}