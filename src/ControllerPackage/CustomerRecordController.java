package ControllerPackage;

import DatabaseConnection.DbConnector;
import Table.OrderTableView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.*;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class CustomerRecordController extends DbConnector implements Initializable {

    ObservableList<OrderTableView > oblist = FXCollections.observableArrayList();
    @FXML
    private TableView<OrderTableView > recodTableView;
    @FXML
    private TableColumn<OrderTableView , String> orderId;
    @FXML
    private TableColumn<OrderTableView , String> customerName;
    @FXML
    private TableColumn<OrderTableView , String> purchaseDate;
    @FXML
    private TableColumn<OrderTableView , String> amountPay;
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {

            this.connection = getConnection();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + "");
        }

        populateCartTable();
    }


    public void populateCartTable() {
        String sql = "Select orderId,customerName,Date,amountPay from orders;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    oblist.add(new OrderTableView (resultSet.getString("orderId"),
                            resultSet.getString("customerName"), resultSet.getString("Date"),
                            resultSet.getString("amountPay")));
                }
            }
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e + "");
        }

        orderId.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        customerName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        purchaseDate.setCellValueFactory(new PropertyValueFactory<>("purchaseDate"));
        amountPay.setCellValueFactory(new PropertyValueFactory<>("amountPay"));

        recodTableView.setItems(oblist);
    }
}

