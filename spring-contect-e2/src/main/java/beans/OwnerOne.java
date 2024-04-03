package beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OwnerOne{

    private CatOne cat;

    @Autowired
    public OwnerOne(CatOne cat){
        this.cat = cat;

    }

    public CatOne getCat() {
        return cat;
    }

    public void setCat(CatOne cat) {
        this.cat = cat;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "cat=" + cat +
                '}';
    }
}
