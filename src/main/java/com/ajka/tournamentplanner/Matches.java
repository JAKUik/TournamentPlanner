/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ajka.tournamentplanner;

/**
 *
 * @author Jaroslav Kucera
 */
public class Matches {
    private Match[] matches;
    
    public void tournament(Teams teamsObj) {
        TeamItem[] teams = teamsObj.teams;
        this.matches = new Match[teamsObj.getTeamsNum() * (teamsObj.getTeamsNum() - 1) / 2];
        int matchIndex = 0;
        for (int i = 0; i < teamsObj.getTeamsNum(); i++) {
            for (int j = i + 1; j < teamsObj.getTeamsNum(); j++) {
                this.matches[matchIndex] = new Match(teams[i].shortName, teams[j].shortName);
                matchIndex++;
            }
        }
    }

    public void printMatches() {
        for (Match match : this.matches) {
            System.out.println(match.home + " vs " + match.guest);
        }
    }
}
