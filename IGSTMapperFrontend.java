public interface IGSTMapperFrontend 
{

    /**
     * This method starts the command loop for the frontend, and will
     * terminate when the user exists the app.
     */
    public void runCommandLoop();

    /**
     * This method prints the main menu
     */
    public void displayMainMenu(); // prints command options to System.out

    /**
     * This method diplays an item using UPC and allows the user to add it to the cart
     */
    public void upcLookup(); 
    
    /**
     * This method diplays an item using item name and allows the user to add it to the cart
     */
    public void itemSearch(); 
    
    /**
     * This method displays all the items in a specific category and allows the user to add an item to the cart
     */
    public void categorySearch();
    
    /**
     * This method sets a price filter
     */
    public void priceFilter();
    
    /**
     * This method displays all the items in the cart
     */
    public void displayCart(); 
    
    /**
     * This method allows the user to remove an item in the cart
     */
    public void removeItems();
    
    /**
     * This method checks out all the items in the cart
     */
    public void checkOut(); 
}

