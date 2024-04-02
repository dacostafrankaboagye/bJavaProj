package org.example;

import beans.MyBean;
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

        MyBean b1 = context.getBean(MyBean.class);
//        MyBean b2 = context.getBean(MyBean.class);
//
//        System.out.println(b1.getSomeText());
        System.out.println(b1.getSomeText());

    }
}