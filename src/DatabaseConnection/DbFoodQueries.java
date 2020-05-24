package DatabaseConnection;

import javax.swing.*;
import java.sql.*;

public class DbFoodQueries extends DbConnector {

    private Connection connection;

    private Statement statement;
    private ResultSet resultSet;


    public DbFoodQueries() {
        try {
            connection = getConnection();
            statement = connection.createStatement();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public int availableStock(String porductName) {
        int available = -1;
        String sql = "SELECT AMMOUNT FROM products where name='" + porductName + "'";

        try {
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                available = Integer.parseInt(resultSet.getString("AMMOUNT"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex + "");
        }

        return available;
    }


    public void insertValuesIntoMealsTable(String name, double price, int Quantity) {
        String mealsQuery = "INSERT INTO meals(name, price,Quantity) VALUES(?,?,?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(mealsQuery)) {
            preparedStatement.setString(1, name);
            preparedStatement.setDouble(2, price * Quantity);
            preparedStatement.setInt(3, Quantity);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

}
