package com.example.magicapplication;

import java.util.ArrayList;

public class GameLogic {
    private ArrayList<Player> players;
    private Player activePlayer;
    private ArrayList<String> roundPhases;
    private String round;
    private ArrayList<Creature> player1Creatures;
    private ArrayList<Creature> player2Creatures;
    private ArrayList<Creature> activeAttackers;
    private ArrayList<Creature> activeBlockers;

    public GameLogic(Player player1, Player player2){
        this.players = new ArrayList<Player>();
        this.players.add(player1);
        this.players.add(player2);
        this.roundPhases = new ArrayList<String>();
        this.roundPhases.add("Main 1");
        this.roundPhases.add("Attack");
        this.roundPhases.add("Block");
        this.roundPhases.add("Damage");
        this.roundPhases.add("Main 2");
        this.roundPhases.add("Swap");
        this.activePlayer = player1;
        this.setRound(0);
    }

    public boolean hasPlayedLand(){
        return this.activePlayer.getHasPlayedLand();
    }

    public Player getActivePlayer(){
        return this.activePlayer;
    }

    public void setActivePlayer(int index){
        this.activePlayer = this.players.get(index);
    }

    public void nextPlayer(){
        if (this.activePlayer == players.get(0) ){
            this.setActivePlayer(1);
        }
        else if (this.activePlayer == players.get(1) ){
            this.setActivePlayer(0);
        }
    }

    public String getRound() {
        return this.round;
    }

    public void setRound(int index) {
        this.round = this.roundPhases.get(index);;
    }

    public void nextRound(){
        int index = this.roundPhases.indexOf(this.round);
        index += 1;
        if (index < 6){
            this.setRound(index);
        } else if (index == 6 ){
            this.setRound(0);
        }
    }

}
