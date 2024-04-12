package test.java.entities;

import main.java.entities.Entity;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestEntity {
    Entity entity;

    @Before
    public void runBefore(){
        entity = new Entity("xyz-Entity", 100, 0);
    }

    @Test
    public void testInstantiation(){
        assertEquals(entity.getName(), "xyz-Entity");
        assertEquals(entity.getHealth(), 100);
        assertEquals(entity.getDamage(), 0);
    }

    @Test
    public void testTakeDamage(){
        entity.setDamage(30);
        entity.takeDamage();
        assertEquals(entity.getHealth(), 70);
    }
    // will implement other test later

    @After
    public void runAfter(){
        entity = null;
    }

}
