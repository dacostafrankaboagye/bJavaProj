package main.java.entities;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Alien extends Entity{

    private boolean canRegenerate;

    public Alien(String name, int health, int damage, boolean canRegenerate){
        super(name, health,damage);
        this.canRegenerate = canRegenerate;
    }

    public void regenerate(int amount){
        if(this.canRegenerate){
            this.health = this.health + amount;
            if(this.health > 100){this.health = 100;}
        }
    }

    @Override
    public void takeDamage() {
        super.takeDamage();
    }
}
