
package customer;
import bill.db_Connection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;


public class Customer_New_details extends javax.swing.JFrame {

    db_Connection dbconn=null;
    Customer_base cb=null;
    public Customer_New_details(Customer_base cb) {
        dbconn=new db_Connection();
        initComponents();
        setSize(500,600);
        this.cb=cb;
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

    }
    public Customer_New_details() {
        initComponents();
        setSize(500,600);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tf_name = new javax.swing.JTextField();
        tf_father_name = new javax.swing.JTextField();
        tf_address = new javax.swing.JTextField();
        tf_city = new javax.swing.JTextField();
        tf_state = new javax.swing.JComboBox<>();
        tf_mobile1 = new javax.swing.JTextField();
        tf_email = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel1.setText("New Customer Details");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(110, 20, 230, 40);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel2.setText("Name");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 90, 100, 30);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel3.setText("Father Name");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 130, 130, 30);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel4.setText("Address");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 170, 110, 30);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel5.setText("City");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(30, 210, 90, 30);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel6.setText("State");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(30, 250, 100, 30);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel7.setText("Mobile no.");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(30, 290, 120, 30);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel8.setText("e-mail");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(30, 330, 100, 30);
        getContentPane().add(tf_name);
        tf_name.setBounds(210, 90, 200, 30);
        getContentPane().add(tf_father_name);
        tf_father_name.setBounds(210, 130, 200, 30);
        getContentPane().add(tf_address);
        tf_address.setBounds(210, 170, 200, 30);
        getContentPane().add(tf_city);
        tf_city.setBounds(210, 210, 200, 30);

        tf_state.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Andra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chhattisgarh", "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jammu and Kashmir", "Jharkhand", "Karnataka", "Kerala", "Madya Pradesh", "Maharashtra", "Manipur", "Meghalaya", "Mizoram", "Nagaland", "Orissa", "Punjab", "Rajasthan", "Sikkim", "Tamil Nadu", "Tripura", "Uttaranchal", "Uttar Pradesh", "West Bengal" }));
        tf_state.setSelectedIndex(20);
        getContentPane().add(tf_state);
        tf_state.setBounds(210, 250, 200, 30);
        getContentPane().add(tf_mobile1);
        tf_mobile1.setBounds(210, 290, 200, 30);
        getContentPane().add(tf_email);
        tf_email.setBounds(210, 330, 200, 30);

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(90, 390, 110, 30);

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(250, 390, 110, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       String name=tf_name.getText();
       String father_name=tf_father_name.getText();
       String address=tf_address.getText();
       String city=tf_city.getText();
       String state=(String)tf_state.getSelectedItem();
       String mobile1=tf_mobile1.getText();
       String email=tf_email.getText();
       Pattern pattern = Pattern.compile("\\d{10}");
       Matcher matcher = pattern.matcher(mobile1);
       if(name.equals("") || father_name.equals("") || address.equals("") || city.equals("") || state.equals("") || mobile1.equals("") )
       {
           JOptionPane.showMessageDialog(this, "plese enter all details");
       }
       else if ((email.length() !=0)  &&( !email.contains("@") || !email.contains("."))) 
                {
                    JOptionPane.showMessageDialog(this, "please enter a valid email address");
                    tf_email.setText("");
                }
       
       else if (!matcher.matches())
              {
                  JOptionPane.showMessageDialog(this, "enter correct mobile number");
                  tf_mobile1.setText("");
              }
        else
              {
           try {
               Connection conn = db_Connection.getconnectiom();               
               Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
               
               try (ResultSet rs = stmt.executeQuery("select * from customer_details")) {
                   rs.moveToInsertRow();
                   rs.updateString("name", name);
                   rs.updateString("father_name",father_name);
                   rs.updateString("address", address);
                   rs.updateString("city", city);
                   rs.updateString("state", state);
                   rs.updateString("mobile_no", mobile1);
                   rs.updateString("email",email );
                   rs.insertRow();
                   if(cb!=null)
                   {
                   this.cb.update_customer_arraylist();
                   }
               }
           } catch (SQLException ex) {
               Logger.getLogger(Customer_New_details.class.getName()).log(Level.SEVERE, null, ex);
           }
           JOptionPane.showMessageDialog(this, "Customer Added Successfully");
           int option=JOptionPane.YES_NO_OPTION;
                JOptionPane.showConfirmDialog(this, "want to add another customer", "Add new Supplier", option);
                       System.out.println(""+option);
                if(option==9)
                {
                    tf_address.setText("");
                    tf_father_name.setText("");
                    tf_city.setText("");
                    tf_email.setText("");
                    tf_mobile1.setText("");
                    tf_name.setText("");
                    
                 }
                else
                {
                    this.dispose();
                }
              }
              
     
         
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Customer_New_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Customer_New_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Customer_New_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Customer_New_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
               // new Customer_New_details().setVisible(true);
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
    private javax.swing.JTextField tf_father_name;
    private javax.swing.JTextField tf_mobile1;
    private javax.swing.JTextField tf_name;
    private javax.swing.JComboBox<String> tf_state;
    // End of variables declaration//GEN-END:variables
}
