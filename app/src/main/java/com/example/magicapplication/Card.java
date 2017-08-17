package com.example.magicapplication;


import android.os.Bundle;

public abstract class Card {
    protected String name;
    protected String colour;
    protected Integer cost;
    protected Boolean tapped;


    public Card(String name, String colour, Integer cost, Boolean trueFalse){
        this.name = name;
        this.colour = colour;
        this.cost = cost;
        this.tapped = trueFalse;
    }

    public String getName(){
        return this.name;
    }


    public String getColour(){
        return this.colour;
    }

    public Integer getCost(){
        return this.cost;
    }

    public boolean getTapped(){
        return this.tapped;
    }

    public void setTapped(boolean tapped){
        this.tapped = tapped;
    }

}
