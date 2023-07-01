/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.planTreninga;

import db.DBBroker;
import domen.OpstiDomenskiObjekat;
import domen.PlanTreninga;
import domen.StavkaPlanaTreninga;
import java.util.ArrayList;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author jovan
 */
public class SOVratiListuStavki extends OpstaSistemskaOperacija {
    
    ArrayList<OpstiDomenskiObjekat> lista;

    public ArrayList<OpstiDomenskiObjekat> getLista() {
        return lista;
    }

    @Override
    protected void proveriPreduslov(OpstiDomenskiObjekat odo) throws Exception {
        if (odo == null || !(odo instanceof StavkaPlanaTreninga)){
            throw new Exception("Greska...");
         }
    }

    @Override
    protected void izvrsiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        //lista = DBBroker.getInstanca().vratiSaUslovom(odo);
        lista = DBBroker.getInstanca().vratiJoinViseTabelaSaUslovom(odo);
    }
    
}
