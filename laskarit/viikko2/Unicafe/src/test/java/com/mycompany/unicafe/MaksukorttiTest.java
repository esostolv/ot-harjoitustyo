package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }

    @Test
    public void kortinSaldoAlussaOikein() {
	assertEquals("saldo: 0.10", kortti.toString());
    }

    @Test
    public void rahanLataaminenKasvattaaSaldoaOikein() {
	kortti.lataaRahaa(1000);
	assertEquals("saldo: 10.10", kortti.toString());
    }
	
	
    @Test
    public void saldoVaheneeOikeinJosRahaaTarpeeksi() {
	kortti.lataaRahaa(1000);
	kortti.otaRahaa(510);
	assert.Equals("saldo: 5.0", kortti.toString());
    }
	
    @Test
    public void saldoEiMuutuJosRahaaEiTarpeeksi() {
	kortti.otaRahaa(50);
	assertEquals("saldo: 0.10", kortti.toString());
    }

    @Test
    public void metodiPalauttaaTrueJosRahatRiittaa() {
	kortti.lataaRahaa(1000);
	kortti.otaRahaa(510);
	assert.Equals(true, kortti.otaRahaa());
    }

    @Test
    public void metodiPalauttaaFalseJosRahatEiRiita() {
	kortti.otaRahaa(50);
	assert.Equals(false, kortti.otaRahaa());
    }
}
