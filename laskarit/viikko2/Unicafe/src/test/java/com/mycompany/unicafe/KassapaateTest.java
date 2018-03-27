
package com.mycompany.unicafe;

import com.mycompany.unicafe.Kassapaate;
import com.mycompany.unicafe.Maksukortti;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class KassapaateTest {
    
    Kassapaate kassa;
    Maksukortti kortti;
    
    public KassapaateTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.kassa = new Kassapaate();
        this.kortti = new Maksukortti(1000);
        
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void luodunKassapaatteenRahamaaraOnOikein() {
        
        assertEquals(100000, this.kassa.kassassaRahaa());
    }
    
    @Test
    public void luodunKassapaatteenMyydytLounaatOnOikein() { 
        
        assertEquals(0, this.kassa.edullisiaLounaitaMyyty());
        assertEquals(0, this.kassa.maukkaitaLounaitaMyyty());
    }
         
    
    @Test
    public void kateisostoToimiiEdullisilleLuonailleJosMaksuOnRiittava() {
        
        assertEquals(760, this.kassa.syoEdullisesti(1000));
       
        assertEquals(100240, this.kassa.kassassaRahaa());
        
        assertEquals(1, this.kassa.edullisiaLounaitaMyyty());             
        
    }
    
    @Test
    public void josMaksuEiOleRiittavaKunSyotEdullisesti() {
               
        assertEquals(100, this.kassa.syoEdullisesti(100));
        
        assertEquals(0, this.kassa.edullisiaLounaitaMyyty());
        
        assertEquals(100000, this.kassa.kassassaRahaa());
        
        
    }
    
    @Test
    public void kateisostoToimiiMaukkailleLuonailleJosMaksuOnRiittava() {
        
        assertEquals(600, this.kassa.syoMaukkaasti(1000));
       
        assertEquals(100400, this.kassa.kassassaRahaa());
        
        assertEquals(1, this.kassa.maukkaitaLounaitaMyyty());             
        
    }
    
    @Test
    public void josMaksuEiOleRiittavaKunSyotMaukkaasti() {
               
        assertEquals(100, this.kassa.syoMaukkaasti(100));
        
        assertEquals(0, this.kassa.maukkaitaLounaitaMyyty());
        
        assertEquals(100000, this.kassa.kassassaRahaa());
        
        
    }
    
          
    @Test
    public void kateisostoToimiiEdullisilleLuonailleJosKortillaOnKatetta() {
        
        assertEquals(true, this.kassa.syoEdullisesti(this.kortti));
                    
        assertEquals(100000, this.kassa.kassassaRahaa());
        
        assertEquals(1, this.kassa.edullisiaLounaitaMyyty());             
        
    }
    
    @Test
    public void josKortillaEiOleKatettaKunSyotEdullisesti() {
        
        this.kortti.otaRahaa(900);
        
        assertEquals(false, this.kassa.syoEdullisesti(this.kortti));
        
        assertEquals(0, this.kassa.edullisiaLounaitaMyyty());
        
        assertEquals(100000, this.kassa.kassassaRahaa());
        
        
    }
    
    @Test
    public void kateisostoToimiiMaukkailleLounailleJosKortillaOnKatetta() {
               
        assertEquals(true, this.kassa.syoMaukkaasti(this.kortti));
               
        assertEquals(100000, this.kassa.kassassaRahaa());
        
        assertEquals(1, this.kassa.maukkaitaLounaitaMyyty());            
        
    }
    
    @Test
    public void josKortillaEiOleKatettaKunSyotMaukkaasti() {
        
        this.kortti.otaRahaa(900);
        
        assertEquals(false, this.kassa.syoMaukkaasti(this.kortti));
        
        assertEquals(0, this.kassa.maukkaitaLounaitaMyyty());
        
        assertEquals(100000, this.kassa.kassassaRahaa());
        
        
    }
    
    @Test
    public void lataaRahaaKortille() {
        
        this.kassa.lataaRahaaKortille(this.kortti, 1);
        
        assertEquals(100001, this.kassa.kassassaRahaa());
        
        assertEquals(1001, this.kortti.saldo());
        
    }
      
            
    
    
    
    
    
    
}
