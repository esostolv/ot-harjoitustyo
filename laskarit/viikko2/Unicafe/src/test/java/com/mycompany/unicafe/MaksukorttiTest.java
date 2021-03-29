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
	assertEquals("saldo: 10.0", kortti.toString());
    }

    @Test
    public void rahanLataaminenKasvattaaSaldoaOikein() {
	kortti.lataaRahaa(10);
	assertEquals("saldo: 20.0", kortti.toString());
    }
}
