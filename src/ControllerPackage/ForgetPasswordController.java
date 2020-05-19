package ControllerPackage;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.net.URL;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ForgetPasswordController extends Control {

    @FXML private TextField email;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    @FXML
    private void sendButton() {


    }
    private String passwordGenerator(){ //For Password Authentication
        final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String LOWER = "abcdefghijklmnopqrstuvwxyz";

        final String DIGITS = "0123456789";
        final String PUNCTUATION = "!@#$%&*()_+-=[]|,./?><";


        StringBuilder password = new StringBuilder(8);

        SecureRandom random = new SecureRandom();

        List<String> passwordCategories = new ArrayList<>(4);

        passwordCategories.add(LOWER);
        passwordCategories.add(DIGITS);
        passwordCategories.add(UPPER);
        passwordCategories.add(PUNCTUATION);

        for (int i =0; i<9; i++){
            String charCategory = passwordCategories.get(random.nextInt(passwordCategories.size()));
            int position = random.nextInt(charCategory.length());
            password.append(charCategory.charAt(position));
        }

        return new String(password);
    }

}
