

## Transaction Propagation

- Theory
  - lets, say you call another method from another method
    - when is the transaction created?
    - when is the transaction committed / rollback?
    - are there multiple transactions?

- There is a default
- there are other 6 levels of propagation
 ---
- Default
  - default propagation level  = required
  
```java
@Transactional(Propagation.REQUIRED)
@Transactional(Propagation.REQUIRES_NEW)
@Transactional(Propagation.MANDATORY)
@Transactional(Propagation.NEVER)
@Transactional(Propagation.SUPPORTS)
@Transactional(Propagation.NOT_SUPPORTED)

@Transactional(Propagation.NESTED) 


```

## Note
  - if you specify Transactional on a class
    - all the methods use it
      - but you can specify for "a different one" for some method
  - e..g
```java

@Transactional(propagation = Propagation.REQUIRED)
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional(propagation = Propagation.MANDATORY) // at the method level, overrides what is in the class
    public void addTenProduct(){
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
            productRepository.addProduct(theProduct.getKey(), theProduct.getValue());
        }

    }


}


```

## @Transactional(Propagation.REQUIRED)
  - the default - can choose not to specify it
  - it first checks it there is a transaction and uses it
    - if the method calls another method with a propagation level of "REQUIRED", it uses the same transaction
    - 

```java


@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    public void addTenProduct(){
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
            productRepository.addProduct(theProduct.getKey(), theProduct.getValue());
        }

    }


}

```

```java
package repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ProductRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(propagation = Propagation.REQUIRED)
    public void addProduct(String name, double price){
        String sql  =  "INSERT INTO product VALUES (NULL, ?, ?)";
        jdbcTemplate.update(sql, name, price);

    }


}

```

```md
// output
id    name               price     
20	Headphones           150
21	Fitness Tracker	     80
22	Laptop	             1200
23	External Hard Drive	 200
24	Wireless Speaker	 100
25	Tablet	             500
26	Camera	             1000
27	Drone	             1500
28	Smartphone	         800
29	Smartwatch	         300


```
---

## changing the inner method to - REQUIRES_NEW

```java

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    public void addTenProduct(){

        for(int i=0; i <11; i++){
            productRepository.addProduct("Product " + i, i);
            if(i == 5){throw new RuntimeException(">> exception here <<");}
        }

    }


}

```

---

```java

    @Transactional(propagation = Propagation.REQUIRES_NEW) // new transaction is created each time
    public void addProduct(String name, double price){
        String sql  =  "INSERT INTO product VALUES (NULL, ?, ?)";
        jdbcTemplate.update(sql, name, price);

    }
```

```md
// output

'49', 'Product 0', '0'
'50', 'Product 1', '1'
'51', 'Product 2', '2'
'52', 'Product 3', '3'
'53', 'Product 4', '4'
'54', 'Product 5', '5'


```

## @Transactional(Propagation.MANDATORY)
- there should be a Transaction
- Opposite is Propagation.NERVER

## @Transactional(Propagation.NOT_SUPPORTED)
- no transaction
## @Transactional(Propagation.SUPPORTS)
- call the method with or without transaction
- if you call it without a transaction, it will execute
- If you call it with a transaction, it uses that transaction
