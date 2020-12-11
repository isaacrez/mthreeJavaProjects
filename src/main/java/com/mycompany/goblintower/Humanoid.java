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
public class Humanoid {
	
    protected int maxHP;
    protected int HP;
    protected int atk;
    protected int def;

    public void attack(Humanoid defender) {
        int opposingDef = defender.getDefense();
        int dmg = Math.max(atk - opposingDef, 1);
        defender.damage(dmg);
    }

    public void damage(int dmg) {
        this.HP -= dmg;
        this.HP = Math.max(0, this.HP);
    }

    public boolean isAlive() {
        return this.HP > 0;
    }

    public boolean canHeal() {
        return this.HP < this.maxHP;
    }

    public int getDefense() {
        return this.def;
    }

}


