/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.planTreninga;

import db.DBBroker;
import domen.OpstiDomenskiObjekat;
import domen.PlanTreninga;
import domen.StavkaPlanaTreninga;
import domen.TrenutniPlanTreninga;
import domen.Vezbac;
import java.util.ArrayList;
import java.util.List;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author jovan
 */
public class SOKreiranjePlanaTreninga extends OpstaSistemskaOperacija{

    @Override
    protected void proveriPreduslov(OpstiDomenskiObjekat odo) throws Exception {
        if (odo == null || !(odo instanceof PlanTreninga)){
            throw new Exception("Greska");
        }
         
        PlanTreninga pt = (PlanTreninga) odo;
        if (pt.getNazivTreninga().isEmpty())  throw new Exception("Plan treninga nema unet naziv!");
        if (pt.getSvrhaTreninga().isEmpty())  throw new Exception("Plan treninga nema unetu svrhu!");
        if (pt.getDuzinaTrajanja() == 0)  throw new Exception("Plan treninga nema unetu duzinu trajanja!");
    }

    @Override
    protected void izvrsiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        //DBBroker.getInstanca().sacuvaj(odo);
        
        int id = DBBroker.getInstanca().sacuvaj(odo);
              
        ArrayList<StavkaPlanaTreninga> pt = ((PlanTreninga) odo).getStavke();
        for (StavkaPlanaTreninga stavkaPlanaTreninga : pt) {
            stavkaPlanaTreninga.setIdFilter(id);
            DBBroker.getInstanca().sacuvaj2(stavkaPlanaTreninga);
        }
        
        Vezbac vezbac = ((PlanTreninga) odo).getVezbac();
        TrenutniPlanTreninga trenutni = ((PlanTreninga) odo).getTrenutni();
        trenutni.setIdDIlter(id);
        trenutni.setIdVezbacFilter(vezbac.getVezbacID());
        
        DBBroker.getInstanca().sacuvaj3(trenutni);
        
    }
    
}
