/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli;

import domen.PlanTreninga;
import java.awt.List;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author jovan
 */
public class ModelTabelePlanovi extends AbstractTableModel{
    
    ArrayList<PlanTreninga> lista;
    String[] kolone = {"Vezbac","Naziv plana treninga"};

    public ModelTabelePlanovi() {
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
        PlanTreninga pt = lista.get(rowIndex);
        
        switch (columnIndex) {
            case 0: return pt.getVezbac().getIme();
            case 1: return pt.getNazivTreninga();
            default: return "";
        }
    }

    public ArrayList<PlanTreninga> getLista() {
        return lista;
    }
    
    public void popuniTabelu(ArrayList<PlanTreninga> planBaza){
        lista = planBaza;
        fireTableDataChanged();
    }
    
    public PlanTreninga vratiPlanTreninga(int selectedRow){
         return lista.get(selectedRow);
    }
    
    public void obrisiRed(int selectedRow) {
        lista.remove(selectedRow);
        fireTableDataChanged();
    }
    
}
