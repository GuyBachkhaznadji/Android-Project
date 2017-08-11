package com.example.magicapplication;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

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

//    public ArrayList<Card> getHand() {
//        return hand;
//    }
//
//    public void addHandCard(Card card) {
//        this.hand.add(card);
//    }
//
//    public void removeHandCard(Card card) {
//        this.hand.remove(card);
//    }
//
//    public ArrayList<Land> getPlayedLand() {
//        return playedLand;
//    }
//
//    public void addActiveLand(Land land) {
//        this.hand.add(land);
//    }
//
//    public ArrayList<Card> getDeck() {
//        return deck;
//    }
//
//    public void setDeck(ArrayList<Card> deck) {
//        this.deck = deck;
//    }
//
//    public ArrayList<Card> getGraveyard() {
//        return graveyard;
//    }

}
