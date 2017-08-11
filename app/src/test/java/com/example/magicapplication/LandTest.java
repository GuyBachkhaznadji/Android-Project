package com.example.magicapplication;


import org.junit.Before;
import org.junit.Test;
import static junit.framework.Assert.*;

public class LandTest extends CardTestTemplate {

    Land land1;


    @Before
    public void before(){
        land1 = new Land("Green", 0);
    }

    @Test
    public void testGetCost(){
        assertEquals( 0, land1.getCost(), 0.01 );
    }

    @Test
    public void testGetColour(){
        assertEquals( "Green", land1.getColour() );
    }

    @Test
    public void testGetTapped(){
        assertEquals( false, land1.getTapped() );
    }

    @Test
    public void testSetTapped(){
        land1.setTapped(true);
        assertEquals( true, land1.getTapped() );
    }

}
