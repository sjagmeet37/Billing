package bill;
import customer.*;
import javax.swing.JOptionPane;
import product.*;
import supplier.*;
import stock.*;
public class home_page extends javax.swing.JFrame {

    public home_page() {
        initComponents();
        setSize(1366, 768);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bt_new_bill = new javax.swing.JButton();
        bt_day_book = new javax.swing.JButton();
        bt_stock_available = new javax.swing.JButton();
        bt_add_stock = new javax.swing.JButton();
        bt_product_list = new javax.swing.JButton();
        bt_add_product = new javax.swing.JButton();
        bt_supplier_list = new javax.swing.JButton();
        bt_add_supplier = new javax.swing.JButton();
        bt_edit_supplier = new javax.swing.JButton();
        bt_edit_product = new javax.swing.JButton();
        bt_customer_list = new javax.swing.JButton();
        bt_add_user = new javax.swing.JButton();
        bt_edit_customer = new javax.swing.JButton();
        bt_add_customer = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        text_firm = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(null);

        bt_new_bill.setBackground(new java.awt.Color(255, 255, 255));
        bt_new_bill.setText("New Bill");
        bt_new_bill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_new_billActionPerformed(evt);
            }
        });
        getContentPane().add(bt_new_bill);
        bt_new_bill.setBounds(603, 20, 110, 30);

        bt_day_book.setBackground(new java.awt.Color(255, 255, 255));
        bt_day_book.setText("Day Book");
        getContentPane().add(bt_day_book);
        bt_day_book.setBounds(603, 60, 110, 30);

        bt_stock_available.setBackground(new java.awt.Color(255, 255, 255));
        bt_stock_available.setText("Stock Available");
        bt_stock_available.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_stock_availableActionPerformed(evt);
            }
        });
        getContentPane().add(bt_stock_available);
        bt_stock_available.setBounds(603, 100, 110, 30);

        bt_add_stock.setBackground(new java.awt.Color(255, 255, 255));
        bt_add_stock.setText("Add Stock");
        bt_add_stock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_add_stockActionPerformed(evt);
            }
        });
        getContentPane().add(bt_add_stock);
        bt_add_stock.setBounds(603, 140, 110, 30);

        bt_product_list.setBackground(new java.awt.Color(255, 255, 255));
        bt_product_list.setText("Product List");
        bt_product_list.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_product_listActionPerformed(evt);
            }
        });
        getContentPane().add(bt_product_list);
        bt_product_list.setBounds(603, 180, 110, 30);

        bt_add_product.setBackground(new java.awt.Color(255, 255, 255));
        bt_add_product.setText("Add Product");
        bt_add_product.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_add_productActionPerformed(evt);
            }
        });
        getContentPane().add(bt_add_product);
        bt_add_product.setBounds(603, 220, 110, 30);

        bt_supplier_list.setBackground(new java.awt.Color(255, 255, 255));
        bt_supplier_list.setText("Supplier List");
        bt_supplier_list.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_supplier_listActionPerformed(evt);
            }
        });
        getContentPane().add(bt_supplier_list);
        bt_supplier_list.setBounds(600, 300, 110, 30);

        bt_add_supplier.setBackground(new java.awt.Color(255, 255, 255));
        bt_add_supplier.setText("Add Supplier");
        bt_add_supplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_add_supplierActionPerformed(evt);
            }
        });
        getContentPane().add(bt_add_supplier);
        bt_add_supplier.setBounds(600, 340, 110, 30);

        bt_edit_supplier.setBackground(new java.awt.Color(255, 255, 255));
        bt_edit_supplier.setText("Edit Supplier");
        bt_edit_supplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_edit_supplierActionPerformed(evt);
            }
        });
        getContentPane().add(bt_edit_supplier);
        bt_edit_supplier.setBounds(600, 380, 110, 30);

        bt_edit_product.setBackground(new java.awt.Color(255, 255, 255));
        bt_edit_product.setText("Edit Product");
        bt_edit_product.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_edit_productActionPerformed(evt);
            }
        });
        getContentPane().add(bt_edit_product);
        bt_edit_product.setBounds(600, 260, 110, 30);

        bt_customer_list.setBackground(new java.awt.Color(255, 255, 255));
        bt_customer_list.setText("Customer List");
        bt_customer_list.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_customer_listActionPerformed(evt);
            }
        });
        getContentPane().add(bt_customer_list);
        bt_customer_list.setBounds(600, 420, 110, 30);

        bt_add_user.setBackground(new java.awt.Color(255, 255, 255));
        bt_add_user.setText("Add User");
        getContentPane().add(bt_add_user);
        bt_add_user.setBounds(600, 540, 110, 30);

        bt_edit_customer.setBackground(new java.awt.Color(255, 255, 255));
        bt_edit_customer.setText("Edit Customer");
        bt_edit_customer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_edit_customerActionPerformed(evt);
            }
        });
        getContentPane().add(bt_edit_customer);
        bt_edit_customer.setBounds(600, 500, 110, 30);

        bt_add_customer.setBackground(new java.awt.Color(255, 255, 255));
        bt_add_customer.setText("Add Customer");
        bt_add_customer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_add_customerActionPerformed(evt);
            }
        });
        getContentPane().add(bt_add_customer);
        bt_add_customer.setBounds(600, 460, 110, 30);

        jButton15.setBackground(new java.awt.Color(255, 255, 255));
        jButton15.setText("Exit");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton15);
        jButton15.setBounds(600, 580, 110, 30);

        text_firm.setText("Firm Name");
        getContentPane().add(text_firm);
        text_firm.setBounds(140, 160, 220, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_product_listActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_product_listActionPerformed
        product.product_base pb=new product_base();
        pb.setVisible(true);
    }//GEN-LAST:event_bt_product_listActionPerformed

    private void bt_customer_listActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_customer_listActionPerformed
        Customer_base c1=new Customer_base();
        c1.setVisible(true);
    }//GEN-LAST:event_bt_customer_listActionPerformed

    private void bt_add_customerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_add_customerActionPerformed
        Customer_New_details cnd=new Customer_New_details();
        cnd.setVisible(true);       
    }//GEN-LAST:event_bt_add_customerActionPerformed

    private void bt_edit_productActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_edit_productActionPerformed
        product_base p_b=new product_base();
        p_b.setVisible(true);
    }//GEN-LAST:event_bt_edit_productActionPerformed

    private void bt_edit_customerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_edit_customerActionPerformed
        Customer_base c1=new Customer_base();
        c1.setVisible(true);
    }//GEN-LAST:event_bt_edit_customerActionPerformed

    private void bt_supplier_listActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_supplier_listActionPerformed
        supplier_base sb=new supplier_base();
        sb.setVisible(true);
    }//GEN-LAST:event_bt_supplier_listActionPerformed

    private void bt_add_supplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_add_supplierActionPerformed
            supplier_add sa=new supplier_add();
            sa.setVisible(true);
    }//GEN-LAST:event_bt_add_supplierActionPerformed

    private void bt_edit_supplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_edit_supplierActionPerformed
        supplier_base sb=new supplier_base();
        sb.setVisible(true);
    }//GEN-LAST:event_bt_edit_supplierActionPerformed

    private void bt_stock_availableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_stock_availableActionPerformed
        Stock_Available sta=new Stock_Available();
        sta.setVisible(true);
    }//GEN-LAST:event_bt_stock_availableActionPerformed

    private void bt_add_stockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_add_stockActionPerformed
        Stock_new stn=new Stock_new();
        stn.setVisible(true);
    }//GEN-LAST:event_bt_add_stockActionPerformed

    private void bt_add_productActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_add_productActionPerformed
        product_new pn=new product_new(null);
        pn.setVisible(true);
    }//GEN-LAST:event_bt_add_productActionPerformed

    private void bt_new_billActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_new_billActionPerformed
        bill_print b1=new bill_print();
        b1.setVisible(true);
    }//GEN-LAST:event_bt_new_billActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        
    }//GEN-LAST:event_jButton15ActionPerformed

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
            java.util.logging.Logger.getLogger(home_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(home_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(home_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(home_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new home_page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_add_customer;
    private javax.swing.JButton bt_add_product;
    private javax.swing.JButton bt_add_stock;
    private javax.swing.JButton bt_add_supplier;
    private javax.swing.JButton bt_add_user;
    private javax.swing.JButton bt_customer_list;
    private javax.swing.JButton bt_day_book;
    private javax.swing.JButton bt_edit_customer;
    private javax.swing.JButton bt_edit_product;
    private javax.swing.JButton bt_edit_supplier;
    private javax.swing.JButton bt_new_bill;
    private javax.swing.JButton bt_product_list;
    private javax.swing.JButton bt_stock_available;
    private javax.swing.JButton bt_supplier_list;
    private javax.swing.JButton jButton15;
    private javax.swing.JLabel text_firm;
    // End of variables declaration//GEN-END:variables
}
