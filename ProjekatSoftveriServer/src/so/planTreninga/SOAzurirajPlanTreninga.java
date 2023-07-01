/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.planTreninga;

import db.DBBroker;
import domen.OpstiDomenskiObjekat;
import domen.PlanTreninga;
import domen.StavkaPlanaTreninga;
import domen.Vezbac;
import java.util.ArrayList;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author jovan
 */
public class SOAzurirajPlanTreninga extends OpstaSistemskaOperacija{

    @Override
    protected void proveriPreduslov(OpstiDomenskiObjekat odo) throws Exception {
        if(odo == null || !(odo instanceof PlanTreninga)) {
            throw new Exception("Greska");
        }
    }

    @Override
    protected void izvrsiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        
        DBBroker.getInstanca().izmeni(odo);
        
        ArrayList<StavkaPlanaTreninga> novaLista = ((PlanTreninga) odo).getStavke();
        
        StavkaPlanaTreninga stavka =  new StavkaPlanaTreninga();
        stavka.setTreningID((PlanTreninga) odo);
        ArrayList<OpstiDomenskiObjekat> staraLista = DBBroker.getInstanca().vratiJoinViseTabelaSaUslovom(stavka);
        
        for (OpstiDomenskiObjekat staro : staraLista) {
            /*OpstaSistemskaOperacija oso =  new SOIzbrisiStavku();
            oso.izvrsi(staro);*/
            db.DBBroker.getInstanca().obrisi2(staro);
        }
        
        for (OpstiDomenskiObjekat novo : novaLista) {
            /*OpstaSistemskaOperacija oso = new SOSacuvajStavke();
            oso.izvrsi(novo);*/
            DBBroker.getInstanca().kreiraj2(novo);
        }
        
    }
    
}
