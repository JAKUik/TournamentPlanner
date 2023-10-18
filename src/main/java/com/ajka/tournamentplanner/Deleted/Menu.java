/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ajka.tournamentplanner;

/**
 *
 * @author kucer
 */
import java.util.Scanner;

public class Menu {
    private final Scanner scanner;
    
    public Menu() {
        this.scanner = new Scanner(System.in);
    }

    public int getChoice(MenuItem[] menuItems) {
    /*
        Return a choice. 0 = non exist choice.
        */
        
        // Print menu
        System.out.println("");
        System.out.println("==================");
        System.out.println("===  M E N U   ===");
        System.out.println("==================");

        for (MenuItem item: menuItems) {
            if (item.number != 0) {
                System.out.println(item.number + ". " + item.text);
            }
            else {
                System.out.println("------------------");
            }
        }
        System.out.println("------------------");

// asi zbytečné        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your choice: ");
        String input = scanner.nextLine();
        
        int choice;
        try {
            choice = Integer.parseInt(input);
            boolean isInMenu = false;
            for (MenuItem item: menuItems) {
                if (item.number == choice) {
                    isInMenu = true;
                    break;
                }
            }
            if (!isInMenu) {
                choice = 0;
            }
        } catch (NumberFormatException e) {
            choice = 0;
        }
        System.out.println("");
        
        return choice;
    }
}
