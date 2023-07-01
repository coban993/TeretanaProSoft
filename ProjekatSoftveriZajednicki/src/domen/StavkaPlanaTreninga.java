/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author jovan
 */
public class StavkaPlanaTreninga implements OpstiDomenskiObjekat{
    
    PlanTreninga treningID;
    int rbStavke;
    int brojSerija;
    int brojPonavljanja;
    int duzinaOdmora;
    String opisVezbe;
    Sprava spravaID;
    int filter;
    int idFilter;

    public StavkaPlanaTreninga() {
    }

    public StavkaPlanaTreninga(PlanTreninga treningID, int rbStavke, int brojSerija, int brojPonavljanja, int duzinaOdmora, String opisVezbe, Sprava spravaID) {
        this.treningID = treningID;
        this.rbStavke = rbStavke;
        this.brojSerija = brojSerija;
        this.brojPonavljanja = brojPonavljanja;
        this.duzinaOdmora = duzinaOdmora;
        this.opisVezbe = opisVezbe;
        this.spravaID = spravaID;
    }

    public PlanTreninga getTreningID() {
        return treningID;
    }

    public void setTreningID(PlanTreninga treningID) {
        this.treningID = treningID;
    }

    public int getRbStavke() {
        return rbStavke;
    }

    public void setRbStavke(int rbStavke) {
        this.rbStavke = rbStavke;
    }

    public int getBrojSerija() {
        return brojSerija;
    }

    public void setBrojSerija(int brojSerija) {
        this.brojSerija = brojSerija;
    }

    public int getBrojPonavljanja() {
        return brojPonavljanja;
    }

    public void setBrojPonavljanja(int brojPonavljanja) {
        this.brojPonavljanja = brojPonavljanja;
    }

    public int getDuzinaOdmora() {
        return duzinaOdmora;
    }

    public void setDuzinaOdmora(int duzinaOdmora) {
        this.duzinaOdmora = duzinaOdmora;
    }

    public String getOpisVezbe() {
        return opisVezbe;
    }

    public void setOpisVezbe(String opisVezbe) {
        this.opisVezbe = opisVezbe;
    }

    public Sprava getSpravaID() {
        return spravaID;
    }

    public void setSpravaID(Sprava spravaID) {
        this.spravaID = spravaID;
    }

    public int getFilter() {
        return filter;
    }

    public void setFilter(int filter) {
        this.filter = filter;
    }

    public int getIdFilter() {
        return idFilter;
    }

    public void setIdFilter(int idFilter) {
        this.idFilter = idFilter;
    }

    @Override
    public String vratiIme() {
        return "" + idFilter + "";
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
        return "stavkaplanatreninga";
    }

    @Override
    public String vratiKolone() {
        return "treningID,rbStavke,brojSerija,brojPonavljanja,duzinaOdmora,opisVezbe,spravaID";
    }

    @Override
    public String vratiVrednostizaUbacivanje() {
        return ""  + rbStavke + ", " + brojSerija + ", " + brojPonavljanja +", "+ duzinaOdmora + ",' " +
                opisVezbe + "', " + spravaID.getSpravaID() + "";
    }
    
    
    @Override
    public String vratiVrednostiZaubacivanje2() {
        return treningID.getTreningID() + ", " + rbStavke + ", " + brojSerija + ", " + brojPonavljanja +", "+ duzinaOdmora + ",' " +
                opisVezbe + "', " + spravaID.getSpravaID();
    }

    @Override
    public String uzmiID() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiUslovZaID() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int vratiID(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
    public String vratiUslovZaBrisanje2() {
        return "treningID = " + treningID.getTreningID() + " AND rbStavke = " + rbStavke ;
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> ucitajListu(ResultSet rs) throws SQLException {
        ArrayList<OpstiDomenskiObjekat> listaStavki = new ArrayList<>();
        
        while (rs.next()) {            
            
            int rbStavke1 = rs.getInt("stavkaplanatreninga.rbStavke");
            int treningID1 = rs.getInt("stavkaplanatreninga.treningID");
            int brojSerija1 = rs.getInt("stavkaplanatreninga.brojSerija");
            int brojPonavljanja1= rs.getInt("stavkaplanatreninga.brojPonavljanja");
            int duzinaOdmora1 = rs.getInt("stavkaplanatreninga.duzinaOdmora");
            String opisVezbe1 = rs.getString("stavkaplanatreninga.opisVezbe");
            
            PlanTreninga pt = new PlanTreninga();
            pt.setTreningID(treningID1);
            
            int spravaId1 = rs.getInt("sprava.spravaID");
            String naziv1 = rs.getString("sprava.naziv");
            String namena1 = rs.getString("sprava.namena");
            
            Sprava spr = new Sprava(spravaId1, naziv1, namena1);
            
            /*StavkaPlanaTreninga s = new StavkaPlanaTreninga(treningID, rbStavke1, brojSerija1,
                    brojPonavljanja1, duzinaOdmora1, opisVezbe1, spr);*/
            StavkaPlanaTreninga s = new StavkaPlanaTreninga(pt ,rbStavke1, brojSerija1,
                    brojPonavljanja1, duzinaOdmora1, opisVezbe1, spr);
            
            
            listaStavki.add(s);
        }
        return listaStavki;
    }

    @Override
    public String vratiUslovZaPretragu() {
        return "treningID = " + filter;
    }

    @Override
    public String vratiJoinTabelu() {
        return "sprava";
    }

    @Override
    public String vratiUslovZaJoin() {
        return "stavkaplanatreninga.spravaID = sprava.spravaID";
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
        return "stavkaplanatreninga.treningID = " + treningID.getTreningID() + 
                " ORDER BY stavkaplanatreninga.rbStavke";
    }

    @Override
    public String vratiUslov2() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    @Override
    public String vratiUslovZaPretragu2() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
    
    
}
