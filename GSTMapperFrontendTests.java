import static org.junit.Assert.assertEquals;

import java.util.Scanner;

import org.junit.jupiter.api.Test;



public class GSTMapperFrontendTests
{
	
/*
 * Role Code Test 1
 * This test is used to check if the program ends when given an input of 8
 */
  @Test
  public void test1()
  {
	  TextUITester tester = new TextUITester("8\n");
      
	  Scanner scn2 = new Scanner(System.in);
     
      GSTMapperFrontend test = new GSTMapperFrontend(null, null, scn2);
      
      test.runCommandLoop();
      
      String expected = "Welcome to the Grocery Store Inventory Application!\n"
      		+ "—--------------------------------------------------\n"
      		+ "\n"
      		+ "You are in the Main Menu:\n"
      		+ "          1)Lookup UPC\n"
      		+ "          2)Search by Item name\n"
      		+ "          3)Search by Category\n"
      		+ "          4)Set Maximum Price filter\n"
      		+ "          5) Display items in cart\n"
      		+ "          6) Remove items from cart\n"
      		+ "          7) Checkout all items\n"
      		+ "          8) Exit Application\n"
      		+ "\n"
      		+ "Goodbye, Thanks for shopping!\n";
      
      String check = tester.checkOutput();
      
     assertEquals(expected, check);
     
      
	  
  }
  /*
   * Role Code Test 2
   * This test is check if the product is return for a valid upc
   * The user inputed upc is 3662994007044
   * it returns the name Chicken wings, along with the price of the item - $7.50
   * it also displays the currently set category and price filter
   */
  @Test
  public void test2()
  {
	  TextUITester tester = new TextUITester("1\n3662994007044\n0\n8\n");
      
	  Scanner scn2 = new Scanner(System.in);
	  
	  UPCChecker checker = new UPCChecker();
	  
	  InventoryBackend end = new InventoryBackend();
          Product product = new Product("Chicken Breast", "Meats", 9.50, 10, "8904319300894");
	   
	   Product product = new Product("Beef Steak", "Meats", 12.50, 10, "5410667151390");
	   
	   Product product = new Product("Pork Chops", "Meats", 8.50, 10, "2868598022112");
	   
	   Product product = new Product("Turkey Breast", "Meats", 10.50, 10, "0810051802924");
	   
	   Product product = new Product("Chicken Wings", "Meats", 7.50, 10, "3662994007044");
	   
	   Product product = new Product("Chicken Thighs", "Meats", 8.50, 10, "0213731805299");
	   
	   Product product = new Product("Chicken Legs", "Meats", 2.50, 10, "4088600511368");
	   
	   Product product = new Product("Chicken Drumsticks", "Meats", 1.50, 10, "0818480018725");
	   
	   Product product = new Product("Ground Beef", "Meats", 7.50, 10, "0024354580162");
	   
	   Product product = new Product("Beef Wings", "Meats", 6.50, 10, "0810051802924");
	   
	   Product product = new Product("Broccoli", "Vegetables", 4.50, 20, "4056289367088");
	   
	   Product product = new Product("Carrots", "Vegetables", 2.25, 20, "5202908000174");
	   
	   Product product = new Product("Green Beans", "Vegetables", 3.25, 20, "0037597902509");
	   
	   Product product = new Product("Grapes", "Fruits", 6.85, 15, "0057316180346");
	   
	   Product product = new Product("Apples", "Fruits", 5.85, 15, "0708820867178");
	   
	   Product product = new Product("Oranges", "Fruits", 4.85, 15, "5028911001584");
	   
	   Product product = new Product("Pizza", "Frozen Foods", 4.79, 30, "0070590952058");
	   
	   Product product = new Product("2% Milk", "Dairy", 3.19, 10, "0602804013110");
	   
	   Product product = new Product("Ice Cream", "Dairy", 4.99, 10, "4806531960013");
	   
	   Product product = new Product("Yogurt", "Dairy", 2.99, 10, "0070590952058");
	   
	   Product product = new Product("Apple Juice", "Beverages", 2.99, 10, "0602804013110");
	   
	   Product product = new Product("Orange Juice", "Beverages", 2.99, 10, "4806531960013");
	   
	   Product product = new Product("Water", "Beverages", 1.99, 10, "5035766048800");

	   Product product = new Product("Chips", "Snacks", 1.99, 10, "6333633354634");
	   
	   Product product = new Product("Popcorn", "Snacks", 1.99, 10, "2868711018633");
	   
		GSTMapperFrontend test = new GSTMapperFrontend(end,checker, scn2);

		test.runCommandLoop();

		String expected = "Welcome to the Grocery Store Inventory Application!\n"
				+ "—--------------------------------------------------\n"
				+ "\n"
				+ "You are in the Main Menu:\n"
				+ "          1)Lookup UPC\n"
				+ "          2)Search by Item name\n"
				+ "          3)Search by Category\n"
				+ "          4)Set Maximum Price filter\n"
				+ "          5) Display items in cart\n"
				+ "          6) Remove items from cart\n"
				+ "          7) Checkout all items\n"
				+ "          8) Exit Application\n"
				+ "\n"
				+ "You are in the Lookup UPC menu:\n"
				+ "          Enter UPC to look up:\n"
				+ "Category filter: \n"
				+ "Price filter: null\n"
				+ "1. Chicken Wings $7.5\n"
				+ "Which product would you like to add to cart? 1 - 1\n"
				+ "Select 0 to cancel.\n"
				+ "You are in the Main Menu:\n"
				+ "          1)Lookup UPC\n"
				+ "          2)Search by Item name\n"
				+ "          3)Search by Category\n"
				+ "          4)Set Maximum Price filter\n"
				+ "          5) Display items in cart\n"
				+ "          6) Remove items from cart\n"
				+ "          7) Checkout all items\n"
				+ "          8) Exit Application\n"
				+ "\n"
				+ "Goodbye, Thanks for shopping!\n";

		String check = tester.checkOutput();
		System.out.println(check);

		assertEquals(expected, check);
	  
  }
  
  /*
   * Role Code Test 3
   * This test is to check if the a valid product is returned when a name is provided
   * The user inputs chicken legs
   *it returns a product with the same name, but ignores case
   */
  @Test
  public void test3()
  {
      TextUITester tester = new TextUITester("2\nChIcken LeGs\n0\n8\n");
      
	  Scanner scn2 = new Scanner(System.in);
	  
	  UPCChecker checker = new UPCChecker();
	  
	  InventoryBackend end = new InventoryBackend();

		ProductLoader loader = new ProductLoader();
		for (IProduct product : loader.loadProducts()) {
			end.addProduct(product);
		}

		GSTMapperFrontend test = new GSTMapperFrontend(end,checker, scn2);
      
      test.runCommandLoop();
      
      String expected = "Welcome to the Grocery Store Inventory Application!\n"
      		+ "—--------------------------------------------------\n"
      		+ "\n"
      		+ "You are in the Main Menu:\n"
      		+ "          1)Lookup UPC\n"
      		+ "          2)Search by Item name\n"
      		+ "          3)Search by Category\n"
      		+ "          4)Set Maximum Price filter\n"
      		+ "          5) Display items in cart\n"
      		+ "          6) Remove items from cart\n"
      		+ "          7) Checkout all items\n"
      		+ "          8) Exit Application\n"
      		+ "\n"
      		+ "You are in the Search Item menu:\n"
      		+ "          Enter item name:\n"
      		+ "Category filter: null\n"
      		+ "Price filter: null\n"
      		+ "1. Chicken Legs $2.5\n"
      		+ "Which product would you like to add to cart? 1 - 1\n"
      		+ "Select 0 to cancel.\n"
      		+ "You are in the Main Menu:\n"
      		+ "          1)Lookup UPC\n"
      		+ "          2)Search by Item name\n"
      		+ "          3)Search by Category\n"
      		+ "          4)Set Maximum Price filter\n"
      		+ "          5) Display items in cart\n"
      		+ "          6) Remove items from cart\n"
      		+ "          7) Checkout all items\n"
      		+ "          8) Exit Application\n"
      		+ "\n"
      		+ "Goodbye, Thanks for shopping!\n";
      
      String check = tester.checkOutput();
      
      assertEquals(expected, check);
	  
  }
  
  /*
   * Role Code Test 4
   * This test is check if all the items added to cart are displayed
   * the user selects multiple items to add to the cart
   * it then returns the list of items added to cart along with their price and total price
   * then it checks out the cart
   * after checkout the cart is cleared
   */
  @Test
  public void test4()
  {
 TextUITester tester = new TextUITester("2\nbroccoli\n1\n2\napple juice\n1\n5\n7\n5\n8\n");
      
	  Scanner scn2 = new Scanner(System.in);
	  
	  UPCChecker checker = new UPCChecker();
	  
	  InventoryBackend end = new InventoryBackend();

		ProductLoader loader = new ProductLoader();
		for (IProduct product : loader.loadProducts()) {
			end.addProduct(product);
		}

		GSTMapperFrontend test = new GSTMapperFrontend(end,checker, scn2);
      
      test.runCommandLoop();
      
      String expected = "Welcome to the Grocery Store Inventory Application!\n"
      		+ "—--------------------------------------------------\n"
      		+ "\n"
      		+ "You are in the Main Menu:\n"
      		+ "          1)Lookup UPC\n"
      		+ "          2)Search by Item name\n"
      		+ "          3)Search by Category\n"
      		+ "          4)Set Maximum Price filter\n"
      		+ "          5) Display items in cart\n"
      		+ "          6) Remove items from cart\n"
      		+ "          7) Checkout all items\n"
      		+ "          8) Exit Application\n"
      		+ "\n"
      		+ "You are in the Search Item menu:\n"
      		+ "          Enter item name:\n"
      		+ "Category filter: null\n"
      		+ "Price filter: null\n"
      		+ "1. Broccoli $4.5\n"
      		+ "Which product would you like to add to cart? 1 - 1\n"
      		+ "Select 0 to cancel.\n"
      		+ "You are in the Main Menu:\n"
      		+ "          1)Lookup UPC\n"
      		+ "          2)Search by Item name\n"
      		+ "          3)Search by Category\n"
      		+ "          4)Set Maximum Price filter\n"
      		+ "          5) Display items in cart\n"
      		+ "          6) Remove items from cart\n"
      		+ "          7) Checkout all items\n"
      		+ "          8) Exit Application\n"
      		+ "\n"
      		+ "You are in the Search Item menu:\n"
      		+ "          Enter item name:\n"
      		+ "Category filter: null\n"
      		+ "Price filter: null\n"
      		+ "1. Apple Juice $2.99\n"
      		+ "Which product would you like to add to cart? 1 - 1\n"
      		+ "Select 0 to cancel.\n"
      		+ "You are in the Main Menu:\n"
      		+ "          1)Lookup UPC\n"
      		+ "          2)Search by Item name\n"
      		+ "          3)Search by Category\n"
      		+ "          4)Set Maximum Price filter\n"
      		+ "          5) Display items in cart\n"
      		+ "          6) Remove items from cart\n"
      		+ "          7) Checkout all items\n"
      		+ "          8) Exit Application\n"
      		+ "\n"
      		+ "Items in cart:\n"
      		+ "1. Broccoli $4.5\n"
      		+ "2. Apple Juice $2.99\n"
      		+ "Your total is $7.49\n"
      		+ "You are in the Main Menu:\n"
      		+ "          1)Lookup UPC\n"
      		+ "          2)Search by Item name\n"
      		+ "          3)Search by Category\n"
      		+ "          4)Set Maximum Price filter\n"
      		+ "          5) Display items in cart\n"
      		+ "          6) Remove items from cart\n"
      		+ "          7) Checkout all items\n"
      		+ "          8) Exit Application\n"
      		+ "\n"
      		+ "Items in cart:\n"
      		+ "1. Broccoli $4.5\n"
      		+ "2. Apple Juice $2.99\n"
      		+ "Your total is $2.99\n"
      		+ "You have checked out 2 items\n"
      		+ "Thank you for shopping\n"
      		+ "You are in the Main Menu:\n"
      		+ "          1)Lookup UPC\n"
      		+ "          2)Search by Item name\n"
      		+ "          3)Search by Category\n"
      		+ "          4)Set Maximum Price filter\n"
      		+ "          5) Display items in cart\n"
      		+ "          6) Remove items from cart\n"
      		+ "          7) Checkout all items\n"
      		+ "          8) Exit Application\n"
      		+ "\n"
      		+ "Items in cart:\n"
      		+ "Empty Cart\n"
      		+ "You are in the Main Menu:\n"
      		+ "          1)Lookup UPC\n"
      		+ "          2)Search by Item name\n"
      		+ "          3)Search by Category\n"
      		+ "          4)Set Maximum Price filter\n"
      		+ "          5) Display items in cart\n"
      		+ "          6) Remove items from cart\n"
      		+ "          7) Checkout all items\n"
      		+ "          8) Exit Application\n"
      		+ "\n"
      		+ "Goodbye, Thanks for shopping!\n";
        
      String check = tester.checkOutput();
      
      assertEquals(expected, check);
	  
	  
  }
  
  /*
   * Role Code Test 5
   * This test is to check if the selected items are removed from the cart
   * the user adds a few items of his choice to the cart
   * then he is given the option to remove selected items
   * it then removes the item 
   * the cart is displayed before and after removal to check the change
   */
  @Test
  public void test5()
  {
	  TextUITester tester = new TextUITester("2\ncarrots\n1\n2\nground beef\n1\n2\norange juice\n1\n5\n6\n2\n5\n8\n");

		Scanner scn2 = new Scanner(System.in);

		UPCChecker checker = new UPCChecker();

		InventoryBackend end = new InventoryBackend();

		ProductLoader loader = new ProductLoader();
		for (IProduct product : loader.loadProducts()) {
			end.addProduct(product);
		}

		GSTMapperFrontend test = new GSTMapperFrontend(end,checker, scn2);
      
      test.runCommandLoop();
      
      String expected = "Welcome to the Grocery Store Inventory Application!\n"
      		+ "—--------------------------------------------------\n"
      		+ "\n"
      		+ "You are in the Main Menu:\n"
      		+ "          1)Lookup UPC\n"
      		+ "          2)Search by Item name\n"
      		+ "          3)Search by Category\n"
      		+ "          4)Set Maximum Price filter\n"
      		+ "          5) Display items in cart\n"
      		+ "          6) Remove items from cart\n"
      		+ "          7) Checkout all items\n"
      		+ "          8) Exit Application\n"
      		+ "\n"
      		+ "You are in the Search Item menu:\n"
      		+ "          Enter item name:\n"
      		+ "Category filter: null\n"
      		+ "Price filter: null\n"
      		+ "1. Carrots $2.25\n"
      		+ "Which product would you like to add to cart? 1 - 1\n"
      		+ "Select 0 to cancel.\n"
      		+ "You are in the Main Menu:\n"
      		+ "          1)Lookup UPC\n"
      		+ "          2)Search by Item name\n"
      		+ "          3)Search by Category\n"
      		+ "          4)Set Maximum Price filter\n"
      		+ "          5) Display items in cart\n"
      		+ "          6) Remove items from cart\n"
      		+ "          7) Checkout all items\n"
      		+ "          8) Exit Application\n"
      		+ "\n"
      		+ "You are in the Search Item menu:\n"
      		+ "          Enter item name:\n"
      		+ "Category filter: null\n"
      		+ "Price filter: null\n"
      		+ "1. Ground Beef $7.5\n"
      		+ "Which product would you like to add to cart? 1 - 1\n"
      		+ "Select 0 to cancel.\n"
      		+ "You are in the Main Menu:\n"
      		+ "          1)Lookup UPC\n"
      		+ "          2)Search by Item name\n"
      		+ "          3)Search by Category\n"
      		+ "          4)Set Maximum Price filter\n"
      		+ "          5) Display items in cart\n"
      		+ "          6) Remove items from cart\n"
      		+ "          7) Checkout all items\n"
      		+ "          8) Exit Application\n"
      		+ "\n"
      		+ "You are in the Search Item menu:\n"
      		+ "          Enter item name:\n"
      		+ "Category filter: null\n"
      		+ "Price filter: null\n"
      		+ "1. Orange Juice $2.99\n"
      		+ "Which product would you like to add to cart? 1 - 1\n"
      		+ "Select 0 to cancel.\n"
      		+ "You are in the Main Menu:\n"
      		+ "          1)Lookup UPC\n"
      		+ "          2)Search by Item name\n"
      		+ "          3)Search by Category\n"
      		+ "          4)Set Maximum Price filter\n"
      		+ "          5) Display items in cart\n"
      		+ "          6) Remove items from cart\n"
      		+ "          7) Checkout all items\n"
      		+ "          8) Exit Application\n"
      		+ "\n"
      		+ "Items in cart:\n"
      		+ "1. Carrots $2.25\n"
      		+ "2. Ground Beef $7.5\n"
      		+ "3. Orange Juice $2.99\n"
      		+ "Your total is $12.74\n"
      		+ "You are in the Main Menu:\n"
      		+ "          1)Lookup UPC\n"
      		+ "          2)Search by Item name\n"
      		+ "          3)Search by Category\n"
      		+ "          4)Set Maximum Price filter\n"
      		+ "          5) Display items in cart\n"
      		+ "          6) Remove items from cart\n"
      		+ "          7) Checkout all items\n"
      		+ "          8) Exit Application\n"
      		+ "\n"
      		+ "Items in cart:\n"
      		+ "1. Carrots $2.25\n"
      		+ "2. Ground Beef $7.5\n"
      		+ "3. Orange Juice $2.99\n"
      		+ "Which product would you like to add to cart? 1 - 31\n"
      		+ "Select 0 to cancel.\n"
      		+ "Select 4 to remove all items\n"
      		+ "You are in the Main Menu:\n"
      		+ "          1)Lookup UPC\n"
      		+ "          2)Search by Item name\n"
      		+ "          3)Search by Category\n"
      		+ "          4)Set Maximum Price filter\n"
      		+ "          5) Display items in cart\n"
      		+ "          6) Remove items from cart\n"
      		+ "          7) Checkout all items\n"
      		+ "          8) Exit Application\n"
      		+ "\n"
      		+ "Items in cart:\n"
      		+ "1. Carrots $2.25\n"
      		+ "2. Orange Juice $2.99\n"
      		+ "Your total is $5.24\n"
      		+ "You are in the Main Menu:\n"
      		+ "          1)Lookup UPC\n"
      		+ "          2)Search by Item name\n"
      		+ "          3)Search by Category\n"
      		+ "          4)Set Maximum Price filter\n"
      		+ "          5) Display items in cart\n"
      		+ "          6) Remove items from cart\n"
      		+ "          7) Checkout all items\n"
      		+ "          8) Exit Application\n"
      		+ "\n"
      		+ "Goodbye, Thanks for shopping!\n";
      
      String check = tester.checkOutput();
      
      assertEquals(expected, check);
	  
  }
  
   /*
    *Code review BackendDeveloper Test 1
    *Testing add and remove methods of backend
    */
    @Test
    public void CodeReviewBackendDeveloperTest1()
    {
		InventoryBackend backend = new InventoryBackend();
        Product chips = new Product("Chips", "Snacks",
            3.0f, 1, "123456788");
        Product beef = new Product("Beef", "Meats",
            5.0f, 1, "123456789");
        backend.addProductToCart(chips);
        backend.addProductToCart(beef);
        backend.removeProductFromCart(chips);
        assertEquals(beef, backend.cart.get(0));
        backend.removeProductFromCart(beef);
        assertEquals(0, backend.cart.size());
    }


    /*Code review BackendDeveloper Test 2
     * Testing getByUpc methods of backend
     */
    @Test
    public void CodeReviewBackendDeveloperTest2()
    {
			InventoryBackend backend = new InventoryBackend();
			ProductLoader loader = new ProductLoader();
			for (IProduct product : loader.loadProducts()) {
				backend.addProduct(product);
			}

			assertEquals("Chicken Breast", backend.getByUPC("8904319300894").getName());
    }
    
}
