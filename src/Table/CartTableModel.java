package Table;

public class CartTableModel {

    String Name;
    String Price;
    String Quantitty;

    public CartTableModel(String Name, String Quantitty, String Price) {
        this.Name = Name;
        this.Price = Price;
        this.Quantitty = Quantitty;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getQuantitty() {
        return Quantitty;
    }

    public void setQuantitty(String quantitty) {
        Quantitty = quantitty;
    }
}
