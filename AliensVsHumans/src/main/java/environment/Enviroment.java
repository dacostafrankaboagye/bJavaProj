package main.java.environment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import main.java.entities.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Getter @Setter
public class Enviroment {
    private ArrayList<Entity> entities;

    public Enviroment(){
        entities = new ArrayList<>();
    }

    public void addEntity(Entity entity){
        entities.add(entity);
    }

    public void removeEntity(Entity entity){
        entities.remove(entity);
    }

    public Entity getDeadEntity(){
        List<Entity> deadEntities = entities.stream()
                                            .filter( e -> e.getHealth() == 0)
                                            .toList();
        return deadEntities.get(0);

    }
}
