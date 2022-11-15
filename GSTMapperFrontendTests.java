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
      		+ "          5)Display items in cart\n"
      		+ "          6)Remove items from cart\n"
      		+ "          7)Checkout all items\n"
      		+ "          8)Exit Application\n"
      		+ "\n"
      		+ "Goodbye, Thanks for shopping!\n";
      
      String check = tester.checkOutput();
      
     assertEquals(expected, check);
     
      
	  
  }
  /*
   * Role Code Test 2
   * This test is check if the product is return for a valid upc
   * The user inputed upc is 4088600511368
   * it returns the name Chicken Legs, along with the price of the item - $7.50
   * it also displays the currently set category and price filter
   */
  @Test
  public void test2()
  {
	  TextUITester tester = new TextUITester("1\n4088600511368\n0\n8\n");
      
	  Scanner scn2 = new Scanner(System.in);
	  
	  UPCChecker checker = new UPCChecker();
	  
      InventoryBackend backend = new InventoryBackend();
      
	 // Product Legs = new Product("Chicken Legs", "Meats", 2.50, 10, "4088600511368");
	  
	  //backend.addProduct(Legs);
	 
      ProductLoader loader = new ProductLoader();
		
	  GSTMapperFrontend test = new GSTMapperFrontend(backend,checker, scn2);
		
		for( IProduct p : loader.loadProducts())
		{
			backend.addProduct(p);
		}

	  test.runCommandLoop();

		String expected = "Welcome to the Grocery Store Inventory Application!\n"
				+ "—--------------------------------------------------\n"
				+ "\n"
				+ "You are in the Main Menu:\n"
				+ "          1)Lookup UPC\n"
				+ "          2)Search by Item name\n"
				+ "          3)Search by Category\n"
				+ "          4)Set Maximum Price filter\n"
				+ "          5)Display items in cart\n"
				+ "          6)Remove items from cart\n"
				+ "          7)Checkout all items\n"
				+ "          8)Exit Application\n"
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
				+ "          5)Display items in cart\n"
				+ "          6)Remove items from cart\n"
				+ "          7)Checkout all items\n"
				+ "          8)Exit Application\n"
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
      TextUITester tester = new TextUITester("2\nChickEN LeGS\n0\n8\n");
      
	  Scanner scn2 = new Scanner(System.in);
	  
	  UPCChecker checker = new UPCChecker();
	  
	  InventoryBackend backend = new InventoryBackend();
	  
	  ProductLoader loader = new ProductLoader();
		
	  GSTMapperFrontend test = new GSTMapperFrontend(backend,checker, scn2);
		
		for( IProduct p : loader.loadProducts())
		{
			backend.addProduct(p);
		}

      test.runCommandLoop();
      
      String expected = "Welcome to the Grocery Store Inventory Application!\n"
      		+ "—--------------------------------------------------\n"
      		+ "\n"
      		+ "You are in the Main Menu:\n"
      		+ "          1)Lookup UPC\n"
      		+ "          2)Search by Item name\n"
      		+ "          3)Search by Category\n"
      		+ "          4)Set Maximum Price filter\n"
      		+ "          5)Display items in cart\n"
      		+ "          6)Remove items from cart\n"
      		+ "          7)Checkout all items\n"
      		+ "          8)Exit Application\n"
      		+ "\n"
      		+ "You are in the Search Item menu:\n"
      		+ "          Enter item name:\n"
      		+ "Category filter: \n"
      		+ "Price filter: null\n"
      		+ "1. Chicken Legs $2.5\n"
      		+ "Which product would you like to add to cart? 1 - 1\n"
      		+ "Select 0 to cancel.\n"
      		+ "You are in the Main Menu:\n"
      		+ "          1)Lookup UPC\n"
      		+ "          2)Search by Item name\n"
      		+ "          3)Search by Category\n"
      		+ "          4)Set Maximum Price filter\n"
      		+ "          5)Display items in cart\n"
      		+ "          6)Remove items from cart\n"
      		+ "          7)Checkout all items\n"
      		+ "          8)Exit Application\n"
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
      TextUITester tester = new TextUITester("2\nbroccoli\n1\n2\napple\n1\n5\n7\n5\n8\n");
      
	  Scanner scn2 = new Scanner(System.in);
	  
	  UPCChecker checker = new UPCChecker();
	  
	  InventoryBackend backend = new InventoryBackend();
	  
	  ProductLoader loader = new ProductLoader();
		
	  GSTMapperFrontend test = new GSTMapperFrontend(backend,checker, scn2);
		
		for( IProduct p : loader.loadProducts())
		{
			backend.addProduct(p);
		}
      
      test.runCommandLoop();
      
      String expected = "Welcome to the Grocery Store Inventory Application!\n"
      		+ "—--------------------------------------------------\n"
      		+ "\n"
      		+ "You are in the Main Menu:\n"
      		+ "          1)Lookup UPC\n"
      		+ "          2)Search by Item name\n"
      		+ "          3)Search by Category\n"
      		+ "          4)Set Maximum Price filter\n"
      		+ "          5)Display items in cart\n"
      		+ "          6)Remove items from cart\n"
      		+ "          7)Checkout all items\n"
      		+ "          8)Exit Application\n"
      		+ "\n"
      		+ "You are in the Search Item menu:\n"
      		+ "          Enter item name:\n"
      		+ "Category filter: \n"
      		+ "Price filter: null\n"
      		+ "1. Broccoli $4.25\n"
      		+ "Which product would you like to add to cart? 1 - 1\n"
      		+ "Select 0 to cancel.\n"
      		+ "You are in the Main Menu:\n"
      		+ "          1)Lookup UPC\n"
      		+ "          2)Search by Item name\n"
      		+ "          3)Search by Category\n"
      		+ "          4)Set Maximum Price filter\n"
      		+ "          5)Display items in cart\n"
      		+ "          6)Remove items from cart\n"
      		+ "          7)Checkout all items\n"
      		+ "          8)Exit Application\n"
      		+ "\n"
      		+ "You are in the Search Item menu:\n"
      		+ "          Enter item name:\n"
      		+ "Category filter: \n"
      		+ "Price filter: null\n"
      		+ "1. Apples $5.849999904632568\n"
      		+ "Which product would you like to add to cart? 1 - 1\n"
      		+ "Select 0 to cancel.\n"
      		+ "You are in the Main Menu:\n"
      		+ "          1)Lookup UPC\n"
      		+ "          2)Search by Item name\n"
      		+ "          3)Search by Category\n"
      		+ "          4)Set Maximum Price filter\n"
      		+ "          5)Display items in cart\n"
      		+ "          6)Remove items from cart\n"
      		+ "          7)Checkout all items\n"
      		+ "          8)Exit Application\n"
      		+ "\n"
      		+ "Items in cart:\n"
      		+ "1. Broccoli $4.25\n"
      		+ "2. Apples $5.849999904632568\n"
      		+ "Your total is $10.099999904632568\n"
      		+ "You are in the Main Menu:\n"
      		+ "          1)Lookup UPC\n"
      		+ "          2)Search by Item name\n"
      		+ "          3)Search by Category\n"
      		+ "          4)Set Maximum Price filter\n"
      		+ "          5)Display items in cart\n"
      		+ "          6)Remove items from cart\n"
      		+ "          7)Checkout all items\n"
      		+ "          8)Exit Application\n"
      		+ "\n"
      		+ "Items in cart:\n"
      		+ "1. Broccoli $4.25\n"
      		+ "2. Apples $5.849999904632568\n"
      		+ "Your total is $5.849999904632568\n"
      		+ "You have checked out 2 items\n"
      		+ "Thank you for shopping\n"
      		+ "You are in the Main Menu:\n"
      		+ "          1)Lookup UPC\n"
      		+ "          2)Search by Item name\n"
      		+ "          3)Search by Category\n"
      		+ "          4)Set Maximum Price filter\n"
      		+ "          5)Display items in cart\n"
      		+ "          6)Remove items from cart\n"
      		+ "          7)Checkout all items\n"
      		+ "          8)Exit Application\n"
      		+ "\n"
      		+ "Items in cart:\n"
      		+ "Empty Cart\n"
      		+ "You are in the Main Menu:\n"
      		+ "          1)Lookup UPC\n"
      		+ "          2)Search by Item name\n"
      		+ "          3)Search by Category\n"
      		+ "          4)Set Maximum Price filter\n"
      		+ "          5)Display items in cart\n"
      		+ "          6)Remove items from cart\n"
      		+ "          7)Checkout all items\n"
      		+ "          8)Exit Application\n"
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
	  TextUITester tester = new TextUITester("2\ncarrots\n1\n2\nground\n1\n2\nb\n6\n6\n2\n5\n8\n");

		Scanner scn2 = new Scanner(System.in);

		UPCChecker checker = new UPCChecker();

		InventoryBackend backend = new InventoryBackend();
		
		 ProductLoader loader = new ProductLoader();
			
		  GSTMapperFrontend test = new GSTMapperFrontend(backend,checker, scn2);
			
			for( IProduct p : loader.loadProducts())
			{
				backend.addProduct(p);
			}
      
      test.runCommandLoop();
      
      String expected = "Welcome to the Grocery Store Inventory Application!\n"
      		+ "—--------------------------------------------------\n"
      		+ "\n"
      		+ "You are in the Main Menu:\n"
      		+ "          1)Lookup UPC\n"
      		+ "          2)Search by Item name\n"
      		+ "          3)Search by Category\n"
      		+ "          4)Set Maximum Price filter\n"
      		+ "          5)Display items in cart\n"
      		+ "          6)Remove items from cart\n"
      		+ "          7)Checkout all items\n"
      		+ "          8)Exit Application\n"
      		+ "\n"
      		+ "You are in the Search Item menu:\n"
      		+ "          Enter item name:\n"
      		+ "Category filter: \n"
      		+ "Price filter: null\n"
      		+ "1. Carrots $2.25\n"
      		+ "Which product would you like to add to cart? 1 - 1\n"
      		+ "Select 0 to cancel.\n"
      		+ "You are in the Main Menu:\n"
      		+ "          1)Lookup UPC\n"
      		+ "          2)Search by Item name\n"
      		+ "          3)Search by Category\n"
      		+ "          4)Set Maximum Price filter\n"
      		+ "          5)Display items in cart\n"
      		+ "          6)Remove items from cart\n"
      		+ "          7)Checkout all items\n"
      		+ "          8)Exit Application\n"
      		+ "\n"
      		+ "You are in the Search Item menu:\n"
      		+ "          Enter item name:\n"
      		+ "Category filter: \n"
      		+ "Price filter: null\n"
      		+ "1. Ground Beef $7.5\n"
      		+ "Which product would you like to add to cart? 1 - 1\n"
      		+ "Select 0 to cancel.\n"
      		+ "You are in the Main Menu:\n"
      		+ "          1)Lookup UPC\n"
      		+ "          2)Search by Item name\n"
      		+ "          3)Search by Category\n"
      		+ "          4)Set Maximum Price filter\n"
      		+ "          5)Display items in cart\n"
      		+ "          6)Remove items from cart\n"
      		+ "          7)Checkout all items\n"
      		+ "          8)Exit Application\n"
      		+ "\n"
      		+ "You are in the Search Item menu:\n"
      		+ "          Enter item name:\n"
      		+ "Category filter: \n"
      		+ "Price filter: null\n"
      		+ "1. Ground Beef $7.5\n"
      		+ "2. Green Beans $3.25\n"
      		+ "3. Turkey Breast $10.5\n"
      		+ "4. Broccoli $4.25\n"
      		+ "5. Beef Steak $12.5\n"
      		+ "6. Chicken Breast $9.5\n"
      		+ "Which product would you like to add to cart? 1 - 6\n"
      		+ "Select 0 to cancel.\n"
      		+ "You are in the Main Menu:\n"
      		+ "          1)Lookup UPC\n"
      		+ "          2)Search by Item name\n"
      		+ "          3)Search by Category\n"
      		+ "          4)Set Maximum Price filter\n"
      		+ "          5)Display items in cart\n"
      		+ "          6)Remove items from cart\n"
      		+ "          7)Checkout all items\n"
      		+ "          8)Exit Application\n"
      		+ "\n"
      		+ "Items in cart:\n"
      		+ "1. Carrots $2.25\n"
      		+ "2. Ground Beef $7.5\n"
      		+ "3. Chicken Breast $9.5\n"
      		+ "Which product would you like to add to cart? 1 - 31\n"
      		+ "Select 0 to cancel.\n"
      		+ "Select 4 to remove all items\n"
      		+ "You are in the Main Menu:\n"
      		+ "          1)Lookup UPC\n"
      		+ "          2)Search by Item name\n"
      		+ "          3)Search by Category\n"
      		+ "          4)Set Maximum Price filter\n"
      		+ "          5)Display items in cart\n"
      		+ "          6)Remove items from cart\n"
      		+ "          7)Checkout all items\n"
      		+ "          8)Exit Application\n"
      		+ "\n"
      		+ "Items in cart:\n"
      		+ "1. Carrots $2.25\n"
      		+ "2. Chicken Breast $9.5\n"
      		+ "Your total is $11.75\n"
      		+ "You are in the Main Menu:\n"
      		+ "          1)Lookup UPC\n"
      		+ "          2)Search by Item name\n"
      		+ "          3)Search by Category\n"
      		+ "          4)Set Maximum Price filter\n"
      		+ "          5)Display items in cart\n"
      		+ "          6)Remove items from cart\n"
      		+ "          7)Checkout all items\n"
      		+ "          8)Exit Application\n"
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
     * Testing getByUpc method of backend
     * it should return the same product as given upc
     */
    @Test
    public void CodeReviewBackendDeveloperTest2()
    {
			InventoryBackend backend = new InventoryBackend();

		    //Product Breast = new Product("Chicken Breast", "Meats", 9.50, 10, "8904319300894");
            
		    //backend.addProduct(Breast);
			
			ProductLoader loader = new ProductLoader();
			
			for( IProduct p : loader.loadProducts())
			{
				backend.addProduct(p);
			}

			assertEquals("Chicken Breast", backend.getByUPC("8904319300894").getName());
    }
    
    /*Integration test1
     * load all products
     * search items using a price filter
     */
    @Test
    public void FrontEndTest1()
    {

  	  TextUITester tester = new TextUITester("4\n10\n2\nm\n0\n8");

  		Scanner scn2 = new Scanner(System.in);

  		UPCChecker checker = new UPCChecker();

  		InventoryBackend end = new InventoryBackend();
  		
  		ProductLoader loader = new ProductLoader();
  		
  	  GSTMapperFrontend test = new GSTMapperFrontend(end,checker, scn2);
  		
  		for( IProduct p : loader.loadProducts())
  		{
  			end.addProduct(p);
  		}
  		
  		 test.runCommandLoop();
  		
  		
  		
  		String check = "Welcome to the Grocery Store Inventory Application!\n"
  				+ "—--------------------------------------------------\n"
  				+ "\n"
  				+ "You are in the Main Menu:\n"
  				+ "          1)Lookup UPC\n"
  				+ "          2)Search by Item name\n"
  				+ "          3)Search by Category\n"
  				+ "          4)Set Maximum Price filter\n"
  				+ "          5)Display items in cart\n"
  				+ "          6)Remove items from cart\n"
  				+ "          7)Checkout all items\n"
  				+ "          8)Exit Application\n"
  				+ "\n"
  				+ "You are in the Filter by Maximum Price Menu:\n"
  				+ "          Enter Maximum Price: \n"
  				+ "You are in the Main Menu:\n"
  				+ "          1)Lookup UPC\n"
  				+ "          2)Search by Item name\n"
  				+ "          3)Search by Category\n"
  				+ "          4)Set Maximum Price filter\n"
  				+ "          5)Display items in cart\n"
  				+ "          6)Remove items from cart\n"
  				+ "          7)Checkout all items\n"
  				+ "          8)Exit Application\n"
  				+ "\n"
  				+ "You are in the Search Item menu:\n"
  				+ "          Enter item name:\n"
  				+ "Category filter: \n"
  				+ "Price filter: 10.0\n"
  				+ "1. 2% Milk $3.190000057220459\n"
  				+ "2. Chicken Drumsticks $1.5\n"
  				+ "3. Ice Cream $4.989999771118164\n"
  				+ "Which product would you like to add to cart? 1 - 3\n"
  				+ "Select 0 to cancel.\n"
  				+ "You are in the Main Menu:\n"
  				+ "          1)Lookup UPC\n"
  				+ "          2)Search by Item name\n"
  				+ "          3)Search by Category\n"
  				+ "          4)Set Maximum Price filter\n"
  				+ "          5)Display items in cart\n"
  				+ "          6)Remove items from cart\n"
  				+ "          7)Checkout all items\n"
  				+ "          8)Exit Application\n"
  				+ "\n"
  				+ "Goodbye, Thanks for shopping!\n";
  		
  		String output = tester.checkOutput();
  		
  		assertEquals(check, output);
  		
    }
    
    /*Integration test2
     * load all products
     * adds some items to the cart 
     * displays the cart
     * checkouts from the cart
     */
    @Test
    public void FrontEndTest2()
    {

  	  TextUITester tester = new TextUITester("2\ng\n4\n2\nm\n1\n5\n7\n5\n8\n");

  	Scanner scn2 = new Scanner(System.in);

		UPCChecker checker = new UPCChecker();

		InventoryBackend end = new InventoryBackend();
		
		ProductLoader loader = new ProductLoader();
		
	  GSTMapperFrontend test = new GSTMapperFrontend(end,checker, scn2);
		
		for( IProduct p : loader.loadProducts())
		{
			end.addProduct(p);
		}
		
		 test.runCommandLoop();
  		
  		String check = "Welcome to the Grocery Store Inventory Application!\n"
  				+ "—--------------------------------------------------\n"
  				+ "\n"
  				+ "You are in the Main Menu:\n"
  				+ "          1)Lookup UPC\n"
  				+ "          2)Search by Item name\n"
  				+ "          3)Search by Category\n"
  				+ "          4)Set Maximum Price filter\n"
  				+ "          5)Display items in cart\n"
  				+ "          6)Remove items from cart\n"
  				+ "          7)Checkout all items\n"
  				+ "          8)Exit Application\n"
  				+ "\n"
  				+ "You are in the Search Item menu:\n"
  				+ "          Enter item name:\n"
  				+ "Category filter: \n"
  				+ "Price filter: null\n"
  				+ "1. Ground Beef $7.5\n"
  				+ "2. Green Beans $3.25\n"
  				+ "3. Grapes $6.849999904632568\n"
  				+ "4. Chicken Thighs $8.5\n"
  				+ "5. Chicken Wings $7.5\n"
  				+ "6. Chicken Legs $2.5\n"
  				+ "7. Oranges $4.849999904632568\n"
  				+ "Which product would you like to add to cart? 1 - 7\n"
  				+ "Select 0 to cancel.\n"
  				+ "You are in the Main Menu:\n"
  				+ "          1)Lookup UPC\n"
  				+ "          2)Search by Item name\n"
  				+ "          3)Search by Category\n"
  				+ "          4)Set Maximum Price filter\n"
  				+ "          5)Display items in cart\n"
  				+ "          6)Remove items from cart\n"
  				+ "          7)Checkout all items\n"
  				+ "          8)Exit Application\n"
  				+ "\n"
  				+ "You are in the Search Item menu:\n"
  				+ "          Enter item name:\n"
  				+ "Category filter: \n"
  				+ "Price filter: null\n"
  				+ "1. 2% Milk $3.190000057220459\n"
  				+ "2. Chicken Drumsticks $1.5\n"
  				+ "3. Ice Cream $4.989999771118164\n"
  				+ "Which product would you like to add to cart? 1 - 3\n"
  				+ "Select 0 to cancel.\n"
  				+ "You are in the Main Menu:\n"
  				+ "          1)Lookup UPC\n"
  				+ "          2)Search by Item name\n"
  				+ "          3)Search by Category\n"
  				+ "          4)Set Maximum Price filter\n"
  				+ "          5)Display items in cart\n"
  				+ "          6)Remove items from cart\n"
  				+ "          7)Checkout all items\n"
  				+ "          8)Exit Application\n"
  				+ "\n"
  				+ "Items in cart:\n"
  				+ "1. Chicken Thighs $8.5\n"
  				+ "2. 2% Milk $3.190000057220459\n"
  				+ "Your total is $11.690000057220459\n"
  				+ "You are in the Main Menu:\n"
  				+ "          1)Lookup UPC\n"
  				+ "          2)Search by Item name\n"
  				+ "          3)Search by Category\n"
  				+ "          4)Set Maximum Price filter\n"
  				+ "          5)Display items in cart\n"
  				+ "          6)Remove items from cart\n"
  				+ "          7)Checkout all items\n"
  				+ "          8)Exit Application\n"
  				+ "\n"
  				+ "Items in cart:\n"
  				+ "1. Chicken Thighs $8.5\n"
  				+ "2. 2% Milk $3.190000057220459\n"
  				+ "Your total is $3.190000057220459\n"
  				+ "You have checked out 2 items\n"
  				+ "Thank you for shopping\n"
  				+ "You are in the Main Menu:\n"
  				+ "          1)Lookup UPC\n"
  				+ "          2)Search by Item name\n"
  				+ "          3)Search by Category\n"
  				+ "          4)Set Maximum Price filter\n"
  				+ "          5)Display items in cart\n"
  				+ "          6)Remove items from cart\n"
  				+ "          7)Checkout all items\n"
  				+ "          8)Exit Application\n"
  				+ "\n"
  				+ "Items in cart:\n"
  				+ "Empty Cart\n"
  				+ "You are in the Main Menu:\n"
  				+ "          1)Lookup UPC\n"
  				+ "          2)Search by Item name\n"
  				+ "          3)Search by Category\n"
  				+ "          4)Set Maximum Price filter\n"
  				+ "          5)Display items in cart\n"
  				+ "          6)Remove items from cart\n"
  				+ "          7)Checkout all items\n"
  				+ "          8)Exit Application\n"
  				+ "\n"
  				+ "Goodbye, Thanks for shopping!\n";
  		
  		String output = tester.checkOutput();
  		
  		assertEquals(check, output);
  		
    }
    
}
