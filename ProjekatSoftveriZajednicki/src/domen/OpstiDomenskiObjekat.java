/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author jovan
 */
public interface OpstiDomenskiObjekat extends Serializable{
    
    public String vratiIme();
    public String vratiPrezime();
    public String vratiIme(ResultSet rs);
    public String vratiPrezime(ResultSet rs);
    
    public String vratiNazivTabele();
    public String vratiKolone();
    public String vratiVrednostizaUbacivanje();
    
    public String uzmiID();
    public String vratiUslovZaID();
    public int vratiID(ResultSet rs);
    
    public String vratiVrednostiZaAzuriranje();
    public String vratiUslovZaAzuriranje();
    public String vratiUslovZaBrisanje();
    public ArrayList<OpstiDomenskiObjekat> ucitajListu(ResultSet rs) throws SQLException;
    
    public String vratiUslovZaPretragu();
    

    public String vratiJoinTabelu();
    public String vratiUslovZaJoin();
    public String vratiJoinTabelu2();
    public String vratiUslovZaJoin2();
    public String vratiJoinTabelu3();
    public String vratiUslovZaJoin3();

    public String vratiUslov();
    public String vratiUslov2();

    public String vratiVrednostiZaubacivanje2();

    public String vratiUslovZaPretragu2();

    public String vratiUslovZaBrisanje2();
}
