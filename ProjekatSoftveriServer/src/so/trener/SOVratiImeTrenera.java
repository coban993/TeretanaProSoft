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
public class SOVratiImeTrenera extends OpstaSistemskaOperacija{
    
    String ime;

    public String getIme() {
        return ime;
    }

    @Override
    protected void proveriPreduslov(OpstiDomenskiObjekat odo) throws Exception {
        if (odo == null || !(odo instanceof Trener)){
            throw new Exception("Greska!");
        }
        
        Trener trener = (Trener) odo;
        if(trener.getEmail().isEmpty() || trener.getLozinka().isEmpty()) throw new Exception("Trener nije uneo korisnicko ime ili lozinku!");
    }

    @Override
    protected void izvrsiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        ime = DBBroker.getInstanca().vratiIme(odo);
    }
    
}
