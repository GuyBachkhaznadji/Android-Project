package com.example.magicapplication;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static junit.framework.Assert.*;

public class PlayerTest {

    Player player1;
    Land card1;
    Land card2;
    Land card3;
    Land card4;
    Land card5;
    Creature card6;
    Creature card7;
    Creature card8;
    Creature card9;
    Creature card10;
    ArrayList<Card> deck;

    @Before
    public void before(){
        card1 = new Land("Forest", "Green");
        card2 = new Land("Forest", "Green");
        card3 = new Land("Forest", "Green");
        card4 = new Land("Forest", "Green");
        card5 = new Land("Forest", "Green");
        card6 = new Creature("Bond Beetle", "Green", 1, 0, 1);
        card7 = new Creature("Hydra", "Green", 8, 8 , 8);
        card7 = new Creature("Garruk's Companion", "Green", 2, 3, 2);
        card8 = new Creature("Scute Mob", "Green", 1, 1, 1);
        card9 = new Creature("Pelkka Wurm", "Green", 7, 7, 7);
        card10 = new Creature("Vigor", "Green", 6, 6, 6);
        deck = new ArrayList<Card>();
        deck.add(card1);
        deck.add(card2);
        deck.add(card3);
        deck.add(card4);
        deck.add(card5);
        deck.add(card6);
        deck.add(card7);
        deck.add(card8);
        deck.add(card9);
        deck.add(card10);
        player1 = new Player(deck);
    }

    @Test
    public void testGetLifePoints(){
        assertEquals(20, player1.getLifePoints(), 0.01);
    }

    @Test
    public void testSetLifePoints(){
        player1.setLifePoints(10);
        assertEquals(10, player1.getLifePoints(), 0.01);
    }

    @Test
    public void testAddLifePoints(){
        player1.addLifePoints(5);
        assertEquals(25, player1.getLifePoints(), 0.01);
    }

    @Test
    public void testRemoveLifePoints(){
        player1.removeLifePoints(5);
        assertEquals(15, player1.getLifePoints(), 0.01);
    }

    @Test
    public void testGetHandSize(){
        assertEquals(0, player1.getHandSize(), 0.01);
    }

    @Test
    public void testAddHandCard(){
        player1.addHandCard(card1);
        assertEquals(1, player1.getHandSize(), 0.01);
    }

    @Test
    public void testRemoveHandCard(){
        player1.addHandCard(card1);
        player1.addHandCard(card2);
        player1.removeHandCard(card2);
        assertEquals(Arrays.asList(card1), player1.getHand());
    }

    @Test
    public void testGetHand(){
        player1.addHandCard(card1);
        assertEquals(Arrays.asList(card1), player1.getHand());
    }

    @Test
    public void testGetDeckSize(){
        assertEquals(10, player1.getDeckSize(), 0.01 );
    }

    @Test
    public void testGetGraveyardSize(){
        assertEquals(0, player1.getGraveyardSize(), 0.01);
    }

    @Test
    public void testAddToGraveyard(){
        player1.addToGraveyard(card1);
        assertEquals(1, player1.getGraveyardSize(), 0.01);
    }

    @Test
    public void testRemoveFromGraveyard(){
        player1.addToGraveyard(card1);
        player1.addToGraveyard(card2);
        player1.removeFromGraveyard(card1);
        assertEquals(1, player1.getGraveyardSize(), 0.01);
    }

    @Test
    public void testGetGraveyard(){
        player1.addToGraveyard(card1);
        player1.addToGraveyard(card2);
        assertEquals(Arrays.asList(card1, card2), player1.getGraveyard());
    }

    @Test
    public void testPlayLand(){
        player1.playLand(card1);
        assertEquals(1, player1.getPlayedLandSize(), 0.01);
    }

    @Test
    public void testGetPlayedLand(){
        player1.playLand(card1);
        assertEquals(Arrays.asList(card1), player1.getPlayedLand());
    }

    @Test
    public void testGetUntappedLand(){
        player1.playLand(card1);
        player1.playLand(card2);
        card3.setTapped(true);
        player1.playLand(card3);
        assertEquals(Arrays.asList(card1, card2), player1.getUntappedLand() );
    }

    @Test
    public void testDrawCard(){
        player1.drawCard();
        assertEquals(Arrays.asList(card1), player1.getHand() );
        assertEquals(9, player1.getDeckSize(), 0.01 );
    }


    @Test
    public void testStart(){
        player1.start();
        assertEquals(Arrays.asList(card1, card2, card3, card4, card5, card6, card7), player1.getHand() );
        assertEquals(3, player1.getDeckSize(), 0.01 );
    }

}
