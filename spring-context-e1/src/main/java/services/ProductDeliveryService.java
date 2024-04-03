package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import repositories.ProductRepository;

//@Component
@Service
public class ProductDeliveryService {

//    @Autowired
    private final ProductRepository productRepository;

    public ProductDeliveryService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }


    public void addSomeProduct(){
        this.productRepository.add();
        this.productRepository.add();
    }
}
