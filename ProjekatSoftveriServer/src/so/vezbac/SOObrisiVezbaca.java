/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.vezbac;

import db.DBBroker;
import domen.OpstiDomenskiObjekat;
import domen.Vezbac;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author jovan
 */
public class SOObrisiVezbaca extends OpstaSistemskaOperacija{

    @Override
    protected void proveriPreduslov(OpstiDomenskiObjekat odo) throws Exception {
        if(odo == null || !(odo instanceof Vezbac)) {
            throw new Exception("Greska");
        }
        
        Vezbac vezbac = (Vezbac) odo;
        if (vezbac.getIme().isEmpty())  throw new Exception("Vezbac nema uneto ime!");
        if (vezbac.getPrezime().isEmpty())  throw new Exception("Vezbac nema uneto prezime!");
        if (vezbac.getAdresa().isEmpty())  throw new Exception("Vezbac nema unetu adresu stanovanja!");
    }

    @Override
    protected void izvrsiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        DBBroker.getInstanca().obrisi(odo);
    }
    
}
