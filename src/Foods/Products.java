package Foods;

abstract class Products {

    private int id;
    private String name;
    private double price;
    private String description;
    private String products_type;
    private String isAvailable;


    protected Products(int id, String name, double price, String description, String products_type,
                       String isAvailable) {

        this.id = id;
        this.name = name;

        this.price = price;
        this.description = description;
        this.products_type = products_type;

        this.isAvailable = isAvailable;

    }

    public Products(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }


    public String getProducts_type() {
        return products_type;
    }

    public String getIsAvailable() {
        return isAvailable;
    }

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +

                ", products_type='" + products_type + '\'' +
                '}';
    }
}
