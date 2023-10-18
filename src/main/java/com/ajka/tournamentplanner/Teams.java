package com.ajka.tournamentplanner;

/**
 *
 * @author Jaroslav Kučera
 */

import javax.swing.JOptionPane;

public class Teams {
    private final TeamItem[] teams;
    private final int maxTeams = 128;
    private int teamsNum = 0;   // Teams counter

    public Teams() {
        this.teams = new TeamItem[this.maxTeams];
        // for testing only
        this.addNewRecord("AJK", "aJKa Software");
        this.addNewRecord("ABC", "Abeceda");
    }
        
    public void addOneTeam() {
        String inputShortName = "";
        while (true) {            
            inputShortName = JOptionPane.showInputDialog(null, null, 
                "Enter the short team name (3 chars): ", JOptionPane.QUESTION_MESSAGE);

            if (inputShortName.isEmpty()) {
                JOptionPane.showMessageDialog(null, 
                        "The short name must be entered.");
            }
            else {
                inputShortName = inputShortName.substring(0, 3).toUpperCase();
                if (isShortName(inputShortName) >= 0) {
                    JOptionPane.showMessageDialog(null, 
                            "The short name '" + inputShortName + 
                                    "' already exists.");
                }
                else {break;}
            }
        }
        String inputFullName = JOptionPane.showInputDialog(null, 
                "Short name team: " + inputShortName, 
                "Enter full team name: ", JOptionPane.QUESTION_MESSAGE);

        if (this.addNewRecord(inputShortName, inputFullName)) {
            JOptionPane.showMessageDialog(null, "You add this new team: " + 
                    oneTeamToString(teamsNum - 1));
        } 
        else {
            JOptionPane.showMessageDialog(null, 
                    "The maximum number of teams has been entered.");
        }
    }

    public void showAllTeams() {
        JOptionPane.showMessageDialog(null, listTeamsBuilder(), 
                "TEAMS LIST", 1);
    }
    
    public void deleteOneTeam() {
        if (this.teamsNum == 0) {
            JOptionPane.showMessageDialog(null, 
                    "The team list is empty.");
            return;
        }
        StringBuilder text = listTeamsBuilder();
        String deleteName = JOptionPane.showInputDialog(null, text, 
                "Entry short team name to delete", JOptionPane.QUESTION_MESSAGE);
        int id = isShortName(deleteName);
        if (id == -1) {
            if (! deleteName.isEmpty()) {
                JOptionPane.showMessageDialog(null, 
                        "The team '" + deleteName + "' doesn't exist.");
            }
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
            JOptionPane.showMessageDialog(null, 
                    "The team '" + deleteName + "' was deleted.");
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

    /**
     * Create and return list of all teams
     */
    public StringBuilder listTeamsBuilder() {
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < this.teamsNum; i++) {
            text.append(oneTeamToString(i));

        }
        return text;
    }

    private String oneTeamToString(int teamId) {
        return this.teams[teamId].shortName + " - " 
                + this.teams[teamId].teamName + "\n";
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
