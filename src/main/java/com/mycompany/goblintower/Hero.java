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
import java.util.Random;

public class Hero extends Humanoid {

    private int lvl = 1;
    private int gold = 0;
    private int killCount = 0;

    private int maxPotions = 5;
    private int drinkIndex = 0;
    private int potions[] = {2, 2, 2, 2, 2};

    public Hero() {
        Random random = new Random();
        this.maxHP = 20 + random.nextInt(11);
        this.HP = this.maxHP;
        this.atk = 1 + random.nextInt(3);
        this.def = 1 + random.nextInt(5);
    }


    public void levelUp() {
        this.lvl += 1;
    }

    public int getLevel() {
        return this.lvl;
    }

    public void awardGold(int gold) {
        this.gold += gold;
    }
    
    public void awardKill() {
        this.killCount += 1;
    }
    
    public int getKillCount() {
        return this.killCount;
    }

    public void getStatus() {
        if (this.HP < this.maxHP / 4) {
            System.out.println("You find yourself covered in gashes and bruises, a bloody mess");
        } else if (this.HP < this.maxHP / 2) {
            System.out.println("The pain aches, but your bruising isn't too severe");
        } else if (this.HP < this.maxHP * 3 / 4) {
            System.out.println("You notice some minor bruises, but they don't worry you much");
        } else {
            System.out.println("You feel fine, bar some scratches and old scars");
        }
    }

    public void drinkPotion() {
        if (canHeal() && hasPotions()) {
            System.out.println("You feel a strange warmth course through your veins");
            this.HP += this.potions[drinkIndex];
            this.drinkIndex += 1;
            this.HP = Math.min(this.HP, this.maxHP);

        } else if (!canHeal()) {
            System.out.println("You're much too healthy to actually drink a potion!");

        } else {
            System.out.println("You're... you're out of potions!");

        }
    }

    private boolean hasPotions() {
        return !(this.drinkIndex == this.maxPotions - 1);
    }

    public void buyPotion(int potionStrength) {
        if (this.gold >= 4) {
            this.gold -= 4;
            if (fullOnPotions()) {
                System.out.println("You move to holster the potion, but hear a crash!");
                System.out.println("The potion didn't fit in your pouch, and you dropped it...");
            } else {
                System.out.println("You add a potion to your holster!");
                System.out.println("Your pouch is now " + this.gold + " coins heavy");

                this.drinkIndex -= 1;
                this.potions[drinkIndex] = potionStrength;
            }
        }
    }

    private boolean fullOnPotions() {
        return (this.drinkIndex == 0);
    }

}
