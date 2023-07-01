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
public class KlijentskiZahtev implements Serializable{
    
    int operacija;
    Object parametar;

    public KlijentskiZahtev() {
    }

    public KlijentskiZahtev(int operacija, Object parametar) {
        this.operacija = operacija;
        this.parametar = parametar;
    }

    public int getOperacija() {
        return operacija;
    }

    public void setOperacija(int operacija) {
        this.operacija = operacija;
    }

    public Object getParametar() {
        return parametar;
    }

    public void setParametar(Object parametar) {
        this.parametar = parametar;
    }
    
    
    
}
