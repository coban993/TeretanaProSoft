/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli;

import domen.Sprava;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author jovan
 */
public class ModelTabeleSprava extends AbstractTableModel{
    
    ArrayList<Sprava> lista;
    String[] kolone = {"naziv", "namena"};

    public ModelTabeleSprava() {
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
        Sprava s = lista.get(rowIndex);
        
        switch (columnIndex) {
            case 0: return s.getNaziv();
            case 1: return s.getNamena();
            default: return "";
        }
    }

    public ArrayList<Sprava> getLista() {
        return lista;
    }
    
    public void popuniTabeluSprava(ArrayList<Sprava> spraveBaza){
        lista = spraveBaza;
        fireTableDataChanged();
    }
    /*
    public PlanTreninga vratiPlanTreninga(int selectedRow){
         return lista.get(selectedRow);
    }
    
    public void obrisiRed(int selectedRow) {
        lista.remove(selectedRow);
        fireTableDataChanged();
    }
    */
}
