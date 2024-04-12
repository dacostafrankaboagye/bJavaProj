package test.java.environment;

import main.java.entities.Alien;
import main.java.entities.Entity;
import main.java.entities.Human;
import main.java.environment.Enviroment;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestEnviroment {

    Enviroment enviroment;
    Entity human;
    Entity alien;

    @Before
    public void runBefore(){
        enviroment = new Enviroment();
        human = new Human("human-1", 100, 0, 10);
        alien = new Alien("alien-1", 100, 0, true);
        enviroment.addEntity(human);
        enviroment.addEntity(alien);
    }

    @Test
    public void testInstantiation(){
        enviroment.getEntities().forEach(entity -> {
            assertEquals(entity.getHealth(), 100);
        });
    }

    // will implement other test later

    @After
    public void runAfter(){
        human = null;
        alien = null;
        enviroment = null;
    }
}
