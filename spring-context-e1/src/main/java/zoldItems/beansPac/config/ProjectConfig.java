//package zoldItems.beansPac.config;
//
////import beans.MyBean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//
//
//@Configuration
//@ComponentScan(basePackages = "zoldItems/beansPac")
//public class ProjectConfig{
//
//}
//
///*
//@Configuration  // tells spring that this is a configuration class
//public class ProjectConfig {
//
//    // we want to return the instance of MyBean to be placed in the spring context
//
//   // @Bean  // tells spring to place "MyBean (the instance)" in the spring context
//    public MyBean myBean1(){
//        MyBean b = new MyBean();
//        b.setSomeText("For bean 1");
//        return b;
//    }
//    //@Primary  // if there are multiple instance -> it defaults to this because of the @Primary
//    @Bean
//    public MyBean myBean2(){
//        MyBean b2 = new MyBean();
//        b2.setSomeText("the bean 2");
//        return b2;
//    }
//
//    @Bean
//    public MyBean myOtherBean(){
//        MyBean anotherOne = new MyBean();
//        anotherOne.setSomeText("another bean - myother bean");
//        return anotherOne;
//    }
//
//    // specify another name for the method
//    @Bean("FrankBean")
//    public MyBean frankBean(){
//        MyBean a = new MyBean();
//        a.setSomeText("frank bean");
//        return a;
//    }
//
//}
//*/