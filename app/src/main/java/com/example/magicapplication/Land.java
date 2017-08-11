package com.example.magicapplication;


public class Land extends Card {
    private boolean tapped;

    public Land(String colour, int cost){
        super(colour, cost);
        this.tapped = false;
    }

    public boolean getTapped(){
        return this.tapped;
    }

    public void setTapped(boolean trueFalse){
        this.tapped = trueFalse;
    }

}
