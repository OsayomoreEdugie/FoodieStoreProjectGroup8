package ControllerPackage;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.io.IOException;

public abstract class Control implements Initializable {
    static String logInUser;
    public BorderPane borderPane;
    public StackPane stackPane;

    public static String getLogInUser() {
        return logInUser;
    }

    public static void setLogInUser(String logInUser) {
        Control.logInUser = logInUser;
    }

    public void setBorderPane(BorderPane borderPane) {
        this.borderPane = borderPane;

    }


    void AlertBox(String error) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Information");
        a.setContentText(error);
        a.showAndWait();
        a.setHeaderText(null);
    }

    public void newWindow(String winName) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FxmlFiles/" + winName + ".fxml"));
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

    public void newInterfaceChanges(String Interface) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FxmlFiles/" + Interface + ".fxml"));
            Parent root = loader.load();
            borderPane.setCenter(root);
            borderPane.setRight(null);
            if (Interface.equals("signUp"))
                ((SignUpController) loader.getController()).setBorderPane(borderPane);
            if (Interface.equals("MainMenu"))
                ((MainMenuController) loader.getController()).setBorderPane(borderPane);

        } catch (IOException e) {
            AlertBox(e + "");
        }
    }



    boolean ValidationOfEmail(String email) {
        try {
            InternetAddress validemail = new InternetAddress(email);
            validemail.validate();
            return true;
        } catch (AddressException ex) {
            AlertBox(ex + "");
            return false;
        }

    }
}




