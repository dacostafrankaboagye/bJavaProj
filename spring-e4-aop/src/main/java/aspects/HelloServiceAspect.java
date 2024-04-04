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



    // its completely decoupled -- so you don't know what the method is returning: so the return type is Object
    @Around("execution(* services.HelloService.hello(..))")
    public Object around(ProceedingJoinPoint joinPoint){ // Note: the method is represented by the jointPoint parameter
        System.out.println("this is something else");
        return "another thing - here - a string";

    }*/

    // let's use the jointPoint
        // generally adviced against this.
        // use aspects as decorators . not as replacers
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
