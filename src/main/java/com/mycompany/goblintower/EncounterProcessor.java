/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.goblintower;

import java.util.Random;

/**
 *
 * @author isaacrez
 */
public class EncounterProcessor {
    
    static float encounterRate = 0.35f;
    
    public static void process(Hero hero) {
        if (checkForEncounter()) {
            runEncounter(hero);
            postEncounter(hero);
        }
    }
    
    private static boolean checkForEncounter() {
        Random rdm = new Random();
        if (encounterRate < rdm.nextDouble()) {
            System.out.println("You hear discomforting creaks, but the nothing lunges from the dark");
            return false;
        } else {
            System.out.println("You hear a shrill cry, before turning to see a goblin rushing you down!");
            return true;
        }
    }

    private static void runEncounter(Hero hero) {

        Goblin goblin = new Goblin();

        while (goblin.isAlive() && hero.isAlive()) {
            System.out.println("The goblin lunges at you!");
            goblin.attack(hero);
            if (hero.isAlive()) {
                    System.out.println("And you lunge back it!");
            }
            hero.attack(goblin);
            goblin.getStatus();
        }
    }

    private static void postEncounter(Hero hero) {
        if (hero.isAlive()) {
            System.out.println("The goblin drops dead, and you quickly pillage 4 coins from it");
            hero.awardKill();
            hero.awardGold(4);
        } else {
            System.out.println("'Oh, that did not go well at all...' is your last thought, as you drop to the ground");
        }
    }
}
