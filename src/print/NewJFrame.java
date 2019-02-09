package print;
import bill.db_Connection;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

public final class NewJFrame extends javax.swing.JFrame {
    ArrayList <print_arraylist> pal=null;
    itemSearch_table_model itm=null;
    String name,add,date,bill_type;
    float total_amount=0;
    
    public NewJFrame()  {
        //int bill_id
        
        pal=new ArrayList<>();
        itm=new itemSearch_table_model();
        initComponents();
        setSize(8000,7000);
        setBillCredential();
        fillTable();
        PrinterJob job = PrinterJob.getPrinterJob();
            job.setJobName("Print Data");
            
            job.setPrintable(new Printable(){
            public int print(Graphics pg,PageFormat pf, int pageNum){
                    pf.setOrientation(PageFormat.LANDSCAPE);
                 if(pageNum>0){
                    return Printable.NO_SUCH_PAGE;
                }
                
                Graphics2D g2 = (Graphics2D)pg;
                g2.translate(pf.getImageableX(), pf.getImageableY());
                g2.scale(0.54,0.54);
                jPanel1.paint(g2);
                return Printable.PAGE_EXISTS;
            }
    });
         
        boolean ok = job.printDialog();
        if(ok){
        try{
            
        job.print();
        }
        catch (PrinterException ex){}
        }
        this.dispose();
    }
    
    void setBillCredential() 
    {
        try {
            int bill_id=1;//add to function parameter
            Connection conn = db_Connection.getconnectiom();
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from customer_details where customer_id in(select customer_id from invoice where invoice_id="+bill_id+")");
            rs.next();
            {
                name=rs.getString("name");
                add=rs.getString("address");
            }
        } catch (SQLException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
       lb_cust_name.setText(name);
       lb_address.setText(add);

    }
    void fillTable()
    {
        int bill_id=3;
        String ProdPack,Manufacturer,Batch_no,Mfg_dt,Exp_dt,SGST,CGST;
        Float Amount,Price,total;
        int Quantity;
        try {
            Connection conn = db_Connection.getconnectiom();
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from invoice where invoice_id="+bill_id);
            while(rs.next())
            {
                ProdPack=getproct_name(rs.getInt("product_id"));
                Manufacturer=rs.getString("manufacturer");
                Batch_no=rs.getString("batch_no.");
                Mfg_dt=rs.getString("manfac_date");
                Exp_dt=rs.getString("expiry_date");
                Quantity=rs.getInt("total_units");
                SGST=rs.getString("cgst");
                CGST=SGST;
                Amount=rs.getFloat("unit_price");
                Price=getTax(SGST,Amount);
                total=rs.getFloat("total_price");
                total_amount+=total;
                pal.add(new print_arraylist(ProdPack,Manufacturer, Batch_no, Mfg_dt, Exp_dt, Quantity, Price, SGST, CGST, Amount, total));
                date=rs.getString("date");
                bill_type=rs.getString("type");
            }
            itm.fireTableDataChanged();
            lb_date.setText(date);
            lb_invoice.setText(String.valueOf(bill_id));
            lb_payment.setText(bill_type);
            lb_totalAmount.setText(String.valueOf(total_amount));
            
        } catch (SQLException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    String getproct_name(int productId)
    {
        String return_string=null;
        try {
            Connection conn = db_Connection.getconnectiom();
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from product_info where product_id ="+productId);
            rs.next();
            return_string=rs.getString("product_name");
            return_string+=',';
            return_string+=rs.getString("packing");
        } catch (SQLException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
            return return_string;
    }
    float getTax(String tax,float price)
        {
            System.out.println(tax);
            int gs;
            StringTokenizer st=new StringTokenizer(tax,"%");
            System.out.println(st.countTokens());
            gs=9;//=Integer.parseInt(st.nextToken());
            price=price-(price*gs*2)/100;
            return price;
        }
    public class itemSearch_table_model extends AbstractTableModel  //inner class
    {
         
       String cn[]={"Product,Packing", "Mfg/Mkt By","Batch no","Mfg dt",
           "Exp dt","Quantity","Price","SGST","CGST","Amount", "total"};
      
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
          return pal.size();
        }

        @Override
        public Object getValueAt(int x, int y)
        {
           switch (y) {
               case 0:
                   return pal.get(x).product_name;
               case 1:
                   return pal.get(x).manufacturer;
               case 2:
                   return pal.get(x).batch_no;
               case 3:
                   return pal.get(x).manf_date;
               case 4:
                   return pal.get(x).expiry_date;
               case 5:
                   return pal.get(x).quantity;
               case 6:
                   return pal.get(x).unit_price;
               case 7:
                   return pal.get(x).sgst;
               case 8:
                   return pal.get(x).cgst;
               case 9:
                   return pal.get(x).amount;
               case 10:
                   return pal.get(x).total;
               default:
                   return null;
           }
        }       
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lb_mob = new javax.swing.JLabel();
        lb_totalAmount = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        billPrintTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        lb_invoice = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lb_date = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lb_payment = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lb_cust_name = new javax.swing.JLabel();
        lb_address = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        firm_name = new javax.swing.JLabel();
        gst = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(null);

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel7.setText("Total ");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(940, 630, 50, 30);

        lb_mob.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lb_mob.setText("9872082398");
        jPanel1.add(lb_mob);
        lb_mob.setBounds(980, 10, 100, 50);

        lb_totalAmount.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lb_totalAmount.setText("jLabel15");
        jPanel1.add(lb_totalAmount);
        lb_totalAmount.setBounds(1010, 630, 80, 30);

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel1.setText("Mob No. ");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(900, 10, 80, 50);

        jLabel4.setText("Address");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(520, 130, 39, 14);

        billPrintTable.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        billPrintTable.setModel(itm);
        billPrintTable.setGridColor(new java.awt.Color(204, 204, 255));
        jScrollPane1.setViewportView(billPrintTable);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(20, 370, 1070, 250);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.setLayout(null);

        lb_invoice.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lb_invoice.setText("jLabel15");
        jPanel2.add(lb_invoice);
        lb_invoice.setBounds(130, 10, 110, 50);
        lb_invoice.getAccessibleContext().setAccessibleParent(jPanel2);

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel10.setText("Date");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(280, 10, 90, 50);
        jLabel10.getAccessibleContext().setAccessibleParent(jPanel2);

        lb_date.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lb_date.setText("jLabel17");
        jPanel2.add(lb_date);
        lb_date.setBounds(360, 10, 90, 50);
        lb_date.getAccessibleContext().setAccessibleParent(jPanel2);

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel2.setText("Invoice No:");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(10, 10, 110, 50);
        jLabel2.getAccessibleContext().setAccessibleParent(jPanel2);

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel9.setText("Payment  Mode");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(10, 80, 140, 50);
        jLabel9.getAccessibleContext().setAccessibleParent(jPanel2);

        lb_payment.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lb_payment.setText("jLabel16");
        jPanel2.add(lb_payment);
        lb_payment.setBounds(160, 80, 100, 50);
        lb_payment.getAccessibleContext().setAccessibleParent(jPanel2);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(550, 220, 540, 150);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel3.setLayout(null);

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel5.setText("Name:");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(10, 20, 100, 30);

        lb_cust_name.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lb_cust_name.setText("jLabel15");
        jPanel3.add(lb_cust_name);
        lb_cust_name.setBounds(150, 20, 320, 30);

        lb_address.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lb_address.setText(";aljd");
        jPanel3.add(lb_address);
        lb_address.setBounds(110, 60, 410, 80);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(20, 220, 540, 150);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel4.setLayout(null);

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel3.setText("TAX INVOICE");
        jPanel4.add(jLabel3);
        jLabel3.setBounds(480, 20, 110, 24);

        firm_name.setFont(new java.awt.Font("SansSerif", 3, 30)); // NOI18N
        firm_name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        firm_name.setText("Sandhu Agro Chemicals");
        jPanel4.add(firm_name);
        firm_name.setBounds(350, 50, 370, 50);

        gst.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        gst.setText("GSTIN:5646");
        jPanel4.add(gst);
        gst.setBounds(10, 0, 130, 30);

        jLabel15.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel15.setText("Prop.");
        jPanel4.add(jLabel15);
        jLabel15.setBounds(1020, 820, 130, 110);

        jLabel6.setText("jLabel6");
        jPanel4.add(jLabel6);
        jLabel6.setBounds(90, 670, 34, 14);

        jLabel8.setText("jLabel8");
        jPanel4.add(jLabel8);
        jLabel8.setBounds(90, 690, 34, 14);

        jLabel11.setText("jLabel11");
        jPanel4.add(jLabel11);
        jLabel11.setBounds(90, 710, 40, 14);

        jLabel12.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel12.setText("Subject To JAlalabad Jurisdiction only");
        jPanel4.add(jLabel12);
        jLabel12.setBounds(10, 730, 240, 30);

        jLabel13.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel13.setText("For Sandhu Agro Chemicals");
        jPanel4.add(jLabel13);
        jLabel13.setBounds(880, 720, 180, 40);

        jLabel14.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel14.setText("Customer sign.");
        jPanel4.add(jLabel14);
        jLabel14.setBounds(470, 730, 110, 30);

        jPanel1.add(jPanel4);
        jPanel4.setBounds(20, 20, 1070, 770);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(jPanel5);
        jPanel5.setBounds(350, 60, 390, 50);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(90, 90, 1140, 810);

        pack();
    }// </editor-fold>//GEN-END:initComponents
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
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable billPrintTable;
    private javax.swing.JLabel firm_name;
    private javax.swing.JLabel gst;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_address;
    private javax.swing.JLabel lb_cust_name;
    private javax.swing.JLabel lb_date;
    private javax.swing.JLabel lb_invoice;
    private javax.swing.JLabel lb_mob;
    private javax.swing.JLabel lb_payment;
    private javax.swing.JLabel lb_totalAmount;
    // End of variables declaration//GEN-END:variables
}
