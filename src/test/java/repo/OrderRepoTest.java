package repo;

import model.Order;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class OrderRepoTest {

    @Test
    public void getAllShouldReturnAllOrders(){
        //Given
        OrderRepo testRepo = setup();
        //When
        HashMap<String, Order> actual = testRepo.getAllOrders();
        //Then
        assertEquals(actual.size(),4);
        assertTrue(actual.containsKey("1"));
        assertFalse(actual.containsKey("5"));
    }

    @Test
    public void getOrderWithValidId(){
        //Given
        OrderRepo testRepo = setup();
        String validId = "2";
        //When
        Order actual = testRepo.getOrderById(validId);
        //Then
        assertEquals(actual.getId(),"2");
    }

    @Test
    public void getOrderWithInvalidIdShouldTrow(){
        //Given
        OrderRepo testRepo = setup();
        String invalidId = "7";
        //When
        try {
            testRepo.getOrderById(invalidId);
            fail();
        } catch (IllegalArgumentException actual){
            //Then
            assertEquals("BestellID "+invalidId+" nicht gefunden",actual.getMessage());
        }


    }

    @Test
    public void addOrderWithNewID(){
        //Given
        OrderRepo testRepo = setup();
        Order orderToAdd = new Order("5",new HashMap<>());
        //When
        Order actual = testRepo.addNewOrder(orderToAdd);
        //Then
        assertEquals(testRepo.getAllOrders().size(),5);
        assertTrue(testRepo.getAllOrders().containsKey(orderToAdd.getId()));
    }

    @Test
    public void addOrderWithExistingIdShouldTrow(){
        //Given
        OrderRepo testRepo = setup();
        Order orderToAdd = new Order("3",new HashMap<>());
        //When
        try {
            testRepo.addNewOrder(orderToAdd);
            fail();
        } catch (IllegalArgumentException actual){
            //Then
            assertEquals("BestellID "+ orderToAdd.getId()+" schon vergeben.",actual.getMessage());
        }
    }

    //Hilfsfunktionen
    public OrderRepo setup(){
        Order order1 = new Order("1",new HashMap<>());
        Order order2 = new Order("2",new HashMap<>());
        Order order3 = new Order("3",new HashMap<>());
        Order order4 = new Order("4",new HashMap<>());
        return new OrderRepo(new HashMap<>(Map.of(
                order1.getId(),order1,
                order2.getId(),order2,
                order3.getId(),order3,
                order4.getId(),order4
        )));
    }


}