package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class KassapaateTest {

    Kassapaate paate;


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
    
}
