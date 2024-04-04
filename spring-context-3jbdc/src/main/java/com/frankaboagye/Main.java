package com.frankaboagye;

import Config.ProjectConfig;
import model.Product;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repositories.ProductRepository;

import java.util.List;

public class Main {
    public static void main(String[] args) {

            try(
                    var c = new AnnotationConfigApplicationContext(ProjectConfig.class);
            ){

                ProductRepository productRepository = c.getBean(ProductRepository.class);
                /*
                Product product = new Product();
                product.setName("tesla model s");
                product.setPrice(75000);

                productRepository.addProduct(product);

                 */

                List<Product> products = productRepository.getProducts();

                products.forEach(System.out::println);


            }

    }
}