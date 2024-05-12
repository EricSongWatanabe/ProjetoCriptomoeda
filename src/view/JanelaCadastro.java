/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;
import controller.ControllerCadastro;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author eric song
 */
public class JanelaCadastro extends javax.swing.JFrame {

    /**
     * Creates new form JanelaCadastro
     */
    public JanelaCadastro() {
        initComponents();
        controller = new ControllerCadastro(this);
    }

    public ControllerCadastro getController() {
        return controller;
    }

    public void setController(ControllerCadastro controller) {
        this.controller = controller;
    }

    public JButton getCadastrarBtn() {
        return cadastrarBtn;
    }

    public void setCadastrarBtn(JButton cadastrarBtn) {
        this.cadastrarBtn = cadastrarBtn;
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

    public JLabel getNomeLbl() {
        return nomeLbl;
    }

    public void setNomeLbl(JLabel nomeLbl) {
        this.nomeLbl = nomeLbl;
    }

    public JTextField getNomeTxt() {
        return nomeTxt;
    }

    public void setNomeTxt(JTextField nomeTxt) {
        this.nomeTxt = nomeTxt;
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

    public JLabel getTituloLbl() {
        return tituloLbl;
    }

    public void setTituloLbl(JLabel tituloLbl) {
        this.tituloLbl = tituloLbl;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nomeLbl = new javax.swing.JLabel();
        nomeTxt = new javax.swing.JTextField();
        cadastrarBtn = new javax.swing.JButton();
        cpfLbl = new javax.swing.JLabel();
        senhaLbl = new javax.swing.JLabel();
        tituloLbl = new javax.swing.JLabel();
        senhaTxt = new javax.swing.JTextField();
        cpfTxt = new javax.swing.JTextField();
        voltarBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        nomeLbl.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        nomeLbl.setText("Nome:");

        nomeTxt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        cadastrarBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cadastrarBtn.setText("CADASTRAR");
        cadastrarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarBtnActionPerformed(evt);
            }
        });

        cpfLbl.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        cpfLbl.setText("CPF:");

        senhaLbl.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        senhaLbl.setText("Senha:");

        tituloLbl.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        tituloLbl.setText("CADASTRO");

        senhaTxt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        cpfTxt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

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
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(tituloLbl)
                .addGap(223, 223, 223))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cpfLbl)
                            .addComponent(nomeLbl)
                            .addComponent(senhaLbl))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nomeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(senhaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cpfTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(cadastrarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(voltarBtn)))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(tituloLbl)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nomeLbl)
                    .addComponent(nomeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cpfLbl)
                    .addComponent(cpfTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(senhaLbl)
                    .addComponent(senhaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(cadastrarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(voltarBtn)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cadastrarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarBtnActionPerformed
        controller.cadastrar();        
    }//GEN-LAST:event_cadastrarBtnActionPerformed

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
//            java.util.logging.Logger.getLogger(JanelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(JanelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(JanelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(JanelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new JanelaCadastro().setVisible(true);
//            }
//        });
//    }
    
    private ControllerCadastro controller;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cadastrarBtn;
    private javax.swing.JLabel cpfLbl;
    private javax.swing.JTextField cpfTxt;
    private javax.swing.JLabel nomeLbl;
    private javax.swing.JTextField nomeTxt;
    private javax.swing.JLabel senhaLbl;
    private javax.swing.JTextField senhaTxt;
    private javax.swing.JLabel tituloLbl;
    private javax.swing.JButton voltarBtn;
    // End of variables declaration//GEN-END:variables
}
