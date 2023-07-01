/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.stavke;

import db.DBBroker;
import domen.OpstiDomenskiObjekat;
import domen.StavkaPlanaTreninga;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author jovan
 */
public class SOSacuvajStavke extends OpstaSistemskaOperacija{

    @Override
    protected void proveriPreduslov(OpstiDomenskiObjekat odo) throws Exception {
        if(odo ==  null || !(odo instanceof StavkaPlanaTreninga)){
            throw new Exception("GRESKA");
        }
        
        StavkaPlanaTreninga st = (StavkaPlanaTreninga) odo;
        if(st.getTreningID() == null) throw new Exception("Nije unet plan treninga");
        if(st.getSpravaID() == null) throw new Exception("Nije uneta sprava");
    }

    @Override
    protected void izvrsiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        DBBroker.getInstanca().kreiraj2(odo);
    }
    
}
