import model.Order;
import model.Product;
import repo.OrderRepo;
import repo.ProductRepo;
import service.ShopService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Shop {

    public static void main(String[] args) {
        //Shop aufbauen
        ShopService myCoolShop = new ShopService(new ProductRepo(new HashMap<>()),new OrderRepo(new HashMap<>()));
        System.out.println("Shop ist fertiggestellt!");
        Product product1 = new Product("1","Bier");
        Product product2 = new Product("2","Wasser");
        Product product3 = new Product("3","Brot");
        Product product4 = new Product("4","Klopapier");
        myCoolShop.addNewProduct(product1);
        myCoolShop.addNewProduct(product2);
        myCoolShop.addNewProduct(product3);
        myCoolShop.addNewProduct(product4);
        System.out.println("Produkte wurden hinzugefügt");
        myCoolShop.getAllProducts();
        myCoolShop.addNewOrder(new Order("1", new ArrayList<>(List.of("1","3"))));
        myCoolShop.getAllOrders();

        // Try/Catch Versuche
        System.out.println("####Hier folgen nun Fehler!#####");
        myCoolShop.addNewProduct(product1);
        myCoolShop.getProduct("5");
        myCoolShop.removeProduct("5");
        myCoolShop.addNewOrder(new Order("1", new ArrayList<>(List.of("1","3"))));
        myCoolShop.getOrderByID("2");
        System.out.println("####Hier Enden die Fehler####");

        // Versuche Remove
        myCoolShop.removeProduct("4");
    }

}
