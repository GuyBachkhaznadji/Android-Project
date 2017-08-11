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


}
