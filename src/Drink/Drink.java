package Drink;

public abstract class Drink {

    private int id;
    private String name;
    private String type;
    private double price;
    private String description;
    private String isAvailable;

    protected Drink(int id, String name, String type, double price, String description, String isAvailable) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.description = description;
        this.isAvailable = isAvailable;
    }

    public Drink(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }


    public String getIsAvailable() {
        return isAvailable;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
