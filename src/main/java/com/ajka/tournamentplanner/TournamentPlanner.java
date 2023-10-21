package com.ajka.tournamentplanner;

/**
 *
 * @author Jaroslav Kučera
 */

public class TournamentPlanner {

    public static void main(String[] args) {
        
        Teams teams = new Teams();
        Matches matches = new Matches();

        MenuG menu = new MenuG();
        MenuItem[] menuItems = {
            new MenuItem(1, "Add team"),
            new MenuItem(2, "Show teams"),
            new MenuItem(3, "Delete team"),
            new MenuItem(4, "Create tournament"),
            new MenuItem(0, ""),
            new MenuItem(5, "Show table"),
            new MenuItem(6, "Match recording"),
            new MenuItem(9, "End of program")
        };
        int choice = 0;
        
        // Main loop
        while (choice != 9) {
            choice = menu.getMenuChoice(menuItems);

            switch (choice) {
                case 1 -> {
                    teams.addOneTeam();
                }
                case 2 -> {
                    teams.showAllTeams();
                }
                case 3 -> {
                    teams.deleteOneTeam();
                }
                case 4 -> {
                    matches.tournament(teams);
                    matches.printMatches();
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
