package beansPac;

import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/*
A bean is class whose instances will be placed in spring context
 */
@Repository
public class MyBean {

    private String aText;
    @PostConstruct
    private void init(){
        this.aText = "for test beans";
    }

    public String getaText() {
        return aText;
    }

    public void setaText(String aText) {
        this.aText = aText;
    }

//    public String getSomeText() {
//        return this.aText;
//    }





}
