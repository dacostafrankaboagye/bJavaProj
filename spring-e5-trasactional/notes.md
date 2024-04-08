## working with database
 - when working with a database we need a data source to create a jdbc Template
 - we need to "register a bean that returns datasource"
   - use a driver-manager-datasource - it is simple in terms of configuration

```java
@Configuration
public class ProjectConfig {
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource myDataSource = new DriverManagerDataSource();
        myDataSource.setUrl("jdbc:mysql://localhost/demo?serverTimezone=America/New_York");
        myDataSource.setUsername("root");
        myDataSource.setPassword("70722023Frank");        
        return myDataSource;
    }
}
```

## Jdbc Template
 - makes it easy to work with the database
   - to send and execute queries
```java

package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class ProjectConfig {
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource myDataSource = new DriverManagerDataSource();
        myDataSource.setUrl("jdbc:mysql://localhost/demo?serverTimezone=America/New_York");
        myDataSource.setUsername("root");
        myDataSource.setPassword("70722023Frank");
        return myDataSource;
    }
    
    @Bean    
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
    
    // or
    @Bean
    public JdbcTemplate jdbcTemplate(){
       return new JdbcTemplate(dataSource());
    }
}


```

## Transaction
 - Transaction Manager
   - will be needed as the object that manages the "transaction-ability" in the project

 - Have it in your context
   - it is represented by by the interface "PlatformTransactionManager"
   - "PlatformTransactionManager"
     - it is that interface / contract that needs to be implemented by any object that is implementing
       a transaction manager in spring 
```java

@Configuration
public class ProjectConfig {
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource myDataSource = new DriverManagerDataSource();
        myDataSource.setUrl("jdbc:mysql://localhost/demo?serverTimezone=America/New_York");
        myDataSource.setUsername("root");
        myDataSource.setPassword("70722023Frank");
        return myDataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public PlatformTransactionManager platformTransactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
}
 ```

## Note - this  with Transaction
    - mostly what you want is that, you want to execute all of them
        - or none of them

    - so if you encounter any exceptions -> you dont what the operations that 
        - have already been done to persist

    - Atomicity is a property of database transactions that ensures that a set of database operations 
        either all occur, or none occur.

    - in this way, we avoid logical inconsistencies

```java
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void addOneProduct(){
        productRepository.addProduct("Mac Book Pro", 133.25);
        throw new RuntimeException(":((--");
    }
}

/*
        The Mac-Book Pro , with the price of 133.25 -> still goes into the database
        -> but an exception occurred? -> the data too is persisting --? this is what we want to avoid
        
        
 */
```

## How do we solve this ? - TrasactionManagement
- Enable Transaction Management in the project config file
```java
@Configuration
@EnableTransactionManagement // enabling the transaction managment
@ComponentScan(basePackages = {"repositories", "services"})
public class ProjectConfig {
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource myDataSource = new DriverManagerDataSource();
        myDataSource.setUrl("jdbc:mysql://localhost/demo?serverTimezone=America/New_York");
        myDataSource.setUsername("root");
        myDataSource.setPassword("70722023Frank");
        return myDataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public PlatformTransactionManager platformTransactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
}

```

## specify the usecase - the method you want to wrap around the transaction
```java
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public void addOneProduct(){
        productRepository.addProduct("Toyota Corolla", 22050.00);
        throw new RuntimeException(":((--");
    }
    // if error occurs, there will be a rollback
    // a transaction is started before the execution of the method
    // a transaction is will commit at the end of the method
}

```
- @Transactional could be place above the class too

## Note
    - for the Transaction, (the rollback happens by default for RuntimeException but does not rollback checked Exception)
    - so there are rules

## changing the default
```java

@Transactional(noRollbackFor = RuntimeException.class) 
public void addOneProduct(){
    productRepository.addProduct("Maruti S-Presso", 73000.00);

}

@Transactional(rollbackFor = Exception.class)
public void addOneProduct(){
        productRepository.addProduct("Maruti S-Presso", 73000.00);

}
```

## Note

- It is not about throwing an exception
- but the exception has to be propagated outside of the method
- e.g
  - if you catch the exception inside of the method, it will not be seen by the transaction / or in general, the aspect
```java

// data will still persist -> we donot want that

    @Transactional
    public void addAnother() {
        productRepository.addProduct("Bicycle old", 150.00);
        try{
            throw new RuntimeException("::))");
        }catch (RuntimeException e){
            System.out.println("An exception occurred!!!  >> " + e.getMessage());
        }
    }
```