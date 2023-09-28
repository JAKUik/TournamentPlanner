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
    
    public Teams() {
        this.scanner = new Scanner(System.in);
    }
        
    public void addTeam(TeamItem[] teams) {
        System.out.print("Enter Short team name: ");
        String inputShortName = scanner.nextLine();
        System.out.print("Enter Full team name: ");
        String inputFullName = scanner.nextLine();
        
        
        
        
    }
    public void listTeams(TeamItem[] teams) {
        for (TeamItem item: teams) {
            if (item == null) {break;}
            System.out.println(item.number + " - " + item.shortName + 
                    item.teamName);
        }

        
    }
    public void deleteTeam(TeamItem[] teams) {
        
        
    }
}
