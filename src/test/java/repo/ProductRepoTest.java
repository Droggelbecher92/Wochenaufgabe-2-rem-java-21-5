package repo;

import model.Product;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepoTest {

    @Test
    public void listShouldReturnAllProducts(){
        //Given
        ProductRepo testRepo = setup();
        //When
        HashMap<String, Product> actual = testRepo.listAllProducts();
        //Then
        assertEquals(actual.size(),4);
        assertTrue(actual.containsKey("4"));
        assertTrue(actual.containsKey("1"));
        assertFalse(actual.containsKey("387456"));
    }
    @Test
    public void getProductWithValidIdOK(){
        //Given
        ProductRepo testRepo = setup();
        String validId = "2";
        //When
        Product actual = testRepo.getProductById(validId);
        //Then
        assertEquals(actual.getId(),validId);
        assertEquals(actual.getName(),"Wasser");
    }
    @Test
    public void getProductWithInvalidIdShouldFail(){
        //Given
        ProductRepo testRepo = setup();
        String invalidId = "836587";
        //When
        try {
            testRepo.getProductById(invalidId);
            fail();
        } catch (IllegalArgumentException actual){
            //Then
            assertEquals("Produkt mit der ID 836587 nicht gefunden.",actual.getMessage());
        }
    }
    @Test
    public void addNewProductWithNewId(){
        //Given
        ProductRepo testRepo = setup();
        Product productToAdd = new Product("5","Kartoffeln");
        //When
        Product actual = testRepo.addNewProduct(productToAdd);
        //Then
        assertEquals(actual.getName(),"Kartoffeln");
        assertEquals(testRepo.listAllProducts().size(),5);
    }

    @Test
    public void addNewProductWithExistigId(){
        //Given
        ProductRepo testRepo = setup();
        Product productToAdd = new Product("1","Kartoffeln");
        //When
        try {
            testRepo.addNewProduct(productToAdd);
            fail();
        } catch (IllegalArgumentException actual){
            //Then
            assertEquals("Id "+productToAdd.getId()+" existiert schon.",actual.getMessage());
        }
    }
    @Test
    public void removeWithExistingId(){
        //Given
        ProductRepo testRepo = setup();
        String removeId = "2";
        //When
        Product actual = testRepo.removeProductById(removeId);
        //Then
        assertEquals(actual.getName(),"Wasser");
        assertEquals(testRepo.listAllProducts().size(),3);
        assertFalse(testRepo.listAllProducts().containsKey(removeId));
    }

    @Test
    public void removeWithNotExistingId(){
        //Given
        ProductRepo testRepo = setup();
        String removeId = "9";
        //When
        try {
            Product actual = testRepo.removeProductById(removeId);
            fail();
        } catch (IllegalArgumentException actual){
            //Then
            assertEquals("ProduktID "+removeId+" nicht gefunden.",actual.getMessage());
        }
    }

    //Hilfsfunktionen

    public ProductRepo setup(){
        Product product1 = new Product("1","Bier");
        Product product2 = new Product("2","Wasser");
        Product product3 = new Product("3","Brot");
        Product product4 = new Product("4","Klopapier");
        return new ProductRepo(new HashMap<>(Map.of(
                product1.getId(),product1,
                product2.getId(),product2,
                product3.getId(),product3,
                product4.getId(),product4
        )));
    }

}