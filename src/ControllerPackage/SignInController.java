package ControllerPackage;


import DatabaseConnection.DBUserQueries;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;


public class SignInController extends Control {

    @FXML
    private TextField email;
    @FXML
    private PasswordField password;
    @FXML
    private ComboBox<String> modeCB;


    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }

    @FXML
    private void signInButton(ActionEvent event) {
        String mode = modeCB.getValue();
        if (!email.getText().isEmpty() && !password.getText().isEmpty()) {
            if (mode.equals("Admin") && email.getText().equals("admin@gmail.com") && password.getText().equals("admin")) {
                newWindow("AdminWindow");
                ((Node) (event.getSource())).getScene().getWindow().hide();

            } else {
                try {
                    DBUserQueries userQueries = new DBUserQueries();
                    if (userQueries.emailExists(email.getText()) && userQueries.passwordExists(password.getText(), email.getText())) {
                        AlertBox("Successfully Login");
                        newWindow("Homepages");
                        ((Node) (event.getSource())).getScene().getWindow().hide();
                        setLogInUser(email.getText());
                    } else {
                        AlertBox("incorrect userName of password");
                    }
                } catch (Exception e) {
                    AlertBox(e + "");
                }
            }

        } else
            AlertBox("Please Validate All Fields to continue");
    }

    @FXML
    private void forgotPasswordButton(ActionEvent event) {

        try {
            newWindow("ForgetPassword");
            ((Node) (event.getSource())).getScene().getWindow().hide();
        } catch (Exception e) {
            AlertBox(e + "");
        }
    }

    @FXML
    private void signUpButton(ActionEvent event) {
        try {
            newWindow("signUp");
            ((Node) (event.getSource())).getScene().getWindow().hide();
        } catch (Exception e) {
            AlertBox(e + "");
        }

    }

}