package war;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class InputBox{
    static int input;

    public static int display(){
        input = 1;
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("InputBox");
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        Button confirmButton = new Button("Confirm");
        Label label = new Label("Number of Copies");
        TextField inputField = new TextField();
        inputField.setMaxWidth(50);

        layout.getChildren().addAll(label, inputField, confirmButton);

        confirmButton.setOnAction(e->{
                try {
                    input = Integer.parseInt(inputField.getText());
                    window.close();
                }
                catch(NumberFormatException err) {
                    System.out.println("Not an integer. It was a " + inputField.getText().getClass() + "Try again.");
                }
        });

        Scene scene = new Scene(layout, 200,200);
        window.setScene(scene);
        window.showAndWait();
        return input;
    }


}
