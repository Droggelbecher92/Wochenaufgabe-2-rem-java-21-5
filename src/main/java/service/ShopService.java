package service;

import model.Order;
import model.Product;
import repo.OrderRepo;
import repo.ProductRepo;

public class ShopService {

    private final ProductRepo myProductRepo;
    private final OrderRepo myOrderRepo;

    public ShopService(ProductRepo myProductRepo, OrderRepo myOrderRepo) {
        this.myProductRepo = myProductRepo;
        this.myOrderRepo = myOrderRepo;
    }

    public void getProduct(String productId){
        try {
            System.out.println(myProductRepo.getProductById(productId));
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    public void getAllProducts(){
        System.out.println(myProductRepo.listAllProducts());
    }

    public void addNewProduct(Product productToAdd){
        try {
            System.out.println(myProductRepo.addNewProduct(productToAdd));
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    public void removeProduct(String idOfProductToRemove){
        try {
            System.out.println(myProductRepo.removeProductById(idOfProductToRemove));
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    public void getOrderByID(String orderId){
        try {
            System.out.println(myOrderRepo.getOrderById(orderId));
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    public void getAllOrders(){
        System.out.println(myOrderRepo.getAllOrders());
    }

    public void addNewOrder(Order orderToAdd){
        try {
            System.out.println(myOrderRepo.addNewOrder(orderToAdd));
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
