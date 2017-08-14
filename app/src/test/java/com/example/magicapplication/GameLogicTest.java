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
    Land cardA;
    Land cardB;
    Land cardC;
    Land cardD;
    Land cardE;
    Creature cardF;
    Creature cardG;
    Creature cardH;
    Creature cardI;
    Creature cardJ;
    Creature cardK;
    ArrayList<Card> deck1;
    ArrayList<Card> deck2;
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
        cardA = new Land("Forest", "Green");
        cardB = new Land("Forest", "Green");
        cardC = new Land("Forest", "Green");
        cardD = new Land("Forest", "Green");
        cardE = new Land("Forest", "Green");
        cardF = new Creature("Bond Beetle", "Green", 1, 0, 1);
        cardG = new Creature("Hydra", "Green", 8, 8 , 8);
        cardH = new Creature("Garruk's Companion", "Green", 2, 3, 2);
        cardI = new Creature("Scute Mob", "Green", 1, 1, 1);
        cardJ = new Creature("Pelkka Wurm", "Green", 7, 7, 7);
        cardK = new Creature("Vigor", "Green", 6, 6, 6);
        deck1 = new ArrayList<Card>();
        deck1.add(card1);
        deck1.add(card2);
        deck1.add(card3);
        deck1.add(card4);
        deck1.add(card5);
        deck1.add(card6);
        deck1.add(card7);
        deck1.add(card8);
        deck1.add(card9);
        deck1.add(card10);
        deck2 = new ArrayList<Card>();
        deck2.add(cardA);
        deck2.add(cardB);
        deck2.add(cardC);
        deck2.add(cardD);
        deck2.add(cardE);
        deck2.add(cardF);
        deck2.add(cardG);
        deck2.add(cardH);
        deck2.add(cardI);
        deck2.add(cardJ);
        player1 = new Player(deck1);
        player2 = new Player(deck2);
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
        card6.setTapped(false);
        game.addActiveAttacker(card6);
        assertEquals(Arrays.asList(card6), game.getActiveAttackers());
        assertEquals(true, card6.getAttacking());
    }

    @Test
    public void testRemoveActiveAttackers(){
        card6.setTapped(false);
        card7.setTapped(false);
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
        card7.setTapped(false);
        card8.setTapped(false);
        game.addActiveAttacker(card7);
        game.addActiveAttacker(card8);
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

    @Test
    public void testGetActivePlayerCreatures__player1(){
        game.addPlayer1Creatures(card6);
        game.addPlayer1Creatures(card7);
        assertEquals(Arrays.asList(card6,card7), game.getActivePlayerCreatures() );
    }

    @Test
    public void testGetActivePlayerCreatures__player2(){
        game.addPlayer2Creatures(card6);
        game.addPlayer2Creatures(card7);
        game.nextPlayer();
        assertEquals(Arrays.asList(card6,card7), game.getActivePlayerCreatures() );
    }

    @Test
    public void testUntapActivePlayerCreatures(){
        card6.setTapped(true);
        card7.setTapped(true);
        game.addPlayer1Creatures(card6);
        game.addPlayer1Creatures(card7);
        game.untapActivePlayerCreatures();
        assertEquals(false, game.getActivePlayerCreatures().get(0).getTapped() );
        assertEquals(false, game.getActivePlayerCreatures().get(1).getTapped() );
    }

    @Test
    public void testGetAbleToAttack(){
        card6.setTapped(true);
        card7.setTapped(false);
        game.addPlayer1Creatures(card6);
        game.addPlayer1Creatures(card7);
        assertEquals(Arrays.asList(card7), game.getAbleToAttack(game.getActivePlayerCreatures()) );
    }

    @Test
    public void testSwap__NextActivePlayer() {
        game.swap();
        assertEquals(player2, game.getActivePlayer() );
    }

    @Test
    public void testSwap__NextRound() {
        game.setRound(5);
        game.swap();
        assertEquals("Main", game.getRound());
    }

    @Test
    public void testSwap__UntappedLand() {
        card1.setTapped(true);
        card2.setTapped(true);
        card3.setTapped(true);
        card4.setTapped(true);
        player2.playLand(card1);
        player2.playLand(card2);
        player2.playLand(card3);
        player2.playLand(card4);
        player2.playLand(card5);
        game.swap();
        assertEquals(5, game.getActivePlayer().getUntappedLandSize(), 0.01 );
    }

    @Test
    public void testSwap__UntappedCreatures() {
        card6.setTapped(true);
        card7.setTapped(true);
        game.addPlayer2Creatures(card6);
        game.addPlayer2Creatures(card7);
        game.swap();
        assertEquals(false, game.getActivePlayerCreatures().get(0).getTapped() );
        assertEquals(false, game.getActivePlayerCreatures().get(1).getTapped() );
    }

    @Test
    public void testSwap__HandSize() {
        game.swap();
        assertEquals(8, game.getActivePlayer().getHandSize(), 0.01 );
    }

    @Test
    public void testContainsLand__true(){
        boolean result = game.containsLand( game.getActivePlayer().getHand() );
        assertEquals(true, result);
    }

    @Test
    public void testContainsLand__false(){
        game.getActivePlayer().getHand().clear();
        boolean result = game.containsLand( game.getActivePlayer().getHand() );
        assertEquals(false, result);
    }

    @Test
    public void testContainsCreature__true(){
        boolean result = game.containsCreature( game.getActivePlayer().getHand() );
        assertEquals(true, result);
    }

    @Test
    public void testContainsCreature__false(){
        game.getActivePlayer().getHand().clear();
        boolean result = game.containsCreature( game.getActivePlayer().getHand() );
        assertEquals(false, result);
    }

    @Test
    public void testGetLand(){
        Land land = game.getLand(game.getActivePlayer().getHand());
        assertEquals(card5, land);
    }

}

