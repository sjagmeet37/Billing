package bill;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

public final class daybook extends javax.swing.JFrame {
    ArrayList<Daybook_arraylist> dba=null;
    daybook_table_model dbt = null;
    public daybook() {
        dba=new ArrayList<>();
        dbt=new daybook_table_model();
        initComponents();
        setSize(600,800);
        Date date=new Date();
        jDateChooser.setDate(date);
        fill_table();
    }
    
    
    void fill_table()
    {
        String cust_name,type;
        int invoice_id;
        float amount;
        try {
            dba.clear();
            Date dateFromDateChooser = jDateChooser.getDate();
            String date = String.format("%1$td/%1$tm/%1$tY", dateFromDateChooser);
            Connection conn = db_Connection.getconnectiom();
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("SELECT sum(total_price) as amount,invoice_id,customer_id,type from invoice where date=\'"+date+"\' GROUP by invoice_id");
            while(rs.next())
            {
                invoice_id=rs.getInt("invoice_id");
               amount=rs.getFloat("amount");
               cust_name=get_cust_name(rs.getInt("customer_id"));
               type=rs.getString("type");
               dba.add(new Daybook_arraylist(cust_name, amount, invoice_id,type));
            }
        } catch (SQLException ex) {
            Logger.getLogger(daybook.class.getName()).log(Level.SEVERE, null, ex);
        }
        dbt.fireTableDataChanged();
    }
    String get_cust_name(int cust_id)
    {
        try {
            Connection conn = db_Connection.getconnectiom();
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("SELECT name from customer_details where customer_id = "+cust_id);
            rs.next();
            return rs.getString("name");
        
        } catch (SQLException ex) {
            Logger.getLogger(daybook.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
            
    }
    public class daybook_table_model extends AbstractTableModel  //inner class
    {
         
       String cn[]={"Invoice Number", "Customer Name","Amount"};
      
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
          return dba.size();
        }

        @Override
        public Object getValueAt(int x, int y)
        {
           switch (y) {
               case 0:
                   return dba.get(x).invoice_no;
               case 1:
                   return dba.get(x).customer_name;
               case 2:
                   return dba.get(x).bill_amount;
               default:
                   return null;
           }
        }       
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jDateChooser = new com.toedter.calendar.JDateChooser();
        dd_transaction_type = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        bt_go = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel1.setText("Day Book");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(191, 11, 180, 40);

        jDateChooser.setDateFormatString("dd/MM/yyyy");
        getContentPane().add(jDateChooser);
        jDateChooser.setBounds(110, 80, 140, 30);

        dd_transaction_type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Cash", "Credit" }));
        getContentPane().add(dd_transaction_type);
        dd_transaction_type.setBounds(500, 80, 100, 30);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel2.setText("Transaction Type");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(350, 80, 140, 30);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel3.setText("Date");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(40, 80, 60, 30);

        jButton1.setText("View");
        getContentPane().add(jButton1);
        jButton1.setBounds(330, 500, 73, 23);

        jButton2.setText("Back");
        getContentPane().add(jButton2);
        jButton2.setBounds(430, 500, 55, 23);

        jTable2.setModel(dbt);
        jScrollPane2.setViewportView(jTable2);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(20, 120, 550, 370);

        bt_go.setText("Go");
        bt_go.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_goActionPerformed(evt);
            }
        });
        getContentPane().add(bt_go);
        bt_go.setBounds(260, 80, 45, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_goActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_goActionPerformed
        fill_table();
    }//GEN-LAST:event_bt_goActionPerformed
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
            java.util.logging.Logger.getLogger(daybook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(daybook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(daybook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(daybook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new daybook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_go;
    private javax.swing.JComboBox<String> dd_transaction_type;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
