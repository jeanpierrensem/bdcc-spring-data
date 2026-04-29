package ma.enset.patients.web;

import ma.enset.patients.entity.*;
import ma.enset.patients.repository.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value="/api/products", produces = "application/json")
public class ProductController {
    ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Consulter tous les produits
    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    //Consulter un produit
    @GetMapping(value = "/{id}")
    public Product findById(@PathVariable Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException());
    }

    //Chercher des produits
    @GetMapping(value = "/find")
    public List<Product> findByNameContains(@RequestParam String kw) {
        return productRepository.findByNameContains(kw);
    }

    // Ajouter des produits
    @PostMapping
    public void saveProduct(@RequestBody Product p) {
        productRepository.save(p);
    }


    @PutMapping
    public void update(@RequestBody Product p) {
         productRepository.save(p);
    }

    //delete product
    @DeleteMapping(value = "/del/{id}")
    public void deleteProduct(@PathVariable Long id) {
        Optional<Product> product =  productRepository.findById(id);

        if (product.isPresent()){
            productRepository.delete(product.get());
        }else{
            throw new RuntimeException("Can not find the product");
        }


    }

}
