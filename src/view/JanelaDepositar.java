/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.ControllerMenu;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author eric song
 */
public class JanelaDepositar extends javax.swing.JFrame {

    /**
     * Creates new form JanelaDepositar
     */
    public JanelaDepositar(double saldoReal) {
        initComponents();
        saldoAtualLbl.setText(String.valueOf(saldoReal));
        controller = new ControllerMenu(this);
    }

    public ControllerMenu getController() {
        return controller;
    }

    public void setController(ControllerMenu controller) {
        this.controller = controller;
    }

    public JButton getDepositarBtn() {
        return depositarBtn;
    }

    public void setDepositarBtn(JButton depositarBtn) {
        this.depositarBtn = depositarBtn;
    }

    public JLabel getDepositarLbl() {
        return depositarLbl;
    }

    public void setDepositarLbl(JLabel depositarLbl) {
        this.depositarLbl = depositarLbl;
    }

    public JTextField getDepositoTxt() {
        return depositoTxt;
    }

    public void setDepositoTxt(JTextField depositoTxt) {
        this.depositoTxt = depositoTxt;
    }

    public JLabel getSaldoAtualLbl() {
        return saldoAtualLbl;
    }

    public void setSaldoAtualLbl(JLabel saldoAtualLbl) {
        this.saldoAtualLbl = saldoAtualLbl;
    }

    public JLabel getSaldoAtualLbl1() {
        return saldoAtualLbl1;
    }

    public void setSaldoAtualLbl1(JLabel saldoAtualLbl1) {
        this.saldoAtualLbl1 = saldoAtualLbl1;
    }

    public JButton getVoltarBtn() {
        return voltarBtn;
    }

    public void setVoltarBtn(JButton voltarBtn) {
        this.voltarBtn = voltarBtn;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        depositarLbl = new javax.swing.JLabel();
        depositoTxt = new javax.swing.JTextField();
        saldoAtualLbl1 = new javax.swing.JLabel();
        saldoAtualLbl = new javax.swing.JLabel();
        depositarBtn = new javax.swing.JButton();
        voltarBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        depositarLbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        depositarLbl.setText("Saldo a ser depositado:");

        depositoTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        saldoAtualLbl1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        saldoAtualLbl1.setText("Saldo atual:");

        saldoAtualLbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        saldoAtualLbl.setText("SALDO ATUAL");

        depositarBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        depositarBtn.setText("DEPOSITAR");
        depositarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depositarBtnActionPerformed(evt);
            }
        });

        voltarBtn.setText("VOLTAR");
        voltarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(depositarLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(depositoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(saldoAtualLbl1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(saldoAtualLbl))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(depositarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(voltarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saldoAtualLbl1)
                    .addComponent(saldoAtualLbl))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(depositarLbl)
                    .addComponent(depositoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(depositarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(voltarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void voltarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarBtnActionPerformed
        JanelaMenu m = new JanelaMenu();
        m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_voltarBtnActionPerformed

    private void depositarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depositarBtnActionPerformed
        controller.depositar();
    }//GEN-LAST:event_depositarBtnActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(JanelaDepositar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(JanelaDepositar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(JanelaDepositar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(JanelaDepositar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new JanelaDepositar().setVisible(true);
//            }
//        });
//    }
    
    private ControllerMenu controller;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton depositarBtn;
    private javax.swing.JLabel depositarLbl;
    private javax.swing.JTextField depositoTxt;
    private javax.swing.JLabel saldoAtualLbl;
    private javax.swing.JLabel saldoAtualLbl1;
    private javax.swing.JButton voltarBtn;
    // End of variables declaration//GEN-END:variables
}