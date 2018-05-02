
package DAO;


public class Nimimerkki {
    
    private String nimikerkki;
    private Integer pisteet;
    private Integer ID;
    
    public Nimimerkki(String nimimerkki, int pisteet) {
        this.nimikerkki = nimimerkki;
        this.pisteet = pisteet;
    }
    
    public Nimimerkki(String nimimerkki, int pisteet, int ID) {
        this.nimikerkki = nimimerkki;
        this.pisteet = pisteet;
        this.ID = ID;
    }
    
    public String getNimi() {
        return this.nimikerkki;
    }
    
    public int getPisteet() {
        return this.pisteet;
    }
    
    public void setID(int ID) {
        this.ID = ID;
    }
    
}
