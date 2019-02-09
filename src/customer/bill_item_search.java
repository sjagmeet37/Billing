
package customer;

import bill.db_Connection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

public class bill_item_search extends javax.swing.JFrame {
    bill_print bp=null;
    itemSearch_table_model itm=null;
    ArrayList<bill_item_arraylist> bia=null;
    String searchText,p_name,manf,packing,product_id;
    db_Connection dbconn=null;
   
    bill_item_search(String product_temp, bill_print aThis) {
        itm=new itemSearch_table_model();
        bia=new ArrayList<>();
        dbconn=new db_Connection();
        this.bp=aThis;
        initComponents();
        setSize(550, 550);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        tf_search_text.setText(product_temp);
        searchProduct();
    }
    final void searchProduct()
    {
        bia.clear();
        searchText=tf_search_text.getText();
        try {
            Connection conn = db_Connection.getconnectiom();
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from product_info where product_name like \'"+searchText+"%\'");
            while(rs.next())
            {
                p_name=rs.getString("product_name");
                manf=rs.getString("manufacturer");
                packing=rs.getString("packing");
                bia.add(new bill_item_arraylist(p_name, packing, manf));
            }
                } catch (SQLException ex) {
            Logger.getLogger(bill_item_search.class.getName()).log(Level.SEVERE, null, ex);
        }
        itm.fireTableDataChanged();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_item_search = new javax.swing.JTable();
        tf_search_text = new javax.swing.JTextField();
        bt_select = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jTable_item_search.setModel(itm);
        jScrollPane1.setViewportView(jTable_item_search);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(28, 57, 452, 380);

        tf_search_text.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_search_textKeyReleased(evt);
            }
        });
        getContentPane().add(tf_search_text);
        tf_search_text.setBounds(30, 10, 170, 30);

        bt_select.setText("Select");
        bt_select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_selectActionPerformed(evt);
            }
        });
        getContentPane().add(bt_select);
        bt_select.setBounds(370, 460, 61, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_search_textKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_search_textKeyReleased
        searchProduct();
    }//GEN-LAST:event_tf_search_textKeyReleased

    private void bt_selectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_selectActionPerformed
            int index=jTable_item_search.getSelectedRow();
            String item=bia.get(index).product_name;
            item=item+",";
            item=item+bia.get(index).packing;
            bp.set_Item(item);
    }//GEN-LAST:event_bt_selectActionPerformed

     public class itemSearch_table_model extends AbstractTableModel  //inner class
    {
         
       String cn[]={"Product Name", "Manufacturer", "Packing"};

    
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
          return bia.size();
        }

        @Override
        public Object getValueAt(int x, int y)
        {
            if(y==0) 
                return bia.get(x).product_name;
                else if(y==1)
                    return bia.get(x).manufacturer;
                else if(y==2)
                    return bia.get(x).packing;
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
            java.util.logging.Logger.getLogger(bill_item_search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(bill_item_search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(bill_item_search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(bill_item_search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
          //     new bill_item_search().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_select;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_item_search;
    private javax.swing.JTextField tf_search_text;
    // End of variables declaration//GEN-END:variables
}
