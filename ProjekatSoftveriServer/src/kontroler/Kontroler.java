/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroler;

import domen.OpstiDomenskiObjekat;
import domen.PlanTreninga;
import domen.Sprava;
import domen.StavkaPlanaTreninga;
import domen.Trener;
import forme.ServerForma;
import java.net.Socket;
import java.util.ArrayList;
import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;
import so.OpstaSistemskaOperacija;
import so.planTreninga.SOAzurirajPlanTreninga;
import so.planTreninga.SOKreiranjePlanaTreninga;
import so.planTreninga.SOVratiListuPlanova;
import so.planTreninga.SOVratiListuStavki;
import so.planTreninga.SOVratiTreningID;
import so.sprave.SOKreirajSpravu;
import so.sprave.SOVratiSprave;
import so.stavke.SOIzbrisiStavku;
import so.stavke.SOSacuvajStavke;
import so.trener.SOIzmeniTrenera;
import so.trener.SOPronadjiTrenera;
import so.trener.SOVratiImeTrenera;
import so.trener.SOVratiPrezimeTrenera;
import so.trener.SOVratiTrenerID;
import so.vezbac.SOAzurirajVezbaca;
import so.vezbac.SOKreirajVezbaca;
import so.vezbac.SOObrisiVezbaca;
import so.vezbac.SOVratiListuVEzbaca;
import so.vezbac.SOVratiVezbacID;

/**
 *
 * @author jovan
 */
public class Kontroler {
    
    private static Kontroler instanca;
    ServerForma sf;
    ArrayList<Socket> klijenti = new ArrayList<>();

    public Kontroler() {
    }

    public static Kontroler getInstanca() {
        if(instanca == null){
            instanca = new Kontroler();
        }
        return instanca;
    }

    public ServerForma getSf() {
        return sf;
    }

    public void setSf(ServerForma sf) {
        this.sf = sf;
    }
    
    public void dodajKlijenta(Socket socket) {
        klijenti.add(socket);
    }

    public Object pronadjiTrenera(OpstiDomenskiObjekat odo) throws Exception {
        OpstaSistemskaOperacija oso = new SOPronadjiTrenera();
        oso.izvrsi(odo);
        return ((SOPronadjiTrenera) oso).getLista();
    }

    public int vratiTrenerID(OpstiDomenskiObjekat odo) throws Exception {
        OpstaSistemskaOperacija oso = new SOVratiTrenerID();
        oso.izvrsi(odo);
        return ((SOVratiTrenerID) oso).getId();
    }

    public String vratiImeTrenera(OpstiDomenskiObjekat odo) throws Exception {
        OpstaSistemskaOperacija oso = new SOVratiImeTrenera();
        oso.izvrsi(odo);
        return ((SOVratiImeTrenera) oso).getIme();
    }

    public String vratiPrezimeTrenera(OpstiDomenskiObjekat odo) throws Exception {
        OpstaSistemskaOperacija oso = new SOVratiPrezimeTrenera();
        oso.izvrsi(odo);
        return ((SOVratiPrezimeTrenera) oso).getPrezime();
    }

    public void izmeniTrenera(OpstiDomenskiObjekat odo) throws Exception {
        OpstaSistemskaOperacija oso = new SOIzmeniTrenera();
        oso.izvrsi(odo);
    }

    public void kreirajVezbaca(OpstiDomenskiObjekat odo) throws Exception {
        OpstaSistemskaOperacija oso = new SOKreirajVezbaca();
        oso.izvrsi(odo);
    }

    public ArrayList<OpstiDomenskiObjekat> vratiListuVezbaca(OpstiDomenskiObjekat odo) throws Exception {
        OpstaSistemskaOperacija oso = new SOVratiListuVEzbaca();
        oso.izvrsi(odo);
        return ((SOVratiListuVEzbaca) oso).getLista();
    }

    public int vratiVezbaca(OpstiDomenskiObjekat odo) throws Exception {
        OpstaSistemskaOperacija oso = new SOVratiVezbacID();
        oso.izvrsi(odo);
        return ((SOVratiVezbacID) oso).getId();
    }

    public void azurirajVezbaca(OpstiDomenskiObjekat odo) throws Exception {
        OpstaSistemskaOperacija oso = new SOAzurirajVezbaca();
        oso.izvrsi(odo);
    }

    public void obrisiVezbaca(OpstiDomenskiObjekat odo) throws Exception {
        OpstaSistemskaOperacija oso = new SOObrisiVezbaca();
        oso.izvrsi(odo);
    }

    public void kreirajSpravu(OpstiDomenskiObjekat odo) throws Exception {
        OpstaSistemskaOperacija oso = new SOKreirajSpravu();
        oso.izvrsi(odo);
    }

    public ArrayList<OpstiDomenskiObjekat> vratiListuSprava(OpstiDomenskiObjekat odo) throws Exception {
        OpstaSistemskaOperacija oso = new SOVratiSprave();
        oso.izvrsi(odo);
        return ((SOVratiSprave) oso).getLista();
    }

    public void kreiranjePlanaTreninga(OpstiDomenskiObjekat odo) throws Exception {
        OpstaSistemskaOperacija oso = new SOKreiranjePlanaTreninga();
        oso.izvrsi(odo);
    }

    public ArrayList<OpstiDomenskiObjekat> vratiListuPlanovaTreninga(OpstiDomenskiObjekat odo) throws Exception {
        OpstaSistemskaOperacija oso = new SOVratiListuPlanova();
        oso.izvrsi(odo);
        return ((SOVratiListuPlanova) oso).getLista();
    }

    public int vratiIzabraniTrening(OpstiDomenskiObjekat odo) throws Exception {
        OpstaSistemskaOperacija oso = new SOVratiTreningID();
        oso.izvrsi(odo);
        return ((SOVratiTreningID) oso).getId();
    }

    public ArrayList<OpstiDomenskiObjekat> vratiListuStavki(OpstiDomenskiObjekat odo) throws Exception {
        OpstaSistemskaOperacija oso = new SOVratiListuStavki();
        oso.izvrsi(odo);
        return ((SOVratiListuStavki) oso).getLista();
    }
    
    public void azurirajTrening(OpstiDomenskiObjekat odo) throws Exception {
        OpstaSistemskaOperacija oso = new SOAzurirajPlanTreninga();
        oso.izvrsi(odo);
    }

    /*public void azurirajPlanTreninga(OpstiDomenskiObjekat odo) throws Exception {
        ArrayList<StavkaPlanaTreninga> novaLista = ((PlanTreninga) odo).getStavke();
        
        StavkaPlanaTreninga stavka =  new StavkaPlanaTreninga();
        stavka.setTreningID((PlanTreninga) odo);
        ArrayList<OpstiDomenskiObjekat> staraLista = vratiListuStavki(stavka);
        
        for (OpstiDomenskiObjekat staro : staraLista) {
            OpstaSistemskaOperacija oso =  new SOIzbrisiStavku();
            oso.izvrsi(staro);
        }
        
        for (OpstiDomenskiObjekat novo : novaLista) {
            OpstaSistemskaOperacija oso = new SOSacuvajStavke();
            oso.izvrsi(novo);
        }
    }*/

    
    
}
