package main.java.entities;

import lombok.*;

@AllArgsConstructor
@Getter @Setter
public class Entity {
    protected String name;
    protected int health;
    protected int damage;


    public void takeDamage(){
        this.health = this.health - this.damage;
        if(this.health < 0){this.health =0;}
    }
}
