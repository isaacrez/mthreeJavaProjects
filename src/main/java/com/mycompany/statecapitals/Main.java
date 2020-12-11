/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.statecapitals;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author isaacrez
 */
public class Main {
 
    public static void main(String args[]) {
        String states[] = {"Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"};
        String capitals[] = { "Montgomery", "Juneau", "Phoenix", "Little Rock", "Sacramento", "Denver", "Hartford", "Dover", "Tallahassee", "Atlanta", "Honolulu", "Boise", "Springfield", "Indianapolis", "Des Moines", "Topeka", "Frankfort", "Baton Rouge", "Augusta", "Annapolis", "Boston", "Lansing", "Saint Paul", "Jackson", "Jefferson City", "Helena", "Lincoln", "Carson City", "Concord", "Trenton", "Santa Fe", "Albany", "Raleigh", "Bismarck", "Columbus", "Oklahoma City", "Salem", "Harrisburg", "Providence", "Columbia", "Pierre", "Nashville", "Austin", "Salt Lake City", "Montpelier", "Richmond", "Olympia", "Charleston", "Madison", "Cheyenne"};
        Map<String, String> stateToCapital = new HashMap<>();
        
        for (int i = 0; i < states.length; i++) {
            stateToCapital.put(states[i], capitals[i]);
        }
        
        System.out.println("STATES:\n"
                + "=======");
        printKeys(stateToCapital);
        
        System.out.println("\nCAPITALS:\n"
                + "=========");
        printElements(stateToCapital);
        
        System.out.println("\nSTATE/CAPITAL PAIRS:\n"
                + "====================");
        printPairs(stateToCapital);
    }
    
    public static void printKeys(Map<String, String> map) {
        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println(key);
        }
    }
    
    public static void printElements(Map<String, String> map) {
        Set<String> keys = map.keySet();
        for(String key : keys) {
            System.out.println(map.get(key));
        }
    }
    
    public static void printPairs(Map<String, String> map) {
        Set<String> keys = map.keySet();
        for(String key : keys) {
            System.out.println(key + ", " + map.get(key));
        }
    }
    
}
