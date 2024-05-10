/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Investidor;

/**
 *
 * @author eric song
 */
public class JanelaConsultarSaldo extends javax.swing.JFrame {
    /**
     * Creates new form JanelaConsultarSaldo
     */
    public JanelaConsultarSaldo(Investidor investidor) {
        initComponents();
        nomeLbl.setText(investidor.getNome());
        cpfLbl.setText(investidor.getCpf());
        realLbl.setText(String.valueOf(investidor.getCarteira().getMoedas().get(0).getSaldo()));
        bitcoinLbl.setText(String.valueOf(investidor.getCarteira().getMoedas().get(1).getSaldo()));
        ethereumLbl.setText(String.valueOf(investidor.getCarteira().getMoedas().get(2).getSaldo()));
        rippleLbl.setText(String.valueOf(investidor.getCarteira().getMoedas().get(3).getSaldo()));
    }
    
    public JLabel getBitcoinLbl() {
        return bitcoinLbl;
    }

    public void setBitcoinLbl(JLabel bitcoinLbl) {
        this.bitcoinLbl = bitcoinLbl;
    }

    public JLabel getBitcoinLbl1() {
        return bitcoinLbl1;
    }

    public void setBitcoinLbl1(JLabel bitcoinLbl1) {
        this.bitcoinLbl1 = bitcoinLbl1;
    }

    public JLabel getCpfLbl() {
        return cpfLbl;
    }

    public void setCpfLbl(JLabel cpfLbl) {
        this.cpfLbl = cpfLbl;
    }

    public JLabel getCpfLbl1() {
        return cpfLbl1;
    }

    public void setCpfLbl1(JLabel cpfLbl1) {
        this.cpfLbl1 = cpfLbl1;
    }

    public JLabel getEthereumLbl() {
        return ethereumLbl;
    }

    public void setEthereumLbl(JLabel ethereumLbl) {
        this.ethereumLbl = ethereumLbl;
    }

    public JLabel getEthereumLbl1() {
        return ethereumLbl1;
    }

    public void setEthereumLbl1(JLabel ethereumLbl1) {
        this.ethereumLbl1 = ethereumLbl1;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public JLabel getNomeLbl() {
        return nomeLbl;
    }

    public void setNomeLbl(JLabel nomeLbl) {
        this.nomeLbl = nomeLbl;
    }

    public JLabel getNomeLbl1() {
        return nomeLbl1;
    }

    public void setNomeLbl1(JLabel nomeLbl1) {
        this.nomeLbl1 = nomeLbl1;
    }

    public JLabel getRealLbl() {
        return realLbl;
    }

    public void setRealLbl(JLabel realLbl) {
        this.realLbl = realLbl;
    }

    public JLabel getRealLbl1() {
        return realLbl1;
    }

    public void setRealLbl1(JLabel realLbl1) {
        this.realLbl1 = realLbl1;
    }

    public JLabel getRippleLbl() {
        return rippleLbl;
    }

    public void setRippleLbl(JLabel rippleLbl) {
        this.rippleLbl = rippleLbl;
    }

    public JLabel getRippleLbl1() {
        return rippleLbl1;
    }

    public void setRippleLbl1(JLabel rippleLbl1) {
        this.rippleLbl1 = rippleLbl1;
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

        jPanel1 = new javax.swing.JPanel();
        realLbl1 = new javax.swing.JLabel();
        realLbl = new javax.swing.JLabel();
        bitcoinLbl1 = new javax.swing.JLabel();
        bitcoinLbl = new javax.swing.JLabel();
        ethereumLbl1 = new javax.swing.JLabel();
        ethereumLbl = new javax.swing.JLabel();
        rippleLbl1 = new javax.swing.JLabel();
        rippleLbl = new javax.swing.JLabel();
        nomeLbl1 = new javax.swing.JLabel();
        cpfLbl1 = new javax.swing.JLabel();
        nomeLbl = new javax.swing.JLabel();
        cpfLbl = new javax.swing.JLabel();
        voltarBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        realLbl1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        realLbl1.setText("Real:");

        realLbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        realLbl.setText("REAL");

        bitcoinLbl1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        bitcoinLbl1.setText("Bitcoin:");

        bitcoinLbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        bitcoinLbl.setText("BITCOIN");

        ethereumLbl1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ethereumLbl1.setText("Ethereum:");

        ethereumLbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ethereumLbl.setText("ETHEREUM");

        rippleLbl1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        rippleLbl1.setText("Ripple:");

        rippleLbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        rippleLbl.setText("RIPPLE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(realLbl1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(realLbl))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bitcoinLbl1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bitcoinLbl))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ethereumLbl1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ethereumLbl))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rippleLbl1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rippleLbl)))
                .addContainerGap(360, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(realLbl1)
                    .addComponent(realLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bitcoinLbl1)
                    .addComponent(bitcoinLbl))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ethereumLbl1)
                    .addComponent(ethereumLbl))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rippleLbl1)
                    .addComponent(rippleLbl))
                .addGap(35, 35, 35))
        );

        nomeLbl1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        nomeLbl1.setText("Nome:");

        cpfLbl1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cpfLbl1.setText("CPF:");

        nomeLbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        nomeLbl.setText("NOME");

        cpfLbl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cpfLbl.setText("CPF");

        voltarBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
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
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cpfLbl1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cpfLbl))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nomeLbl1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nomeLbl)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(voltarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(227, 227, 227))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeLbl1)
                    .addComponent(nomeLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cpfLbl1)
                    .addComponent(cpfLbl))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(voltarBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void voltarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarBtnActionPerformed
        JanelaMenu m = new JanelaMenu();
        m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_voltarBtnActionPerformed

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
//            java.util.logging.Logger.getLogger(JanelaConsultarSaldo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(JanelaConsultarSaldo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(JanelaConsultarSaldo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(JanelaConsultarSaldo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new JanelaConsultarSaldo().setVisible(true);
//            }
//        });
//    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bitcoinLbl;
    private javax.swing.JLabel bitcoinLbl1;
    private javax.swing.JLabel cpfLbl;
    private javax.swing.JLabel cpfLbl1;
    private javax.swing.JLabel ethereumLbl;
    private javax.swing.JLabel ethereumLbl1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nomeLbl;
    private javax.swing.JLabel nomeLbl1;
    private javax.swing.JLabel realLbl;
    private javax.swing.JLabel realLbl1;
    private javax.swing.JLabel rippleLbl;
    private javax.swing.JLabel rippleLbl1;
    private javax.swing.JButton voltarBtn;
    // End of variables declaration//GEN-END:variables
}
