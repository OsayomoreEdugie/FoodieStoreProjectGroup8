package Table;
public class Order {

    private String orderName;
    private String city;
    private String date;
    private String street;
    private String postCode;

    private int orderQuantity;
    private Double orderPrice;
;


    public Order(String name, int quantity, double price){
                  this.orderName =  name;
                 this.orderPrice =  price;
                 this.orderQuantity = quantity;
    }

    public Order(String date, String street, String city, String postCode, String name, String quantity, String price){
        this.date = date;
        this.street = street;
        this.city = city;
        this.postCode = postCode;
        this.orderName =  name;
        this.orderPrice =  Double.valueOf(price);
        this.orderQuantity = Integer.valueOf(quantity);
    }

         public String getOrderName() {
               return orderName;
        }

         public Double getOrderPrice() {
              return orderPrice;
      }

        public int getOrderQuantity() {
            return orderQuantity;
       }

        public void setOrderQuantity(int orderQuantity) {
              this.orderQuantity = orderQuantity;
      }

    @Override
    public String toString() {
        return "Order{" +
                "orderName=" + orderName + ", orderPrice=" + orderPrice + ", orderQuantity=" + orderQuantity +
                '}';
    }

}
