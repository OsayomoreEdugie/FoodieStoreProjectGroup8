package ControllerPackage;

import DatabaseConnection.DbConnector;
import DatabaseConnection.DbQueries;
import Table.CartTableModel;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.*;
import java.io.FileOutputStream;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class PaymentController extends DbConnector implements Initializable {

    public Label subtotalLabel;
    public Label subtotalLabel1;
    public AnchorPane cartPane;
    DbQueries dbQueries = new DbQueries();
    Control control;
    ObservableList<CartTableModel> oblist = FXCollections.observableArrayList();
    String logInuser;
    String getOrderId;
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
            JOptionPane.showMessageDialog(null, e + "");
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
            JOptionPane.showMessageDialog(null, e);
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
            JOptionPane.showMessageDialog(null, e + "");
        }
    }

    public void checkOutButton(ActionEvent event) {

        logInuser = Control.getLogInUser();
        String payAmount = subtotalLabel.getText();
        dbQueries.addOrderRecord(logInuser, payAmount);
        getOrderId = dbQueries.getOrderId();
        for (CartTableModel person : cartTableView.getItems()) {
            String productName = person.getName();
            dbQueries.updateStockQuantity(productName);
        }
        generateReciept();
        AlertBox("Order Place Successfully!");
        dbQueries.deleteCart();
        backToMainWindow();
        ((Node) (event.getSource())).getScene().getWindow().hide();


    }


    public void generateReciept() {
        Rectangle pagesize = new Rectangle(400, 861);
        Document doc = new Document(PageSize.HALFLETTER, 0f, 0f, 10f, 0f);
        BaseFont arialUnicodeMs;
        try {
            Font font1 = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
            Font font2 = new Font(Font.FontFamily.COURIER, 12, Font.NORMAL);
            Font font3 = new Font(Font.FontFamily.COURIER, 12, Font.BOLD);
            PdfWriter.getInstance(doc, new FileOutputStream("src/RecieptRecord/reciept_" + getOrderId + ".pdf"));
            doc.open();
            Paragraph p1 = new Paragraph("************************************", font1);
            Paragraph p2 = new Paragraph("FoodieHeroes Store\nBill Reciept\n", font1);
            Paragraph p3 = new Paragraph("************************************\n", font1);
            Paragraph p4 = new Paragraph("   CustomerId : " + logInuser + "\n    OrderId    : " + getOrderId + "\n\n", font3);
            PdfPTable table = new PdfPTable(3);
            PdfPCell c1Title = new PdfPCell(new Paragraph("Product Name", font1));
            PdfPCell c2Title = new PdfPCell(new Paragraph("Quantity", font1));
            PdfPCell c3Title = new PdfPCell(new Paragraph("Price", font1));
            c1Title.setHorizontalAlignment(Element.ALIGN_LEFT);
            c2Title.setHorizontalAlignment(Element.ALIGN_RIGHT);
            c3Title.setHorizontalAlignment(Element.ALIGN_RIGHT);
            c1Title.setBorder(Rectangle.NO_BORDER);
            c2Title.setBorder(Rectangle.NO_BORDER);
            c3Title.setBorder(Rectangle.NO_BORDER);

            p1.setAlignment(Element.ALIGN_CENTER);
            p2.setAlignment(Element.ALIGN_CENTER);
            p3.setAlignment(Element.ALIGN_CENTER);

            table.addCell(c1Title);
            table.addCell(c2Title);
            table.addCell(c3Title);


            doc.add(p1);
            doc.add(p2);
            doc.add(p3);
            doc.add(p4);


            String sql = "Select name ,quantity, Price from meals;";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        PdfPCell c1 = new PdfPCell(new Paragraph(resultSet.getString("name"), font2));
                        PdfPCell c2 = new PdfPCell(new Paragraph(resultSet.getString("quantity"), font2));
                        PdfPCell c3 = new PdfPCell(new Paragraph(resultSet.getString("Price"), font2));
                        c2.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        c3.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        c1.setBorder(Rectangle.NO_BORDER);
                        c2.setBorder(Rectangle.NO_BORDER);
                        c3.setBorder(Rectangle.NO_BORDER);
                        table.addCell(c1);
                        table.addCell(c2);
                        table.addCell(c3);

                    }
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }

            doc.add(table);
            Paragraph p5 = new Paragraph(" \n\n- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -  ", font1);
            p5.setAlignment(Element.ALIGN_CENTER);
            Paragraph totalBill = new Paragraph("\nTotal Bill : " + subtotalLabel.getText() + "        ", font1);
            totalBill.setAlignment(Element.ALIGN_RIGHT);

            doc.addCreator("zain_335");
            doc.addHeader("FoodieStore", "FooodieHeroes");

            doc.add(p5);
            doc.add(totalBill);
            doc.close();
            AlertBox("reciept_" + getOrderId + "  is Successfully Generated to RecieptRecord Directoy");
        } catch (Exception e) {
            AlertBox(e + "");
        }

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