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
import java.util.Scanner;

public class Main {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        
        System.out.println("Hello, welcome to this deck simulator!");
        System.out.println("To see all commands, type 'help'");
        
        Deck deck = new Deck();

        while (true) {
            System.out.print("Your command:\t");

            String[] input = in.nextLine().split(" ");

            if (input[0].equals("quit")) {
                System.out.println("Awh phoo-ey!  We'll miss ya!");
                break;
                
            } else if (input[0].equals("show")) {
                deck.printHand();
                
            } else if (input[0].equals("draw")) {
                draw(deck, input);
                
            } else if (input[0].equals("play")) {
                deck.play();
                
            } else if (input[0].equals("help")) {
                System.out.println("show, draw [# of cards], play, help");
                
            } else {
                System.out.println("Unrecognized command! Try 'help'");
                
            }

        }

        in.close();
    }

    private static void draw(Deck deck, String[] input) {
        try {
            int drawCount = Integer.parseInt(input[1]);
            if (drawCount <= 0) {
                throw new NumberFormatException();
            }

            deck.draw(drawCount);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("You need a second input, to show how many cards you want to draw!");

        } catch (IndexOutOfBoundsException e) {
            System.out.println("You drew the entire deck!");

        } catch (NumberFormatException e) {
            System.out.println("Please use a positive integer as the second input!");

        }
    }
}