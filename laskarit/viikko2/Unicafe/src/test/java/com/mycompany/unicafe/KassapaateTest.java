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
        paate.syoEdullisesti(300);
        assertEquals(1, paate.edullisiaLounaitaMyyty());      
    }
    @Test
    public void kassanRahamaaraEiKasvaAlleEdullisenHinnalla() {
        paate.syoEdullisesti(230);
        assertEquals(100000, paate.kassassaRahaa());      
    }
    
    @Test
    public void syoEdullisestiEiTarpeeksiRahaaVaihtorahaOikein() {
        assertEquals(230, paate.syoEdullisesti(230));      
    }
    
    @Test
    public void syoEdullisestiEiLisaaMyytyjaLounaita() {
        paate.syoEdullisesti(230);
        assertEquals(0, paate.edullisiaLounaitaMyyty());      
    }
    
    @Test
    public void kassanRahamaaraKasvaaMaukkaastiHinnalla() {
        paate.syoMaukkaasti(450);
        assertEquals(100400, paate.kassassaRahaa());      
    }
    
    @Test
    public void syoMaukkaastiVaihtorahaOikein() {
        assertEquals(50, paate.syoMaukkaasti(450));      
    }
    
    @Test
    public void syoEMaukkaastiLisaaMyytyjaLounaita() {
        paate.syoMaukkaasti(450);
        assertEquals(1, paate.maukkaitaLounaitaMyyty());      
    }
    @Test
    public void kassanRahamaaraEiKasvaAlleMaukkaastiHinnalla() {
        paate.syoMaukkaasti(390);
        assertEquals(100000, paate.kassassaRahaa());      
    }
    
    @Test
    public void syoMaukkaastiEiTarpeeksiRahaaVaihtorahaOikein() {
        assertEquals(390, paate.syoMaukkaasti(390));      
    }
    
    @Test
    public void syoMaukkaastiEiLisaaMyytyjaLounaita() {
        paate.syoMaukkaasti(390);
        assertEquals(0, paate.maukkaitaLounaitaMyyty());      
    }
}
