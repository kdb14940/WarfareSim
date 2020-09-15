package war.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.SnapshotResult;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Callback;
import war.model.Army;
import war.model.ArmyList;
import war.view.BattleGui;
import war.view.NewArmyGui;
import war.view.ArmyChoiceGui;

import java.io.*;


public class ArmyChoiceController {

    public ArmyChoiceController( ArmyList armyList) {
        this.armyChoiceGui = new ArmyChoiceGui();
        this.armyList = armyList;
        initControllers();
        initComboBox(armyChoiceGui.getArmy1ComboBox());
        initComboBox(armyChoiceGui.getArmy2ComboBox());
    }

    public ArmyChoiceController() {
        this.armyChoiceGui = new ArmyChoiceGui();
        this.armyList = new ArmyList();
        getAllData();
        initControllers();
        initComboBox(armyChoiceGui.getArmy1ComboBox());
        initComboBox(armyChoiceGui.getArmy2ComboBox());
    }

    private void initControllers(){
        armyChoiceGui.getNewArmyButton().setOnAction(e ->{
            NewArmyController newArmyController = new NewArmyController(armyList);
            NewArmyGui newArmyGui = newArmyController.getNewArmyGui();
            Stage primaryStage = (Stage)((Node)e.getSource()).getScene().getWindow();
            primaryStage.setScene(newArmyGui.getScene());

            Screen screen = Screen.getPrimary();
            Rectangle2D bounds = screen.getVisualBounds();
            primaryStage.setWidth(bounds.getWidth());
            primaryStage.setHeight(bounds.getHeight());
            primaryStage.setMaximized(true);
        });
        armyChoiceGui.getContinueButton().setOnAction(e ->{
            saveAllData();
            Army army1 = armyChoiceGui.getArmy1ComboBox().getValue();
            Army army2 = armyChoiceGui.getArmy2ComboBox().getValue();
            BattleController battleController = new BattleController(army1, army2);
            BattleGui battleGui = battleController.getBattleGui();
            Stage primaryStage = (Stage)((Node)e.getSource()).getScene().getWindow();
            primaryStage.setScene(battleGui.getScene());

            Screen screen = Screen.getPrimary();
            Rectangle2D bounds = screen.getVisualBounds();
            primaryStage.setWidth(bounds.getWidth());
            primaryStage.setHeight(bounds.getHeight());
            primaryStage.setMaximized(true);

        });

        armyChoiceGui.getExitButton().setOnAction(e ->{
            saveAllData();
            Stage primaryStage = (Stage)((Node)e.getSource()).getScene().getWindow();
            primaryStage.close();

        });

    }

    private void initComboBox(ComboBox<Army> comboBox){
        Callback<ListView<Army>, ListCell<Army>> factory = lv -> new ListCell<Army>() {
            @Override
            protected void updateItem(Army item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? "" : item.getName());
            }
        };
        comboBox.setCellFactory(factory);
        comboBox.setButtonCell(factory.call(null));

        ObservableList<Army> oArmyList = FXCollections.observableArrayList(armyList.getArmyList());
        comboBox.getItems().addAll(oArmyList);
        comboBox.getSelectionModel().selectFirst();

    }

    public void saveAllData(){
        String filename = this.FILE_PATH;

        // Serialization
        try
        {
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object
            out.writeObject(armyList);

            out.close();
            file.close();

            System.out.println("Object has been serialized");

        }
        catch(IOException ex)
        {
            System.out.println("IOException is caught");
            System.out.println(ex.getMessage());
            System.out.println(ex.getCause());
        }
    }

    public boolean getAllData(){
        String filename = FILE_PATH;
        try
        {
            // Reading the object from a file
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            armyList = (ArmyList)in.readObject();

            in.close();
            file.close();

            System.out.println("Object has been deserialized ");
        }

        catch(IOException ex)
        {
            System.out.println("IOException is caught");
            return false;
        }

        catch(ClassNotFoundException ex)
        {
            System.out.println("ClassNotFoundException is caught");
            return false;
        }
        return true;
    }

    /**
     * Getter for armyChoiceGui
     *
     * @return armyChoiceGui
     */
    public ArmyChoiceGui getArmyChoiceGui() {
        return armyChoiceGui;
    }

    /**
     * Setter for armyChoiceGui
     *
     * @param armyChoiceGui - armyChoiceGui
     */
    public void setArmyChoiceGui(ArmyChoiceGui armyChoiceGui) {
        this.armyChoiceGui = armyChoiceGui;
    }

    /**
     * Getter for armyList
     *
     * @return armyList
     */
    public ArmyList getArmyList() {
        return armyList;
    }

    /**
     * Setter for armyList
     *
     * @param armyList - armyList
     */
    public void setArmyList(ArmyList armyList) {
        this.armyList = armyList;
    }

    private ArmyChoiceGui armyChoiceGui;
    private ArmyList armyList;
    private String FILE_PATH = "./resources/armies.dat";
}
