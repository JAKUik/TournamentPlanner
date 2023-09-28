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

public class Teams {
    private final Scanner scanner;
    private final TeamItem[] teams;
    private final int maxTeams = 128;
    private int teamsNum = 0;   // Teams counter

    public Teams() {
        this.scanner = new Scanner(System.in);
        this.teams = new TeamItem[this.maxTeams];
        this.addNewRecord("AJK", "Ajka Software");
    }
        
    // Add one team
    public void addTeam() {
        System.out.print("Enter Short team name (3 chars): ");
        String inputShortName = 
                scanner.nextLine().substring(0, 3).toUpperCase();
        System.out.print("Enter Full team name: ");
        String inputFullName = scanner.nextLine();

        if (this.addNewRecord(inputShortName, inputFullName)) {
            System.out.println("You add this new team: ");
            printOneTeam(teamsNum - 1);
        }
        
    }

    // Print all teams
    public void listTeams() {
        for (int i = 0; i < this.teamsNum; i++) {
            System.out.println((i + 1) + ". " + this.teams[i].shortName + " - " +
                    this.teams[i].teamName);
        }
    }

    public void deleteTeam() {
    }

    private void printOneTeam(int teamId) {
        System.out.println((teamId + 1) + ". " + this.teams[teamId].shortName + 
                " - " + this.teams[teamId].teamName);
    }
    
    private boolean addNewRecord(String shortName, String teamName) {
        if (this.teamsNum < this.maxTeams) {
            this.teams[this.teamsNum] = new TeamItem (shortName, teamName);
            this.teamsNum++;
            return true;
        } 
        else {
            return false;
        }
    }
}
