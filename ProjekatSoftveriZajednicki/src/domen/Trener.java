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
public class Trener implements OpstiDomenskiObjekat{
    
    int trenerID;
    String ime;
    String prezime;
    String email;
    String lozinka;
    boolean ulogovan;

    public Trener() {
    }

    public Trener(int trenerID, String ime, String prezime, String email, String lozinka, boolean ulogovan) {
        this.trenerID = trenerID;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.lozinka = lozinka;
        this.ulogovan = ulogovan;
    }

    

    public int getTrenerID() {
        return trenerID;
    }

    public void setTrenerID(int trenerID) {
        this.trenerID = trenerID;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public boolean isUlogovan() {
        return ulogovan;
    }

    public void setUlogovan(boolean ulogovan) {
        this.ulogovan = ulogovan;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    @Override
    public String vratiIme() {
        return "ime";
    }

    @Override
    public String vratiPrezime() {
        return "prezime";
    }

    @Override
    public String vratiIme(ResultSet rs) {
        String ime = "";
        try {
            while(rs.next()){
                ime = rs.getString("ime");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Trener.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ime;
    }

    @Override
    public String vratiPrezime(ResultSet rs) {
        String prezime = "";
        try {
            while(rs.next()){
                prezime = rs.getString("prezime");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Trener.class.getName()).log(Level.SEVERE, null, ex);
        }
        return prezime;
    }

    @Override
    public String vratiNazivTabele() {
        return "trener";
    }


    @Override
    public String uzmiID() {
        return "trenerID";
    }

    @Override
    public String vratiUslovZaID() {
        return "trener.email = '" + email + "' AND trener.lozinka = '" + lozinka + "' ";
    }

    @Override
    public int vratiID(ResultSet rs) {
        int id = 0;
        try {
            while(rs.next()){
                id = rs.getInt("trenerID");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Trener.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    @Override
    public String vratiVrednostiZaAzuriranje() {
        int login = 1;
        if(ulogovan){
            login = 0;
        }
        
        return "trener.ulogovan = " + login;
    }

    @Override
    public String vratiUslovZaAzuriranje() {
        return "trener.email = '" + email + "' AND trener.lozinka = '" + lozinka + "' ";
    }

    @Override
    public String vratiUslovZaBrisanje() {
        return "trener.trenerID = " + trenerID;
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> ucitajListu(ResultSet rs) throws SQLException {
        ArrayList<OpstiDomenskiObjekat> listaTrenera = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("trenerID");
            String ime = rs.getString("ime");
            String prezime = rs.getString("prezime");
            String email = rs.getString("email");
            String lozinka = rs.getString("lozinka");
            boolean ulogovan = rs.getBoolean("ulogovan");

            Trener t = new Trener(id, ime, prezime, email, lozinka, ulogovan);
            listaTrenera.add(t);
        }
        return listaTrenera;
    }

    @Override
    public String vratiUslovZaPretragu() {
        return "trener.email = '" + email + "' AND trener.lozinka = '" + lozinka + "' ";
    }
    
    @Override
    public String vratiKolone() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostizaUbacivanje() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
