/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ajka.tournamentplanner;

/**
 *  Object for a Teams
 */
public class TeamItem {
    int number;
    String shortName;
    String teamName;

    public TeamItem(int number, String shortName, String teamName) {
        this.number = number;
        this.shortName = shortName;
        this.teamName = teamName;
    }
}