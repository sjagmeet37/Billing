
package product;

import bill.db_Connection;
import customer.Customer_New_details;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jagmeet sandhu
 */
public class product_edit extends javax.swing.JFrame {

    int index;
    int p_id;
    product_base p_b=null;
    db_Connection dbconn=null;
        
    public product_edit(int index,product_base pb) 
    {
        this.index=index;
        p_b=new product_base();
        initComponents();
        dbconn=new db_Connection();
        setSize(500,600);
        try {
            Connection conn = db_Connection.getconnectiom();
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from units");
                while(rs.next())
                {
                    tf_units.addItem(rs.getString("abbreviation"));
                }
        } catch (SQLException ex) 
           {
                ex.printStackTrace();
           }
        tf_product_name.setText(this.p_b.pa.get(index).product_name);
        tf_description.setText(this.p_b.pa.get(index).description);
        String str=this.p_b.pa.get(index).packing;
        String str2 = str.replaceAll("[^\\d]", "");
        tf_packing.setText(str2);
        p_id=this.p_b.pa.get(index).product_id;
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
        tf_product_name = new javax.swing.JTextField();
        tf_company = new javax.swing.JComboBox<>();
        tf_category = new javax.swing.JComboBox<>();
        bt_cancel = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tf_description = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        tf_packing = new javax.swing.JTextField();
        bt_edit = new javax.swing.JButton();
        tf_units = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel1.setText("Add New Product");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(150, 20, 230, 50);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel2.setText("Product Name");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 100, 130, 30);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel3.setText("Company");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(40, 140, 110, 30);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel4.setText("Description");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(40, 260, 100, 30);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel5.setText("Category");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(40, 180, 90, 30);
        getContentPane().add(tf_product_name);
        tf_product_name.setBounds(230, 100, 210, 30);

        tf_company.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(tf_company);
        tf_company.setBounds(230, 140, 210, 30);

        tf_category.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(tf_category);
        tf_category.setBounds(230, 180, 210, 30);

        bt_cancel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bt_cancel.setText("cancel");
        bt_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cancelActionPerformed(evt);
            }
        });
        getContentPane().add(bt_cancel);
        bt_cancel.setBounds(350, 370, 90, 30);

        tf_description.setColumns(20);
        tf_description.setRows(5);
        jScrollPane2.setViewportView(tf_description);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(230, 260, 210, 96);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel6.setText("Packing");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(40, 220, 80, 20);
        getContentPane().add(tf_packing);
        tf_packing.setBounds(230, 220, 90, 30);

        bt_edit.setText("Edit");
        bt_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_editActionPerformed(evt);
            }
        });
        getContentPane().add(bt_edit);
        bt_edit.setBounds(230, 370, 90, 30);

        getContentPane().add(tf_units);
        tf_units.setBounds(340, 220, 100, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_editActionPerformed

        String name=tf_product_name.getText();
        String category=(String)tf_category.getSelectedItem();
        String company=(String)tf_company.getSelectedItem();
        String packing=tf_packing.getText();
        String units=(String)tf_units.getSelectedItem();
        String description=tf_description.getText();
        

        if(name.equals("") || packing.equals("")  )
        {
            JOptionPane.showMessageDialog(this, "please enter name and packing");
        }
        else if (name.length() <=4 )
        {
            JOptionPane.showMessageDialog(this, "please enter a valid product name");
            tf_product_name.setText("");
        }
        else
        {
            product_arraylist pa_temp=new product_arraylist(p_id, name, name, name, packing, description);
            packing=packing.concat(units);
            try {
                Connection conn = db_Connection.getconnectiom();

                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

                try (ResultSet rs = stmt.executeQuery("select * from product_info where product_id="+p_id)) {
                    System.out.println("Resultset created");
                    rs.next();
                    rs.updateString("product_name", name);
                    rs.updateString("type",category);
                    rs.updateString("manufacturer", company);
                    rs.updateString("packing",packing);
                    rs.updateString("description",description);
                    rs.updateRow();
                    
                    this.p_b.pa.set(index, pa_temp);
                    this.p_b.ptm.fireTableDataChanged();
                    JOptionPane.showMessageDialog(this, "Product Edited Successfully");
                    this.dispose();
                }
                //quantity needs to be added
            } catch (SQLException ex) {
                Logger.getLogger(Customer_New_details.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_bt_editActionPerformed

    private void bt_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_bt_cancelActionPerformed

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
            java.util.logging.Logger.getLogger(product_edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(product_edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(product_edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(product_edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                //new product_edit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_cancel;
    private javax.swing.JButton bt_edit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> tf_category;
    private javax.swing.JComboBox<String> tf_company;
    private javax.swing.JTextArea tf_description;
    private javax.swing.JTextField tf_packing;
    private javax.swing.JTextField tf_product_name;
    private javax.swing.JComboBox<String> tf_units;
    // End of variables declaration//GEN-END:variables
}
