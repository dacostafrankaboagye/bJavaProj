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