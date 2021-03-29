package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class KassapaateTest {

    Kassapaate paate;

      @Before
    public void setUp() {
        paate = new Kassapaate();
    }
    
    @Test
    public void rahaaOikeaMaara() {
        assertEquals(100000, paate.kassassaRahaa());      
    }
    @Test
    public void lounaitaMennytOikeaMaara() {
        int lounaat = paate.maukkaitaLounaitaMyyty();
        lounaat = lounaat + paate.edullisiaLounaitaMyyty();
        assertEquals(0, lounaat);      
    }
    
    @Test
    public void kassanRahamaaraKasvaaEdullisenHinnalla() {
        paate.syoEdullisesti(300);
        assertEquals(100240, paate.kassassaRahaa());      
    }
    
    @Test
    public void syoEdullisestiVaihtorahaOikein() {
        assertEquals(60, paate.syoEdullisesti(300));      
    }
    
    @Test
    public void syoEdullisestiLisaaMyytyjaLounaita() {
        assertEquals(1, paate.edullisiaLounaitaMyyty());      
    }
}
