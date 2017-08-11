package com.example.magicapplication;


import android.os.Bundle;

public abstract class Card {
    protected String colour;
    protected Integer cost;
    protected Boolean tapped;



    public Card(String colour, Integer cost, Boolean trueFalse){
        this.colour = colour;
        this.cost = cost;
        this.tapped = trueFalse;
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

    public void setTapped(boolean trueFalse){
        this.tapped = trueFalse;
    }
}
