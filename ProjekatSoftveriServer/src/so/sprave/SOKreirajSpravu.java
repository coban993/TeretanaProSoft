/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.sprave;

import db.DBBroker;
import domen.OpstiDomenskiObjekat;
import domen.Sprava;
import domen.Vezbac;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author jovan
 */
public class SOKreirajSpravu extends OpstaSistemskaOperacija{

    @Override
    protected void proveriPreduslov(OpstiDomenskiObjekat odo) throws Exception {
        if(odo == null || !(odo instanceof Sprava)) {
            throw new Exception("Greska");
        }
        
        Sprava sprava = (Sprava) odo;
        if (sprava.getNaziv().isEmpty())  throw new Exception("Sprava nema unet naziv!");
        if (sprava.getNamena().isEmpty())  throw new Exception("Sprava nema unetu namenu!");
        
    }

    @Override
    protected void izvrsiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        DBBroker.getInstanca().kreiraj(odo);
    }
    
}
