package print;

public class print_arraylist {
    String product_name;
    String manufacturer;
    String batch_no;
    String manf_date;
    String expiry_date;
    int quantity;
    float unit_price;
    String sgst;
    String cgst;
    float amount;
    float total;

    public print_arraylist(String product_name, String manufacturer, String batch_no, String manf_date, String expiry_date, int quantity, float unit_price, String sgst, String cgst, float amount, float total) {
        this.product_name = product_name;
        this.manufacturer = manufacturer;
        this.batch_no = batch_no;
        this.manf_date = manf_date;
        this.expiry_date = expiry_date;
        this.quantity = quantity;
        this.unit_price = unit_price;
        this.sgst = sgst;
        this.cgst = cgst;
        this.amount = amount;
        this.total = total;
    }    
}