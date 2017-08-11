package com.example.magicapplication;

import org.junit.Before;
import org.junit.Test;
import static junit.framework.Assert.*;


public class CreatureTest extends CardTestTemplate {

    Creature creature1;

    @Before
    public void before(){
        creature1 = new Creature( "Bond Beetle", "Green", 5, 0, 1);
    }

    @Test
    public void testGetCost(){
        assertEquals( 5, creature1.getCost(), 0.01 );
    }

    @Test
    public void testGetName(){
        assertEquals( "Bond Beetle", creature1.getName() );
    }

    @Test
    public void testGetColour(){
        assertEquals( "Green", creature1.getColour() );
    }


    @Test
    public void testGetTapped(){
        assertEquals( true, creature1.getTapped() );
    }

    @Test
    public void testSetTapped(){
        creature1.setTapped(false);
        assertEquals( false, creature1.getTapped() );
    }


    @Test
    public void testGetAttacking(){
        assertEquals( false, creature1.getAttacking() );
    }

    @Test
    public void testSetAttacking(){
        creature1.setAttacking(true);
        assertEquals( true, creature1.getAttacking() );
    }

    @Test
    public void testGetAttack(){
        assertEquals( 0, creature1.getAttack(), 0.01 );
    }

    @Test
    public void testSetAttack(){
        creature1.setAttack(1);
        assertEquals( 1, creature1.getAttack(), 0.01 );
    }

    @Test
    public void testGetDefence(){
        assertEquals( 1, creature1.getDefence(), 0.01 );
    }

    @Test
    public void testSetDefence(){
        creature1.setDefence(2);
        assertEquals( 2, creature1.getDefence(), 0.01 );
    }


}
