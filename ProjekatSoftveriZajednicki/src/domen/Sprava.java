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
public class Sprava implements OpstiDomenskiObjekat{
    
    int spravaID;
    String naziv;
    String namena;
    String filter;

    public Sprava() {
    }

    public Sprava(int spravaID, String naziv, String namena) {
        this.spravaID = spravaID;
        this.naziv = naziv;
        this.namena = namena;
    }

    public int getSpravaID() {
        return spravaID;
    }

    public void setSpravaID(int spravaID) {
        this.spravaID = spravaID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getNamena() {
        return namena;
    }

    public void setNamena(String namena) {
        this.namena = namena;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    @Override
    public String toString() {
        return naziv;
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
        return "sprava";
    }

    @Override
    public String vratiKolone() {
        return "naziv, namena";
    }

    @Override
    public String vratiVrednostizaUbacivanje() {
        return "'" + naziv + "' ,'" + namena + "'";
    }

    @Override
    public String uzmiID() {
        return "spravaID";
    }

    @Override
    public String vratiUslovZaID() {
        return "naziv = '" + naziv + "' AND namena= '" + namena + "'";
    }

    @Override
    public int vratiID(ResultSet rs) {
        int id = 0;
        try {
            while(rs.next()) {
                id = rs.getInt("spravaID");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Vezbac.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    @Override
    public String vratiVrednostiZaAzuriranje() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiUslovZaAzuriranje() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiUslovZaBrisanje() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> ucitajListu(ResultSet rs) throws SQLException {
        ArrayList<OpstiDomenskiObjekat> listaSprava = new ArrayList<>();
        
        while (rs.next()) {            
            int id = rs.getInt("spravaID");
            String naziv1 = rs.getString("naziv");
            String namena1 = rs.getString("namena");
            
            Sprava s = new Sprava(id, naziv1, namena1);
            listaSprava.add(s);
            
        }
        return listaSprava;
    }

    @Override
    public String vratiUslovZaPretragu() {
        if(filter.equals("")){
            return "namena LIKE '%'"; 
        }
        return "namena LIKE " + "'" + filter + "%'";
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
