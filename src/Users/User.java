package Users;

public class User {

    private int id;
    private String firstName;
    private String lastName;
    private String birthday;
    private String userName;
    private String password;
    private String email;
    private String mobile;
    private String userRole;
    private int paymentCard_id;
    private int addresses_id;

    private String cardHolderName;
    private String cvcNumber;
    private String cardNumber;
    private int expirationMonth;
    private int expirationYear;

    private String street;
    private String city;
    private int zipCode;

    public enum Role{
        admin, customer, guest
    }


    public User(int id, String firstName, String lastName, String birthday, String userName, String password,
                String email, String mobile, String userRole, int paymentCard_id, int addresses_id,
                String cardHolderName, String cvcNumber, String cardNumber, int expirationMonth, int expirationYear,
                String street, String city, int zipCode) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.mobile = mobile;
        this.userRole = userRole;
        this.paymentCard_id = paymentCard_id;
        this.addresses_id = addresses_id;
        this.cardHolderName = cardHolderName;
        this.cvcNumber = cvcNumber;
        this.cardNumber = cardNumber;
        this.expirationMonth = expirationMonth;
        this.expirationYear = expirationYear;
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
    }

    public int getId() {
        return id;
    }

    public int getPaymentCard_id() {
        return paymentCard_id;
    }

    public int getAddresses_id() {
        return addresses_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public String getUserRole() {
        return userRole;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public int getZipCode() {
        return zipCode;
    }
}
