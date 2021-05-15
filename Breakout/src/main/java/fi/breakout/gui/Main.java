/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.breakout.gui;

import fi.breakout.logics.Breakout;

/**
 * Metodi käynnistää sovelluksen ja avaa käyttöliittymän.   
 * @author Oskari
 */
public class Main {
    /**
     * Metodi luo uuden käyttöliittymän ja käynnistää sen. 
     * @param args 
     */
    public static void main(String[] args) {
        Ui ui = new Ui();
        ui.launch();
    }
}
