import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;

/**
 * Loads products from an XML file.
 */
public class ProductLoader implements IProductLoader {

    /**
     * Loads products from an XML file.
     * @return the list of products
     */
    public ArrayList<IProduct> loadProducts() {
        ArrayList<IProduct> products = new ArrayList<>();
        try {
            File fXmlFile = new File("products.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            NodeList allProducts = doc.getElementsByTagName("product");
            int numProducts = allProducts.getLength();

            for (int i = 0; i < numProducts; i++) {
                NodeList product = allProducts.item(i).getChildNodes();
                String name = product.item(1).getTextContent();
                String category = product.item(3).getTextContent();
                float price = Float.parseFloat(product.item(5).getTextContent().replace("$", ""));
                int quantity = Integer.parseInt(product.item(7).getTextContent());
                String UPC = product.item(9).getTextContent();
                products.add(new Product(name, category, price, quantity, UPC));
            }

            return products;
        } catch (Exception e) {
            System.out.println("Error loading products");
        }

        return null;
    }
}
