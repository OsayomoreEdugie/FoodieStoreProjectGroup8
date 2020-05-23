package ControllerPackage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../FxmlFiles/SignIn.fxml"));
        primaryStage.setTitle("FoodieStore");
        Scene scene = new Scene(root);

        scene.setFill(Color.TRANSPARENT);
        primaryStage.setScene(scene);
        primaryStage.getScene().setRoot(root);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.getIcons().add(new Image("Images/FoodieLogo.png"));
        primaryStage.show();
    }
}
