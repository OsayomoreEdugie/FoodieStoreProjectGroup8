package DatabaseConnection;


import javafx.scene.control.Alert;

import java.sql.*;

public class DBUserQueries extends DbConnector {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;


    public DBUserQueries() {
        try {

            this.connection = getConnection();
//

        } catch (Exception e) {
            AlertBox(e + "");
        }
    }

    void AlertBox(String error) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("error");
        a.setContentText(error);
        a.showAndWait();
        a.setHeaderText(null);
    }

    public void getForgotPassword(String email) {
        String sql = "select password from users where email='" + email + "';";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    AlertBox("Password : " + resultSet.getString("password"));
                }
            }
        } catch (SQLException e) {
            AlertBox(e + "");
        }

    }

    private boolean existence(String attribute, String query) {

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, attribute);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {

                    return true;
                } else {

                    return false;
                }
            }
        } catch (SQLException e) {
            AlertBox(e + "");
            return false;
        }
    }

    public boolean isProductExist(String name) {

        String Query = "SELECT * FROM products WHERE NAME = ? ;";


        if (existence(name, Query) == true) {
            return true;
        } else {
            return false;
        }

    }


    public boolean emailExists(String email) {

        String emailQuery = "SELECT * FROM users WHERE email = ? ;";


        if (existence(email, emailQuery) == true) {
            return true;
        } else {
            return false;
        }

    }

    public boolean userNameExists(String userName) {
        String userNameQuery = "SELECT * FROM users WHERE userName = ?";
        if (existence(userName, userNameQuery) == true) {

            return true;
        } else {
            return false;
        }

    }

    public void updateProducts(String name, String Price, String amount) {
        String updatesql = "UPDATE  products SET AMMOUNT= ?, Price= ? WHERE NAME = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(updatesql)) {
            System.out.println("testing steinf update 999");
            preparedStatement.setString(1, amount);
            preparedStatement.setString(2, Price);
            preparedStatement.setString(3, name);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            AlertBox(e + "");
        }
    }


    public boolean passwordExists(String passwod, String email) {
        String passwordQuery = "SELECT * FROM users WHERE password = ? AND email = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(passwordQuery)) {
            preparedStatement.setString(1, passwod);
            preparedStatement.setString(2, email);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (SQLException e) {
            AlertBox(e + "");
            return false;
        }
    }

    public void addingValuesIntoUsers(String firstName, String lastName, Date birthday, String userName, String password,
                                      String email, String phoneNumber, String type, String street, String city, int zipCode) {
        String userQuery = "INSERT INTO users(firstName, lastName, birthday, userName, password, email, phoneNumber, " +
                "type, street, city, zipcode) VALUES(?,?,?,?,?,?,?,?,?,?,?)";

        try {
            userTablePreparedStatement(firstName, lastName, birthday, userName, password, email, phoneNumber, type,
                    street, city, zipCode, userQuery);
        } catch (Exception e) {
            AlertBox(e + "");

        }

    }


    private void userTablePreparedStatement(String firstName, String lastName, Date birthday,
                                            String userName, String password, String email,
                                            String phoneNumber, String type, String street, String city, int zipCode,
                                            String query) {

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setDate(3, birthday);
            preparedStatement.setString(4, userName);
            preparedStatement.setString(5, password);
            preparedStatement.setString(6, email);
            preparedStatement.setString(7, phoneNumber);
            preparedStatement.setString(8, type);
            preparedStatement.setString(9, street);
            preparedStatement.setString(10, city);
            preparedStatement.setInt(11, zipCode);

            preparedStatement.executeUpdate();
            AlertBox("Successfully Created Account Please Login");


        } catch (SQLException e) {
            AlertBox(e + "");


        }
    }


}