package com.example.magicapplication;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public abstract class CardTestTemplate {

    @Before
    public abstract void before();

    @Test
    public abstract void testGetName();

    @Test
    public abstract void testGetCost();

    @Test
    public abstract void testGetColour();

    @Test
    public abstract void testGetTapped();

    @Test
    public abstract void testSetTapped();

}
