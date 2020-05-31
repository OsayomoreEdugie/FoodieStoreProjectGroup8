package DatabaseConnection;


import javafx.scene.control.Alert;

import javax.swing.*;
import java.sql.*;


public class DbQueries extends DbConnector {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public DbQueries() {
        try {
            connection = getConnection();
            statement = connection.createStatement();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    void AlertBox(String error) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("error");
        a.setContentText(error);
        a.showAndWait();
        a.setHeaderText(null);
    }

    public void addOrderRecord(String name, String Price) {
        String ordersHasDrinksQuery = "INSERT INTO orders(customerName,amountPay) VALUES(?,?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(ordersHasDrinksQuery)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, Price);
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            AlertBox(ex + "");
        }

    }

    public String getOrderId() {
        String totalsql = "Select max(OrderId) from orders;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(totalsql)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    return resultSet.getString(1);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e + "");
            return null;
        }
        return null;
    }

    public void deleteCart() {
        String sql = "delete from meals";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            AlertBox(e + "");
        }
    }

    public void updateStockQuantity(String Name) {
        String updateStock = "UPDATE products P, meals m\n" +
                "SET P.AMMOUNT= p.AMMOUNT - m.Quantity\n" +
                "WHERE P.name = m.name AND m.name=? ;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateStock)) {
            preparedStatement.setString(1, Name);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            AlertBox(e + "");
        }
    }


}

