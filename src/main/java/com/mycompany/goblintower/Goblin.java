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

public class Goblin extends Humanoid {
	
    public Goblin() {
        Random random = new Random();
        this.maxHP = 5 + random.nextInt(6);
        this.HP = this.maxHP;
        this.atk = 2 + random.nextInt(2);
        this.def = 1 + random.nextInt(2);
    }

    public void getStatus() {
        if (this.HP < this.maxHP / 4) {
            System.out.println("It's haggard and barely standing");
        } else if (this.HP < this.maxHP / 2) {
            System.out.println("It's fercious still, but struggling to stay upright");
        } else if (this.HP < this.maxHP * 3 / 4) {
            System.out.println("It's covered in small cuts, and seems enraged because of it");
        } else {
            System.out.println("It appears perfectly healthy, and has a murderous glint in it's eyes");
        }
    }

}