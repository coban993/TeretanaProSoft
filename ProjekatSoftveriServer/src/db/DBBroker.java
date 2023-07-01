/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import domen.OpstiDomenskiObjekat;
import domen.PlanTreninga;
import domen.StavkaPlanaTreninga;
import domen.TrenutniPlanTreninga;
import domen.Vezbac;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jovan
 */
public class DBBroker {
    Connection connection;
    private static DBBroker instanca;

    public DBBroker() {
        try {
            DBProperties dbp = new DBProperties();
            String url = dbp.vratiDbUrl();
            String username = dbp.vratiDbUsername();
            String password = dbp.vratiDbPassword();
            connection = DriverManager.getConnection(url, username, password);
            connection.setAutoCommit(false);
        } catch (IOException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static DBBroker getInstanca() {
        if(instanca == null){
            instanca = new DBBroker();
        }
        return instanca;
    }
    
    public void zatvori(){
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void commit(){
        try {
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void rollback(){
        try {
            connection.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<OpstiDomenskiObjekat> vratiSaUslovom(OpstiDomenskiObjekat odo) throws SQLException {
        String upit = "SELECT * FROM " + odo.vratiNazivTabele() + " WHERE " + odo.vratiUslovZaPretragu();
        System.out.println(upit);
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(upit);
        return odo.ucitajListu(rs);
    }

    public int vratiID(OpstiDomenskiObjekat odo) throws SQLException {
        String upit = "SELECT " + odo.uzmiID() + " FROM " + odo.vratiNazivTabele() + " WHERE " + odo.vratiUslovZaID();
        System.out.println(upit);
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(upit);
        return odo.vratiID(rs);
    }

    public String vratiIme(OpstiDomenskiObjekat odo) throws SQLException {
        String upit = "SELECT " + odo.vratiIme() + " FROM " + odo.vratiNazivTabele() + " WHERE " +odo.vratiUslovZaID();
        System.out.println(upit);
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(upit);
        return odo.vratiIme(rs);
    }

    public String vratiPrezime(OpstiDomenskiObjekat odo) throws SQLException {
        String upit = "SELECT " + odo.vratiPrezime()+ " FROM " + odo.vratiNazivTabele() + " WHERE " +odo.vratiUslovZaID();
        System.out.println(upit);
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(upit);
        return odo.vratiPrezime(rs);
    }

    public void izmeni(OpstiDomenskiObjekat odo) throws SQLException {
        String upit = "UPDATE " + odo.vratiNazivTabele() + " SET " + odo.vratiVrednostiZaAzuriranje()+ " WHERE " + odo.vratiUslovZaAzuriranje();
        System.out.println(upit);
        Statement st = connection.createStatement();
        st.executeUpdate(upit);
        st.close();
    }

    public void kreiraj(OpstiDomenskiObjekat odo) throws SQLException {
        String upit = "INSERT INTO " + odo.vratiNazivTabele() + "(" + odo.vratiKolone() + ")" + " VALUES (" + odo.vratiVrednostizaUbacivanje()+ ")";
        System.out.println(upit);
        PreparedStatement ps = connection.prepareStatement(upit);
        ps.executeUpdate(upit);
    }

    public void obrisi(OpstiDomenskiObjekat odo) throws SQLException {
        String upit = "DELETE FROM " + odo.vratiNazivTabele() + " WHERE " + odo.vratiUslovZaBrisanje();
        System.out.println(upit);
        PreparedStatement ps = connection.prepareStatement(upit);
        ps.executeUpdate(upit);
    }

    public ArrayList<OpstiDomenskiObjekat> vratiBezUslova(OpstiDomenskiObjekat odo) throws SQLException {
        String upit = "SELECT * FROM " + odo.vratiNazivTabele();
        System.out.println(upit);
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(upit);
        return odo.ucitajListu(rs);
    }

    /*public void sacuvaj(OpstiDomenskiObjekat odo) throws SQLException {
        String upit = "INSERT INTO " + odo.vratiNazivTabele() + "(" +
                odo.vratiKolone() + ")" + " VALUES (" + odo.vratiVrednostizaUbacivanje()+ ")";
        System.out.println(upit);
        PreparedStatement ps = connection.prepareStatement(upit, Statement.RETURN_GENERATED_KEYS);
        ps.executeUpdate();
        
        ResultSet tableKeys = ps.getGeneratedKeys();
        tableKeys.next();
        
        int planTreningaID = (int) tableKeys.getLong(1);
        System.out.println(planTreningaID);
        //
        //nema kastovanja ovde menjaj
        //
        ArrayList<StavkaPlanaTreninga> stavke = ((PlanTreninga) odo).getStavke();
        System.out.println(stavke);
        
        for (OpstiDomenskiObjekat stavkaPlanaTreninga : stavke) {
            upit = "INSERT INTO " + stavkaPlanaTreninga.vratiNazivTabele() + "(" + stavkaPlanaTreninga.vratiKolone() + ")" +
                    " VALUES (" + planTreningaID + ", " + stavkaPlanaTreninga.vratiVrednostizaUbacivanje()+ ")";
            System.out.println(upit);
            ps = connection.prepareStatement(upit);
            ps.executeUpdate();
        }
        
        Vezbac vezbac = ((PlanTreninga) odo).getVezbac();
        TrenutniPlanTreninga trenutni = ((PlanTreninga) odo).getTrenutni();
        //System.out.println("vezbac if" + vezbac.getVezbacID());
        
        String upit3 = "INSERT INTO " + trenutni.vratiNazivTabele() + "(" +
                trenutni.vratiKolone() + ")" + " VALUES (" + planTreningaID + ", "+vezbac.getVezbacID()+
                ",'"+trenutni.vratiVrednostizaUbacivanje()+ "'" + ")";
        System.out.println(upit3);
        ps = connection.prepareStatement(upit3);
        ps.executeUpdate();
        
    }*/
    
    public int sacuvaj(OpstiDomenskiObjekat odo) throws SQLException {
        String upit = "INSERT INTO " + odo.vratiNazivTabele() + "(" +
                odo.vratiKolone() + ")" + " VALUES (" + odo.vratiVrednostizaUbacivanje()+ ")";
        System.out.println(upit);
        PreparedStatement ps = connection.prepareStatement(upit, Statement.RETURN_GENERATED_KEYS);
        ps.executeUpdate();
        
        ResultSet tableKeys = ps.getGeneratedKeys();
        tableKeys.next();
        
        int planTreningaID = (int) tableKeys.getLong(1);
        System.out.println(planTreningaID);
        return planTreningaID;
    }
    
    public void sacuvaj2(OpstiDomenskiObjekat odo) throws SQLException{
            String upit = "INSERT INTO " + odo.vratiNazivTabele() + "(" + odo.vratiKolone() + ")" +
                    " VALUES (" + odo.vratiIme() + ", " + odo.vratiVrednostizaUbacivanje()+ ")";
            System.out.println(upit);
            PreparedStatement ps = connection.prepareStatement(upit);
            ps.executeUpdate();
    }
    
    public void sacuvaj3(OpstiDomenskiObjekat odo) throws SQLException{
        String upit3 = "INSERT INTO " + odo.vratiNazivTabele() + "(" +
                odo.vratiKolone() + ")" + " VALUES (" + odo.vratiIme() + ", " + odo.vratiPrezime() +
                ",'"+odo.vratiVrednostizaUbacivanje()+ "'" + ")";
        System.out.println(upit3);
        PreparedStatement ps = connection.prepareStatement(upit3);
        ps.executeUpdate();
    }

    public ArrayList<OpstiDomenskiObjekat> vratiJoinTabelu(OpstiDomenskiObjekat odo) throws SQLException {
        String upit = "SELECT * FROM "+ odo.vratiNazivTabele() + " JOIN "
                +odo.vratiJoinTabelu()+ " ON " + odo.vratiUslovZaJoin()+" JOIN "
                +odo.vratiJoinTabelu2()+ " ON " + odo.vratiUslovZaJoin2() + " WHERE " + odo.vratiUslovZaPretragu();
        System.out.println(upit);
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(upit);
        return odo.ucitajListu(rs);
    }

    public ArrayList<OpstiDomenskiObjekat> vratiJoinViseTabelaSaUslovom(OpstiDomenskiObjekat odo) throws SQLException {
        String upit = "SELECT * FROM " + odo.vratiNazivTabele() + " JOIN "
                + odo.vratiJoinTabelu() + " ON "+ odo.vratiUslovZaJoin() + " WHERE " + odo.vratiUslov();
        System.out.println(upit);
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(upit);
        return odo.ucitajListu(rs);
    }

    public void obrisi2(OpstiDomenskiObjekat odo) throws SQLException {
        String upit = "DELETE FROM " + odo.vratiNazivTabele() + " WHERE " + odo.vratiUslovZaBrisanje2();
        System.out.println(upit);
        PreparedStatement ps = connection.prepareStatement(upit);
        ps.executeUpdate(upit);
    }

    public void kreiraj2(OpstiDomenskiObjekat odo) throws SQLException {
        String upit = "INSERT INTO " + odo.vratiNazivTabele() + "(" + odo.vratiKolone() + ")" + " VALUES (" + odo.vratiVrednostiZaubacivanje2()+ ")";
        System.out.println(upit);
        PreparedStatement ps = connection.prepareStatement(upit);
        ps.executeUpdate(upit);
    }
    
    
}
