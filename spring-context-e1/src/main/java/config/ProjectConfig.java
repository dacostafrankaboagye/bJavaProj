package config;

import beans.MyBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration  // tells spring that this is a configuration class
public class ProjectConfig {

    // we want to return the instance of MyBean to be placed in the spring context

    @Bean  // tells spring to place "MyBean (the instance)" in the spring context
    public MyBean myBean(){
        MyBean b = new MyBean();
        b.setSomeText("This is an example text");
        return b;
    }
    @Bean
    @Primary
    public MyBean myBean2(){
        MyBean b2 = new MyBean();
        b2.setSomeText("Here is the second one");
        return b2;
    }
}
