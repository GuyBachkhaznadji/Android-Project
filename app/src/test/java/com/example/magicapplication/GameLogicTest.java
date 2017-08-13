package com.example.magicapplication;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import static junit.framework.Assert.*;


public class GameLogicTest {

    GameLogic game;
    Player player1;
    Player player2;
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
        player2 = new Player(deck);
        game = new GameLogic(player1, player2);
    }

    @Test
    public void testHasPlayedLand(){
        assertEquals(false, game.hasPlayedLand() );
    }


}

