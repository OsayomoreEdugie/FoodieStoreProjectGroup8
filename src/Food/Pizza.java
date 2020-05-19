package Food;

public class Pizza extends Products {

    public Pizza(int id, String name, double price, String description, String products_type, String isAvailable){
        super(id, name, price, description, products_type, isAvailable);
    }

    public Pizza(int id, String name){
        super(id,name);
    }
}
