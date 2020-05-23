package ControllerPackage;


import DatabaseConnection.DBUserQueries;
import execptions.ProfileErrorHandling;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;

import java.net.URL;
import java.time.ZoneId;
import java.util.ResourceBundle;


public class SignUpController extends Control {
    private ProfileErrorHandling profileExceptionHandling;

    @FXML
    private TextField firstName, lastName, userName, email, mobile, street, zipCode;
    @FXML
    private PasswordField password;
    @FXML
    private DatePicker birthday;
    @FXML
    private Button create;

    @FXML
    private ComboBox city;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        profileExceptionHandling = new ProfileErrorHandling();
        city.getItems().addAll("Kristianstad", "Malmö");

    }


    @FXML
    public void createButton(ActionEvent event) {

        try {
            DBUserQueries dbUserQueries = new DBUserQueries();
            boolean promptSave = true;

            if (promptSave) {
                if (!emailValidation(email.getText())) {
                    promptSave = false;

                } else if (profileExceptionHandling.passwordLength(password.getText())) {
                    promptSave = false;

                } else if (profileExceptionHandling.mobileNumberIsNotNumbers(mobile.getText())) {
                    promptSave = false;

                } else if (profileExceptionHandling.comboBoxes(city)) {
                    promptSave = false;

                } else promptSave = !profileExceptionHandling.datePChecker(birthday);
            }

            if (promptSave) { // save user's info if they are correct


                java.util.Date date = java.util.Date.from(birthday.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());


                dbUserQueries.addingValuesIntoUsers(firstName.getText(), lastName.getText(), sqlDate,
                        userName.getText(), //adding user info
                        password.getText(), email.getText(), mobile.getText(), "customer",
                        street.getText(), city.getValue().toString(),
                        Integer.parseInt(zipCode.getText()));

                newWindow("SignIn");
                ((Node) (event.getSource())).getScene().getWindow().hide();
            } else {
                AlertBox("Please Validate all Fields to continue");
            }


        } catch (NullPointerException e) {
            AlertBox(e + "");
        }
    }

    public void backBtn(ActionEvent event) {
        newWindow("SignIn");
        ((Node) (event.getSource())).getScene().getWindow().hide();

    }

}





