import java.util.Scanner;

public class GSTMapper {
    public static void main(String[] args) {
        // instantiate the backend
        IGSTBackend backend = new InventoryBackend();

        // instantiate the scanner for user input
        Scanner userInputScanner = new Scanner(System.in);

        // instantiate the UPC validator
        IUPCChecker upcChecker = new UPCChecker();

        // instantiate the front end and pass references to the scanner and backend to it
        IGSTMapperFrontend frontend =  new GSTMapperFrontend(backend, upcChecker, userInputScanner);

        // start the input loop of the front end
        frontend.runCommandLoop();
    }
}
