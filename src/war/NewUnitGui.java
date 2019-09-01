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
import org.w3c.dom.Text;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

import static javafx.application.Application.launch;

public class NewUnitGui{
    static Unit unit;


    public static Unit display(){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("New Unit Creation");

        Button saveButton = new Button("Save Unit");
        TextField nameField = new TextField("Enter Name Here");

        //choice boxes
        ChoiceBox<Type> typeChoiceBox = createTypeChoiceBox();
        ChoiceBox<Equipment> equipmentChoiceBox = createEquipmentChoiceBox();
        ChoiceBox<Experience> experienceChoiceBox = createExperienceChoiceBox();
        ChoiceBox<Integer> sizeChoiceBox = createSizeChoiceBox();

        //additional modifiers label
        Label additionalLabel = new Label("Additional Modifiers");
        Label strengthLabel = new Label("Strength: ");
        Label powerLabel = new Label("Power: ");
        Label defenseLabel = new Label("Defense: ");
        Label toughnessLabel = new Label("Toughness: ");
        Label moraleLabel = new Label("Morale: ");

        // additional modifiers Text Fields
        Label blankLabel = new Label("    ");
        TextField strengthField = new TextField("0");
        TextField powerField = new TextField("0");
        TextField defenseField = new TextField("0");
        TextField toughnessField = new TextField("0");
        TextField moraleField = new TextField("0");

        //button to save all inputted information to a unit
        //TODO input validation
        saveButton.setOnAction(e->{
            StringBuilder name = new StringBuilder();
            if(!nameField.getText().equals("Enter Name Here")) {
                name.append(nameField.getText());
                name.append(" ");
            }
            name.append(experienceChoiceBox.getValue() + " " + equipmentChoiceBox.getValue()
                        + " " + typeChoiceBox.getValue());
            Type tempType = typeChoiceBox.getValue();
            Equipment tempEquipment = equipmentChoiceBox.getValue();
            Experience tempExperience = experienceChoiceBox.getValue();
            Integer size = sizeChoiceBox.getValue();
            int [] additionalModifiers = new int[5];
            additionalModifiers[0] = Integer.parseInt(strengthField.getText());
            additionalModifiers[1] = Integer.parseInt(powerField.getText());
            additionalModifiers[2] = Integer.parseInt(defenseField.getText());
            additionalModifiers[3] = Integer.parseInt(toughnessField.getText());
            additionalModifiers[4] = Integer.parseInt(moraleField.getText());
            unit = new Unit(name.toString(), tempType, tempEquipment, tempExperience, size, additionalModifiers);
            window.close();
        });

        //layouts
        HBox layout = new HBox(30);
        VBox nameLayout = new VBox();
        VBox typeLayout = new VBox();
        VBox equipmentLayout = new VBox();
        VBox experienceLayout = new VBox();
        VBox sizeLayout = new VBox();
        VBox modiferLabelsLayout = new VBox();
        VBox modifierFieldsLayout = new VBox();

        nameLayout.getChildren().add(nameField);
        typeLayout.getChildren().add(typeChoiceBox);
        equipmentLayout.getChildren().add(equipmentChoiceBox);
        experienceLayout.getChildren().add(experienceChoiceBox);
        sizeLayout.getChildren().add(sizeChoiceBox);
        modiferLabelsLayout.getChildren().addAll(additionalLabel, strengthLabel, powerLabel, defenseLabel, toughnessLabel, moraleLabel);
        modifierFieldsLayout.getChildren().addAll(blankLabel, strengthField, powerField, defenseField, toughnessField, moraleField);
        layout.getChildren().addAll(nameLayout, typeLayout, equipmentLayout, experienceLayout, sizeLayout, modiferLabelsLayout, modifierFieldsLayout, saveButton);

        Scene scene = new Scene(layout, 800,600);

        window.setScene(scene);
        window.showAndWait();
        return unit;
    }

    public static ChoiceBox<Type> createTypeChoiceBox(){
        ChoiceBox<Type> typeChoiceBox = new ChoiceBox<>();
        typeChoiceBox.getItems().addAll(Type.LEVIES, Type.INFANTRY, Type.CAVALRY, Type.SIEGE_ENGINE, Type.ARCHERS, Type.FLYING);
        return typeChoiceBox;
    }

    public static ChoiceBox<Equipment> createEquipmentChoiceBox(){
        ChoiceBox<Equipment> equipmentChoiceBox = new ChoiceBox<>();
        equipmentChoiceBox.getItems().addAll(Equipment.LIGHT, Equipment.MEDIUM, Equipment.HEAVY, Equipment.SUPER_HEAVY);
        return equipmentChoiceBox;
    }

    public static ChoiceBox<Experience> createExperienceChoiceBox(){
        ChoiceBox<Experience> experienceChoiceBox = new ChoiceBox<>();
        experienceChoiceBox.getItems().addAll(Experience.GREEN, Experience.REGULAR, Experience.SEASONED, Experience.VETERAN,
                                                Experience.ELITE, Experience.SUPER_ELITE);
        return experienceChoiceBox;
    }

    public static ChoiceBox<Integer> createSizeChoiceBox(){
        ChoiceBox<Integer> sizeChoiceBox = new ChoiceBox<Integer>();
        sizeChoiceBox.getItems().addAll(4,6,8,10,12);
        return sizeChoiceBox;
    }

}
