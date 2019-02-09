package product;

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

public class product_base extends javax.swing.JFrame {

    ArrayList<product_arraylist> pa=null;
    product_tablemodel ptm=null;
    db_Connection dbconn=null;
        
    public product_base() {
        pa=new ArrayList<>();
        ptm=new product_tablemodel();
        dbconn=new db_Connection();
        initComponents();
        setSize(700, 700);
        try {
            Connection conn =db_Connection.getconnectiom();
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from product_info");
            while(rs.next())
            {
                int product_id=rs.getInt("product_id");
                String name=rs.getString("product_name");
                String category=rs.getString("type");
                String company=rs.getString("manufacturer");
                String packing=rs.getString("packing");
                String description=rs.getString("description");
                pa.add(new product_arraylist(product_id, name, category, company, packing, description));
            }
        } catch (SQLException ex) {
            Logger.getLogger(product_base.class.getName()).log(Level.SEVERE, null, ex);
        }
        ptm.fireTableDataChanged();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

    }

    void product_base_arraylist_update(String query)
    {
        pa.clear();
        try {
            
            Connection conn =db_Connection.getconnectiom();
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next())
            {
                int product_id=rs.getInt("product_id");
                String name=rs.getString("product_name");
                String category=rs.getString("type");
                String company=rs.getString("manufacturer");
                String packing=rs.getString("packing");
                String description=rs.getString("description");
                pa.add(new product_arraylist(product_id, name, category, company, packing, description));
            }
        } catch (SQLException ex) {
            Logger.getLogger(product_base.class.getName()).log(Level.SEVERE, null, ex);
        }
        ptm.fireTableDataChanged();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_product = new javax.swing.JTable();
        bt_add = new javax.swing.JButton();
        bt_edit = new javax.swing.JButton();
        bt_back = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tf_search_product = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("Products");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(270, 4, 80, 30);

        table_product.setModel(ptm);
        jScrollPane1.setViewportView(table_product);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(50, 80, 500, 230);

        bt_add.setText("Add");
        bt_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_addActionPerformed(evt);
            }
        });
        getContentPane().add(bt_add);
        bt_add.setBounds(290, 320, 51, 23);

        bt_edit.setText("Edit");
        bt_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_editActionPerformed(evt);
            }
        });
        getContentPane().add(bt_edit);
        bt_edit.setBounds(380, 320, 51, 23);

        bt_back.setText("Back");
        bt_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_backActionPerformed(evt);
            }
        });
        getContentPane().add(bt_back);
        bt_back.setBounds(470, 320, 55, 23);

        jLabel2.setText("Search Product");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 40, 80, 30);

        tf_search_product.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_search_productKeyReleased(evt);
            }
        });
        getContentPane().add(tf_search_product);
        tf_search_product.setBounds(110, 40, 110, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_addActionPerformed
        product_new pn=new product_new(this);
        pn.setVisible(true);
    }//GEN-LAST:event_bt_addActionPerformed

    private void bt_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_editActionPerformed
        // TODO add your handling code here:
        int index=table_product.getSelectedRow();
        product_edit p_e=new product_edit(index, this);
        p_e.setVisible(true);
    }//GEN-LAST:event_bt_editActionPerformed

    private void bt_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_backActionPerformed
        this.dispose();
    }//GEN-LAST:event_bt_backActionPerformed

    private void tf_search_productKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_search_productKeyReleased
        
            String product_search=tf_search_product.getText();
            product_base_arraylist_update("select * from product_info where product_name like \'"+product_search+"%\'");      
    }//GEN-LAST:event_tf_search_productKeyReleased

     public class product_tablemodel extends AbstractTableModel
    {
        String cn[]={ "Product Id","Product Name", "Type", "Manufacturer", "Packing", "Description"};

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
          return pa.size();
        }

        @Override
        public Object getValueAt(int x, int y)
        {
            if(y==0) 
                return pa.get(x).product_id;
                else if(y==1)
                    return pa.get(x).product_name;
                else if(y==2)
                    return pa.get(x).type;
                else if(y==3)
                     return pa.get(x).manufacturer;
                else if(y==4)
                    return pa.get(x).packing;
                else if(y==5)
                    return pa.get(x).description;
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
            java.util.logging.Logger.getLogger(product_base.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(product_base.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(product_base.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(product_base.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new product_base().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_add;
    private javax.swing.JButton bt_back;
    private javax.swing.JButton bt_edit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_product;
    private javax.swing.JTextField tf_search_product;
    // End of variables declaration//GEN-END:variables
}
