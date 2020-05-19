package Users;

public class Customer extends User {

    private final Role role = Role.customer;

    public Customer(int id, String firstName, String lastName, String birthday, String userName, String password, String email,
                    String mobile, String userRole, int paymentCard_id, int addresses_id, String cardHolderName,
                    String cvcNumber, String cardNumber, int expirationMonth,
                    int expirationYear, String street, String city, int zipCode) {
        super(id,firstName, lastName, birthday, userName, password, email, mobile, userRole, paymentCard_id,
                addresses_id, cardHolderName, cvcNumber, cardNumber,
                expirationMonth, expirationYear, street, city, zipCode);


    }

    public Role getRole() {
        return role;
    }
}
