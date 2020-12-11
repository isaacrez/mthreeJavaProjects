/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.morestatecapitals;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * @author isaacrez
 */
public class StateCapitalsApp {
    
    static Map<String, Capital> stateToCapital;
    static Set<String> states;
    static Scanner in = new Scanner(System.in);
    
    public static void main(String args[]) throws Exception {
        stateToCapital = loadData("src\\main\\java\\statesToCapitals.txt");
        states = stateToCapital.keySet();
        
        printHeader(stateToCapital.size() + " STATE/CAPITAL PAIRS LOADED");
        printCapitalsFor(states);
        
        float lowerLimit = getNumber("Display capitals with populations above:");
        printHeader("CAPITALS: POPULATION >= " + lowerLimit);
        printCapitalsFor(statesCapitalPopOf(lowerLimit));
        
        lowerLimit = getNumber("Display capitals with areas (in mi^2) above:");
        printHeader("CAPITALS: AREA >= " + lowerLimit + " mi^2");
        printCapitalsFor(statesCapitalAreaOf(lowerLimit));
    }
    
    private static Map<String, Capital> loadData(String filename) throws FileNotFoundException {
        Map<String, Capital> statesToCapital = new HashMap<>();
        Scanner in = new Scanner(new BufferedReader(new FileReader(filename)));
        
        while (in.hasNextLine()) {
            String capitalInfo = in.nextLine();
            String infoArr[] = capitalInfo.split("::");
            
            String state = infoArr[0];
            String capitalName = infoArr[1];
            int population = Integer.parseInt(infoArr[2]);
            float areaSqMiles = Float.parseFloat(infoArr[3]);
            
            Capital capital = new Capital(capitalName, population, areaSqMiles);
            statesToCapital.put(state, capital);
        }
        return statesToCapital;
    }
    
    private static void printHeader(String title) {
        System.out.println("\n" + title + "\n" + "=".repeat(title.length() - 1));
    }
    
    private static float getNumber(String prompt) {
        System.out.println("");
        while (true) {
            try {
                System.out.print(prompt + "\t");
                return in.nextFloat();
            } catch (Exception e) {
                System.out.print(e);
            }
        }
    }
    
    private static void printCapitalsFor(Collection<String> states) {
        for (String state : states) {
            System.out.println(state + " - " + stateToCapital.get(state));
        }
    }
    
    private static List<String> statesCapitalPopOf(float minimumPopulation) {
        return states.stream()
                .filter(s -> stateToCapital.get(s).getPop() >= minimumPopulation)
                .collect(Collectors.toList());
    }
    
    private static List<String> statesCapitalAreaOf(float minimumSqMiles) {
        return states.stream()
                .filter(s -> stateToCapital.get(s).getArea() >= minimumSqMiles)
                .collect(Collectors.toList());
    }
    
}
