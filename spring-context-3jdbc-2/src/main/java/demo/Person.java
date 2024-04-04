/*package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {

    @Autowired
    private HelloService helloService;

    public void sayHello(String name){
        String message = helloService.sayHello(name);
        System.out.println(message);

    }
}

 */

// ------- since we are using qualifier
package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Person {

    @Autowired
    @Qualifier("english") // the implementation we want to inject -> since they are more than one
    private HelloService helloService;

    public void sayHello(String name){
        String message = helloService.sayHello(name);
        System.out.println(message);

    }
}
