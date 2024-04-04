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
