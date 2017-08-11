package com.example.magicapplication;


public class Creature extends Card {
    private Integer attack;
    private Integer defence;

    public Creature(String colour, int cost){
        super(colour, cost, true);
    }

}
