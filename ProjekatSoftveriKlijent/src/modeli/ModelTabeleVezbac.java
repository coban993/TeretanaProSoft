/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli;

import domen.Vezbac;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author jovan
 */
public class ModelTabeleVezbac extends AbstractTableModel{
    
    ArrayList<Vezbac> lista;
    String[] kolone = {"Ime","Prezime","Adresa"};

    public ModelTabeleVezbac() {
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
        Vezbac v = lista.get(rowIndex);
        
        switch (columnIndex) {
            case 0: return v.getIme();
            case 1: return v.getPrezime();
            case 2: return v.getAdresa();  
            default: return "";
        }
    }

    public ArrayList<Vezbac> getLista() {
        return lista;
    }
    
    public void popuniTabelu(ArrayList<Vezbac> vezbaci){
        lista = vezbaci;
        fireTableDataChanged();
    }
    
    public Vezbac vratiVezbaca(int selectedRow){
        return lista.get(selectedRow);
    }
    
}
