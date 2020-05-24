package ControllerPackage;

import DatabaseConnection.DbConnector;
import DatabaseConnection.DbQueries;
import Table.CartTableModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.print.PageLayout;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.*;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class PaymentController extends DbConnector implements Initializable {

    public Label subtotalLabel;
    public Label subtotalLabel1;
    DbQueries dbQueries = new DbQueries();
    Control control;
    ObservableList<CartTableModel> oblist = FXCollections.observableArrayList();
    @FXML
    private Button confirmationButton;
    @FXML
    private TableView<CartTableModel> cartTableView;
    @FXML
    private TableColumn<CartTableModel, String> Name;
    @FXML
    private TableColumn<CartTableModel, String> Quantitty;
    @FXML
    private TableColumn<CartTableModel, String> Price;
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {

            this.connection = getConnection();
//
//            this.statement = connection.createStatement();
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null,e+"");
        }

        populateCartTable();
        getTotalPrice();

    }

    void AlertBox(String error) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Information");
        a.setContentText(error);
        a.showAndWait();
        a.setHeaderText(null);
    }


    public void populateCartTable() {
        String sql = "Select name ,quantity, Price from meals;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    oblist.add(new CartTableModel(resultSet.getString("name"), resultSet.getString("quantity"), resultSet.getString("Price")));
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e);
        }
        Name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        Quantitty.setCellValueFactory(new PropertyValueFactory<>("Quantitty"));
        Price.setCellValueFactory(new PropertyValueFactory<>("Price"));

        cartTableView.setItems(oblist);
    }

    public void getTotalPrice() {
        String totalsql = "Select sum(Price) from meals;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(totalsql)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    subtotalLabel.setText(resultSet.getString(1));
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e+"");
        }
    }

    public void checkOutButton(ActionEvent event) {

        String logInuser = Control.getLogInUser();
        String payAmount = subtotalLabel.getText();
        dbQueries.addOrderRecord(logInuser, payAmount);
        for (CartTableModel person : cartTableView.getItems()) {
            String productName = person.getName();
            dbQueries.updateStockQuantity(productName);
        }
        ReceiptPrinter(cartTableView);
        AlertBox("Order Place Successfully!");
        dbQueries.deleteCart();
        backToMainWindow();
        ((Node) (event.getSource())).getScene().getWindow().hide();


    }


    public void ReceiptPrinter(Node node) {

        Printer printer = Printer.getDefaultPrinter();

        PageLayout page = printer.getDefaultPageLayout();

        double X = page.getPrintableWidth() / (node.getBoundsInParent().getWidth());
        double Y = page.getPrintableHeight() / (node.getBoundsInParent().getHeight());

        Scale SCL = new Scale(X, Y);
        node.getTransforms().add(SCL);

        PrinterJob PJ = PrinterJob.createPrinterJob(printer);

        if (PJ != null) {
            boolean Success = PJ.printPage(page, node);
            if (Success) {
                PJ.endJob();
            }
        }
        node.getTransforms().remove(SCL);
    }

    public void deleteFromShopCartList(ActionEvent event) {
        dbQueries.deleteCart();
        AlertBox("Order Cancle Succesfully");
        backToMainWindow();
        ((Node) (event.getSource())).getScene().getWindow().hide();

    }

    public void backToMainWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FxmlFiles/Homepages.fxml"));
            Parent root = (Parent) loader.load();
            Stage primaryStage = new Stage();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("FoodieStore");
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.getIcons().add(new Image("Images/FoodieLogo.png"));
            primaryStage.show();

        } catch (Exception e) {
            AlertBox(e + "");
        }
    }
}