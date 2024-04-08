package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repositories.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional(noRollbackFor = RuntimeException.class)
    public void addOneProduct(){
        productRepository.addProduct("Maruti S-Presso", 73000.00);
        //throw new RuntimeException(":((--");
    }
    // if error occurs, there will be a rollback
    // a transaction is started before the execution of the method
    // a transaction is will commit at the end of the method

    @Transactional(rollbackFor = RuntimeException.class)
    public void addAnother() {
        productRepository.addProduct("Bicycle old one", 150.00);
        try{
            throw new RuntimeException("::))");
        }catch (RuntimeException e){
            System.out.println("An exception occurred!!!  >> " + e.getMessage());
        }
    }

}
