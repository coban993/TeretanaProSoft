/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import komunikacija.KlijentskiZahtev;

/**
 *
 * @author jovan
 */
public class PokretanjeServera extends Thread{
    
    private static ArrayList<ObradaKlijentskihZahteva> klijenti = new ArrayList<>();
    private static boolean working = false;
    private ServerSocket ss;
    
    public PokretanjeServera(){
        try {
            ss = new ServerSocket(9000);
        } catch (IOException ex) {
            Logger.getLogger(PokretanjeServera.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        try {
         
            Socket s;
            System.out.println("Server je pokrenut!");
            
            while(!isInterrupted()){
               s = ss.accept();
               kontroler.Kontroler.getInstanca().dodajKlijenta(s);
               ObradaKlijentskihZahteva okz =  new ObradaKlijentskihZahteva(s, klijenti);
               okz.start();
               klijenti.add(okz);
               System.out.println("Klijent se povezao!");
            }
        } catch (SocketException ex) {
            System.out.println("Prekinula se konekcija sa serverom!");
        } catch (IOException ex) {
            System.out.println("Greska prilikom povezivanja klijenta!");
        }
    }
    
    public void zaustavi(){
        try {
            for (ObradaKlijentskihZahteva obradaKlijentskihZahteva : klijenti) {
                obradaKlijentskihZahteva.getSocket().close();
                System.out.println("Klijentski soket se zatvorio");
            }
            ss.close();
            //prodji kroz listu klijenata i zatvori sve otvorene sokete
        } catch (IOException ex) {
            Logger.getLogger(PokretanjeServera.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static boolean isWorking() {
        return working;
    }

    public static void setWorking(boolean working) {
        PokretanjeServera.working = working;
    }
    
}
