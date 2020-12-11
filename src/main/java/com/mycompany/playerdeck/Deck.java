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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Deck {

    int BUST_LIMIT = 21;
    
    ArrayList<Card> contents = new ArrayList<>(32);
    ArrayList<Card> discard = new ArrayList<>(32);
    ArrayList<Card> dealerHand = new ArrayList<>(8);
    ArrayList<Card> hand = new ArrayList<>(8);

    Random random = new Random();

    Deck() {
        populateDeck();
        playDealer();
    }
    
    private void populateDeck() {
        String suits[] = new String[] {"Clubs", "Spades", "Hearts", "Diamonds"};

        ArrayList<String> ranks = new ArrayList(12);
        ranks.add("Jack");
        ranks.add("Queen");
        ranks.add("King");
        ranks.add("Ace");        
        for (int i = 2; i < 11; i++) {
            ranks.add(i + "");
        }
        
        for (String rank : ranks) {
            for (String suit : suits) {
                Card card = new Card(rank, suit);
                this.contents.add(card);
            }
        }
    }
    
    public void draw(int drawCount) {
        if (isBusted()) {
            System.out.println("You already busted!");
            
        } else {
            for (int i = 0; i < drawCount; i++) {
                System.out.println("You draw:\t" + drawFor(this.hand));

                if (isBusted()) {
                    System.out.println("BUST");
                    break;
                }
            }
        }
    }
    
    private Card drawFor(ArrayList<Card> hand) {
        if (this.contents.isEmpty()) {
            resetDeck();
        }
        
        int idx = this.random.nextInt(this.contents.size());
        Card drawnCard = this.contents.get(idx);
        this.contents.remove(idx);
        hand.add(drawnCard);
        return drawnCard;
    }

    public void play() {
        int playerHandValue = getHandValue(this.hand);
        int dealerHandValue = getHandValue(this.dealerHand);
        
        System.out.print("You played...\n\t");
        printHand(this.hand);
        System.out.print("Dealer played...\n\t");
        printHand(this.dealerHand);
        
        clearHand(this.hand);
        clearHand(this.dealerHand);        
        
        if (isBusted(playerHandValue)) {
            System.out.println("Dealer wins!");
        } else if (playerHandValue > dealerHandValue) {
            System.out.println("Player wins!");
        } else {
            System.out.println("Dealer wins!");
        }
        
        playDealer();
    }
    
    private void clearHand(ArrayList<Card> hand) {
        for (Card card : hand) {
            this.discard.add(card);
        }
        hand.clear();
    }
    
    public void playDealer() {
        int handValue = 0;
        while (handValue < 15) { 
            drawFor(this.dealerHand);
            handValue = getHandValue(this.dealerHand);
        }
        
        System.out.println("Dealer reveals:");
        System.out.print(this.dealerHand.get(0) + ", and drew " 
                + this.dealerHand.size() + " many cards");
    }
    
    public void printHand() {
        printHand(this.hand);
    }

    public void printHand(ArrayList<Card> hand) {
        if (hand.isEmpty()) {
            System.out.println("[ Empty ]");
        } else {
            List<String> cardText = hand.stream()
                    .map(c -> c.toString()).collect(Collectors.toList());
            System.out.print(String.join(", ", cardText) + "\t");
            printHandValue(hand);
        }
    }
    
    public void printHandValue() {
        printHandValue(this.hand);
    }
    
    public void printHandValue(ArrayList<Card> hand) {
        String base = "[ VALUE: ";
        int handValue = getHandValue(hand);
        
        if (isBusted(handValue)) {
            System.out.println(base + "BUST ]");
        } else {
            System.out.println(base + handValue + " ]");
        }
    }
    
    public int getHandValue(ArrayList<Card> hand) {
        int handValue = hand.stream()
                .map(c -> c.getValue())
                .reduce(0, (a, b) -> a + b);
        
        if (isBusted(handValue)) {
            handValue = reduceHandValue(handValue);
        }
        
        return handValue;
    }
    
    private int reduceHandValue(int handValue) {
        int aceCount = (int) this.hand.stream()
                .filter(c -> c.isAce())
                .count();
            
        for (int i = 0; i < aceCount; i++){
            handValue -= 10;
            if (!isBusted(handValue)) {
                return handValue;
            }
        }
        return handValue;
    }
    
    private boolean isBusted() {
        return isBusted(getHandValue(this.hand));
    }
    
    private boolean isBusted(int handValue) {
        return handValue > BUST_LIMIT;
    }

    public void resetDeck() {
        if (!this.discard.isEmpty()) {
            for (Card card : this.discard) {
                this.contents.add(card);
            }
            this.discard.clear();
        }
    }

}
