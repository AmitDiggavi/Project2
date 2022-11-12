import static org.junit.Assert.assertEquals;

import java.util.Scanner;

import org.junit.jupiter.api.Test;



public class GSTMapperFrontendTest 
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
	  
	  UPCChecker checker = new IUPCPlaceHolder();
	  
	  InventoryBackend end = new IIventoryPlaceHolder();
	  
     
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
      		+ "Category filter: null\n"
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
	  
	  UPCChecker checker = new IUPCPlaceHolder();
	  
	  InventoryBackend end = new IIventoryPlaceHolder();
	  
     
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
	  
	  UPCChecker checker = new IUPCPlaceHolder();
	  
	  InventoryBackend end = new IIventoryPlaceHolder();
	  
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
	  
      UPCChecker checker = new IUPCPlaceHolder();
	  
      InventoryBackend end = new IIventoryPlaceHolder();
	  
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
     
     
}
