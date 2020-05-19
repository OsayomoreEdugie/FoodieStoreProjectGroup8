package execptions;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import javafx.scene.layout.StackPane;
import com.jfoenix.controls.JFXDialogLayout;
import javafx.scene.text.Text;


public class AlertHandler {

   public void dialog(String heading, String body, StackPane stackPane) {
        JFXDialogLayout content = new JFXDialogLayout();
        content.setHeading(new Text(heading));
        content.setBody(new Text(body));
        JFXDialog dialog = new JFXDialog(stackPane, content, JFXDialog.DialogTransition.CENTER);

        JFXButton button = new JFXButton("okay");
        button.setOnAction(event -> dialog.close());
        content.setActions(button);
        dialog.show();
    }
}
