import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GSTMapperFrontend implements IGSTMapperFrontend {
    private final IGSTBackend backend;

    private final IUPCChecker upcChecker;

    private final Scanner scn;

    public GSTMapperFrontend(IGSTBackend backend, IUPCChecker upcChecker,
        Scanner userInputScanner) {
        this.backend = backend;

        this.upcChecker = upcChecker;

        this.scn = userInputScanner;
    }


    public void runCommandLoop() {
        System.out.println("Welcome to the Grocery Store Inventory Application!\n"
            + "—--------------------------------------------------\n");

        displayMainMenu();

    }


    public void displayMainMenu() {
        System.out.println("You are in the Main Menu:");

        System.out.println("          1)Lookup UPC\n" + "          2)Search by Item name\n"
            + "          3)Search by Category\n" + "          4)Set Maximum Price filter\n"
            + "          5)Display items in cart\n" + "          6)Remove items from cart\n"
            + "          7)Checkout all items\n" + "          8)Exit Application\n");

        int option = scn.nextInt();

        switch (option) {
            case 1:
                upcLookup();
                break;

            case 2:
                itemSearch();
                break;

            case 3:
                categorySearch();
                break;

            case 4:
                priceFilter();
                break;

            case 5:
                displayCart();
                break;


            case 6:
                removeItems();
                break;

            case 7:
                checkOut();
                break;

            case 8:
                System.out.println("Goodbye, Thanks for shopping!");
                break;

            default:
                System.out.println("Invalid option, please choose from displayed options");

                displayMainMenu();
        }


    }

    public void upcLookup() {
        System.out.println("You are in the Lookup UPC menu:");

        System.out.println("          Enter UPC to look up:");

        scn.nextLine();

        String upc = scn.nextLine();

        ArrayList<IProduct> productList = new ArrayList<>();

        if (upcChecker.check(upc)) {

            productList.add(backend.getByUPC(upc));

            displayProducts(productList);


        } else {
            System.out.println("Invalid UPC");
        }

        displayMainMenu();


    }


    public void itemSearch() {
        System.out.println("You are in the Search Item menu:");

        System.out.println("          Enter item name:");

        List<IProduct> productList;

        scn.nextLine();

        String item = scn.nextLine();

        productList = backend.searchByProductName(item);

        displayProducts(productList);

        displayMainMenu();


    }

    @Override public void categorySearch() {
        System.out.println("You are in the Search by Category Menu:");

        System.out.println("          Enter a category to browse: ");

        backend.resetCategoryFilter();

        scn.nextLine();

        String category = scn.nextLine();

        backend.setCategoryFilter(category);

        displayMainMenu();



    }

    @Override public void priceFilter() {
        System.out.println("You are in the Filter by Maximum Price Menu:");

        System.out.println("          Enter Maximum Price: ");

        backend.resetPriceFilter();

        scn.nextLine();

        String price = scn.nextLine();

        backend.setPriceFilter(price);

        displayMainMenu();

    }

    public void displayCart() {
        System.out.println("Items in cart:");

        List<IProduct> cart;

        cart = backend.getCart();

        if (cart == null || cart.isEmpty() || cart.get(0) == null) {
            System.out.println("Empty Cart");
        } else {
            int count = 0;

            double totalPrice = 0.0;

            for (IProduct L : cart) {
                count = count + 1;

                System.out.println((count) + ". " + L.getName() + " $" + L.getPrice());

                totalPrice = totalPrice + L.getPrice();
            }

            System.out.println("Your total is $" + totalPrice);
        }

        displayMainMenu();

    }

    public void removeItems() {


        System.out.println("Items in cart:");

        List<IProduct> cart;

        cart = backend.getCart();

        if (cart == null || cart.isEmpty() || cart.get(0) == null) {
            System.out.println("Empty Cart");

            displayMainMenu();
        } else {
            int count = 0;

            for (IProduct L : cart) {
                count = count + 1;

                System.out.println((count) + ". " + L.getName() + " $" + L.getPrice());

            }

            System.out.println(
                "Which product would you like to add to cart? " + "1 - " + cart.size() + 1);

            System.out.println("Select 0 to cancel.");

            System.out.println("Select " + (cart.size() + 1) + " to remove all items");

            int option = scn.nextInt();

            if (option >= 1 && option <= cart.size()) {

                backend.removeProductFromCart(cart.get(option - 1));

            } else if (option == cart.size() + 1) {
                System.out.println("Emptied cart");
                backend.removeAllFromCart();

            } else {
                System.out.println("Invalid option");
            }

            displayMainMenu();
        }

    }


    @Override public void checkOut() {

        List<IProduct> cart;

        cart = backend.getCart();

        System.out.println("Items in cart:");


        if (cart == null || cart.isEmpty() || cart.get(0) == null) {
            System.out.println("Empty Cart, can not checkout");
        } else {
            int count = 0;

            double totalPrice = 0.0;

            for (IProduct L : cart) {
                count = count + 1;

                System.out.println((count) + ". " + L.getName() + " $" + L.getPrice());

                totalPrice = totalPrice + L.getPrice();
            }

            System.out.println("Your total is $" + totalPrice);
        }

        System.out.println("You have checked out " + cart.size() + " items");

        System.out.println("Thank you for shopping");

        backend.removeAllFromCart();

        displayMainMenu();

    }

    public void displayProducts(List<IProduct> products) {
        if (products == null || products.isEmpty() || products.get(0) == null) {
            System.out.println("No Matches");
            return;
        }

        int numProducts = products.size();

        if (numProducts >= 1) {
            System.out.println("Category filter: " + backend.getCategoryFilter());

            System.out.println("Price filter: " + backend.getPriceFilter());


        }

        int count = 0;

        for (IProduct L : products) {

            count++;
            System.out.println((count) + ". " + L.getName() + " $" + L.getPrice());

        }



        System.out.println(
            "Which product would you like to add to cart? " + "1 - " + products.size());

        System.out.println("Select 0 to cancel.");

        int option = scn.nextInt();

        if (option < 1) {
            return;
        } else if (option >= 1 && option <= numProducts) {

            backend.addProductToCart(products.get(option - 1));

        } else {
            System.out.println("Invalid input");

        }


    }


}
