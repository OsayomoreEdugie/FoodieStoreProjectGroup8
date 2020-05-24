package ControllerPackage;

import DatabaseConnection.DBUserQueries;
import DatabaseConnection.DbConnector;
import Table.AdminTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class AdminController extends DbConnector implements Initializable {


    DBUserQueries dbUserQueries = new DBUserQueries();
    ObservableList<String> PizzaList = FXCollections.observableArrayList("American Pizza", "Veg Pizza", "Chicken Pizza", "Pepperroni Pizza");
    ObservableList<String> BurgerList = FXCollections.observableArrayList("Veg Burger", "Chicken Burger", "Power Burger", "Sandwich Burger");
    ObservableList<String> SoftDrinkList = FXCollections.observableArrayList("Cola Zero", "Fanta", "7up", "Sprite", "Crush Lime", "Coke", "Pepsi", "Loka");
    ObservableList<String> data = FXCollections.observableArrayList("Pizza", "Burger", "Soft Drink");
    ObservableList<String> filterData = FXCollections.observableArrayList("ALL", "Pizza", "Burger", "Soft Drink");
    ObservableList<AdminTable> oblist = FXCollections.observableArrayList();
    @FXML
    private StackPane stackPane;
    @FXML
    private Button updateButton;
    @FXML
    private TableView<AdminTable> adminTable;
    @FXML
    private TableColumn<AdminTable, String> nameColumn;
    @FXML
    private TableColumn<AdminTable, String> priceColumn;
    @FXML
    private TableColumn<AdminTable, String> typeColumn;
    @FXML
    private TableColumn<AdminTable, String> isAvaliableColumn;
    @FXML
    private TextField amountTextField;
    @FXML
    private TextField priceTextField;
    @FXML
    private TextField descriptionTextField;
    @FXML
    private ComboBox<String> typrComoboBox = new ComboBox<>(data);
    @FXML
    private ComboBox<String> NameComboBox = new ComboBox<>();

    @FXML
    private ComboBox<String> filterComoboBox1 = new ComboBox<>(filterData);
    @FXML
    private Button addButton;

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {

            this.connection = getConnection();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e+"");
        }

        typrComoboBox.setItems(data);
        filterComoboBox1.setItems(filterData);
        String sql = "select * from products";
        PopulateTable(sql);

    }


    public void PopulateTable(String sql) {
        try {
            ResultSet rs = connection.createStatement().executeQuery(sql);
            while (rs.next()) {
                oblist.add(new AdminTable(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
        } catch (SQLException throwables) {
            JOptionPane.showMessageDialog(null, throwables + "");
        }
        nameColumn.setCellValueFactory(new PropertyValueFactory<AdminTable, String>("name"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<AdminTable, String>("price"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<AdminTable, String>("type"));
        isAvaliableColumn.setCellValueFactory(new PropertyValueFactory<AdminTable, String>("ammouont"));
        adminTable.setItems(null);
        adminTable.setItems(oblist);

    }

    public void UpdateItemRecord() {
        String name = NameComboBox.getValue();
        String ammount = amountTextField.getText();
        String price = priceTextField.getText();
        dbUserQueries.updateProducts(name, price, ammount);
    }


    public void handleUpdateButton(ActionEvent actionEvent) {
        adminTable.getItems().clear();
        if (filterComoboBox1.getValue() == "Pizza") {
            String sql = "select * from products where TYPE='Pizza'";
            PopulateTable(sql);

        } else if (filterComoboBox1.getValue() == "Burger") {
            String sql = "select * from products where TYPE='Burger'";
            PopulateTable(sql);
        } else if (filterComoboBox1.getValue() == "Soft Drink") {
            String sql = "select * from products where TYPE='Soft Drink'";
            PopulateTable(sql);

        } else {
            String sql = "select * from products";
            PopulateTable(sql);
        }

    }


    public void handleAddButton(ActionEvent actionEvent) {
        String name = NameComboBox.getValue();
        if (dbUserQueries.isProductExist(name)) {
            UpdateItemRecord();
        } else {
            String ammount = amountTextField.getText();
            String type = typrComoboBox.getValue();
            String price = priceTextField.getText();
            InsertFirstData(name, price, type, ammount);
        }
    }


    void InsertFirstData(String name, String price, String type, String ammount) {
        String sql = "insert into products (NAME,PRICE,TYPE,AMMOUNT) VALUES('" + name + "','" + price + "','" + type + "','" + ammount + "')";
        Statement statement;
        {
            try {
                statement = connection.createStatement();
                statement.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "ADDED  SUCCESSFULLY");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }

    }

    public void ActionOFtype(ActionEvent actionEvent) {

        if (typrComoboBox.getValue() == "Pizza") {
            NameComboBox.setItems(PizzaList);
        } else if (typrComoboBox.getValue() == "Burger") {
            NameComboBox.setItems(BurgerList);
        } else if (typrComoboBox.getValue() == "Soft Drink") {
            NameComboBox.setItems(SoftDrinkList);
        } else {
            NameComboBox.setItems(BurgerList);
        }
    }

    public void CustomerRecordBtn(ActionEvent actionEvent) {
    }

    public void logOutAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FxmlFiles/SignIn.fxml"));
            Parent root = loader.load();
            Stage primaryStage = new Stage();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.setTitle("FoodieStore");
            primaryStage.getIcons().add(new Image("Images/FoodieLogo.png"));
            primaryStage.show();
            ((Node) (event.getSource())).getScene().getWindow().hide();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + "");
        }
    }

}
