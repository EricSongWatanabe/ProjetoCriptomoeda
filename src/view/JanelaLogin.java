/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.ControllerLogin;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author eric song
 */
public class JanelaLogin extends javax.swing.JFrame {

    /**
     * Creates new form JanelaLogin
     */
    public JanelaLogin() {
        initComponents();
        controller = new ControllerLogin(this);
    }

    public JLabel getCpfLbl() {
        return cpfLbl;
    }

    public void setCpfLbl(JLabel cpfLbl) {
        this.cpfLbl = cpfLbl;
    }

    public JTextField getCpfTxt() {
        return cpfTxt;
    }

    public void setCpfTxt(JTextField cpfTxt) {
        this.cpfTxt = cpfTxt;
    }

    public JButton getLogarBtn() {
        return logarBtn;
    }

    public void setLogarBtn(JButton logarBtn) {
        this.logarBtn = logarBtn;
    }

    public JLabel getLoginLbl() {
        return loginLbl;
    }

    public void setLoginLbl(JLabel loginLbl) {
        this.loginLbl = loginLbl;
    }

    public JLabel getSenhaLbl() {
        return senhaLbl;
    }

    public void setSenhaLbl(JLabel senhaLbl) {
        this.senhaLbl = senhaLbl;
    }

    public JTextField getSenhaTxt() {
        return senhaTxt;
    }

    public void setSenhaTxt(JTextField senhaTxt) {
        this.senhaTxt = senhaTxt;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cpfLbl = new javax.swing.JLabel();
        cpfTxt = new javax.swing.JTextField();
        loginLbl = new javax.swing.JLabel();
        senhaLbl = new javax.swing.JLabel();
        senhaTxt = new javax.swing.JTextField();
        logarBtn = new javax.swing.JButton();
        voltarBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cpfLbl.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        cpfLbl.setText("CPF:");

        cpfTxt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        loginLbl.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        loginLbl.setText("LOGIN");

        senhaLbl.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        senhaLbl.setText("Senha:");

        senhaTxt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        logarBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        logarBtn.setText("LOGAR");
        logarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logarBtnActionPerformed(evt);
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(senhaLbl)
                                .addGap(18, 18, 18)
                                .addComponent(senhaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cpfLbl)
                                .addGap(18, 18, 18)
                                .addComponent(cpfTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(52, 52, 52))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(logarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(215, 215, 215))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(247, 247, 247)
                        .addComponent(loginLbl))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(voltarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(loginLbl)
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cpfLbl)
                    .addComponent(cpfTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(senhaLbl)
                    .addComponent(senhaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addComponent(logarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(voltarBtn)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logarBtnActionPerformed
        controller.logar();
    }//GEN-LAST:event_logarBtnActionPerformed

    private void voltarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarBtnActionPerformed
        JanelaEntrada e = new JanelaEntrada();
        e.setVisible(true);
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
//            java.util.logging.Logger.getLogger(JanelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(JanelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(JanelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(JanelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new JanelaLogin().setVisible(true);
//            }
//        });
//    }

    private ControllerLogin controller;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cpfLbl;
    private javax.swing.JTextField cpfTxt;
    private javax.swing.JButton logarBtn;
    private javax.swing.JLabel loginLbl;
    private javax.swing.JLabel senhaLbl;
    private javax.swing.JTextField senhaTxt;
    private javax.swing.JButton voltarBtn;
    // End of variables declaration//GEN-END:variables
}
