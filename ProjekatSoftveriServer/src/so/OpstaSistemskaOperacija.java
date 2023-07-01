/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import db.DBBroker;
import domen.OpstiDomenskiObjekat;

/**
 *
 * @author jovan
 */
public abstract class OpstaSistemskaOperacija {
    
    public void izvrsi(OpstiDomenskiObjekat odo) throws Exception{
        try {
            proveriPreduslov(odo);
            izvrsiOperaciju(odo);
            potvrdi();
        } catch (Exception ex) {
            ponisti();
            throw new Exception("GRESKA: so -> " + ex.getMessage());
        }
    }

    protected abstract void proveriPreduslov(OpstiDomenskiObjekat odo) throws Exception;

    protected abstract void izvrsiOperaciju(OpstiDomenskiObjekat odo) throws Exception;

    private void potvrdi() {
        DBBroker.getInstanca().commit();
    }
    
    private void ponisti(){
        DBBroker.getInstanca().rollback();
    }
}
