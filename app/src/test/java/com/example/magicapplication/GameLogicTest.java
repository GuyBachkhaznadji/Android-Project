package com.example.magicapplication;

import org.junit.Before;
import org.junit.Test;
import org.junit.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import static junit.framework.Assert.*;
import org.mockito.*;
import static org.mockito.Mockito.*;


public class GameLogicTest {

    GameLogic game;
    GameLogic game2;
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
    Creature card11;
    Land card12;
    Land card13;
    Land card14;
    ArrayList<Card> deck;
    Player spyPlayer;
    GameLogic spyGame;

    @Before
    public void before(){
        card1 = new Land("Forest", "Green");
        card2 = new Land("Forest", "Green");
        card3 = new Land("Forest", "Green");
        card4 = new Land("Forest", "Green");
        card5 = new Land("Forest", "Green");
        card6 = new Creature("Bond Beetle", "Green", 1, 0, 1);
        card7 = new Creature("Hydra", "Green", 8, 8 , 8);
        card8 = new Creature("Garruk's Companion", "Green", 2, 3, 2);
        card9 = new Creature("Scute Mob", "Green", 1, 1, 1);
        card10 = new Creature("Pelkka Wurm", "Green", 7, 7, 7);
        card11 = new Creature("Vigor", "Green", 6, 6, 6);
        card12 = new Land("Forest", "Green");
        card13 = new Land("Forest", "Green");
        card14 = new Land("Forest", "Green");
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
        spyGame = Mockito.spy(game);
        spyPlayer = Mockito.spy(player1);
        game2 = new GameLogic(spyPlayer, player2);
    }

    @Test
    public void testHasPlayedLand(){
        assertEquals(false, game.hasPlayedLand() );
    }

    @Test
    public void testGetActivePlayer(){
        assertEquals(player1, game.getActivePlayer());
    }

    @Test
    public void testSetActivePlayer(){
        game.setActivePlayer(1);
        assertEquals(player2, game.getActivePlayer());
    }

    @Test
    public void testNextPlayer__player2(){
        game.nextPlayer();
        assertEquals(player2, game.getActivePlayer());
    }

    @Test
    public void testNextPlayer__player1(){
        game.nextPlayer();
        game.nextPlayer();
        assertEquals(player1, game.getActivePlayer());
    }

    @Test
    public void testGetRound(){
        assertEquals("Main", game.getRound());
    }

    @Test
    public void testSetRound(){
        game.setRound(5);
        assertEquals("Swap", game.getRound());
    }

    @Test
    public void testNextRound__Main1(){
        game.setRound(5);
        game.nextRound();
        assertEquals("Main", game.getRound());
    }

    @Test
    public void testNextRound__Attack(){
        game.nextRound();
        assertEquals("Attack", game.getRound());
    }

    @Test
    public void testPlayableCards__card6(){
        Mockito.when(spyPlayer.getHasPlayedLand()).thenReturn(true);
        Mockito.when(spyPlayer.getUntappedLandSize()).thenReturn(5);
        assertEquals(Arrays.asList(card6), game2.playableCards(spyPlayer));
    }

    @Test
    public void testPlayableCards__Land(){
        Mockito.when(spyPlayer.getHasPlayedLand()).thenReturn(false);
        Mockito.when(spyPlayer.getUntappedLandSize()).thenReturn(5);
        assertEquals(Arrays.asList(card1, card2, card3, card4, card5, card6), game2.playableCards(spyPlayer));
    }

    @Test
    public void testPlayableCards__card6Card7(){
        Mockito.when(spyPlayer.getHasPlayedLand()).thenReturn(true);
        Mockito.when(spyPlayer.getUntappedLandSize()).thenReturn(8);
        assertEquals(Arrays.asList(card6, card7), game2.playableCards(spyPlayer));
    }

    @Test
    public void testPlayCard__Land(){
        game2.playCard(card1, spyPlayer);
        assertEquals(true, game2.getActivePlayer().getHasPlayedLand());
        assertEquals(Arrays.asList(card1), game2.getActivePlayer().getActiveLand());
    }


    @Test
    public void testPlayCard__Creature(){
        ArrayList<Land> land = new ArrayList<Land>();
        game2.getActivePlayer().playLand(card1);
        game2.getActivePlayer().playLand(card2);
        game2.getActivePlayer().playLand(card3);
        game2.playCard(card6, spyPlayer);
        int result = game2.getActivePlayer().getUntappedLandSize();
        assertEquals(2, result, 0.01);
    }

    @Test
    public void testGetPlayer1Creature(){
        assertEquals(Arrays.asList(), game.getPlayer1Creatures());
    }

    @Test
    public void testAddPlayer1Creature(){
        game.addPlayer1Creatures(card6);
        assertEquals(Arrays.asList(card6), game.getPlayer1Creatures());
    }

    @Test
    public void testRemovePlayer1Creature(){
        game.addPlayer1Creatures(card6);
        game.addPlayer1Creatures(card7);
        game.removePlayer1Creatures(card6);
        assertEquals(Arrays.asList(card7), game.getPlayer1Creatures());
    }

    @Test
    public void testGetPlayer2Creature(){
        assertEquals(Arrays.asList(), game.getPlayer2Creatures());
    }

    @Test
    public void testAddPlayer2Creature(){
        game.addPlayer2Creatures(card6);
        assertEquals(Arrays.asList(card6), game.getPlayer2Creatures());
    }

    @Test
    public void testRemovePlayer2Creature(){
        game.addPlayer2Creatures(card6);
        game.addPlayer2Creatures(card7);
        game.removePlayer2Creatures(card6);
        assertEquals(Arrays.asList(card7), game.getPlayer2Creatures());
    }

    @Test
    public void testAddCreatureToBattlefield__Player1(){
        game.addCreatureToBattlefield(card6, player1);
        assertEquals(Arrays.asList(card6), game.getPlayer1Creatures());
    }

    @Test
    public void testAddCreatureToBattlefield__Player2(){
        game.addCreatureToBattlefield(card6, player2);
        assertEquals(Arrays.asList(card6), game.getPlayer2Creatures());
    }

    @Test
    public void testGetActiveAttackers(){
        assertEquals(Arrays.asList(), game.getActiveAttackers());
    }


    @Test
    public void testAddActiveAttackers(){
        game.addActiveAttacker(card6);
        assertEquals(Arrays.asList(card6), game.getActiveAttackers());
        assertEquals(true, card6.getAttacking());
    }

    @Test
    public void testRemoveActiveAttackers(){
        game.addActiveAttacker(card6);
        game.addActiveAttacker(card7);
        game.removeActiveAttacker(card7);
        assertEquals(Arrays.asList(card6), game.getActiveAttackers());
    }

    @Test
    public void testGetPlayer(){
        assertEquals(player2, game.getPlayer(1) );
    }

    @Test
    public void testAttack(){
        game.addActiveAttacker(card8);
        game.addActiveAttacker(card7);
        assertEquals(11, game.attack(player2));
        assertEquals(9, game.getPlayer(1).getLifePoints(), 0.01 );
        assertEquals(true, card8.getTapped() );
        assertEquals(false, card8.getAttacking() );
        assertEquals(Arrays.asList(), game.getActiveAttackers() );
        assertEquals(9, game.getPlayer(1).getLifePoints(), 0.01 );
    }

    @Test
    public void testAnyoneDead__false(){
        assertEquals(false, game.anyoneDead() );
    }

    @Test
    public void testAnyoneDead__0True(){
        player1.removeLifePoints(20);
        assertEquals(true, game.anyoneDead() );
    }

    @Test
    public void testAnyoneDead__True(){
        player1.removeLifePoints(30);
        assertEquals(true, game.anyoneDead() );
    }

    @Test
    public void testWhoDead(){
        player1.setDead(true);
        assertEquals(player1, game.whoDead() );
    }

}

