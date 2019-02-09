
package customer;

/**
 *
 * @author Jagmeet sandhu
 */
public class bill_print_arraylist {
    String item;
    String batch_no;
    String manufacturer;
    String manfacture_date;
    String expiry;
    int quantity;
    float rate;
    String cgst;
    String sgst;
    float unit_price;
    float total;

    public bill_print_arraylist(String item, String batch_no, String manufacturer, String manfacture_date, String expiry, int quantity, float rate, String cgst, String sgst, float unit_price, float total) {
        this.item = item;
        this.batch_no = batch_no;
        this.manufacturer = manufacturer;
        this.manfacture_date = manfacture_date;
        this.expiry = expiry;
        this.quantity = quantity;
        this.rate = rate;
        this.cgst = cgst;
        this.sgst = sgst;
        this.unit_price = unit_price;
        this.total = total;
    }

    
    

    
    
}
