/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.birthdaycalculator;

/**
 *
 * @author isaacrez
 */
import java.util.Scanner;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Main {
    
    static Scanner in = new Scanner(System.in);
	
    public static void main(String[] args) {
        System.out.println("Welcome to the 100% Scientifically Accurate Birthday Calculator!");

        while (true) {
            LocalDate birthday = getBirthday();			
            LocalDate thisBirthday = LocalDate.of(
                LocalDate.now().getYear(),
                birthday.getMonth(),
                birthday.getDayOfMonth());

            LocalDate nextBirthday = thisBirthday;
            if (LocalDate.now().isAfter(nextBirthday)) {
                nextBirthday = nextBirthday.plusYears(1);
            }


            long daysLeft = ChronoUnit.DAYS.between(LocalDate.now(), nextBirthday);
            long age = ChronoUnit.YEARS.between(birthday, LocalDate.now());

            System.out.println("This means you were born on a " + birthday.getDayOfWeek() + "!");
            System.out.println("This year it falls on a " + thisBirthday.getDayOfWeek() + "...");

            System.out.println("And since today is " + LocalDate.now() + ",");
            System.out.println("there's only " + daysLeft + " more days until the next one when you turn " + (age + 1) + "!");
        }
    }

    public static LocalDate getBirthday() {
        System.out.println("\nWhat's your birthday? (Format: mm/dd/yyyy)");


        boolean invalid = true;
        int year = 0;
        int month = 0;
        int day = 0;

        while (invalid) {
            try {
                String input = in.nextLine();
                String[] date = input.split("/");
                year = Integer.parseInt(date[2]);
                month = Integer.parseInt(date[0]);
                day = Integer.parseInt(date[1]);
                invalid = false;
            } catch (Exception e) {
                System.out.println("I couldn't understand that - make sure you use the mm/dd/yyyy format!");
            }
        }

        System.out.println("");

        return LocalDate.of(year, month, day);
    }	
}