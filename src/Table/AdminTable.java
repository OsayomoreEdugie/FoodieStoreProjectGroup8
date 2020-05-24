package Table;

public class AdminTable {
    String name, price, type, ammouont;

    public AdminTable(String name, String price, String type, String ammouont) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.ammouont = ammouont;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAmmouont() {
        return ammouont;
    }

    public void setAmmouont(String ammouont) {
        this.ammouont = ammouont;
    }
}
