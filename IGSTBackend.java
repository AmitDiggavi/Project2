import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Instances of this interface implement the search and filter functionality
 * of the product Mapper app using tree maps.
 */
public interface IGSTBackend {

    /**
     * Adds a product to cart
     * @param product the product to add
     */
    public void addProductToCart(IProduct product);

    /**
     * Removes a product from cart
     * @param product the product to remove
     */
    public void removeProductFromCart(IProduct product);

    /**
     * Removes all products from cart
     */
    public void removeAllFromCart();

    /**
     * returns the cart
     * @return List of products in the cart
     */
    public ArrayList<IProduct> getCart();


    /**
     * This method can be used to set a filter for the category
     * contained in the search results.
     * @param filterBy the string that the product's category must equal
     */
    public void setCategoryFilter(String filterBy);

    /**
     * Returns the string used as the category filter, null if no category
     * filter is currently set.
     * @return the string used as the category filter, or null if none is set
     */
    public String getCategoryFilter();

    /**
     * Resets the category filter to null (no filter).
     */
    public void resetCategoryFilter();

    /**
     * Search through all the products in the title base and return products whose
     * title contains the string word (and that satisfies the category filter,
     * if category filter is set).
     * @param name word that must be contained in a product's title in result set
     * @return list of products found
     */
    public ArrayList<IProduct> searchByProductName(String name);

    /**
     * Return the product uniquely identified by the UPC, or null if UPC is not
     * present in the dataset.
     * @param UPC the product's UPC number
     * @return the product identified by the UPC, or null if UPC not in database
     */
    public IProduct getByUPC(String UPC);

    /**
     * This method can be used to set a filter for the price
     * contained in the search results.  it also contains the string filterBy
     * @param filterBy the string that the product's price must be less than or equal to
     */
    public void setPriceFilter(String filterBy);

    /**
     * Returns the string used as the price filter, null if no price
     * filter is currently set.
     * @return the string used as the price filter, or null if none is set
     */
    public Double getPriceFilter();

    /**
     * Resets the price filter to null (no filter).
     */
    public void resetPriceFilter();

}
