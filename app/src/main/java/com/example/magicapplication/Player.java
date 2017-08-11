package com.example.magicapplication;


import java.util.ArrayList;
import java.util.Collections;

public class Player {
    private Integer lifePoints;
    private ArrayList<Card> deck;
    private ArrayList<Card> hand;
    private ArrayList<Land> playedLand;
    private ArrayList<Card> graveyard;

    public Player(ArrayList<Card> deck){
        this.lifePoints = 20;
        this.deck = deck;
//        this.shuffleDeck();
        this.hand = new ArrayList<Card>();
        this.playedLand = new ArrayList<Land>();
        this.graveyard = new ArrayList<Card>();
    }

    public void shuffleDeck(){
        Collections.shuffle(this.deck);
    }

    public void start(){
        this.drawCard(7);
    }

    public void drawCard(){
        if (this.deck.size() >= 1) {
            this.hand.add(this.deck.get(0));
            this.deck.remove(0);
        }
//            else { MAKE THEM LOSE }
    }

    public void drawCard(int numCards){
        for (int i = 0; i < numCards; i++){
            if (this.deck.size() >= 1) {
                this.hand.add(this.deck.get(0));
                this.deck.remove(0);
            }
//            else { MAKE THEM LOSE }
        }
    }


    public Integer getDeckSize(){
        return this.deck.size();
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
        return this.hand;
    }

    public void addHandCard(Card card) {
        this.hand.add(card);
    }

    public void removeHandCard(Card card) {
        this.hand.remove(card);
    }

    public void playLand(Land land){
        this.playedLand.add(land);
    }

    public Integer getPlayedLandSize(){
        return this.playedLand.size();
    }

    public ArrayList<Land> getPlayedLand() {
        return playedLand;
    }

    public ArrayList<Land> getUntappedLand() {
        ArrayList<Land> untappedLand = new ArrayList<Land>();

        for (Land land : this.playedLand){
            if (land.getTapped() == false){
                untappedLand.add(land);
            }
        }
        return untappedLand;
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public Integer getUntappedLandSize(){
       return this.getUntappedLand().size();
    }

    public Integer getGraveyardSize(){
        return this.graveyard.size();
    }

    public void addToGraveyard(Card card) {
         this.graveyard.add(card);
    }

    public void removeFromGraveyard(Card card) {
        this.graveyard.remove(card);
    }

    public ArrayList<Card> getGraveyard() {
        return graveyard;
    }
}
