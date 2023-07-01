/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli;

import domen.Sprava;
import domen.StavkaPlanaTreninga;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author jovan
 */
public class ModelTabeleStavke extends AbstractTableModel{
    
    ArrayList<StavkaPlanaTreninga> lista;
    String[] kolone = {"RB","Broj serija", "Broj ponavljanja","Duzina odmora","Opis vezbe","Sprava"};
    int rb = 0;

    public ModelTabeleStavke() {
        lista = new ArrayList<>();
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }


    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StavkaPlanaTreninga s = lista.get(rowIndex);
        
        switch (columnIndex) {
            case 0: return s.getRbStavke();
            case 1: return s.getBrojSerija();
            case 2: return s.getBrojPonavljanja();
            case 3: return s.getDuzinaOdmora();
            case 4: return s.getOpisVezbe();
            case 5: return s.getSpravaID();
            default: return "";
        }
    }

    public ArrayList<StavkaPlanaTreninga> getLista() {
        return lista;
    }
    
    public boolean vecPostoji(Sprava sprava){
        for (StavkaPlanaTreninga stavkaPlanaTreninga : lista) {
            if(stavkaPlanaTreninga.getSpravaID().equals(sprava)){
                return true;
            }
        }
        return false;
    }
    
    public void dodajStavku(StavkaPlanaTreninga stz){
        rb = lista.size();
        stz.setRbStavke(++rb);
        lista.add(stz);
        fireTableDataChanged();
    }
    
    public void obrisiRed(int selectedRow){
        lista.remove(selectedRow);
        rb = 0;
        
        for (StavkaPlanaTreninga stavkaPlanaTreninga : lista) {
            stavkaPlanaTreninga.setRbStavke(++rb);
        }
        
        fireTableDataChanged();
    }
    
    public void popuniTabelu(ArrayList<StavkaPlanaTreninga> lista){
        this.lista = lista;
    }
    
    public int vratiRB(){
        int rb = 0;
        for (StavkaPlanaTreninga stavkaPlanaTreninga : lista) {
            rb++;
        }
        return rb + 1;
    }
    
}
