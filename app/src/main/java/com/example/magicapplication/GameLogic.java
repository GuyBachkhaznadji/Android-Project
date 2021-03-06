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
    private boolean gameover;

    public GameLogic(Player player1, Player player2){
        this.players = new ArrayList<Player>();
        this.players.add(player1);
        this.players.add(player2);
        this.roundPhases = new ArrayList<String>();
        this.roundPhases.add("Main");
        this.roundPhases.add("Attack");
        this.roundPhases.add("Block");
        this.roundPhases.add("Damage");
        this.roundPhases.add("End");
        this.roundPhases.add("Swap");
        this.player1Creatures = new ArrayList<Creature>();
        this.player2Creatures = new ArrayList<Creature>();
        this.activeAttackers = new ArrayList<Creature>();
        this.activeBlockers = new ArrayList<Creature>();
        this.activePlayer = player1;
        this.setRound(0);
    }

    public boolean hasPlayedLand(){
        return this.activePlayer.getHasPlayedLand();
    }

    public Player getActivePlayer(){
        return this.activePlayer;
    }

    public Player getNonActivePlayer(){
        Player player = null;
        if (this.activePlayer == players.get(0) ){
            player = players.get(1);
        }
        else if (this.activePlayer == players.get(1) ){
            player = players.get(0);
        } return player;
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

    public Player getPlayer(int index){
        return this.players.get(index);
    }



    public ArrayList<Creature> getActivePlayerCreatures(){
        ArrayList<Creature> creatures = null;
        if (this.activePlayer == players.get(0) ){
            creatures = this.player1Creatures;
        }
        else if (this.activePlayer == players.get(1) ){
            creatures = this.player2Creatures;
        } return creatures;
    }

    public ArrayList<Creature> getNonActivePlayerCreatures(){
        ArrayList<Creature> creatures = null;
        if (this.activePlayer == players.get(0) ){
            creatures = this.player2Creatures;
        }
        else if (this.activePlayer == players.get(1) ){
            creatures = this.player1Creatures;
        } return creatures;
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

    public ArrayList<Card> playableCards(Player player){
        ArrayList<Card> playableHand = new ArrayList<Card>();

        for (Card card : player.getHand() ){
            if (!player.getHasPlayedLand() && card instanceof Land) {
                playableHand.add(card);
            } else if (card.getCost() <= player.getUntappedLandSize() && !(card instanceof Land) ) {
                playableHand.add(card);
            }
        }
        return playableHand;
    }

    public boolean playable(Card card, Player player){
        boolean playable = false;

        if (card instanceof Land && !player.getHasPlayedLand() ){
            playable = true;
        } else if ( (card instanceof Creature) && (card.getCost() <= player.getUntappedLandSize() ) ){
            playable = true;
        }
        return playable;
    }

    public void removeCardFromHand(Card card, Player player){
        int index = player.getHand().indexOf(card);
        player.getHand().remove(index);
    }


    public void playCard(Card card, Player player){
        if (card instanceof Land){
            this.removeCardFromHand(card, player);
            player.playLand( (Land) card);
        } else if (card instanceof Creature){
            this.removeCardFromHand(card, player);
            this.addCreatureToBattlefield( (Creature) card, player);
            ArrayList<Land> untappedLand = player.getUntappedLand();
            for (int i = 0; i < card.getCost() ; i++){
                untappedLand.get(i).setTapped(true);
            }
        }
    }

    public ArrayList<Creature> getPlayer1Creatures() {
        return this.player1Creatures;
    }

    public void addPlayer1Creatures(Card creature) {
        this.player1Creatures.add( (Creature) creature );
    }

    public void removePlayer1Creatures(Card creature) {
        this.player1Creatures.remove(creature );
    }

    public ArrayList<Creature> getPlayer2Creatures() {
        return this.player2Creatures;
    }

    public void addPlayer2Creatures(Card creature) {
        this.player2Creatures.add( (Creature) creature );
    }

    public void removePlayer2Creatures(Card creature) {
        this.player2Creatures.remove(creature);
    }

    public void addCreatureToBattlefield(Creature creature, Player player){
        if(player == this.players.get(0) ){
            this.player1Creatures.add(creature);
        } else if (player == this.players.get(1) ) {
            this.player2Creatures.add(creature);
        }
    }

    public ArrayList<Creature> getActiveAttackers(){
        return this.activeAttackers;
    }

    public ArrayList<Creature> getAbleToAttack(ArrayList<Creature> creatures){
        ArrayList<Creature> canAttack = new ArrayList<Creature>();
        for (Creature creature : creatures ){
            if (!creature.getTapped() ){
                canAttack.add(creature);
            }
        } return canAttack;
    }

    public void addActiveAttacker(Creature creature){
        if (!creature.getTapped() ) {
            creature.setAttacking(true);
            creature.setTapped(true);
            this.activeAttackers.add(creature);
        }
    }

    public void removeActiveAttacker(Creature creature){
        this.activeAttackers.remove(creature);
    }

    public int attack(Player player){
        int damageCounter = 0;
        for (Creature creature : this.activeAttackers){
            damageCounter += creature.getAttack();
            creature.setAttacking(false);
        }
        this.activeAttackers.clear();
        player.removeLifePoints(damageCounter);
        if (player.isDead()){
            this.gameover = true;
        }
        return damageCounter;
    }

    public boolean anyoneDead(){
        boolean dead = false;
        if ( (this.getPlayer(0).isDead() ) || (this.getPlayer(1).isDead() ) ){
            dead = true;
            this.gameover = true;
        } return dead;
    }

    public Player whoDead(){
        Player deadPlayer = null;
        for (Player player : players){
            if (player.isDead() ){
                deadPlayer = player;
            }
        } return deadPlayer;
    }

    public void untapActivePlayerCreatures(){
        for (Creature creature : this.getActivePlayerCreatures() ){
            creature.setTapped(false);
        }
    }

    public void swap(){
        this.nextPlayer();
        this.nextRound();
        this.activePlayer.untappAllLand();
        this.activePlayer.setPlayedLand(false);
        this.untapActivePlayerCreatures();
        this.activePlayer.drawCard();
//
//        if (this.activePlayer == players.get(1) ) {
//            this.computerTurn();
//        }
    }

    public boolean containsLand(ArrayList<Card> cards){
        boolean land = false;
        for (Card card : cards){
            if (card instanceof Land){
                land = true;
            }
        } return land;
    }

    public boolean containsCreature(ArrayList<Card> cards){
        boolean creature = false;
        for (Card card : cards){
            if (card instanceof Creature){
                creature = true;
            }
        } return creature;
    }

    public Land getLand(ArrayList<Card> cards){
        Land land = null;
        for (Card card : cards){
            if (card instanceof Land){
                land = (Land) card;
            }
        } return land;
    }

    public Creature getBestCreature(ArrayList<Card> cards){
        Creature creature = new Creature("Default", "Default", 0, 0, 0);
        int challengerStatsCounter = 0;
        int winnerStatsCounter = 0;
        for(Card card : cards){
            if (card instanceof Creature){
                challengerStatsCounter = ( (Creature) card ).getAttack();
                challengerStatsCounter += ( (Creature) card ).getDefence();
                winnerStatsCounter = creature.getAttack();
                winnerStatsCounter += creature.getDefence();
                if (challengerStatsCounter > winnerStatsCounter){
                    creature = ( (Creature) card);
                }
            }
        } return creature;
    }

    public ArrayList<Creature> logicalAttackers(ArrayList<Creature> potentialAttackers, ArrayList<Creature> potentialDefenders){
        ArrayList<Creature> attackers = new ArrayList<Creature>();

        if ( (potentialAttackers.size() >= 1) && (potentialDefenders.size() >= 1) ){
            for (Creature attacker : potentialAttackers){
                boolean attack = true;
                int attackersTotalAttack = 0;
                int defendersTotalDefence = 0;
                attackersTotalAttack += attacker.getAttack();
                for (Creature defender : potentialDefenders){
                    if ( !(attacker.getAttack() > defender.getDefence()) || (attacker.getDefence() < defender.getAttack())) {
                        attack = false;
                        defendersTotalDefence += defender.getDefence();
                    }
                }
                if (attackersTotalAttack >= defendersTotalDefence){
                    attack = true;
                }
                if (attack){
                    attackers.add(attacker);
                }
            }
        }

        else if ( (potentialAttackers.size() >= 1) && (potentialDefenders.size() == 0) ) {
            for (Creature attacker : potentialAttackers){
                attackers.add(attacker);
            }
        } return attackers;
    }

    public void computerPlayCreature(ArrayList<Card> playableHand){
        if (playableHand.size() >=1) {
            boolean hasCreature = this.containsCreature(playableHand);
            if (hasCreature) {
                Creature creatureCard = this.getBestCreature(playableHand);
                this.playCard(creatureCard, this.activePlayer);
            }
        }
    }

    public void computerTurn(){
        ArrayList<Card> playableHand1 = this.playableCards(this.activePlayer);
        boolean hasLand = this.containsLand(playableHand1);

        if ( (!this.activePlayer.getHasPlayedLand() ) && hasLand ){
            Land landCard = this.getLand(playableHand1);
            this.playCard(landCard, this.activePlayer);
        }

        while (this.playableCards(this.activePlayer).size() > 0) {
            ArrayList<Card> playableHand = this.playableCards(this.activePlayer);
            this.computerPlayCreature(playableHand);
        }

        ArrayList<Creature> potentialAttackers = this.getAbleToAttack(this.getActivePlayerCreatures() );
        ArrayList<Creature> potentialDefenders = this.getAbleToAttack(this.getNonActivePlayerCreatures() );
        ArrayList<Creature> attackers = this.logicalAttackers(potentialAttackers, potentialDefenders);

        if (attackers.size() > 0){
            for (Creature attacker : attackers){
                this.addActiveAttacker(attacker);
            } this.attack(this.getNonActivePlayer());
        }
    }

    public ArrayList<Creature> getActiveBlockers() {
        return activeBlockers;
    }

    public void setActiveBlockers(ArrayList<Creature> activeBlockers) {
        this.activeBlockers = activeBlockers;
    }

    public void addActiveBlocker(Creature creature){
        this.activeBlockers.add(creature);
    }

    public void block(Creature blocker, Creature attacker){
        int index = this.activeAttackers.indexOf(attacker);
        this.activeAttackers.remove(index);
        if (blocker.getAttack() >= attacker.getDefence()){
            if (this.player1Creatures.contains(attacker)){
                int attackerIndex = this.player1Creatures.indexOf(attacker);
                this.player1Creatures.remove(attackerIndex);
                this.getPlayer(0).addToGraveyard(attacker);
            } else if (this.player2Creatures.contains(attacker)){
                    int attackerIndex = this.player2Creatures.indexOf(attacker);
                    this.player1Creatures.remove(attackerIndex);
                    this.getPlayer(1).addToGraveyard(attacker);
                }
            }
        if (attacker.getAttack() >= blocker.getDefence()) {
            if (this.player1Creatures.contains(blocker)){
                int blockerIndex = this.player1Creatures.indexOf(blocker);
                this.player1Creatures.remove(blockerIndex);
                this.getPlayer(0).addToGraveyard(blocker);
            } else if (this.player2Creatures.contains(blocker)){
                int blockerIndex = this.player2Creatures.indexOf(blocker);
                this.player1Creatures.remove(blockerIndex);
                this.getPlayer(1).addToGraveyard(blocker);
            }
        }

    }

    public boolean isGameover() {
        return gameover;
    }

    public void setGameover(boolean gameover) {
        this.gameover = gameover;
    }
}














