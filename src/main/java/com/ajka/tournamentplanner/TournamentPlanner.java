/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.ajka.tournamentplanner;

/**
 *
 * @author kucer
 */
public class TournamentPlanner {

    public static void main(String[] args) {
        Menu menu = new Menu();
        
        int choice = 0;
        
        TeamItem[] teams = {
            new TeamItem(1, "AJKA", "Ajka Software")
        };
        
        MenuItem[] menuItems = {
            new MenuItem(1, "Add team"),
            new MenuItem(2, "List teams"),
            new MenuItem(3, "Delete team"),
            new MenuItem(0, "---------------"),
            new MenuItem(4, "Create schedule"),
            new MenuItem(5, "Match recording"),
            new MenuItem(6, "Print table"),
            new MenuItem(9, "End of program")
        };
        
        // Main loop
        while (choice != 9) {
            choice = menu.getChoice(menuItems);

        // Control print    System.out.println(choice);
        
            switch (choice) {
                case 1 -> {
                }
                case 2 -> {
                }
                case 3 -> {
                }
                case 4 -> {
                }
                case 5 -> {
                }
                case 6 -> {
                }

                default ->                     {
                    {}
                    
                }
            }
            // AddTeam(teams);
                    }
    }
}
