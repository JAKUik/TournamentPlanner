/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ajka.tournamentplanner;

/**
 *
 * @author Jaroslav Kučera
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
        // for testing only
        this.addNewRecord("AJK", "aJKa Software");
        this.addNewRecord("ABC", "Abeceda");
    }
        
    // Add one team
    public void addTeam() {
        String inputShortName = "";
        while (true) {            
            System.out.print("Enter the short team name (3 chars): ");
            inputShortName = scanner.nextLine();

            if (inputShortName.isEmpty()) {
                System.out.println("The short name must be entered.");
            }
            else {
                inputShortName = inputShortName.substring(0, 3).toUpperCase();
                if (isShortName(inputShortName) >= 0) {
                    System.out.println("The short name '" + inputShortName + 
                            "' already exists.");
                }
                else {break;}
            }
        }
        System.out.print("Enter Full team name: ");
        String inputFullName = scanner.nextLine();

        if (this.addNewRecord(inputShortName, inputFullName)) {
            System.out.println("You add this new team: ");
            printOneTeam(teamsNum - 1);
        } 
        else {
            System.out.println("The maximum number of teams has been entered.");
        }
    }

    // Print all teams
    public void listTeams() {
        for (int i = 0; i < this.teamsNum; i++) {
            printOneTeam(i);
//            System.out.println(this.teams[i].shortName + " - " +
//                    this.teams[i].teamName);
        }
    }

    public void deleteTeam() {
        if (this.teamsNum == 0) {
            System.out.println("The team list is empty.");
            return;
        }
        listTeams();
        System.out.println("Entry s short team name to delete");
        String deleteName = scanner.nextLine();
        int id = isShortName(deleteName);
        if (id == -1) {
            System.out.println("The team '" + deleteName + "' doesn't exist.");
        }
        else {
            this.teams[id].shortName = "";
            this.teams[id].teamName = "";
        // Pack list
            for (int i = id + 1; i < this.teamsNum; i++) {
                this.teams[i-1].shortName = this.teams[i].shortName;
                this.teams[i-1].teamName = this.teams[i].teamName;
                this.teams[i].shortName = "";
                this.teams[i].teamName = "";
            }
            this.teamsNum--;
        }
        
    }

    private int isShortName(String shortName) {
        for (int i = 0; i < this.teamsNum; i++) {
            if (this.teams[i].shortName.equals(shortName)) {
                return i;
            }
        }
        return -1;
    }
    
    private void printOneTeam(int teamId) {
        System.out.println(this.teams[teamId].shortName + 
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
