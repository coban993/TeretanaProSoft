/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

import java.io.Serializable;

/**
 *
 * @author jovan
 */
public class ServerskiOdgovor implements Serializable{
    
    Object odgovor;
    String poruka;
    boolean uspesno;
    String operacija;

    public ServerskiOdgovor() {
    }

    public ServerskiOdgovor(Object odgovor, String poruka, boolean uspesno, String operacija) {
        this.odgovor = odgovor;
        this.poruka = poruka;
        this.uspesno = uspesno;
        this.operacija = operacija;
    }

    public Object getOdgovor() {
        return odgovor;
    }

    public void setOdgovor(Object odgovor) {
        this.odgovor = odgovor;
    }

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }

    public boolean isUspesno() {
        return uspesno;
    }

    public void setUspesno(boolean uspesno) {
        this.uspesno = uspesno;
    }

    public String getOperacija() {
        return operacija;
    }

    public void setOperacija(String operacija) {
        this.operacija = operacija;
    }
    
    
}
