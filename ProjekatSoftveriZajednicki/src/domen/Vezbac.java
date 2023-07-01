/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jovan
 */
public class Vezbac implements OpstiDomenskiObjekat{
    
    int vezbacID;
    String ime;
    String prezime;
    String adresa;
    String filter;
    
    public Vezbac() {
    }

    public Vezbac(int vezbacID, String ime, String prezime, String adresa) {
        this.vezbacID = vezbacID;
        this.ime = ime;
        this.prezime = prezime;
        this.adresa = adresa;
    }

    

    public int getVezbacID() {
        return vezbacID;
    }

    public void setVezbacID(int vezbacID) {
        this.vezbacID = vezbacID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    @Override
    public String vratiIme() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiPrezime() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiIme(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiPrezime(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiNazivTabele() {
        return "vezbac";
    }

    @Override
    public String vratiKolone() {
        return "ime, prezime, adresa";
    }

    @Override
    public String vratiVrednostizaUbacivanje() {
        return "'" + ime + "' ,'" + prezime + "' ,'" + adresa +  "'";
    }

    @Override
    public String uzmiID() {
        return "vezbacID";
    }

    @Override
    public String vratiUslovZaID() {
        return "ime = '" + ime + "' AND prezime = '" + prezime + "' AND adresa = '" + adresa + "'";
    }

    @Override
    public int vratiID(ResultSet rs) {
        int id = 0;
        try {
            while(rs.next()) {
                id = rs.getInt("vezbacID");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Vezbac.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    @Override
    public String vratiVrednostiZaAzuriranje() {
         return "ime = '" + ime + "', prezime = '" + prezime + "' , adresa = '" + adresa + "'";
    }

    @Override
    public String vratiUslovZaAzuriranje() {
        return "vezbacID = " + vezbacID;
    }

    @Override
    public String vratiUslovZaBrisanje() {
        return " vezbacID = " + vezbacID;
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> ucitajListu(ResultSet rs) throws SQLException {
        ArrayList<OpstiDomenskiObjekat> listaVezbaca = new ArrayList<>();
        
        while (rs.next()) {            
            int id = rs.getInt("vezbacID");
            String ime = rs.getString("ime");
            String prezime = rs.getString("prezime");
            String adresa = rs.getString("adresa");
            
            Vezbac v = new Vezbac(vezbacID, ime, prezime, adresa);
            listaVezbaca.add(v);
        }
        return listaVezbaca;
    }

    @Override
    public String vratiUslovZaPretragu() {
        if(filter.equals("")){
            return "prezime LIKE '%'"; 
        }
        return "prezime LIKE " + "'" + filter + "%'";
    }

    @Override
    public String vratiJoinTabelu() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiUslovZaJoin() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiJoinTabelu2() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiUslovZaJoin2() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiJoinTabelu3() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiUslovZaJoin3() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiUslov() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiUslov2() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaubacivanje2() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiUslovZaPretragu2() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiUslovZaBrisanje2() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
