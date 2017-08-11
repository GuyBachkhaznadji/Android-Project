package com.example.magicapplication;

import org.junit.Before;
import org.junit.Test;
import static junit.framework.Assert.*;


public class CreatureTest extends CardTestTemplate {

    Creature creature1;

    @Before
    public void before(){
        creature1 = new Creature("Green", 5);
    }

    @Test
    public void testGetCost(){
        assertEquals( 5, creature1.getCost(), 0.01 );
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



}
