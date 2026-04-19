package ma.enset.bdccspringdata.web;

import ma.enset.bdccspringdata.entity.*;
import ma.enset.bdccspringdata.repository.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class ProductController {
    ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Consulter tous les produits
    @GetMapping(value = "/products")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    //Consulter un produit

    //Chercher des produits

    // Ajouter des produits

    //Mettre à jour un produit

    //delete product

}
