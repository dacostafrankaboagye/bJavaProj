package main.java.entities;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Human extends Entity{

    private int amour;

    public Human(String name, int health, int damage, int amour){
        super(name, health, damage);
        this.amour = amour;
    }

    @Override
    public void takeDamage() {
        this.damage = this.damage - amour;
        if(this.damage < 0){this.damage = 0;}
        super.takeDamage();
    }

    public void eatForStrength(int amount){}
}
