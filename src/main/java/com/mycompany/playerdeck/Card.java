/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.playerdeck;

/**
 *
 * @author isaacrez
 */
public class Card {

    private int value;
    private String rank;
    private String suit;

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
        getValueFromRank();
    }
    
    private void getValueFromRank() {
        try {
            this.value = Integer.parseInt(this.rank);
        } catch (NumberFormatException e) {
            if (isAce()) {
                this.value = 11;
            } else {
                this.value = 10;
            }
        }
    }
    
    public boolean isAce() {
        return (this.rank.equals("Ace"));
    }
    
    public int getValue() {
        return this.value;
    }
    
    @Override
    public String toString() {
        return this.rank + " of " + this.suit;
    }
	
}

