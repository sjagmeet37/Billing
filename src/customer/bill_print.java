package customer;

import bill.db_Connection;
import stock.Stock_Available;
import java.awt.print.PrinterException;
import java.sql.*;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
public class bill_print extends javax.swing.JFrame {
    
    int cust_id;
    float bill_total_amt;
    String customer_name;
    int invoice_id;
    int product_id_purchased[]=null;
    String date;
    ArrayList<bill_print_arraylist> bpa=null;
    item_add_tablemodel iat=null;
    db_Connection dbconn=null;
    public bill_print() {
        
            bpa=new ArrayList<>();
            iat=new item_add_tablemodel();
            bill_total_amt=0;
            dbconn=new db_Connection();
            initComponents();
            setSize(800, 800);
            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tf_quantity = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        bill_item_jtable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        tf_final_total = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        bt_remove = new javax.swing.JButton();
        bt_save_print = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        tf_txn_type = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        bt_save = new javax.swing.JButton();
        tf_date = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        tf_gst = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        tf_batch_no = new javax.swing.JTextField();
        tf_custname = new javax.swing.JTextField();
        bt_customer_search = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        tf_unit_price = new javax.swing.JTextField();
        bt_add = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        tf_mfg_date = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tf_exp_date = new javax.swing.JTextField();
        tf_item = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Item");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 190, 90, 30);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Quantity");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(500, 190, 70, 30);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("GST");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(600, 190, 70, 30);
        getContentPane().add(tf_quantity);
        tf_quantity.setBounds(500, 220, 90, 30);

        bill_item_jtable.setModel(iat);
        bill_item_jtable.setShowHorizontalLines(false);
        bill_item_jtable.setShowVerticalLines(false);
        jScrollPane1.setViewportView(bill_item_jtable);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 260, 870, 210);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel2.setText("Customer Name");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 70, 190, 30);

        tf_final_total.setEnabled(false);
        getContentPane().add(tf_final_total);
        tf_final_total.setBounds(770, 490, 110, 30);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel8.setText("Total");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(700, 490, 50, 30);

        bt_remove.setText("Remove");
        bt_remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_removeActionPerformed(evt);
            }
        });
        getContentPane().add(bt_remove);
        bt_remove.setBounds(40, 500, 90, 30);

        bt_save_print.setText("Print And Save");
        bt_save_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_save_printActionPerformed(evt);
            }
        });
        getContentPane().add(bt_save_print);
        bt_save_print.setBounds(760, 540, 120, 30);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel9.setText("Date");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(20, 110, 130, 30);

        tf_txn_type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "cash", "credit" }));
        getContentPane().add(tf_txn_type);
        tf_txn_type.setBounds(660, 110, 160, 30);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel10.setText("Transaction Mode");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(500, 110, 140, 30);

        bt_save.setText("Save");
        bt_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_saveActionPerformed(evt);
            }
        });
        getContentPane().add(bt_save);
        bt_save.setBounds(650, 540, 90, 30);

        tf_date.setDateFormatString("dd-MM-yyyy");
        getContentPane().add(tf_date);
        tf_date.setBounds(180, 110, 200, 30);

        jLabel11.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel11.setText("Invoice");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(370, 0, 160, 50);

        tf_gst.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "6%", "12%", "18%", "28%" }));
        getContentPane().add(tf_gst);
        tf_gst.setBounds(600, 220, 90, 30);

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel12.setText("Batch no.");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(230, 190, 80, 30);
        getContentPane().add(tf_batch_no);
        tf_batch_no.setBounds(230, 220, 100, 30);
        getContentPane().add(tf_custname);
        tf_custname.setBounds(180, 70, 200, 30);

        bt_customer_search.setText("Search");
        bt_customer_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_customer_searchActionPerformed(evt);
            }
        });
        getContentPane().add(bt_customer_search);
        bt_customer_search.setBounds(390, 70, 70, 30);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setText("Unit Price");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(700, 190, 70, 30);
        getContentPane().add(tf_unit_price);
        tf_unit_price.setBounds(700, 220, 90, 30);

        bt_add.setText("Add");
        bt_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_addActionPerformed(evt);
            }
        });
        getContentPane().add(bt_add);
        bt_add.setBounds(800, 220, 80, 30);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Mfg. date");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(340, 190, 70, 30);
        getContentPane().add(tf_mfg_date);
        tf_mfg_date.setBounds(340, 220, 70, 30);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Exp. date");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(420, 190, 70, 30);
        getContentPane().add(tf_exp_date);
        tf_exp_date.setBounds(420, 220, 70, 30);

        tf_item.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_itemKeyTyped(evt);
            }
        });
        getContentPane().add(tf_item);
        tf_item.setBounds(20, 220, 200, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_customer_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_customer_searchActionPerformed
        // TODO add your handling code here:
        String temp=tf_custname.getText();
        bill_print_search bps=new bill_print_search(temp,this);
        bps.setVisible(true);
    }//GEN-LAST:event_bt_customer_searchActionPerformed
    void updatecredit()
    {
        float prevbal;
        try {
            Connection conn =db_Connection.getconnectiom();
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            try {
            ResultSet rs0=stmt.executeQuery("select * from customer_credit where customer_id="+cust_id);
            rs0.last();
            prevbal=rs0.getFloat("updated_balance");
            } catch (Exception e) {
                prevbal=0;
            }
            System.out.println("previous balance"+prevbal);
            float updtbal=prevbal+Float.parseFloat(tf_final_total.getText());
            ResultSet rs=stmt.executeQuery("select * from customer_credit");
            rs.moveToInsertRow();
            rs.updateInt("customer_id", cust_id);
            rs.updateInt("invoice_id",invoice_id );
            rs.updateFloat("bill_amount",Float.parseFloat(tf_final_total.getText()));
            rs.updateFloat("previous_balance",prevbal);
            rs.updateFloat("updated_balance", updtbal);
            rs.updateFloat("amount_debited", 0);
            rs.updateString("date",date);
            rs.insertRow();
        } catch (SQLException ex) {
            Logger.getLogger(bill_print.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void setcust(int cust_id,String customer)
    {
        this.cust_id=cust_id;
        this.customer_name=customer;
        this.tf_custname.setText(customer);
    }
    String getmanfacturer(String item)
    {
        String man = null;
        try {
            StringTokenizer st=new StringTokenizer(item,",");
            String p_name=st.nextToken();
            String packing=st.nextToken();
            Connection conn =db_Connection.getconnectiom();
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from product_info where product_name=\'"+p_name+"\'and packing=\'"+packing+"\'");
            rs.next();
            man=rs.getString("manufacturer");
        } catch (SQLException ex) {
            Logger.getLogger(bill_print.class.getName()).log(Level.SEVERE, null, ex);
        }
            return man;
    }
    boolean stock_check(int units,String p_name) throws SQLException
    {
        StringTokenizer st1=new StringTokenizer(p_name,",");
        String name=st1.nextToken();
        String pkg=st1.nextToken();
        int local_unit = 0;
            Connection conn =db_Connection.getconnectiom();
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from stock_available where product_id=(select product_id from product_info where product_name=\'"+name+"\'and packing=\'"+pkg+"\')");
            if(rs.next())
            {
                local_unit=rs.getInt("available_units");
            }
            else
            {   
                return true;
            }
            return units>=local_unit;                    
    }
    private void bt_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_addActionPerformed
            String cust_name=tf_custname.getText();
            date=tf_date.getDateFormatString();
            String item=tf_item.getText();
            String manufacturer=getmanfacturer(item);
            String batch_no=tf_batch_no.getText();
            int quantity = 0;
            float total = 0;
            float unit_price = 0;
            float rate = 0;
            String tf_selected=(String)tf_gst.getSelectedItem();
            StringTokenizer st=new StringTokenizer(tf_selected,"%");
            int gst=Integer.parseInt(st.nextToken());
            int temp_try_check=0;
            try
            {
                unit_price=Float.parseFloat(tf_unit_price.getText());
                temp_try_check=1;
                rate=unit_price-((unit_price*gst)/100);
                quantity=Integer.parseInt(tf_quantity.getText());
                total=quantity*unit_price;
                bill_total_amt=bill_total_amt+total;
            }
            catch(NumberFormatException nfe)
            {
                if(temp_try_check==0){
                     JOptionPane.showMessageDialog(this, "Please enter valid Price eg. 20");
                     tf_unit_price.setText("");
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Plese enter valid quantity eg. 5");
                    tf_quantity.setText("");
                }
            }
            String cgst=String.valueOf(gst/2);
            cgst=cgst.concat("%");
            String sgst=cgst;
            String manfacture_date=tf_mfg_date.getText();
            String expiry=tf_exp_date.getText();
            Pattern pattern = Pattern.compile("\\d{2}-\\d{2}");
            Matcher matcher = pattern.matcher(manfacture_date);
            Matcher matcher2 = pattern.matcher(expiry);
            boolean b = false;
        try {
            b = stock_check(quantity,item);
        } catch (SQLException ex) {
            Logger.getLogger(bill_print.class.getName()).log(Level.SEVERE, null, ex);
        }
            if(item.equals("") || batch_no.equals("") || manfacture_date.equals("") || expiry.equals("") || cust_name.equals("") || date.equals("") || tf_unit_price.getText().equals("") || tf_quantity.getText().equals(""))
            {
                JOptionPane.showMessageDialog(this, "Plese enter all details");
            }
            else if(!matcher.matches() || !matcher2.matches())
            {
                JOptionPane.showMessageDialog(this, "Enter valid Manufature or expiry date(ex. mm-yy)");
                tf_mfg_date.setText("");
                tf_exp_date.setText("");
            }
            else if(b)
            {
                JOptionPane.showMessageDialog(this, "Stock not available");
            }
            else
                {
                    tf_final_total.setText(Float.toString(bill_total_amt));
                    bpa.add(new bill_print_arraylist(item, batch_no, manufacturer, manfacture_date, expiry, quantity, rate, cgst, sgst, unit_price, total));
                    iat.fireTableDataChanged();
                    tf_quantity.setText("");
                    tf_batch_no.setText("");
                    tf_mfg_date.setText("");
                    tf_exp_date.setText("");
                    tf_unit_price.setText("");
                }
    }//GEN-LAST:event_bt_addActionPerformed

    private void bt_removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_removeActionPerformed
        // TODO add your handling code here:
        int index=bill_item_jtable.getSelectedRow();
        bill_total_amt=bill_total_amt-bpa.get(index).total;
        tf_final_total.setText(Float.toString(bill_total_amt));
        bpa.remove(index);
        iat.fireTableDataChanged();
    }//GEN-LAST:event_bt_removeActionPerformed

    private void bt_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_saveActionPerformed
        try {                                        
            try {
                product_id_purchased=new int[bpa.size()];
                Connection conn =db_Connection.getconnectiom();
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                for (int i = 0; i < bpa.size(); i++)
                {
                    String temp=bpa.get(i).item;
                    StringTokenizer st=new StringTokenizer(temp,",");
                    String p_name=st.nextToken();
                    String packing=st.nextToken();
                    try (ResultSet rs = stmt.executeQuery("select * from product_info where product_name=\'"+p_name+"\'and packing=\'"+packing+"\'")) {
                        rs.next();
                        product_id_purchased[i]=Integer.parseInt(rs.getString("product_id"));
                    }
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
            Connection conn =db_Connection.getconnectiom();
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs=stmt.executeQuery("select * from invoice");
            rs.last();
            invoice_id=1+rs.getInt("invoice_id");
            
            Date dateFromDateChooser = tf_date.getDate();
             date = String.format("%1$td/%1$tm/%1$tY", dateFromDateChooser);
            
            for (int i = 0; i < bpa.size(); i++) 
            {
                rs.moveToInsertRow();
                rs.updateInt("invoice_id",invoice_id);
                rs.updateInt("customer_id",cust_id);
                rs.updateInt("product_id",product_id_purchased[i]);
                rs.updateFloat("unit_price",bpa.get(i).unit_price );
                rs.updateFloat("total_units",bpa.get(i).quantity );
                rs.updateFloat("total_price",bpa.get(i).total);
                rs.updateString("type",(String)tf_txn_type.getSelectedItem());
                rs.updateString("manfac_date",bpa.get(i).manfacture_date );
                rs.updateString("expiry_date",bpa.get(i).expiry );
                rs.updateString("batch_no.",bpa.get(i).batch_no );
                rs.updateString("date",date);
                rs.updateString("manufacturer",bpa.get(i).manufacturer);
                rs.updateString("cgst",bpa.get(i).cgst);
                rs.updateString("sgst",bpa.get(i).sgst);
                rs.insertRow();
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        String txntyp=(String) tf_txn_type.getSelectedItem();
        if(txntyp.equals("credit"))
        {
            updatecredit();
        }
        try {
            update_stock();
        } catch (SQLException ex) {
            Logger.getLogger(bill_print.class.getName()).log(Level.SEVERE, null, ex);
        }
        bpa.clear();
        //tf_date.setDate(new);
        tf_custname.setText("");        
    }//GEN-LAST:event_bt_saveActionPerformed

    private void bt_save_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_save_printActionPerformed
        MessageFormat header=new MessageFormat("Stock");
        MessageFormat footer=new MessageFormat("{0}");
        
    try {
        bill_item_jtable.print(JTable.PrintMode.FIT_WIDTH, header, footer);
    } catch (PrinterException ex) {
        Logger.getLogger(Stock_Available.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_bt_save_printActionPerformed

    private void tf_itemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_itemKeyTyped
        String product_temp=tf_item.getText();
        bill_item_search bis=new bill_item_search(product_temp,this);
        bis.setVisible(true);
    }//GEN-LAST:event_tf_itemKeyTyped
    void set_Item(String item)
    {
        tf_item.setText(item);
    }
    void update_stock() throws SQLException
    {
        Connection conn =db_Connection.getconnectiom();
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
        for(int i=0;i<bpa.size();i++)
        {
            ResultSet rs=stmt.executeQuery("select * from stock_available where product_id="+product_id_purchased[i]);
           rs.next();
            int avail=rs.getInt(2);
            avail=avail-bpa.get(i).quantity;
            rs.updateInt(2, avail);
            rs.updateRow();
            //rs.close();
        }
    }
    public class item_add_tablemodel extends AbstractTableModel  //inner class
    {
    
       String cn[]={"Item,Packing", "Batch no.", "Manufacturer", "Mfg dt.", "Exp dt.", "Quantity", "Rate","CGST","SGST","Unit Price","Total"};

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
          return bpa.size();
        }

        @Override
        public Object getValueAt(int x, int y)
        {

            
            if(y==0) 
                return bpa.get(x).item;
                else if(y==1)
                    return bpa.get(x).batch_no;
                else if(y==2)
                    return bpa.get(x).manufacturer;
                else if(y==3)
                    return bpa.get(x).manfacture_date;
                else if(y==4)
                    return bpa.get(x).expiry;
                else if(y==5)
                     return bpa.get(x).quantity;
                else if(y==6)
                    return bpa.get(x).rate;
                else if(y==7)
                    return bpa.get(x).cgst;
                else if (y==8)
                    return bpa.get(x).sgst;
                else if (y==9)
                    return bpa.get(x).unit_price;
                else if (y==10)
                    return bpa.get(x).total;
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
            java.util.logging.Logger.getLogger(bill_print.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(bill_print.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(bill_print.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(bill_print.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new bill_print().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable bill_item_jtable;
    private javax.swing.JButton bt_add;
    private javax.swing.JButton bt_customer_search;
    private javax.swing.JButton bt_remove;
    private javax.swing.JButton bt_save;
    private javax.swing.JButton bt_save_print;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tf_batch_no;
    private javax.swing.JTextField tf_custname;
    private com.toedter.calendar.JDateChooser tf_date;
    private javax.swing.JTextField tf_exp_date;
    private javax.swing.JTextField tf_final_total;
    private javax.swing.JComboBox<String> tf_gst;
    private javax.swing.JTextField tf_item;
    private javax.swing.JTextField tf_mfg_date;
    private javax.swing.JTextField tf_quantity;
    private javax.swing.JComboBox<String> tf_txn_type;
    private javax.swing.JTextField tf_unit_price;
    // End of variables declaration//GEN-END:variables
}
