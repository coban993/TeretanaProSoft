/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.planTreninga;

import db.DBBroker;
import domen.OpstiDomenskiObjekat;
import domen.PlanTreninga;
import domen.Vezbac;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author jovan
 */
public class SOVratiTreningID extends OpstaSistemskaOperacija{
    
    private int id;

    public int getId() {
        return id;
    }

    @Override
    protected void proveriPreduslov(OpstiDomenskiObjekat odo) throws Exception {
        if(odo == null || !(odo instanceof PlanTreninga)) {
            throw new Exception("Greska");
        }
        
        PlanTreninga pt = (PlanTreninga) odo;
        if (pt.getNazivTreninga().isEmpty())  throw new Exception("Plan treninga nema unetu svrhu!");
        if (pt.getDuzinaTrajanja() == 0)  throw new Exception("Plan treninga nema unetu duzinu trajanja!");
        if (pt.getNazivTreninga().isEmpty())  throw new Exception("Plan treninga nema unet naziv!");
        
        
    }

    @Override
    protected void izvrsiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        id = DBBroker.getInstanca().vratiID(odo);
    }
    
}
