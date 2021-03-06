/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TokenAdmin.java
 *
 * Created on 27.06.2012, 15:16:47
 */
package org.sec2.token.tools;

import java.awt.Component;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import org.sec2.token.ITokenProgress;
import org.sec2.token.ReturnCodes;
import org.sec2.token.IToken.TokenStatus;
import org.sec2.token.TokenConstants;
import org.sec2.token.TokenHelper;
import org.sec2.token.exceptions.TokenException;
import org.sec2.token.hwtoken.HardwareToken;
import org.sec2.token.keys.ByteArray;

/**
 *
 * @author be
 */
public class TokenAdmin extends javax.swing.JFrame implements ITokenProgress {

    private TokenHelper myTool;
    private Component frame;

    /**
     * Creates new form TokenAdmin
     */
    public TokenAdmin() {
        initComponents();

        myTool = new TokenHelper(new HardwareToken(), this);

        String lblString = updateCardStatus(myTool);
        lblStatus.setText(lblString);
    }

    public void init(int maxSteps) {
    }

    public void update(final String desc) {
        /*
         * Since I'm too lazy/stupid to make the GUI redraw from this callback,
         * we just ouput everything to stdout.
         */
        System.out.println(desc);
    }

    public void done() {
        /*
         * We need to create a new TokenHelper here because if we use the one
         * which executed this done() callback (i.e. this.myTool), we would end
         * up in an infinite loop.. :D
         */
        TokenHelper noCallbackHelper = new TokenHelper(new HardwareToken());
        lblStatus.setText(updateCardStatus(noCallbackHelper));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed"
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnInit = new javax.swing.JButton();
        btnSetSKEY = new javax.swing.JButton();
        btnSetPIN = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtPUK = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        txtPIN = new javax.swing.JPasswordField();
        panelStatus = new javax.swing.JPanel();
        lblStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sec2 TokenAdmin");
        setResizable(false);

        btnInit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnInit.setText("INIT");
        btnInit.setEnabled(false);
        btnInit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInitActionPerformed(evt);
            }
        });

        btnSetSKEY.setText("Set SKEY");
        btnSetSKEY.setEnabled(false);
        btnSetSKEY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetSKEYActionPerformed(evt);
            }
        });

        btnSetPIN.setText("Set PIN");
        btnSetPIN.setEnabled(false);
        btnSetPIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetPINActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Authentication"));

        jLabel1.setText("PIN");

        jLabel2.setText("PUK");

        txtPIN.setPreferredSize(new java.awt.Dimension(150, 20));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtPIN, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPUK)))
                .addContainerGap(18, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtPIN, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPUK, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap())
        );

        panelStatus.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblStatus.setBackground(java.awt.Color.gray);
        lblStatus.setText("Idle..");

        javax.swing.GroupLayout panelStatusLayout = new javax.swing.GroupLayout(panelStatus);
        panelStatus.setLayout(panelStatusLayout);
        panelStatusLayout.setHorizontalGroup(
            panelStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        panelStatusLayout.setVerticalGroup(
            panelStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblStatus)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnInit, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(21, 21, 21)
                            .addComponent(btnSetPIN, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnSetSKEY, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(panelStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInit, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSetPIN, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSetSKEY, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(panelStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private String updateCardStatus(TokenHelper theHelper) {
        String lblString;

        try {
            TokenStatus cStatus = theHelper.getStatus();
            String verStr = theHelper.getVersion();
            lblString = "Applet v." + verStr;

            if (cStatus.pukIsChanged) {
                lblString += ", PUK";
            }
            if (cStatus.pinIsChanged) {
                lblString += ", PIN";
            }
            if (cStatus.skeyIsSet) {
                lblString += ", SKEY";
            }
            if (cStatus.ukeysAreGenerated) {
                lblString += ", UKEY";
            }

            /*
             * Only if the PUK has not been changed, we can do a full
             * initialization. Otherwise, the PUK cannot be changed anymore.
             */
            if (!cStatus.pukIsChanged) {
                btnInit.setEnabled(true);
                btnSetPIN.setEnabled(false);
                btnSetSKEY.setEnabled(false);

            } else {
                btnSetPIN.setEnabled(true);
                btnSetSKEY.setEnabled(true);
                btnInit.setEnabled(false);
            }
        } catch (TokenException ex) {
            lblString = ex.toString();
        }

        return lblString;
    }

    private void btnInitActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnInitActionPerformed
        final byte[] newPIN = txtPIN.getText().getBytes();
        final byte[] newPUK = txtPUK.getText().getBytes();

        if (newPIN.length < TokenConstants.PIN_MIN_SIZE
                || newPIN.length > TokenConstants.PIN_MAX_SIZE) {
            for (int i = 0; i < 10; i++) {
                JOptionPane.showMessageDialog(frame, "Length of PIN must be "
                        + TokenConstants.PIN_MIN_SIZE + "-" + TokenConstants.PIN_MAX_SIZE
                        + " digits");
                return;
            }
        }
        if (newPUK.length < TokenConstants.PUK_MIN_SIZE
                || newPUK.length > TokenConstants.PUK_MAX_SIZE) {
            JOptionPane.showMessageDialog(frame, "Length of PUK must be "
                    + TokenConstants.PUK_MIN_SIZE + "-" + TokenConstants.PUK_MAX_SIZE
                    + " digits");
            return;
        }

        final String certPath = selectCertFile();
        if (!certPath.isEmpty()) {
            try {
                myTool.initialize(new ByteArray(newPIN), new ByteArray(newPUK), 
                        certPath);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "Unable to read file: "
                        + ex);
            } catch (TokenException ex) {
                lblStatus.setText(ex.toString());
            }
        }
    }// GEN-LAST:event_btnInitActionPerformed

    private void btnSetPINActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSetPINActionPerformed
        byte[] newPIN = txtPIN.getText().getBytes();
        byte[] thePUK = txtPUK.getText().getBytes();

        if (newPIN.length < TokenConstants.PIN_MIN_SIZE
                || newPIN.length > TokenConstants.PIN_MAX_SIZE) {
            JOptionPane.showMessageDialog(frame, "Length of PIN must be "
                    + TokenConstants.PIN_MIN_SIZE + "-" + TokenConstants.PIN_MAX_SIZE
                    + " digits");
            return;
        }

        try {
            myTool.setPIN(new ByteArray(thePUK), new ByteArray(newPIN));
        } catch (TokenException ex) {
            lblStatus.setText(ex.toString());
        }
    }// GEN-LAST:event_btnSetPINActionPerformed

    private void btnSetSKEYActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSetSKEYActionPerformed
        String certPath = selectCertFile();

        if (!certPath.isEmpty()) {
            try {
                myTool.setServerKey(new ByteArray(txtPUK.getText()), certPath);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "Unable to read file: "
                        + ex);
                return;
            } catch (TokenException ex) {
                lblStatus.setText(ex.toString());
            }
        }
    }// GEN-LAST:event_btnSetSKEYActionPerformed

    private String selectCertFile() {
        String filename = File.separator + "crt";
        JFileChooser fc = new JFileChooser(new File(filename));
        fc.showOpenDialog(frame);
        File selFile = fc.getSelectedFile();

        if (selFile != null && selFile.exists()) {
            return selFile.getAbsolutePath();
        } else {
            return "";
        }
    }

    private static void handleCommandline(String args[]) {
        String newPIN = null;
        String newPUK = null;
        String certFile = null;

        short i;
        try {
            for (i = 0; i < args.length; i++) {
                if ("--pin".equals(args[i])) {
                    newPIN = args[i + 1];
                } else if ("--puk".equals(args[i])) {
                    newPUK = args[i + 1];
                } else if ("--cert".equals(args[i])) {
                    certFile = args[i + 1];
                }
            }
        } catch (Exception ex) {
            System.out.println("Error: Arguments incomplete");
        }

        if (newPIN != null && newPUK != null && certFile != null) {
            TokenHelper tokenHelper = new TokenHelper(new HardwareToken());
            try {
                tokenHelper.initialize(new ByteArray(newPIN), new ByteArray(newPUK), certFile);
                System.out.println("OK");
            } catch (Exception ex) {
                System.out.println("Error: " + ex.toString());
            }
        } else {
            System.out.println("Error: Arguments incomplete");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        // <editor-fold defaultstate="collapsed"
        // desc=" Look and feel setting code (optional) ">
		/*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase
         * /tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("GTK+".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TokenAdmin.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TokenAdmin.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TokenAdmin.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TokenAdmin.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        if (Arrays.binarySearch(args, "--nogui") >= 0) {
            /*
             * Commandline mode
             */
            handleCommandline(args);
        } else if (Arrays.binarySearch(args, "--help") >= 0) {
            /*
             * Display help for commandline usage.
             */
            System.out.println("Usage: TokenAdmin --nogui --pin <pin> --puk <puk> --cert <file>");
            System.out.println("  --help          Display this help");
            System.out.println("  --nogui         Enables commandline mode");
            System.out.println("  --pin <pin>     Set new PIN");
            System.out.println("  --puk <puk>     Set new PUK");
            System.out.println("  --cert <file>   Set new ServerKey from x509 cert");
        } else {
            /*
             * Create and display the form
             */
            java.awt.EventQueue.invokeLater(new Runnable() {

                @Override
                public void run() {
                    new TokenAdmin().setVisible(true);
                }
            });
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInit;
    private javax.swing.JButton btnSetPIN;
    private javax.swing.JButton btnSetSKEY;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JPanel panelStatus;
    private javax.swing.JPasswordField txtPIN;
    private javax.swing.JPasswordField txtPUK;
    // End of variables declaration//GEN-END:variables
}
