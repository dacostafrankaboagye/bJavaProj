## AOP
- Aspect is a decoupled piece of code that intercepts a specific group of methods
  - you have to specify the methods
-  maybe - name aspects as the service you want to intercept
- An aspect should be annotated with @Aspect
```java

// example

package aspects;

import org.aspectj.lang.annotation.Aspect;

@Aspect
public class HelloServiceAspect {
}
//--------------------------------------------


// in the Project Config - example
package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"services"})
@EnableAspectJAutoProxy
public class ProjectConfig {
}


```
---
-  When you use Aspect, enable them in the ProjectConfig - @EnableAspectJAutoProxy

```java

package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"services"})
@EnableAspectJAutoProxy
public class ProjectConfig {
}


```
---

- there must be an instance of the aspect in spring  - : it has to be known by spring
```java
package aspects;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HelloServiceAspect {
}
```

```java

// ------------

package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"services", "aspects"})
@EnableAspectJAutoProxy
public class ProjectConfig {
}



```

```java

package aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HelloServiceAspect {

    // the logic

    @Before("execution(* services.HelloService.hello(..))") // before these groups of methods are executed // note: ".." taking any overloading
    public void before(){
        System.out.println("before just executed o");
    }
}

```

```java

// main

package com.frankaboagye;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.HelloService;

public class Main {
    public static void main(String[] args) {

        try(
                var c = new AnnotationConfigApplicationContext(ProjectConfig.class)
        ){
            HelloService service = c.getBean(HelloService.class);

            String result = service.hello("Frank Aboagye");

            System.out.println(result);


        }

    }
}

/*
        output
        
        before just executed o
        Hello, Frank Aboagye!
 */

```

## Another Example


```java

package services;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String hello(String name){
        return "Hello, " + name + "!";
    }

    public void printHello(String name){
        System.out.println("Hello, " + name + "!");
    }
}

```

```java

package aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HelloServiceAspect {

    // the logic

    @Before("execution(* services.HelloService.hello(..))") // before these groups of methods are executed // note: ".." taking any overloading
    public void before(){
        System.out.println("before just executed o");
    }

    @Before("execution(* services.HelloService.printHello(..))")
    public void beforePrintHello(){
        System.out.println("this is before the print hello method");
    }


}


```

```java

package com.frankaboagye;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.HelloService;

public class Main {
    public static void main(String[] args) {

        try(
                var c = new AnnotationConfigApplicationContext(ProjectConfig.class)
        ){
            HelloService service = c.getBean(HelloService.class);

//            String result = service.hello("Frank Aboagye");
//            System.out.println(result);


            service.printHello("Bernice");


        }

    }
}


/*

            output

this is before the print hello method
Hello, Bernice!


 */
```

## Note

- what if you want to execute if the methods had / did not have / return an Exception


    @After
    -> whether or not your method throws an exception or not

    @AfterReturning
    -> the method only executes when there is no exception
    
    @AfterThrowing
    -> It is executed when the method throws an exception

    @Around
    -> will always have the parameter, ProceedingJointPoint
    -> you can change the value that is returned by the method

```java

package services;

import org.springframework.stereotype.Service;

import java.lang.reflect.Executable;

@Service
public class HelloService {

    public String hello(String name){
        String message =  "Hello, " + name + "!";
        System.out.println(message);
        return message;
    }

    public void printHello(String name){
        System.out.println("Hello, " + name + "!");
//        throw new RuntimeException("an error test");
    }
}

```

```java

package aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HelloServiceAspect {

    /*

    // the logic

    @Before("execution(* services.HelloService.hello(..))") // before these groups of methods are executed // note: ".." taking any overloading
    public void before(){
        System.out.println("before just executed o");
    }

    @Before("execution(* services.HelloService.printHello(..))")
    public void beforePrintHello(){
        System.out.println("this is before the print hello method");
    }

    @After("execution(* services.HelloService.printHello(..))")
    public void AfterPrintHello(){
        System.out.println("after the print hello");
    }

    @AfterReturning("execution(* services.HelloService.printHello(..))")
    public void AfterReturningPrintHello(){
        System.out.println("after returning called - since there is no exception");
    }

    @AfterThrowing("execution(* services.HelloService.printHello(..))")
    public void AfterThrowingPrintHello(){
        System.out.println("after throwing method");
    }

     */

    // its completely decoupled -- so you don't know what the method is returning: so the return type is Object
    @Around("execution(* services.HelloService.hello(..))")
    public Object around(ProceedingJoinPoint joinPoint){ // Note: the method is represented by the jointPoint parameter
        System.out.println("this is something else");
        return "another thing - here - a string";

    }


}

```

```java

package com.frankaboagye;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.HelloService;

public class Main {
    public static void main(String[] args) {

        try(
                var c = new AnnotationConfigApplicationContext(ProjectConfig.class)
        ){
            HelloService service = c.getBean(HelloService.class);

//            String result = service.hello("Frank Aboagye");
//            System.out.println(result);
          
//            service.printHello("Portia");

            // testing other aspects
            String result = service.hello("Godwin"); // the aspect takes charge beause of the @Around
            System.out.println("Result is = " + result);
            
            /*
                    this is something else
                    Result is = another thing - here - a string

             */
        }
    }
}
```

## Using @Around

```java
package services;

import org.springframework.stereotype.Service;

import java.lang.reflect.Executable;

@Service
public class HelloService {

    public String hello(String name){
        String message =  "Hello, " + name + "!";
        System.out.println(message);
        return message;
    }

    public void printHello(String name){
        System.out.println("Hello, " + name + "!");
//        throw new RuntimeException("an error test");
    }
}

```

```java
package aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HelloServiceAspect {

    // let's use the jointPoint
        // generally adviced against this.
        // use aspects as decorators . not as replacers
    @Around("execution(* services.HelloService.hello(..))")
    public Object around(ProceedingJoinPoint joinPoint){
        System.out.println("before the method execution");
        Object result = null;
        try {
            result = joinPoint.proceed();
            System.out.println("after the method execution");
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        return result;

    }


}

```

```java

package com.frankaboagye;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.HelloService;

public class Main {
    public static void main(String[] args) {

        try(
                var c = new AnnotationConfigApplicationContext(ProjectConfig.class)
        ){
            HelloService service = c.getBean(HelloService.class);

//            String result = service.hello("Frank Aboagye");
//            System.out.println(result);


//            service.printHello("Portia");

            // testing other aspects
            String result = service.hello("Godwin");
            System.out.println("Final Result is = " + result);
            
            /*
                    output
            before the method execution
            Hello, Godwin!
            after the method execution
            Final Result is = Hello, Godwin!

             */


        }

    }
}
```

## changing the parameter



```java
package aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HelloServiceAspect {

    
  @Around("execution(* services.HelloService.hello(..))")
  public Object around(ProceedingJoinPoint joinPoint){
    System.out.println("before the method execution");
    Object result = null;
    try {
      //result = joinPoint.proceed();
      result = joinPoint.proceed(new Object[]{"Stella"});// we can do this to change the value of the parameter
      System.out.println("after the method execution");
    } catch (Throwable e) {
      throw new RuntimeException(e);
    }
    return result;

  }


}


/*

                output
        before the method execution
        Hello, Stella!
        after the method execution
        Final Result is = Hello, Stella!
 */
```












