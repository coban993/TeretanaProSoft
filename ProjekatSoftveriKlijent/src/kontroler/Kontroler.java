/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroler;

import domen.Trener;

/**
 *
 * @author jovan
 */
public class Kontroler {
    
    private static Kontroler instanca;
    Trener trener;

    public static Kontroler getInstanca() {
        if(instanca == null){
            instanca = new Kontroler();
        }
        return instanca;
    }

    public Trener getTrener() {
        return trener;
    }

    public void setTrener(Trener trener) {
        this.trener = trener;
    }
    
    
    
}
