/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ajka.tournamentplanner;

/**
 *
 * @author Jaroslav Kucera
 */
    
import javax.swing.JOptionPane;

public class MenuG {

    public int getChoice(MenuItem[] menuItems) {
        // Print menu
        StringBuilder menu = new StringBuilder();
        menu.append("  M E N U \n \n");

        for (MenuItem item: menuItems) {
            if (item.number != 0) {
                menu.append(item.number + ". " + item.text + "\n");
            }
            else {
                menu.append("\n");
            }
        }
        menu.append("\n");

        String input = JOptionPane.showInputDialog(null, menu.toString(), "Enter your choice", JOptionPane.QUESTION_MESSAGE);
        
        int choice;
        try {
            choice = Integer.parseInt(input);
            boolean isInMenu = false;
            for (MenuItem item: menuItems) {
                if (item.number == choice) {
                    isInMenu = true;
                    break;
                }
            }
            if (!isInMenu) {
                choice = 0;
            }
        } catch (NumberFormatException e) {
            choice = 0;
        }
        
        return choice;
    }
}
