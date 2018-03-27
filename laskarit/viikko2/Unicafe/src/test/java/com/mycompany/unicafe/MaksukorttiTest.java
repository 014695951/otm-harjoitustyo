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
        assertTrue(kortti != null);
    }

    @Test
    public void saldoOikeinAlussa() {

        assertEquals(kortti.saldo(), 10);
    }

    @Test
    public void rahanLataaminenOnnistuu() {

        this.kortti.lataaRahaa(10);

        assertEquals(this.kortti.saldo(), 20);

    }

    @Test
    public void saldoVaheneeJosRahaaOnTarpeeksi() {
        this.kortti.otaRahaa(5);

        assertEquals(this.kortti.saldo(), 5);
    }

    @Test
    public void saldoEiMuutuJosSaldoOnOikein() {
        this.kortti.otaRahaa(15);

        assertEquals(this.kortti.saldo(), 10);

    }

    @Test
    public void palauttaaTrueJosRahatRiittavat() {
        assertEquals(this.kortti.otaRahaa(5), true);
    }

    @Test
    public void palauttaaFalseJosRahatEivatRiita() {
        assertEquals(this.kortti.otaRahaa(15), false);
    }

}
