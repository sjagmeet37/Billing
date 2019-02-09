/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stock;

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

/**
 *
 * @author Jagmeet sandhu
 */
public class Stock_Available extends javax.swing.JFrame {
ArrayList<stock_available_list> sal=null;
stock_available_tablemodel sat=null;  
db_Connection dbconn=null;
        
    public Stock_Available() {
        sat=new stock_available_tablemodel();
        sal=new ArrayList<>();
        dbconn=new db_Connection();
        initComponents();
        setSize(800,600);
        try {
        Connection conn = db_Connection.getconnectiom();
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs=stmt.executeQuery("SELECT p1.product_name,p1.packing,sa.available_units FROM product_info p1 LEFT JOIN stock_available sa on p1.product_id=sa.product_id ORDER BY p1.product_name");
            while (rs.next()) 
            {
                String prod_name=rs.getString("product_name");
                String pkg=rs.getString(2);
                int units_avalilable=rs.getInt("available_units");
                sal.add(new stock_available_list(prod_name, pkg,units_avalilable));
            }
        } catch (SQLException ex) {
        Logger.getLogger(Stock_Available.class.getName()).log(Level.SEVERE, null, ex);
    }
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtable_stock = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        tf_product = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel1.setText("Available Stocks");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(180, 10, 210, 50);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel2.setText("Product");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 80, 70, 30);

        jtable_stock.setModel(sat);
        jScrollPane1.setViewportView(jtable_stock);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 120, 490, 330);

        jButton1.setText("Add Stock");
        getContentPane().add(jButton1);
        jButton1.setBounds(310, 470, 90, 30);

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(430, 470, 90, 30);

        tf_product.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_productKeyReleased(evt);
            }
        });
        getContentPane().add(tf_product);
        tf_product.setBounds(110, 80, 110, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_productKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_productKeyReleased
        sal.clear();
        String prod_search=tf_product.getText();
        try {
        Connection conn = db_Connection.getconnectiom();
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs=stmt.executeQuery("SELECT p1.product_name,p1.packing,sa.available_units FROM product_info p1 LEFT JOIN stock_available sa on p1.product_id=sa.product_id where p1.product_name like\'"+prod_search+"%\' ORDER BY p1.product_name");
            while (rs.next()) 
            {
                String prod_name=rs.getString("product_name");
                String pkg=rs.getString(2);
                int units_avalilable=rs.getInt("available_units");
                
                sal.add(new stock_available_list(prod_name, pkg,units_avalilable));
                
            }
            sat.fireTableDataChanged();
        } catch (SQLException ex) {
        Logger.getLogger(Stock_Available.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_tf_productKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    public class stock_available_tablemodel extends AbstractTableModel  //inner class
    {
    
       String cn[]={"Product","Packing","Units Available"};

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
          return sal.size();
        }

        @Override
        public Object getValueAt(int x, int y)
        {

            
            if(y==0) 
                return sal.get(x).product_name;
                else if(y==1)
                    return sal.get(x).packing;
                else if(y==2)
                    return sal.get(x).units;
                else
                {
                    return null; 
                }
            
            }
          
        
}
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
            java.util.logging.Logger.getLogger(Stock_Available.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Stock_Available.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Stock_Available.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Stock_Available.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Stock_Available().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtable_stock;
    private javax.swing.JTextField tf_product;
    // End of variables declaration//GEN-END:variables
}