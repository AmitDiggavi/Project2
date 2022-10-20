
/**
* Implementations of this interface is used to validate UPC numbers.
 @author Amit Diggavi
        */
public interface IUPCChecker {

    /**
     * Checks if the given UPC number is a valid UPC number.
     * @param upc the UPC number to validate
     * @return true is the number if a valid UPC number is given, otherwise returns false.
     */
    public boolean check(String upc);

}
