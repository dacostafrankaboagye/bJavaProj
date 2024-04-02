package beans;
/*
A bean is class whose instances will be placed in spring context
 */
public class MyBean {

    private String someText;

    public String getSomeText() {
        return someText;
    }

    public void setSomeText(String someText) {
        this.someText = someText;
    }


}
