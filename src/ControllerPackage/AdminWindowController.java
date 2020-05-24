package ControllerPackage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminWindowController extends Control implements Initializable {

    @FXML
    private BorderPane borderPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        borderPane.setRight(null);
        newInterfaceChanges("adminMenu");

    }
    public void homeWindow(ActionEvent event){
        borderPane.setRight(null);
        newInterfaceChanges("adminMenu");
    }


    public void onClosePressed(MouseEvent mouseEvent) {
        Stage stage = (Stage) borderPane.getScene().getWindow();
        stage.close();
    }

    public void logoutBtn(ActionEvent event) {
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

    public void customerRecord(ActionEvent event) {

        borderPane.setRight(null);
        newInterfaceChanges("customerRecord");

    }


}
