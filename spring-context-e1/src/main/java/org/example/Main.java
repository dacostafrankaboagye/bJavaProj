package org.example;

import beansPac.MyBean;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        /*
        XML
        Annotations
         */

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ProjectConfig.class); // as a parameter, you have to configure a spring application class


        MyBean myBean = context.getBean(MyBean.class);
        MyBean myBean2 = context.getBean(MyBean.class);
        MyBean myBean3 = context.getBean(MyBean.class);

        System.out.println(myBean.getaText());

    }
}

// by type
        /*

        MyBean b1 = context.getBean(MyBean.class);
        MyBean b2 = context.getBean(MyBean.class);
        System.out.println(b1.getSomeText());
        System.out.println(b1.getSomeText());



        // by name - we can avoid the error of multiple instance
        MyBean otherOne = context.getBean("myOtherBean",MyBean.class);
        System.out.println(otherOne.getSomeText());

        MyBean b1 = context.getBean("myBean1", MyBean.class);
        System.out.println(b1.getSomeText());



        // using another name for the method @Bean("FrankBean")
        MyBean fBean = context.getBean("FrankBean",MyBean.class);
        System.out.println(fBean.getSomeText());

         */