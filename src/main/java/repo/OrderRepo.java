package repo;

import model.Order;

import java.util.HashMap;
import java.util.Optional;

public class OrderRepo {

    private HashMap<String, Order> orderRepo;

    public OrderRepo(HashMap<String, Order> orderRepo) {
        this.orderRepo = orderRepo;
    }

    public HashMap<String,Order> getAllOrders(){
        return this.orderRepo;
    }

    public Order getOrderById(String whichId){
        Optional<Order> optionalOrder = Optional.ofNullable(orderRepo.get(whichId));
        if (optionalOrder.isPresent()){
            return optionalOrder.get();
        }
        throw new IllegalArgumentException("BestellID "+whichId+" nicht gefunden");
    }

    public Order addNewOrder(Order orderToAdd){
        if (orderRepo.containsKey(orderToAdd.getId())){
            throw new IllegalArgumentException("BestellID "+ orderToAdd.getId()+" schon vergeben.");
        }
        orderRepo.put(orderToAdd.getId(), orderToAdd);
        return orderToAdd;
    }
}
