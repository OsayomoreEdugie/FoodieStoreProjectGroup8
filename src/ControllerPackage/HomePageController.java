package ControllerPackage;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class HomePageController extends Control {

    @FXML
    private BorderPane borderPane;
    @FXML
    private Pane upBar;
    @FXML
    private Button logInButton;
    @FXML
    private Button aboutButton;

    private Double x, y;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        logInButton.setText("Logout");
        aboutButton.setVisible(false);
    }


    @FXML
    private void onLoginButtonPressed(ActionEvent event) {
        if (logInButton.getText().equals("Logout")) {
            try {
                newWindow("SignIn");
                ((Node) (event.getSource())).getScene().getWindow().hide();
            } catch (Exception e) {
                AlertBox(e + "");
            }

        }
    }

// Button to view about page
    @FXML
    private void aboutSystemBtn() {
        borderPane.setRight(null);
        newInterfaceChanges("about");
    }
    @FXML
    private void onMenuButtonPressed() {// Button method to enter menu
        borderPane.setRight(null);
        newInterfaceChanges("MainMenu");

    }

    @FXML
    private void onCartButtonPressed() { // Cart button
        borderPane.setRight(null);
        newInterfaceChanges("Payment");
    }

    @FXML
    private void onCloseButtonPressed() {
        Stage stage = (Stage) borderPane.getScene().getWindow();
        stage.close();

    }

    @FXML
    private void onUpBarDragged(MouseEvent event) {
        Stage stage = (Stage) upBar.getScene().getWindow();
        stage.setX(event.getScreenX() - x);
        stage.setY(event.getScreenY() - y);
    }

    @FXML
    private void onUpBarButtonPressed(MouseEvent event) {
        Stage stage = (Stage) upBar.getScene().getWindow();
        x = event.getScreenX() - stage.getX();
        y = event.getScreenY() - stage.getY();
    }


}

