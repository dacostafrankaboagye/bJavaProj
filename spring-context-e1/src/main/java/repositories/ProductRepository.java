package repositories;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component
@Repository
public class ProductRepository {

    public void add(){
        System.out.println("A new Product Added");
    }
}
