package com.frankaboagye;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.ProductService;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        try( var c = new AnnotationConfigApplicationContext(ProjectConfig.class)){

            ProductService productService = c.getBean(ProductService.class);

//            productService.addOneProduct();
              productService.addAnother();
        }

    }
}