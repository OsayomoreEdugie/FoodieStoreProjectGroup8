package ControllerPackage;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import Users.Person;
import Utilities.StoreTempData;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomePageController extends Control {

    @FXML private BorderPane borderPane;
    @FXML private Pane upBar;
    @FXML private Button logInButton;
    @FXML private Button cartButton;
    @FXML private Button statisticsButton;
    @FXML private Button updateButton;
    @FXML private Button signOutButton;//Buttons in main menu

    private Double x,y; // for the up bar


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        logInButton.setText("Login");
        if (StoreTempData.getInstance().getRole() == Person.Role.customer ||
                StoreTempData.getInstance().getRole() == Person.Role.admin)
            logInButton.setText(StoreTempData.getInstance().getUserData().get(0).getUserName());

        menuButtonsHandler();
        cartButton.disableProperty().bind(Bindings.size(StoreTempData.getInstance().getShoppingCartData()).isEqualTo(0));
    }



    @FXML
    private void onLoginPressed() {
        if (logInButton.getText().equals("Login")) {
            newInterfaceChanges("SignIn");
        }
    }


    @FXML
    private void aboutButton() {
        borderPane.setRight(null);
        newInterfaceChanges("about");
    }

    @FXML
    private void onMenuPressed() {
        borderPane.setRight(null);
        newInterfaceChanges("MainMenu");

    }

    @FXML
    private void onUpdatePressed() {
        borderPane.setRight(null);
        newInterfaceChanges("adminMenu");
    }

    @FXML
    private void onCartPressed() {
        borderPane.setRight(null);
        newInterfaceChanges("Cart");

    }
    @FXML
    private void onStatisticsPressed() {
        borderPane.setRight(null);
        newInterfaceChanges("statistics");
    }
    @FXML
    private void onLogOutPressed(ActionEvent event){
        StoreTempData.getInstance().getShoppingCartData().clear();
        StoreTempData.getInstance().getUserData().clear();
        createNewStage(event);
    }

    @FXML
    private void onClosePressed() {
        Stage stage = (Stage) borderPane.getScene().getWindow();
        stage.close();

    }

    @FXML
    private void onUpBarDragged(MouseEvent event) {
        Stage stage = (Stage)upBar.getScene().getWindow();
        stage.setX(event.getScreenX() - x);
        stage.setY(event.getScreenY() - y);
    }

    @FXML
    private void onUpBarPressed(MouseEvent event) {
        Stage stage = (Stage)upBar.getScene().getWindow();

        x=event.getScreenX() - stage.getX();
        y=event.getScreenY() - stage.getY();
    }

    @FXML
    private void onHomePageButton(){
        borderPane.setRight(null);
        ImageView backGroundImage = new ImageView(new Image("/Images/Backg.jpg",true));
        backGroundImage.setFitWidth(908);
        backGroundImage.setFitHeight(608);
        borderPane.setCenter(backGroundImage);
    }

    private void menuButtonsHandler() {

        if (StoreTempData.getInstance().getRole() == Person.Role.customer) {   //if signIn as customer
            signOutButton.setVisible(true);
        }

        if (StoreTempData.getInstance().getRole() == Person.Role.admin) {   //if signIn as admin
            statisticsButton.setVisible(true);
            signOutButton.setVisible(true);
            updateButton.setVisible(true);

        }
    }

    private void newInterfaceChanges(String Interface) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FxmlFiles/" + Interface +".fxml"));
            Parent root=loader.load();
            borderPane.setCenter(root);
            borderPane.setRight(null);

            if (Interface .equals("SignIn"))
                ((SignInController)loader.getController()).setBorderPane(borderPane);
            if (Interface .equals("MainMenu"))
                ((MainMenuController)loader.getController()).setBorderPane(borderPane);
            if (Interface .equals("signUp"))
                ((SignUpController)loader.getController()).setBorderPane(borderPane);
            if (Interface .equals("Cart"))
                ((ShoppingCartController)loader.getController()).setBorderPane(borderPane);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

