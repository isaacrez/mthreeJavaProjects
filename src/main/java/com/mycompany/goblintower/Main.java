/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.goblintower;

/**
 *
 * @author isaacrez
 */
import java.util.Scanner;

public class Main {

    static Scanner in = new Scanner(System.in);
    static Hero hero;

    public static void main(String[] args) {
        boolean playing = true;
        while (playing) {
            runGame();
            if (!wantsAnotherGame()) {
                playing = false;
            }
        }	
    }

    private static void runGame() {
        int steps = 0;
        hero = new Hero();

        while (hero.isAlive()) {
            System.out.println("You take a step deeper into the tower");
            steps += 1;

            if (steps % 10 == 0) {
                System.out.println("You feel more confident in yourself, after making it this far");
                hero.levelUp();
                potionShop();
            } else {
                EncounterProcessor.process(hero);
            }

            if (hero.isAlive()) {
                hero.getStatus();
                if (drinksPotion()) {
                        hero.drinkPotion();
                }
            }
        }
    }

    private static void potionShop() {
        System.out.println("You see a small warp gate, and hear a distant voice...");
        System.out.println("It whispers, 'For four coins, I'll send you a potion'");
        System.out.print("How many potions would you like?\t");

        try {
            int desiredPotions = in.nextInt();
            in.nextLine();
            for (int i = 0; i < desiredPotions; i++) {
                    hero.buyPotion(2);
            }
        } catch (Exception e) {
            System.out.println("The shopkeep fails to understand you, and the portal vanishes before your eyes");
            System.out.println("Perhaps a simple number, rather than a conversation, would work better next time?");
        }
    }

    private static boolean drinksPotion() {
        boolean drinksPotion = getConfirmation("Would you like to use a potion (y/n)?\t");
        if (drinksPotion) {
            System.out.println("You hesitate, before deciding to drink the potion");
        } else {
            System.out.println("You decide to carry on without wasting such a precious resource");
        }
        return drinksPotion;
    }

    private static boolean wantsAnotherGame() {
        boolean gameDesired = getConfirmation("Play another game (y/n)?\t");
        if (gameDesired) {
            System.out.println("Another round then!");
        } else {
            System.out.println("I see, you grow weary of this dark place.");
            displayStatistics();			
        }
        return gameDesired;
    }

    private static boolean getConfirmation(String requestDialog) {
        while (true) {
            System.out.print(requestDialog);
            String input = in.nextLine().toLowerCase();

            if (input.equals("n")) {
                return false;
            } else if (input.equals("y")) {
                return true;				
            } else {
                System.out.println("I'm sorry, I didn't quite get that...");
            }
        }
    }

    private static void displayStatistics() {
        System.out.println("After your dungeoneering, you managed to reach level " + hero.getLevel());
        System.out.println("...and you left a trail of " + hero.getKillCount() + " goblins in your wake");
    }

}

