
package customer;

import bill.db_Connection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;


public class Customer_base extends javax.swing.JFrame {
     ArrayList<customer_arraylist> ca=null;
     customer_table_model ctm=null;
     db_Connection dbconn=null;
    public Customer_base() {        
        ca=new ArrayList<>();
        ctm=new customer_table_model();
        dbconn=new db_Connection();
        initComponents();
        setSize(1400,700);
        System.out.println("here");
            try {

                 Connection conn =db_Connection.getconnectiom();
                 Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                 ResultSet rs = stmt.executeQuery("select * from customer_details");
                 while(rs.next())
                {
                    int cust_id=rs.getInt("customer_id");
                    String name=rs.getString("name");
                    String father_name=rs.getString("father_name");
                    String address=rs.getString("address");
                    String city=rs.getString("city");
                    String state=rs.getString("state");
                    String mobile_no=rs.getString("mobile_no");
                    String email=rs.getString("email");
                    String date=rs.getString("date");
                    ca.add(new customer_arraylist(cust_id, name, father_name, address, city, state, mobile_no, email, date));
                 }

             } catch (SQLException ex) {
                 Logger.getLogger(Customer_base.class.getName()).log(Level.SEVERE, null, ex);
             }
             ctm.fireTableDataChanged();
            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

    }
    public void update_customer_arraylist()
    {
         try {
             ca.clear();
             Connection conn =db_Connection.getconnectiom();
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = stmt.executeQuery("select * from customer_details");
             while(rs.next())
            {
                int cust_id=rs.getInt("customer_id");
                String name=rs.getString("name");
                String father_name=rs.getString("father_name");
                String address=rs.getString("address");
                String city=rs.getString("city");
                String state=rs.getString("state");
                String mobile_no=rs.getString("mobile_no");
                String email=rs.getString("email");
                String date=rs.getString("date");
                ca.add(new customer_arraylist(cust_id, name, father_name, address, city, state, mobile_no, email, date));
             }
             
         } catch (SQLException ex) {
             Logger.getLogger(Customer_base.class.getName()).log(Level.SEVERE, null, ex);
         }
         ctm.fireTableDataChanged();
         
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        bt_edit = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        bt_add = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable1.setModel(ctm);
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 50, 1170, 510);

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 36)); // NOI18N
        jLabel1.setText("Customers");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(470, 0, 240, 50);

        bt_edit.setText("Edit");
        bt_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_editActionPerformed(evt);
            }
        });
        getContentPane().add(bt_edit);
        bt_edit.setBounds(1020, 570, 80, 23);

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(1110, 570, 70, 23);

        bt_add.setText("Add");
        bt_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_addActionPerformed(evt);
            }
        });
        getContentPane().add(bt_add);
        bt_add.setBounds(930, 570, 70, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_addActionPerformed
        Customer_New_details cnd=new Customer_New_details(this);
        cnd.setVisible(true);
    }//GEN-LAST:event_bt_addActionPerformed

    private void bt_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_editActionPerformed
        int index=jTable1.getSelectedRow();
        if(index==-1)
        {
            JOptionPane.showMessageDialog(this, "Please select a customer");
        }
        else
        {
            Customer_edit_details ced=new Customer_edit_details(index,this);
        ced.setVisible(true);
        }
    }//GEN-LAST:event_bt_editActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed
     public class customer_table_model extends AbstractTableModel  //inner class
    {
         
       String cn[]={"customer id", "name", "father_name", "address", "city", "state", "mobile","email","customer since"};

        @Override
        public String getColumnName(int i)
        {
           return cn[i];
        }

        @Override
        public int getColumnCount()
        {
           return cn.length;
        }

        @Override
        public int getRowCount()
        {
          return ca.size();
        }

        @Override
        public Object getValueAt(int x, int y)
        {

            if(y==0) 
                return ca.get(x).customer_id;
                else if(y==1)
                    return ca.get(x).name;
                else if(y==2)
                    return ca.get(x).father_name;
                else if(y==3)
                    return ca.get(x).address;
                else if(y==4)
                     return ca.get(x).city;
                else if(y==5)
                    return ca.get(x).state;
                else if(y==6)
                    return ca.get(x).mobile_no;
                else if (y==7)
                    return ca.get(x).email;
                else if (y==8)
                    return ca.get(x).date;
                else
                {
                    return null; 
                }
            
            }
          
        
}
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
            java.util.logging.Logger.getLogger(Customer_base.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Customer_base.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Customer_base.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Customer_base.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Customer_base().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_add;
    private javax.swing.JButton bt_edit;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
