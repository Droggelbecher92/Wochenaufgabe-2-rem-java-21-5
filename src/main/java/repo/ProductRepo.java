package repo;

import model.Product;

import java.util.HashMap;
import java.util.Optional;

public class ProductRepo {

    private HashMap<String, Product> productRepo;

    public ProductRepo(HashMap<String, Product> productRepo) {
        this.productRepo = productRepo;
    }

    public HashMap<String,Product> listAllProducts(){
        return this.productRepo;
    }

    public Product getProductById (String whichId){
        Optional<Product> optionalProduct = Optional.ofNullable(productRepo.get(whichId));
        if (optionalProduct.isPresent()){
            return optionalProduct.get();
        }
        throw new IllegalArgumentException("Produkt mit der ID "+whichId+" nicht gefunden.");
    }

    public Product addNewProduct(Product productToAdd){
        if (productRepo.containsKey(productToAdd.getId())){
            throw new IllegalArgumentException("Id "+productToAdd.getId()+" existiert schon.");
        }
        productRepo.put(productToAdd.getId(),productToAdd);
        return productToAdd;
    }

    public Product removeProductById(String whichId){
        Optional<Product> optionalProduct = Optional.ofNullable(productRepo.get(whichId));
        if (optionalProduct.isPresent()){
            return productRepo.remove(whichId);
        }
        throw new IllegalArgumentException("ProduktID "+whichId+" nicht gefunden.");
    }
}
