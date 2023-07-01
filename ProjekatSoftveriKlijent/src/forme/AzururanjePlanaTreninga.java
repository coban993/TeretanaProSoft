/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forme;

import domen.PlanTreninga;
import domen.Sprava;
import domen.StavkaPlanaTreninga;
import domen.TrenutniPlanTreninga;
import domen.Vezbac;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import komunikacija.KlijentskiZahtev;
import komunikacija.ServerskiOdgovor;
import modeli.ModelTabeleStavke;

/**
 *
 * @author jovan
 */
public class AzururanjePlanaTreninga extends javax.swing.JFrame {
    //int id = 0;
    private  PlanTreninga planTreninga;
    /**
     * Creates new form AzururanjePlanaTreninga
     */
    public AzururanjePlanaTreninga() {
        initComponents();
        setTitle("Azuriranje plana treninga");
        setLocationRelativeTo(null);
        tblStavke.setModel(new ModelTabeleStavke());
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtSvrha = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNaziv = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDuzina = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStavke = new javax.swing.JTable();
        btnOtkazi = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        btnSacuvaj = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Svrha");

        jLabel2.setText("Naziv ");

        jLabel3.setText("Duzina trajanja(min)");

        tblStavke.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblStavke);

        btnOtkazi.setText("Otkazi");
        btnOtkazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOtkaziActionPerformed(evt);
            }
        });

        btnObrisi.setText("Obrisi iz plana treninga");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        btnSacuvaj.setText("SACUVAJ");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                                .addComponent(txtDuzina, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNaziv, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
                                    .addComponent(txtSvrha)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(366, 366, 366)
                        .addComponent(btnSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(105, 105, 105)
                        .addComponent(btnObrisi)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(99, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnOtkazi)
                        .addGap(33, 33, 33))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtSvrha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDuzina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnObrisi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(btnOtkazi)
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOtkaziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOtkaziActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnOtkaziActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
       int selectedRow = tblStavke.getSelectedRow();
        
        if(selectedRow == -1 ){
            JOptionPane.showMessageDialog(this, "Molimo Vas izaberite stavku");
            return;
        }
        
        ModelTabeleStavke mts = (ModelTabeleStavke) tblStavke.getModel();
        mts.obrisiRed(selectedRow);
    }//GEN-LAST:event_btnObrisiActionPerformed

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed

        int id = planTreninga.getTreningID();
        String naziv2 = txtNaziv.getText();
        String svrha2 = txtSvrha.getText();
        String duzina2 = txtDuzina.getText();
        int duz = Integer.valueOf(duzina2);
        //String status = txtStatus.getText();
        
        ModelTabeleStavke mts = (ModelTabeleStavke) tblStavke.getModel();
        ArrayList<StavkaPlanaTreninga> stavke = mts.getLista();
        
        Vezbac vez = planTreninga.getVezbac();
        TrenutniPlanTreninga tpt = planTreninga.getTrenutni();
        
        PlanTreninga plan = new PlanTreninga(id, naziv2, svrha2, duz,
                stavke, vez, tpt);
        plan.setStavke(stavke);
        
        KlijentskiZahtev kz = new KlijentskiZahtev(operacije.Operacije.IZMENI_TRENING, plan);
        komunikacija.KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
        
        ServerskiOdgovor so = komunikacija.KomunikacijaSaServerom.getInstanca().primiOdgovor();
        
        if(so.isUspesno()){
            JOptionPane.showMessageDialog(this, so.getPoruka());
        }else{
            JOptionPane.showMessageDialog(this, so.getPoruka(), "GRESKA", JOptionPane.ERROR_MESSAGE);
        }
        
 
        /*ModelTabeleStavke mts2 = (ModelTabeleStavke) tblStavke.getModel();
        ArrayList<StavkaPlanaTreninga> stavke2 = mts2.getLista();
        plan.setStavke(stavke2);
        
        KlijentskiZahtev kzz = new KlijentskiZahtev(operacije.Operacije.SACUVAJ_IZMENE_TRENINGA, plan);
        komunikacija.KomunikacijaSaServerom.getInstanca().posaljiZahtev(kzz);
        ServerskiOdgovor soo = komunikacija.KomunikacijaSaServerom.getInstanca().primiOdgovor();
        
        if(soo.isUspesno()){
            JOptionPane.showMessageDialog(this, so.getPoruka());
        }else{
            JOptionPane.showMessageDialog(this, so.getPoruka(), "GRESKA", JOptionPane.ERROR_MESSAGE);
        }*/
        
        this.dispose();
    }//GEN-LAST:event_btnSacuvajActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AzururanjePlanaTreninga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AzururanjePlanaTreninga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AzururanjePlanaTreninga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AzururanjePlanaTreninga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AzururanjePlanaTreninga().setVisible(true);
            }
        });
    }

    void postaviVrednost(PlanTreninga pt) {
        //id = pt.getTreningID();
        this.planTreninga = pt;
        txtSvrha.setText(planTreninga.getSvrhaTreninga());
        txtNaziv.setText(planTreninga.getNazivTreninga());
        int duzina = planTreninga.getDuzinaTrajanja();
        String d = String.valueOf(duzina);
        txtDuzina.setText(d);
        popuniTabelu(planTreninga);
        
        
        /*TrenutniPlanTreninga tp = pt.getTrenutni();
        String status = tp.getStatus();
        txtStatus.setText(status);*/
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnOtkazi;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblStavke;
    private javax.swing.JTextField txtDuzina;
    private javax.swing.JTextField txtNaziv;
    private javax.swing.JTextField txtSvrha;
    // End of variables declaration//GEN-END:variables

    private void popuniTabelu(PlanTreninga pts) {
        
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(operacije.Operacije.VRATI_LISTU_STAVKI);
        kz.setParametar(pts);
        komunikacija.KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
        ServerskiOdgovor so = komunikacija.KomunikacijaSaServerom.getInstanca().primiOdgovor();
        
        ArrayList<StavkaPlanaTreninga> stavka = (ArrayList<StavkaPlanaTreninga>) so.getOdgovor();
        ModelTabeleStavke mts = (ModelTabeleStavke) tblStavke.getModel();
        
        mts.popuniTabelu(stavka);
    }
}
