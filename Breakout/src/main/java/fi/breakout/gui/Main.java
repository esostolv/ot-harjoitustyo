/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.breakout.gui;

import fi.breakout.logics.Breakout;

/**
 * Luokka käynnistää sovelluksen ja luo uuden käyttöliittymän. 
 * @author Oskari
 */
public class Main {
    /**
     * Metodi luo uuden käyttöliittymän ja käynnistää sen. 
     * @param args 
     */
    public static void main(String[] args) {
        //Breakout b = new Breakout();
        Ui ui = new Ui();
        ui.launch();
    }
}
