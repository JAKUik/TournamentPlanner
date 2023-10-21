/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ajka.tournamentplanner;

/**
 *
 * @author Jaroslav Kucera
 */
import java.util.ArrayList;
        
public class Match {
    int matchNumber;
    String home;
    String guest;
    ArrayList<Integer> setScoresHome;
    ArrayList<Integer> setScoresGuest;
    
    public Match (String home, String guest) {
        this.home = home;
        this.guest = guest;
        this.setScoresHome = new ArrayList<>();
        this.setScoresGuest = new ArrayList<>();
    }

    public void addSetScore(int scoreHome, int scoreGuest) {
        this.setScoresHome.add(scoreHome);
        this.setScoresGuest.add(scoreGuest);
    }

    public String getScore() {
        return getScoreHome() + " : " + getScoreGuest();
    }
    
    public int getScoreHome() {
        int score = 0;
        for (int i = 0; i < setScoresHome.size(); i++) {
            if (setScoresHome.get(i) > setScoresGuest.get(i)) {
                score++;
            }
        }
        return score;
    }

    public int getScoreGuest() {
        int score = 0;
        for (int i = 0; i < setScoresGuest.size(); i++) {
            if (setScoresGuest.get(i) > setScoresHome.get(i)) {
                score++;
            }
        }
        return score;
    }
}
