package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import repositories.ProductRepository;

import java.util.HashMap;
import java.util.Map;


@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    public void addTenProduct(){

        /*
        Map<String, Double> productMap = new HashMap<>() {{
            put("Laptop", 1200.0);
            put("Smartphone", 800.0);
            put("Tablet", 500.0);
            put("Smartwatch", 300.0);
            put("Headphones", 150.0);
            put("Camera", 1000.0);
            put("Drone", 1500.0);
            put("Fitness Tracker", 80.0);
            put("External Hard Drive", 200.0);
            put("Wireless Speaker", 100.0);
        }};

        for(Map.Entry<String, Double> theProduct : productMap.entrySet()){

            // intentionally throwing an exception
            if (theProduct.getKey().equals("Headphones")) {
                throw new RuntimeException(">> exception <<");
            }
            productRepository.addProduct(theProduct.getKey(), theProduct.getValue());
        }

         */

        for(int i=0; i <11; i++){
            productRepository.addProduct("Product " + i, i);
            if(i == 5){throw new RuntimeException(">> exception here <<");}
        }

    }


}
