package war;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
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

public class EditArmyGui{
    static VBox vBox;
    static TableView<Unit> unitTableView;

    public static void display(Army army){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Edit Army");

        vBox = new VBox();
        VBox buttonBox = new VBox(15);

        createTable(army);



        updateUnitTableView(army);
        //variables
        Button saveButton = new Button("Save");
        Button addButton = new Button("Add Unit");
        Button removeButton = new Button("Remove Unit");
        buttonBox.getChildren().addAll(addButton,removeButton,saveButton);
        //button to save army to file and exit screen
        saveButton.setOnAction(e->
        {

            window.close();
        });

        addButton.setOnAction(e ->{
            Unit[] units = NewUnitGui.display();
            for(Unit unit : units){
                army.addUnit(unit);
            }
            updateUnitTableView(army);
        });

        removeButton.setOnAction(e->{
            Unit selectedUnit = unitTableView.getSelectionModel().getSelectedItem();
            army.removeUnit(selectedUnit);
            updateUnitTableView(army);
        });

        HBox layout = new HBox(20);
        layout.getChildren().addAll(vBox, buttonBox);
        Scene scene = new Scene(layout, 800,600);
        window.setScene(scene);
        window.showAndWait();
        //return army;
    }

    private static void updateUnitTableView(Army army){
        vBox.getChildren().clear();
        unitTableView.getItems().clear();
        LinkedList<Unit> unitLinkedList = army.getUnits();
        for(Unit unit : unitLinkedList){
            unitTableView.getItems().add(unit);
        }
        Label unitsLabel = new Label("Units");
        vBox.getChildren().addAll(unitsLabel, unitTableView);
    }

    public static void createTable(Army army){
        unitTableView = new TableView<>();
        TableColumn<Unit, String> nameColumn = new TableColumn<>("Name");
        TableColumn<Unit, Integer> attackColumn = new TableColumn<>("Attack");
        TableColumn<Unit, Integer> powerColumn = new TableColumn<>("Power");
        TableColumn<Unit, Integer> defenseColumn = new TableColumn<>("Defense");
        TableColumn<Unit, Integer> toughnessColumn = new TableColumn<>("Toughness");
        TableColumn<Unit, Integer> moraleColumn = new TableColumn<>("Morale");
        TableColumn<Unit, Integer> costColumn = new TableColumn<>("Cost");

        nameColumn.setMinWidth(250);
        attackColumn.setMinWidth(20);
        powerColumn.setMinWidth(20);
        defenseColumn.setMinWidth(20);
        toughnessColumn.setMinWidth(20);
        moraleColumn.setMinWidth(20);
        costColumn.setMinWidth(20);

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        attackColumn.setCellValueFactory(new PropertyValueFactory<>("attackBonus"));
        powerColumn.setCellValueFactory(new PropertyValueFactory<>("powerBonus"));
        defenseColumn.setCellValueFactory(new PropertyValueFactory<>("defenseBonus"));
        toughnessColumn.setCellValueFactory(new PropertyValueFactory<>("toughnessBonus"));
        moraleColumn.setCellValueFactory(new PropertyValueFactory<>("moraleBonus"));
        costColumn.setCellValueFactory(new PropertyValueFactory<>("cost"));

        updateUnitTableView(army);

        unitTableView.getColumns().addAll(nameColumn, attackColumn, powerColumn, defenseColumn, toughnessColumn, moraleColumn, costColumn);
    }

}
