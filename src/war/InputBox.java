package war;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

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
