
package supplier;

import bill.db_Connection;
import customer.Customer_New_details;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;


public class supplier_edit extends javax.swing.JFrame {
    db_Connection dbconn=null;
   supplier_base sts=null;
   int index;
  
    public supplier_edit(supplier_base ss ,int index) {
        dbconn=new db_Connection();
        initComponents();
        setSize(500, 500);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        this.sts=ss;
        this.index=index;
        
        tf_spplier_name.setText(this.sts.al.get(index).supplier_name);
        tf_address.setText(this.sts.al.get(index).address);
        tf_city.setText(this.sts.al.get(index).city);
        tf_mobile.setText(this.sts.al.get(index).mobile_no);
        tf_email.setText(this.sts.al.get(index).email);
        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tf_spplier_name = new javax.swing.JTextField();
        tf_address = new javax.swing.JTextField();
        tf_city = new javax.swing.JTextField();
        tf_mobile = new javax.swing.JTextField();
        tf_email = new javax.swing.JTextField();
        tf_state = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tf_type = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel1.setText("Edit Supplier");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(130, 10, 190, 50);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel2.setText("Supplier Name");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(50, 80, 120, 30);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel3.setText("Address");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(50, 120, 120, 30);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel4.setText("City");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(50, 160, 120, 30);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel5.setText("Mobile no.");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(50, 240, 120, 30);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel6.setText("e-mail");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(50, 280, 120, 30);
        getContentPane().add(tf_spplier_name);
        tf_spplier_name.setBounds(210, 80, 190, 30);
        getContentPane().add(tf_address);
        tf_address.setBounds(210, 120, 190, 30);
        getContentPane().add(tf_city);
        tf_city.setBounds(210, 160, 190, 30);
        getContentPane().add(tf_mobile);
        tf_mobile.setBounds(210, 240, 190, 30);
        getContentPane().add(tf_email);
        tf_email.setBounds(210, 280, 190, 30);

        tf_state.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Andra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chhattisgarh", "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jammu and Kashmir", "Jharkhand", "Karnataka", "Kerala", "Madya Pradesh", "Maharashtra", "Manipur", "Meghalaya", "Mizoram", "Nagaland", "Orissa", "Punjab", "Rajasthan", "Sikkim", "Tamil Nadu", "Tripura", "Uttaranchal", "Uttar Pradesh", "West Bengal" }));
        tf_state.setSelectedIndex(20);
        getContentPane().add(tf_state);
        tf_state.setBounds(210, 200, 190, 30);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel7.setText("State");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(50, 200, 80, 30);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel8.setText("Type");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(50, 320, 80, 30);

        tf_type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Manufacturer", "Distibutor" }));
        getContentPane().add(tf_type);
        tf_type.setBounds(210, 320, 190, 30);

        jButton1.setText("Edit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(230, 380, 51, 23);

        jButton2.setText("Back");
        getContentPane().add(jButton2);
        jButton2.setBounds(320, 380, 55, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            int splier_id=(int)this.sts.al.get(index).supplier_id;
            String name=tf_spplier_name.getText();
            String address=tf_address.getText();
            String city=tf_city.getText();
            String state=(String)tf_state.getSelectedItem();
            String mobile1=tf_mobile.getText();
            String email=tf_email.getText();
            String type=(String)tf_type.getSelectedItem();
            supplier_arraylist al_temp=new supplier_arraylist(splier_id, name, address, city, state, mobile1, email, type);
            Pattern pattern = Pattern.compile("\\d{10}");
            Matcher matcher = pattern.matcher(mobile1);
            if(name.equals("") || address.equals("") || city.equals("") || state.equals("") || mobile1.equals("") )
            {
                JOptionPane.showMessageDialog(this, "please enter all details");
            }
            else if ((email.length() !=0)  &&( !email.contains("@") || !email.contains("."))) 
                     {
                         JOptionPane.showMessageDialog(this, "please enter a valid email address");
                         tf_email.setText("");
                     }

            else if (!matcher.matches())
                   {
                       JOptionPane.showMessageDialog(this, "enter correct mobile number");
                       tf_mobile.setText("");
                   }
             else
                   {
                try {
                    
                    Connection conn =         db_Connection.getconnectiom();
                    Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

                    try (ResultSet rs = stmt.executeQuery("select * from supplier_details where supplier_id="+splier_id)) {
                        rs.next();
                        String nme=rs.getString("supplier_name");
                        System.out.println(""+nme);
                        rs.updateString("supplier_name", name);
                        rs.updateString("type",type);
                        rs.updateString("address", address);
                        rs.updateString("city", city);
                        rs.updateString("state", state);
                        rs.updateString("mobile_no", mobile1);
                        rs.updateString("email",email );
                        rs.updateRow();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Customer_New_details.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(this, "Customer Added Successfully");
                this.sts.al.set(index, al_temp);
                this.sts.st.fireTableDataChanged();
                int option=JOptionPane.YES_NO_OPTION;
                JOptionPane.showConfirmDialog(this, "want to add another supplier", "Add new Supplier", option);
                       System.out.println(""+option);
                if(option==9)
                {
                    tf_address.setText("");
                    tf_spplier_name.setText("");
                    tf_city.setText("");
                    tf_mobile.setText("");
                    tf_email.setText("");
                    
                 }
                else
                {
                    this.dispose();
                    
                    
                }
                   }
    }//GEN-LAST:event_jButton1ActionPerformed

   
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
            java.util.logging.Logger.getLogger(supplier_edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(supplier_edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(supplier_edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(supplier_edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
               //new supplier_edit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
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
    private javax.swing.JTextField tf_email;
    private javax.swing.JTextField tf_mobile;
    private javax.swing.JTextField tf_spplier_name;
    private javax.swing.JComboBox<String> tf_state;
    private javax.swing.JComboBox<String> tf_type;
    // End of variables declaration//GEN-END:variables
}
