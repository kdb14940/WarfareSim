package war;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import war.model.Army;

import java.io.IOException;
import java.util.LinkedList;

public class EditArmyGui{}
    /**
    static VBox vBox;
    static TableView<Unit> unitTableView;

    /**
     * Displays the Window for Editing an Army
     * @param army - army to be edited

    public static void display(Army army){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Edit Army");

        vBox = new VBox();
        VBox buttonBox = new VBox(15);

        createTable(army);

        //variables
        Button saveButton = new Button("Save To File");
        Button backButton = new Button("Back");
        Button addButton = new Button("Add Unit");
        Button removeButton = new Button("Remove Unit");
        buttonBox.getChildren().addAll(addButton,removeButton,backButton, saveButton);
        //button to save army to file and exit screen
        //TODO better exception handling
        // create an alert box??
        saveButton.setOnAction(e->
        {
            try{
               // army.saveArmyToFile();
            }
            catch(IOException err){
                System.out.println("Error with saving army to file");
            }
            window.close();
        });

        //button to save without exiting
        backButton.setOnAction(e->{
            window.close();
        });

        // button to add a unit
        addButton.setOnAction(e ->{
            Unit[] units = NewUnitGui.display();
            for(Unit unit : units){
                army.addUnit(unit);
            }
            updateUnitTableView(army);
        });

        // button to remove a unit
        removeButton.setOnAction(e->{
            Unit selectedUnit = unitTableView.getSelectionModel().getSelectedItem();
            army.removeUnit(selectedUnit);
            updateUnitTableView(army);
        });

        //layout and set Scene
        HBox layout = new HBox(20);
        layout.getChildren().addAll(vBox, buttonBox);
        Scene scene = new Scene(layout, 800,600);
        window.setScene(scene);
        window.showAndWait();
    }

    /**
     * Clears the table of all values then refills it with any changes
     * NOTE: May be innefficient to delete everything then refill all
     * @param army - army used to fill table

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

    /**
     * Creates the table with all the attributes for a Unit
     * @param army - used to be passed into updateUnitTableView

    public static void createTable(Army army){
        unitTableView = new TableView<>();
        //columns
        TableColumn<Unit, String> nameColumn = new TableColumn<>("Name");
        TableColumn<Unit, Integer> attackColumn = new TableColumn<>("Attack");
        TableColumn<Unit, Integer> powerColumn = new TableColumn<>("Power");
        TableColumn<Unit, Integer> defenseColumn = new TableColumn<>("Defense");
        TableColumn<Unit, Integer> toughnessColumn = new TableColumn<>("Toughness");
        TableColumn<Unit, Integer> moraleColumn = new TableColumn<>("Morale");
        TableColumn<Unit, Integer> sizeColumn = new TableColumn<>("Size");
        TableColumn<Unit, Integer> costColumn = new TableColumn<>("Cost");

        nameColumn.setMinWidth(250);
        attackColumn.setMinWidth(20);
        powerColumn.setMinWidth(20);
        defenseColumn.setMinWidth(20);
        toughnessColumn.setMinWidth(20);
        moraleColumn.setMinWidth(20);
        sizeColumn.setMinWidth(20);
        costColumn.setMinWidth(20);

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        attackColumn.setCellValueFactory(new PropertyValueFactory<>("attackBonus"));
        powerColumn.setCellValueFactory(new PropertyValueFactory<>("powerBonus"));
        defenseColumn.setCellValueFactory(new PropertyValueFactory<>("defenseBonus"));
        toughnessColumn.setCellValueFactory(new PropertyValueFactory<>("toughnessBonus"));
        moraleColumn.setCellValueFactory(new PropertyValueFactory<>("moraleBonus"));
        sizeColumn.setCellValueFactory(new PropertyValueFactory<>("size"));
        costColumn.setCellValueFactory(new PropertyValueFactory<>("cost"));

        updateUnitTableView(army);

        unitTableView.getColumns().addAll(nameColumn, attackColumn, powerColumn, defenseColumn, toughnessColumn, moraleColumn, sizeColumn, costColumn);
    }

}

     */