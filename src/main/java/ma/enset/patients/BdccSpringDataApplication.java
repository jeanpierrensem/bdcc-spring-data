package ma.enset.patients;

import ma.enset.patients.entity.*;
import ma.enset.patients.web.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;

@SpringBootApplication
public class BdccSpringDataApplication {
    ProductController productController ;

    public BdccSpringDataApplication(ProductController productController) {
        this.productController = productController;
    }

    public static void main(String[] args) {
        SpringApplication.run(BdccSpringDataApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(){
        return args-> {
            //ajouter un produit
           productController.saveProduct( Product.builder()
                    .name("Computer")
                    .price(15000)
                    .quantite(20)
                    .build());

            productController.saveProduct(Product.builder()
                    .name("Printer")
                    .price(20000)
                    .quantite(40)
                    .build());

            productController.saveProduct(Product.builder()
                    .name("Scanner")
                    .price(4000)
                    .quantite(90)
                    .build());

            productController.getAllProducts().forEach(System.out::println);
        };


    }
}
