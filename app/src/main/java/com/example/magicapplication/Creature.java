package com.example.magicapplication;


public class Creature extends Card {
    private Integer attack;
    private Integer defence;
    private Boolean attacking;

    public Creature(String colour, int cost){
        super(colour, cost, true);
        this.attacking = false;
    }

    public boolean getAttacking() {
        return attacking;
    }

    public void setAttacking(Boolean attacking) {
        this.attacking = attacking;
    }

}
