
package supplier;

import bill.db_Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;


public class supplier_base extends javax.swing.JFrame {
    db_Connection dbconn=null;
        
   ArrayList<supplier_arraylist> al=null;
   supplier_tablemodel st=null;
    public supplier_base() {
           dbconn=new db_Connection();
           al=new ArrayList<>();
           st=new supplier_tablemodel();
           initComponents();
           setSize(900,700);
           setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
       try {
          
           Connection conn =         db_Connection.getconnectiom();
           Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
           ResultSet rs = stmt.executeQuery("select * from supplier_details");
           while(rs.next())
           {
               System.out.println("in rs");
               int id=rs.getInt("supplier_id");
               String name=rs.getString("supplier_name");
               String address=rs.getString("address");
               String city=rs.getString("city");
               String state=rs.getString("state");
               String mobile=rs.getString("mobile_no");
               String email=rs.getString("email");
               String type=rs.getString("type");
               al.add(new supplier_arraylist(id, name, address, city, state, mobile, email, type));
           }
       } catch (SQLException ex) {
           Logger.getLogger(supplier_base.class.getName()).log(Level.SEVERE, null, ex);
       }
       st.fireTableDataChanged();
    }

    public class supplier_tablemodel extends AbstractTableModel
    {
              
        String cn[]={ "Supplier Id","Supplier name", "Address", "City", "State", "Mobile", "Email","Type"};

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
          return al.size();
        }

        @Override
        public Object getValueAt(int x, int y)
        {
            if(y==0) 
                return al.get(x).supplier_id;
                else if(y==1)
                    return al.get(x).supplier_name;
                else if(y==2)
                    return al.get(x).address;
                else if(y==3)
                     return al.get(x).city;
                else if(y==4)
                    return al.get(x).state;
                else if(y==5)
                    return al.get(x).mobile_no;
                else if (y==6)
                    return al.get(x).email;
                else if(y==7)
                    return al.get(x).type;
                else
                {
                    return null; 
                }
            
            }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel1.setText("Suppliers");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(340, 10, 150, 50);

        jTable1.setModel(st);
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 80, 770, 380);

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(490, 480, 80, 30);

        jButton2.setText("Edit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(610, 480, 80, 30);

        jButton3.setText("Back");
        getContentPane().add(jButton3);
        jButton3.setBounds(720, 480, 80, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents
     void update_supplier_list()
     {
         al.clear();
         try {
          
           Connection conn = db_Connection.getconnectiom();
           Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
           ResultSet rs = stmt.executeQuery("select * from supplier_details");
           while(rs.next())
           {
               System.out.println("in rs");
               int id=rs.getInt("supplier_id");
               String name=rs.getString("supplier_name");
               String address=rs.getString("address");
               String city=rs.getString("city");
               String state=rs.getString("state");
               String mobile=rs.getString("mobile_no");
               String email=rs.getString("email");
               String type=rs.getString("type");
               al.add(new supplier_arraylist(id, name, address, city, state, mobile, email, type));
           }
       } catch (SQLException ex) {
           Logger.getLogger(supplier_base.class.getName()).log(Level.SEVERE, null, ex);
       }
       st.fireTableDataChanged();
     }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        supplier_add sa=new supplier_add(this);
        sa.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int index=jTable1.getSelectedRow();
        supplier_edit s1=new supplier_edit(this, index);
        s1.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

  
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
            java.util.logging.Logger.getLogger(supplier_base.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(supplier_base.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(supplier_base.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(supplier_base.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
         
            @Override
            public void run() {
                new supplier_base().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
