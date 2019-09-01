package war;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

public class NewArmyGui{
    static Army army;
    static LinkedList<Unit> listOfUnits;

    public static Army display(){
        army = new Army();
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("New Army Creation");

        //variables
        listOfUnits = new LinkedList<>();
        VBox unitsView = new VBox();
        Button newUnitButton = new Button("Add New Unit");
        Button saveButton = new Button("Save Army");
        Label unitsLabel = new Label("Units");
        TextField armyName = new TextField("Enter Army Name Here");
        unitsView.getChildren().add(armyName);
        unitsView.getChildren().add(unitsLabel);

        //layout
        HBox layout = new HBox(50);
        layout.getChildren().addAll(unitsView, newUnitButton, saveButton);
        Scene scene = new Scene(layout, 800, 600);

        // Button for adding a new unit
        newUnitButton.setOnAction(e->{
            listOfUnits.add(NewUnitGui.display());
            unitsView.getChildren().clear();
            updateVBoxList(unitsView);
            window.setScene(scene);
        });

        //button to save army to file and exit screen
        saveButton.setOnAction(e->
        {
            if(!armyName.getText().equals("Enter Army Name Here")){
                army.setName(armyName.getText());
            }
            else{
                army.setName(listOfUnits.get(0).getName());
            }
            for(Unit unit : listOfUnits){
                army.addUnit(unit);
            }
            window.close();
        });

        window.setScene(scene);
        window.showAndWait();
        return army;
    }

    private static void updateVBoxList(VBox vbox){
        Label unitsLabel = new Label("Units");
        vbox.getChildren().add(unitsLabel);
        for(Unit unit : listOfUnits){
            Label temp = new Label(unit.getName());
            vbox.getChildren().add(temp);
        }
    }

}
