package main;

import beans.CatOne;
import beans.OwnerOne;
import config.ProjectConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        try{
            AnnotationConfigApplicationContext aCaContext = new AnnotationConfigApplicationContext(ProjectConfiguration.class);


        CatOne c = aCaContext.getBean(CatOne.class);
        OwnerOne o = aCaContext.getBean(OwnerOne.class);

        //c.setName("LoyalCat");

        System.out.println(c);
        System.out.println(o);
        }catch (Exception e){

        }


    }
}