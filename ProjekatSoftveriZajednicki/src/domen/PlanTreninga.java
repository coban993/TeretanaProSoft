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
public class PlanTreninga implements OpstiDomenskiObjekat{
    
    int treningID;
    String nazivTreninga;
    String svrhaTreninga;
    int duzinaTrajanja;
    ArrayList<StavkaPlanaTreninga> stavke;
    Vezbac vezbac;
    TrenutniPlanTreninga trenutni;
    String filter;
    

    public PlanTreninga() {
    }

    public PlanTreninga(int treningID, String nazivTreninga, String svrhaTreninga, int duzinaTrajanja, ArrayList<StavkaPlanaTreninga> stavke, Vezbac vezbac, TrenutniPlanTreninga trenutni) {
        this.treningID = treningID;
        this.nazivTreninga = nazivTreninga;
        this.svrhaTreninga = svrhaTreninga;
        this.duzinaTrajanja = duzinaTrajanja;
        this.stavke = stavke;
        this.vezbac = vezbac;
        this.trenutni = trenutni;
    }

    

    public int getTreningID() {
        return treningID;
    }

    public void setTreningID(int treningID) {
        this.treningID = treningID;
    }

    public String getNazivTreninga() {
        return nazivTreninga;
    }

    public void setNazivTreninga(String nazivTreninga) {
        this.nazivTreninga = nazivTreninga;
    }

    public String getSvrhaTreninga() {
        return svrhaTreninga;
    }

    public void setSvrhaTreninga(String svrhaTreninga) {
        this.svrhaTreninga = svrhaTreninga;
    }

    public int getDuzinaTrajanja() {
        return duzinaTrajanja;
    }

    public void setDuzinaTrajanja(int duzinaTrajanja) {
        this.duzinaTrajanja = duzinaTrajanja;
    }

    public ArrayList<StavkaPlanaTreninga> getStavke() {
        return stavke;
    }

    public void setStavke(ArrayList<StavkaPlanaTreninga> stavke) {
        this.stavke = stavke;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public Vezbac getVezbac() {
        return vezbac;
    }

    public void setVezbac(Vezbac vezbac) {
        this.vezbac = vezbac;
    }

    public TrenutniPlanTreninga getTrenutni() {
        return trenutni;
    }

    public void setTrenutni(TrenutniPlanTreninga trenutni) {
        this.trenutni = trenutni;
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
        return "plantreninga";
    }

    @Override
    public String vratiKolone() {
        return "nazivTreninga,svrhaTreninga,duzinaTrajanja";
    }

    @Override
    public String vratiVrednostizaUbacivanje() {
        return "'" + nazivTreninga + "' ,'" + svrhaTreninga + "' ,'" + duzinaTrajanja +  "'";
    }

    @Override
    public String uzmiID() {
        return "treningID";
    }

    @Override
    public String vratiUslovZaID() {
         return "svrhaTreninga = " + "'"+ svrhaTreninga+ "'";
    }

    @Override
    public int vratiID(ResultSet rs) {
        int id = 0;
        try {
            while(rs.next()) {
                id = rs.getInt("treningID");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Vezbac.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    @Override
    public String vratiVrednostiZaAzuriranje() {
        return "nazivTreninga = '" + nazivTreninga + "', svrhaTreninga = '" + svrhaTreninga + "',duzinaTrajanja = " + duzinaTrajanja;
    }

    @Override
    public String vratiUslovZaAzuriranje() {
        return "treningID = " + treningID;
    }

    @Override
    public String vratiUslovZaBrisanje() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> ucitajListu(ResultSet rs) throws SQLException {
        ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();
        
        while(rs.next()){
            int id = rs.getInt("plantreninga.treningID");
            
            String naziv = rs.getString("nazivTreninga");
            String svrha = rs.getString("svrhaTreninga");
            int duzinaTrajanja1 = rs.getInt("duzinaTrajanja");
            
            int vezbacID = rs.getInt("vezbacID");
            String ime = rs.getString("ime");
            String prezime = rs.getString("prezime");
            String adresa = rs.getString("adresa");
            
            String status =  rs.getString("status");
            
            Vezbac vezbac = new Vezbac(vezbacID, ime, prezime, adresa);
            TrenutniPlanTreninga trenutni11 = new TrenutniPlanTreninga(null, vezbac, status);
            PlanTreninga plan = new PlanTreninga(id, naziv, svrha, duzinaTrajanja1,
                    null, vezbac, trenutni11);
            
            TrenutniPlanTreninga trenutni = new TrenutniPlanTreninga(plan, vezbac, status);
            
            
            lista.add(plan);
        }
        
        return lista;
    }

    @Override
    public String vratiUslovZaPretragu() {
        return "vezbac.ime LIKE '%'";
    }

    @Override
    public String vratiJoinTabelu() {
        return "trenutniplantreninga";
    }

    @Override
    public String vratiUslovZaJoin() {
        return "plantreninga.treningID = trenutniplantreninga.treningID";
    }

    @Override
    public String vratiJoinTabelu2() {
        return "vezbac";
    }

    @Override
    public String vratiUslovZaJoin2() {
        return "trenutniplantreninga.vezbacID = vezbac.vezbacID";
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
