package test.java.entities;

import main.java.entities.Entity;
import main.java.entities.Human;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TestHuman {

    Human human;

    @Before
    public void runBefore(){
        human = new Human("human-1", 100, 0, 10);
    }

    @Test
    public void testInstantiation(){
        assertEquals(human.getName(), "human-1");
        assertEquals(human.getAmour(), 10);
        assertEquals(human.getDamage(), 0);
        assertEquals(human.getHealth(), 100);
    }

    @Test
    public void testTakeDamage(){
        human.setDamage(30);
        human.takeDamage();
        assertEquals(human.getDamage(), 20);
        assertEquals(human.getHealth(), 80);
    }

    @After
    public void runAfter(){
        human = null;
    }

}
