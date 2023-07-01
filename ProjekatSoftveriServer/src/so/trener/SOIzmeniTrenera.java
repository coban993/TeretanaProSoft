/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.trener;

import db.DBBroker;
import domen.OpstiDomenskiObjekat;
import domen.Trener;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author jovan
 */
public class SOIzmeniTrenera extends OpstaSistemskaOperacija{

    @Override
    protected void proveriPreduslov(OpstiDomenskiObjekat odo) throws Exception {
        if(odo == null || !(odo instanceof Trener)){
            throw new Exception("Greska!");
        }
        
        Trener trener = (Trener) odo;
        if(trener.getIme().isEmpty()) throw new Exception("Trener nema uneto ime!");
        if(trener.getPrezime().isEmpty()) throw new Exception("Trener nema uneto prezime!");
        if(trener.getEmail().isEmpty()) throw new Exception("Trener nema unet email!");
        if(trener.getLozinka().isEmpty()) throw new Exception("Trener nema unetu lozinku!");
    }

    @Override
    protected void izvrsiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        DBBroker.getInstanca().izmeni(odo);
    }
    
}
