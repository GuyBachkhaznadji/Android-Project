package com.example.magicapplication;


import java.util.ArrayList;

public class Player {
    private Integer lifePoints;
    private ArrayList<Card> deck;
    private ArrayList<Card> hand;
    private ArrayList<Land> playedLand;
    private ArrayList<Card> graveyard;

    public Player(ArrayList<Card> deck){
        this.lifePoints = 20;
        this.deck = deck;
        this.hand = new ArrayList<Card>();
        this.playedLand = new ArrayList<Land>();
        this.graveyard = new ArrayList<Card>();
    }

    public Integer getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(Integer lifePoints) {
        this.lifePoints = lifePoints;
    }

    public void addLifePoints(Integer lifePoints) {
        this.lifePoints += lifePoints;
    }
    public void removeLifePoints(Integer lifePoints) {
        this.lifePoints -= lifePoints;
    }

    public Integer getHandSize(){
        return this.hand.size();
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void addHandCard(Card card) {
        this.hand.add(card);
    }

    public void removeHandCard(Card card) {
        this.hand.remove(card);
    }

    public ArrayList<Land> getPlayedLand() {
        return playedLand;
    }

    public void addActiveLand(Land land) {
        this.hand.add(land);
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void setDeck(ArrayList<Card> deck) {
        this.deck = deck;
    }

    public ArrayList<Card> getGraveyard() {
        return graveyard;
    }
}
