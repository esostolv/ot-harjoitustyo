package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class KassapaateTest {

    Kassapaate paate;
    Maksukortti rikas;
    Maksukortti koyha;

      @Before
    public void setUp() {
        paate = new Kassapaate();
        rikas = new Maksukortti(500);
        koyha = new Maksukortti(20);
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
    
    @Test
    public void syoMaukkaastiKortillaOttaaRahat() {
        paate.syoMaukkaasti(rikas);
        assertEquals(100, rikas.saldo());      
    }
    
    @Test
    public void syoMaukkaastiKortillaPalauttaaTrue() {
        assertTrue(paate.syoMaukkaasti(rikas));      
    }
    
    @Test
    public void syoMaukkaastiKortillaLisaaMaaraa() {
        paate.syoMaukkaasti(rikas);
        assertEquals(1, paate.maukkaitaLounaitaMyyty());     
    }
    
    @Test
    public void syoMaukkaastiKortillaEiOtaRahojaJosKoyha() {
        paate.syoMaukkaasti(koyha);
        assertEquals(20, koyha.saldo());      
    }
    
    @Test
    public void syoMaukkaastiKortillaPalauttaaFalseJosEiRahaa() {
        assertFalse(paate.syoMaukkaasti(koyha));      
    }
    
    @Test
    public void syoMaukkaastiKortillaEiLisaaMaaraaJosEiRahaa() {
        paate.syoMaukkaasti(koyha);
        assertEquals(0, paate.maukkaitaLounaitaMyyty());     
    }
    @Test
    public void kassassaOlevaRahamaaraEiMuutuJosKortillaMaukkaasti() {
        paate.syoMaukkaasti(rikas);
        assertEquals(100000, paate.kassassaRahaa());     
    }
    
    @Test
    public void syoEdullisestiKortillaOttaaRahat() {
        paate.syoEdullisesti(rikas);
        assertEquals(260, rikas.saldo());      
    }
    
    @Test
    public void syoEdullisestiKortillaPalauttaaTrue() {
        assertTrue(paate.syoEdullisesti(rikas));      
    }
    
    @Test
    public void syoEdullisestiKortillaLisaaMaaraa() {
        paate.syoEdullisesti(rikas);
        assertEquals(1, paate.edullisiaLounaitaMyyty());     
    }
    
    @Test
    public void syoEdullisestiKortillaEiOtaRahojaJosKoyha() {
        paate.syoEdullisesti(koyha);
        assertEquals(20, koyha.saldo());      
    }
    
    @Test
    public void syoEdullisestiKortillaPalauttaaFalseJosEiRahaa() {
        assertFalse(paate.syoEdullisesti(koyha));      
    }
    
    @Test
    public void syoEdullisestiKortillaEiLisaaMaaraaJosEiRahaa() {
        paate.syoEdullisesti(koyha);
        assertEquals(0, paate.edullisiaLounaitaMyyty());     
    }
    @Test
    public void kassassaOlevaRahamaaraEiMuutuJosKortillaMaukkaasti() {
        paate.syoEdullisesti(rikas);
        assertEquals(100000, paate.kassassaRahaa());     
    }
}
