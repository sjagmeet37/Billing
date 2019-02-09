
package customer;

import bill.db_Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class bill_print_search extends javax.swing.JFrame 
{
    ArrayList<customer_arraylist> ca=null;
    bill_table_model btm=null;
    bill_print bp=null;
    db_Connection dbconn=null;
        
        
    public bill_print_search(String temp, bill_print bp)
    {
        btm=new bill_table_model();
        ca=new ArrayList<>();
        this.bp=bp;
        dbconn=new db_Connection();
        initComponents();
        setSize(500, 500);
        
        tf_search.setText(temp);
        try 
        {
             
             Connection conn = db_Connection.getconnectiom();
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = stmt.executeQuery("select * from customer_details where name like \'"+temp+"%\'");
             while(rs.next())
             {
                int cust_id=rs.getInt("customer_id");
                String cust_name=rs.getString("name");
                String father_name=rs.getString("father_name");
                String address=rs.getString("address");
                String city=rs.getString("city");
                String state=rs.getString("state");
                String mobile_no=rs.getString("mobile_no");
                String email=rs.getString("email");
                String date=rs.getString("date");
                ca.add(new customer_arraylist(cust_id, cust_name, father_name, address, city, state, mobile_no, email, date));
              }
             btm.fireTableDataChanged();
         } 
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);        
    }
    public void rapid_search(String name)
    {
        ca.clear();
        try
        {
             Connection conn = db_Connection.getconnectiom();
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = stmt.executeQuery("select * from customer_details where name like \'"+name+"%\'");
             while(rs.next())
            {
                //System.out.println("executed");
                int cust_id=rs.getInt("customer_id");
                String cust_name=rs.getString("name");
                String father_name=rs.getString("father_name");
                String address=rs.getString("address");
                String city=rs.getString("city");
                String state=rs.getString("state");
                String mobile_no=rs.getString("mobile_no");
                String email=rs.getString("email");
                String date=rs.getString("date");
                ca.add(new customer_arraylist(cust_id, cust_name, father_name, address, city, state, mobile_no, email, date));
             }
             btm.fireTableDataChanged();
         } 
         catch (Exception ex)
         {
             ex.printStackTrace();
         }
        
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tf_search = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        tf_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_searchKeyReleased(evt);
            }
        });
        getContentPane().add(tf_search);
        tf_search.setBounds(30, 30, 160, 30);

        jTable1.setModel(btm);
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 70, 440, 300);

        jButton1.setText("Select");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(340, 390, 90, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int index=jTable1.getSelectedRow();
        int cust_id=ca.get(index).customer_id;
        String customer=ca.get(index).name;
        bp.setcust(cust_id, customer);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tf_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_searchKeyReleased
         String name=tf_search.getText();
        System.out.println("Key Typed Name:::"+name);
        rapid_search(name);
        name="";
    }//GEN-LAST:event_tf_searchKeyReleased

      public class bill_table_model extends AbstractTableModel  //inner class
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
            java.util.logging.Logger.getLogger(bill_print_search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(bill_print_search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(bill_print_search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(bill_print_search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                //new bill_print_search().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField tf_search;
    // End of variables declaration//GEN-END:variables
}
