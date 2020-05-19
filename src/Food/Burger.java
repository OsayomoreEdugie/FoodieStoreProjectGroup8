package Food;

public class Burger extends Products {

    public Burger(int id, String name, double price, String description, String products_type, String isAvailable){
        super(id, name, price, description, products_type, isAvailable);
    }

    public Burger(int id, String name){
        super(id,name);
    }
}
