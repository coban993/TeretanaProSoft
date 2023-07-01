/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.sprave;

import db.DBBroker;
import domen.OpstiDomenskiObjekat;
import domen.Sprava;
import java.util.ArrayList;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author jovan
 */
public class SOVratiSprave extends OpstaSistemskaOperacija{
    
    ArrayList<OpstiDomenskiObjekat> lista;

    public ArrayList<OpstiDomenskiObjekat> getLista() {
        return lista;
    }

    @Override
    protected void proveriPreduslov(OpstiDomenskiObjekat odo) throws Exception {
        if (odo == null || !(odo instanceof Sprava)){
            throw new Exception("Greska...");
         }
    }

    @Override
    protected void izvrsiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        lista = DBBroker.getInstanca().vratiBezUslova(odo);
    }
    
}
