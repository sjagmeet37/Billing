package customer;

import javax.swing.JOptionPane;

public class new_user extends javax.swing.JFrame {
    public new_user() {
        initComponents();
        setSize(400,400);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tf_cust_name = new javax.swing.JTextField();
        tf_cust_father = new javax.swing.JTextField();
        tf_address = new javax.swing.JTextField();
        tf_mobile = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cb_state = new javax.swing.JComboBox<>();
        tf_pincode = new javax.swing.JTextField();
        tf_city = new javax.swing.JTextField();
        bt_add = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel1.setText("New Customer");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(100, 20, 230, 40);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 22)); // NOI18N
        jLabel2.setText("Customer Name");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 90, 180, 30);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 22)); // NOI18N
        jLabel3.setText("Father Name");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 130, 180, 30);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 22)); // NOI18N
        jLabel4.setText("Address");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 170, 120, 30);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 3, 22)); // NOI18N
        jLabel5.setText("Mobile no.");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(20, 330, 110, 30);
        getContentPane().add(tf_cust_name);
        tf_cust_name.setBounds(230, 90, 200, 30);
        getContentPane().add(tf_cust_father);
        tf_cust_father.setBounds(230, 130, 200, 30);
        getContentPane().add(tf_address);
        tf_address.setBounds(230, 170, 200, 30);
        getContentPane().add(tf_mobile);
        tf_mobile.setBounds(230, 330, 200, 30);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 3, 22)); // NOI18N
        jLabel6.setText("Pincode");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(20, 210, 90, 30);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 3, 22)); // NOI18N
        jLabel7.setText("City");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(20, 250, 120, 30);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 3, 22)); // NOI18N
        jLabel8.setText("State");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(20, 290, 80, 30);

        cb_state.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Andra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chhattisgarh", "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jammu and Kashmir", "Jharkhand", "Karnataka", "Kerala", "Madya Pradesh", "Maharashtra", "Manipur", "Meghalaya", "Mizoram", "Nagaland", "Orissa", "Punjab", "Rajasthan", "Sikkim", "Tamil Nadu", "Tripura", "Uttaranchal", "Uttar Pradesh", "West Bengal" }));
        cb_state.setSelectedIndex(20);
        getContentPane().add(cb_state);
        cb_state.setBounds(230, 290, 200, 30);
        getContentPane().add(tf_pincode);
        tf_pincode.setBounds(230, 210, 200, 30);
        getContentPane().add(tf_city);
        tf_city.setBounds(230, 250, 200, 30);

        bt_add.setText("Add");
        bt_add.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bt_addKeyPressed(evt);
            }
        });
        getContentPane().add(bt_add);
        bt_add.setBounds(330, 380, 100, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_addKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bt_addKeyPressed
JOptionPane.showMessageDialog(this, "enter pressed");        // TODO add your handling code here:
    }//GEN-LAST:event_bt_addKeyPressed

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
            java.util.logging.Logger.getLogger(new_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(new_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(new_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(new_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new new_user().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_add;
    private javax.swing.JComboBox<String> cb_state;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField tf_address;
    private javax.swing.JTextField tf_city;
    private javax.swing.JTextField tf_cust_father;
    private javax.swing.JTextField tf_cust_name;
    private javax.swing.JTextField tf_mobile;
    private javax.swing.JTextField tf_pincode;
    // End of variables declaration//GEN-END:variables
}
