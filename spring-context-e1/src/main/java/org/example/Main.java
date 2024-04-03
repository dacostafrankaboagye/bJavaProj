package org.example;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.ProductDeliveryService;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext aCaContext = new AnnotationConfigApplicationContext(ProjectConfig.class);

        ProductDeliveryService service =  aCaContext.getBean(ProductDeliveryService.class);

        service.addSomeProduct();

    }
}
