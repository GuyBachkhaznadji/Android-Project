package com.example.magicapplication;


public class Creature extends Card {
    private Integer attack;
    private Integer defence;
    private Boolean attacking;

    public Creature(String name, String colour, int cost, int attack, int defence){
        super(name, colour, cost, true);
        this.attacking = false;
        this.attack = attack;
        this.defence = defence;
    }

    public boolean getAttacking() {
        return attacking;
    }

    public void setAttacking(Boolean attacking) {
        this.attacking = attacking;
    }

    public Integer getAttack() {
        return attack;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    public Integer getDefence() {
        return defence;
    }

    public void setDefence(Integer defence) {
        this.defence = defence;
    }
}
