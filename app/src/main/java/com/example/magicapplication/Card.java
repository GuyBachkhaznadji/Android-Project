package com.example.magicapplication;


public abstract class Card {
    protected String colour;
    protected int cost;


    public Card(String colour, int cost){
        this.colour = colour;
        this.cost = cost;
    }

    public String getColour(){
        return this.colour;
    }

    public int getCost(){
        return this.cost;
    }


}
