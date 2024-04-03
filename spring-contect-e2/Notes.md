
## Approach 1
```java
package config;

import beans.Cat;
import beans.Owner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    /*
    @Bean
    public Cat cat(){
        Cat c = new Cat();
        c.setName("PieceCat");
        return c;
    }

    @Bean
    public Owner owner(){
        Owner o = new Owner();
        o.setCat(new Cat());
        return o;
    }



    // we would like to connect them-> call the method in the method

    @Bean
    public Cat cat(){
        Cat c = new Cat();
        c.setName("PieceCat");
        return c;
    }

    @Bean
    public Owner owner(){
        Owner o = new Owner();
        o.setCat(cat()); // calling the method
        return o;
    }*/

    // how does it work
    /*
    - Spring checks if the cat()'s Cat is a bean
    - if it is in the context already, it uses that one "since it already knows the instance"
     */


    //====

    // using autowiring


    @Bean
    public Cat cat(){
        Cat c = new Cat();
        c.setName("PieceCat");
        return c;
    }

    @Bean
    public Owner owner(Cat cat){
        Owner o = new Owner();
        o.setCat(cat); // calling the method
        return o;
    }
    /*
    The above works!!
    -> when you use a parameter to a method that is annotated with @Bean spring checks the context to search for the instance of it
   
     */

}

```

```java
package main;

import beans.Cat;
import beans.Owner;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext aCaContext = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Cat c = aCaContext.getBean(Cat.class);
        Owner o = aCaContext.getBean(Owner.class);

        c.setName("LoyalCat");

        System.out.println(c);
        System.out.println(o);


    }
}
```

```java
package beans;

public class Cat {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}

```
```java
package beans;

public class Owner {

    private Cat cat;

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "cat=" + cat +
                '}';
    }
}

```

---

## Approach 2

    using the stereotypes

```java
```