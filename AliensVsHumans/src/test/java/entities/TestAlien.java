package test.java.entities;

import main.java.entities.Alien;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestAlien {

    Alien alien;

    @Before
    public void runBefore(){
        alien = new Alien("alien-1", 100, 0, true);
    }

    @Test
    public void testInstantiation(){
        assertEquals(alien.getName(), "alien-1");
        assertEquals(alien.getHealth(), 100);
        assertEquals(alien.getDamage(), 0);
        assertTrue(alien.isCanRegenerate());
    }

    @Test
    public void TestRegenerate(){
        alien.setDamage(20);
        alien.takeDamage();
        assertEquals(alien.getHealth(), 80);
        alien.regenerate(10);
        assertEquals(alien.getHealth(), 90);
    }
    // will implement other test later

    @After
    public void runAfter(){
        alien = null;
    }
}
