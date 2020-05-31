package Table;

public class OderTableView {
    String customerName;
    String purchaseDate;
    String amountPay;
    String orderId;

    public OderTableView(String orderId, String customerName, String purchaseDate, String amountPay) {
        this.customerName = customerName;
        this.purchaseDate = purchaseDate;
        this.amountPay = amountPay;
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getAmountPay() {
        return amountPay;
    }

    public void setAmountPay(String amountPay) {
        this.amountPay = amountPay;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
