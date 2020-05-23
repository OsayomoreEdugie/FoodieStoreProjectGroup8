package ControllerPackage;


import DatabaseConnection.DBUserQueries;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ForgetPasswordController extends Control {

    @FXML
    private TextField email;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    @FXML
    public void promptPasswordButton(ActionEvent event) {

        if (!email.getText().isEmpty()) {
            DBUserQueries userQueries = new DBUserQueries();
            if (!email.getText().isEmpty()) {
                if (userQueries.emailExists(email.getText())) {
                    try {
                        userQueries.getForgotPassword(email.getText());
                        newWindow("SignIn");
                        ((Node) (event.getSource())).getScene().getWindow().hide();
                    } catch (Exception e) {
                        AlertBox(e + "");
                    }
                } else {
                    AlertBox("this email does not exist");
                }
            } else {
                AlertBox("please validate field to continue");
            }
        } else
            AlertBox("please validate field to continue");

    }

    public void backBtn(ActionEvent event) {
        newWindow("SignIn");
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

}
