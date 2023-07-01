/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import static com.sun.corba.se.impl.util.Utility.printStackTrace;
import domen.OpstiDomenskiObjekat;
import domen.PlanTreninga;
import domen.Sprava;
import domen.StavkaPlanaTreninga;
import domen.Trener;
import domen.Vezbac;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import komunikacija.KlijentskiZahtev;
import komunikacija.ServerskiOdgovor;

/**
 *
 * @author jovan
 */
public class ObradaKlijentskihZahteva extends Thread{

    Socket s;
    ArrayList<ObradaKlijentskihZahteva> klijenti;
    boolean kraj = false;
    Trener trener;

    public ObradaKlijentskihZahteva(Socket s, ArrayList<ObradaKlijentskihZahteva> klijenti) {
        this.s = s;
        this.klijenti = klijenti;
    }
    
    @Override
    public void run() {
        while(!kraj){
            try {
                System.out.println("Ceka se klijentski zahtev...");
                KlijentskiZahtev kz = primiZahtev();
                ServerskiOdgovor so = new ServerskiOdgovor();
                switch (kz.getOperacija()) {
                    case operacije.Operacije.LOGIN:
                        trener = (Trener) kz.getParametar();
                        ArrayList<Trener> listaTrenera = (ArrayList<Trener>) kontroler.Kontroler.getInstanca().pronadjiTrenera((OpstiDomenskiObjekat) trener);
                        if(listaTrenera.isEmpty()){
                            try {
                                throw new Exception();
                            } catch (Exception ex) {
                                Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        for(int i =0; i< listaTrenera.size(); i++){
                            Trener tr = listaTrenera.get(i);
                            if((trener.getEmail().equals(tr.getEmail()) && trener.getLozinka().equals(tr.getLozinka()))
                                    && tr.isUlogovan()){
                                so.setPoruka("Vec ste se ulogovali");
                                so.setUspesno(false);
                            }else{
                                trener.setTrenerID(kontroler.Kontroler.getInstanca().vratiTrenerID((OpstiDomenskiObjekat) kz.getParametar()));
                                trener.setIme(kontroler.Kontroler.getInstanca().vratiImeTrenera((OpstiDomenskiObjekat) kz.getParametar()));
                                trener.setPrezime(kontroler.Kontroler.getInstanca().vratiPrezimeTrenera((OpstiDomenskiObjekat) kz.getParametar()));
                                kontroler.Kontroler.getInstanca().izmeniTrenera((OpstiDomenskiObjekat) kz.getParametar());
                                trener.setUlogovan(true);
                                so.setOdgovor(trener);
                                so.setPoruka("Trener "+trener.toString()+" se uspesno ulogovao!");
                                so.setUspesno(true);
                            }
                        }
                        break;
                    case operacije.Operacije.LOGOUT:
                        try {
                            kontroler.Kontroler.getInstanca().izmeniTrenera(trener);
                            kraj = true;
                            so.setUspesno(true);
                            so.setPoruka("Uspesno ste se izlogovali");
                        } catch (Exception e) {
                            so.setUspesno(false);
                            so.setPoruka("Greska prilikom odjavljivanja");
                        }
                        break;
                    case operacije.Operacije.KREIRAJ_VEZBACA:
                        try {
                            kontroler.Kontroler.getInstanca().kreirajVezbaca((OpstiDomenskiObjekat)kz.getParametar());
                            so.setPoruka("Vezbac je kreiran");
                            so.setUspesno(true);
                        } catch (Exception e) {
                            so.setPoruka("Vezbac nije kreiran, dogodila se greska");
                            so.setUspesno(false);
                        }
                        break;
                    case operacije.Operacije.VRATI_LISTU_VEZBACA:
                        try {
                            ArrayList<OpstiDomenskiObjekat> listaVezbaca = kontroler.Kontroler.getInstanca().vratiListuVezbaca((OpstiDomenskiObjekat)kz.getParametar());
                            so.setOdgovor(listaVezbaca);
                            if(((ArrayList<Vezbac>) so.getOdgovor()).isEmpty()){
                                throw new Exception();
                            }
                            so.setPoruka("Pronadjen je vezbac po zadatoj vrednosti");
                            so.setUspesno(true);
                        } catch (Exception e) {
                            so.setPoruka("Sistem nije mogao da nadje vezbace/a po zadatoj vrednosti");
                            so.setUspesno(false);
                        }
                        break;
                    case operacije.Operacije.VRATI_IZABRANOG_VEZBACA:
                        try {
                            int id = kontroler.Kontroler.getInstanca().vratiVezbaca((OpstiDomenskiObjekat) kz.getParametar());
                            so.setOdgovor(id);
                            so.setPoruka("Vezbac je uspesno ucitan");
                            so.setUspesno(true);
                        } catch (Exception e) {
                            so.setPoruka("Sistem nije uspeo da ucita vezbaca");
                            so.setUspesno(false);
                        }
                        break;
                    case operacije.Operacije.AZURIRAJ_VEZBACA:
                        try {
                            kontroler.Kontroler.getInstanca().azurirajVezbaca((OpstiDomenskiObjekat) kz.getParametar());
                            so.setPoruka("Uspesno ste azurirali podatke o vezbacu");
                            so.setUspesno(true);
                        } catch (Exception e) {
                            so.setPoruka("Sistem nije uspeo da promeni podatke o vezbacu");
                            so.setUspesno(false);
                        }
                        break;
                    case operacije.Operacije.OBRISI_VEZBACA:
                        try {
                            kontroler.Kontroler.getInstanca().obrisiVezbaca((OpstiDomenskiObjekat) kz.getParametar());
                            so.setPoruka("Uspesno ste obrisali vezbaca");
                            so.setUspesno(true);
                        } catch (Exception ex) {
                            so.setPoruka("Sistem nije uspeo da obrise vezbaca");
                            so.setUspesno(false);
                        }
                        break;
                    case operacije.Operacije.KREIRAJ_SPRAVU:
                        try {
                            kontroler.Kontroler.getInstanca().kreirajSpravu((OpstiDomenskiObjekat)kz.getParametar());
                            so.setPoruka("Sprava je kreirana");
                            so.setUspesno(true);
                        } catch (Exception e) {
                            so.setPoruka("Sprava nije kreirana, dogodila se greska");
                            so.setUspesno(false);
                        }
                        break;
                    case operacije.Operacije.VRATI_LISTU_SPRAVA:
                        try {
                            ArrayList<OpstiDomenskiObjekat> sprave = kontroler.Kontroler.getInstanca().vratiListuSprava((OpstiDomenskiObjekat) kz.getParametar());
                            so.setOdgovor(sprave);
                            so.setPoruka("Uspesno je ucitana lista sprava");
                            so.setUspesno(true);
                        } catch (Exception ex) {
                            so.setPoruka("Sistem ne moze da ucita sprave");
                            so.setUspesno(false);
                        }
                        break;
                    case operacije.Operacije.KREIRANJE_PLANA_TRENINGA:
                        try {
                            kontroler.Kontroler.getInstanca().kreiranjePlanaTreninga((OpstiDomenskiObjekat) kz.getParametar());
                            so.setPoruka("Uspesno ste kreirali plan treninga");
                            so.setUspesno(true);
                        } catch (Exception e) {
                            so.setPoruka("Sistem nije uspeo da kreira plan treninga");
                            so.setUspesno(true);
                        }
                        break;
                    case operacije.Operacije.VRATI_LISTU_PLANOVA_TRENINGA:
                        try {
                            ArrayList<OpstiDomenskiObjekat> planovi = kontroler.Kontroler.getInstanca().vratiListuPlanovaTreninga((OpstiDomenskiObjekat) kz.getParametar());
                            so.setOdgovor(planovi);
                            so.setPoruka("Uspesno je ucitana lista planova treninga");
                            so.setUspesno(true);
                        } catch (Exception ex) {
                            so.setPoruka("Sistem ne moze da ucita planove treninga");
                            so.setUspesno(false);
                        }
                        break;
                    case operacije.Operacije.VRATI_IZABRAN_PLAN_TRENINGA:
                        try {
                            int id = kontroler.Kontroler.getInstanca().vratiIzabraniTrening((OpstiDomenskiObjekat) kz.getParametar());
                            so.setOdgovor(id);
                            so.setPoruka("Plan treninga je uspesno ucitan");
                            so.setUspesno(true);
                        } catch (Exception e) {
                            so.setPoruka("Sistem nije uspeo da ucita plan treninga");
                            so.setUspesno(false);
                        }
                        break;
                    case operacije.Operacije.VRATI_LISTU_STAVKI:
                        try {
                            PlanTreninga plan = (PlanTreninga) kz.getParametar();
                            StavkaPlanaTreninga stpt = new StavkaPlanaTreninga();
                            stpt.setTreningID(plan);
                            ArrayList<OpstiDomenskiObjekat> stavke = kontroler.Kontroler.getInstanca().vratiListuStavki((OpstiDomenskiObjekat) stpt);
                            so.setOdgovor(stavke);
                            so.setPoruka("Sistem je uspesno ucitao stavke");
                            so.setUspesno(true);
                        } catch (Exception e) {
                            so.setPoruka("Sistem ne moze da ucita stavke");
                            so.setUspesno(false);
                        }
                        break;
                    /*case operacije.Operacije.SACUVAJ_IZMENE_TRENINGA:
                        try {
                            kontroler.Kontroler.getInstanca().azurirajPlanTreninga((OpstiDomenskiObjekat) kz.getParametar());
                            so.setPoruka("Uspesno ste promenili podatke od planu treninga");
                            so.setUspesno(true);
                        } catch (Exception e) {
                            so.setPoruka("Sistem nije uspeo da promeni podatke o planu treninga");
                            so.setUspesno(false);
                        }
                        break;*/
                    case operacije.Operacije.IZMENI_TRENING:
                        try {
                            kontroler.Kontroler.getInstanca().azurirajTrening((OpstiDomenskiObjekat) kz.getParametar());
                            so.setPoruka("Uspesno ste azurirali podatke o planu treninga");
                            so.setUspesno(true);
                        } catch (Exception e) {
                            so.setPoruka("Sistem nije uspeo da promeni podatke o planu treninga");
                            so.setUspesno(false);
                        }
                        break;
  
                }
                posaljiOdgovor(so);
            } catch (Exception ex) {
                Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private KlijentskiZahtev primiZahtev() {
        try {
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            return (KlijentskiZahtev) ois.readObject();
        } catch (IOException ex) {
            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private void posaljiOdgovor(ServerskiOdgovor so) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
            oos.writeObject(so);
        } catch (IOException ex) {
            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Socket getSocket() {
        return s;
    }

    
    
}
