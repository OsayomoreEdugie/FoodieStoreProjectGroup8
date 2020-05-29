package ControllerPackage;

import javafx.fxml.FXML;

import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuController extends Control {


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void handleDrinksViewButton() {
        newInterfaceChanges("Drinks");
    }

    @FXML
    private void handleFoodsViewButton() {
        newInterfaceChanges("BurgerAndPizzaMenu");
    }



}

