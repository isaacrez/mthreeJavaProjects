/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.morestatecapitals;

/**
 *
 * @author isaacrez
 */
public class Capital {
    
    private String capital;
    private int population;
    private float sqMiles;
    
    public Capital(String capital, int population, float sqMiles) {
        this.capital = capital;
        this.population = population;
        this.sqMiles = sqMiles;
    }
    
    public int getPop() {
        return this.population;
    }
    
    public float getArea() {
        return this.sqMiles;
    }
    
    @Override
    public String toString() {
        return this.capital + " | "
                + "Pop: " + this.population + " | "
                + "Area: " + this.sqMiles + " mi^2";
    }
    
}
