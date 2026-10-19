package uk.ac.westminster.products_api;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Tutorial 3: owns the product catalogue and the rules about it.
 * Contains no HTTP code at all.
 */
@Service
public class ProductService {

    private List<Product> products = new ArrayList<>();
    private Long nextId = 1L;

    public List<Product> getAllProducts() {
        return products;
    }

    public Optional<Product> getProductById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    public Product addProduct(Product product) {
        product.setId(nextId++); // use the value, then add one
        products.add(product);
        return product;
    }

    public ProductService (){
        products.add(new DigitalProduct(nextId++,"New Software 1",699,"https://newsoftwareurl.html",2.4));
        products.add(new PhysicalProduct(nextId++,"New Poroduct 1", 2899, 23,"23.5"));

    }


    public void deleteProduct(Long id) {
        products.removeIf(p -> p.getId().equals(id));
    }

    public List<Product> findByName(String name) {
        return products.stream()
                .filter(p -> p.getName().contains(name))
                .toList();
    }
}
