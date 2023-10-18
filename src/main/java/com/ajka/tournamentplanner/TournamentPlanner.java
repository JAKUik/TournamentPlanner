package com.ajka.tournamentplanner;

/**
 *
 * @author Jaroslav Kučera
 */

public class TournamentPlanner {

    public static void main(String[] args) {
        
        Teams cTeams = new Teams();
        

        MenuG menu = new MenuG();
        MenuItem[] menuItems = {
            new MenuItem(1, "Add team"),
            new MenuItem(2, "List teams"),
            new MenuItem(3, "Delete team"),
            new MenuItem(4, "Create schedule"),
            new MenuItem(0, ""),
            new MenuItem(5, "Match recording"),
            new MenuItem(6, "Print table"),
            new MenuItem(9, "End of program")
        };
        int choice = 0;
        
        // Main loop
        while (choice != 9) {
            choice = menu.getMenuChoice(menuItems);

            switch (choice) {
                case 1 -> {
                    cTeams.addOneTeam();
                }
                case 2 -> {
                    cTeams.showAllTeams();
                }
                case 3 -> {
                    cTeams.deleteOneTeam();
                }
                case 4 -> {
                }
                case 5 -> {
                }
                case 6 -> {
                }

                default -> {
                    {}
                    
                }
            }
        }
    }
}
