package war.controller;

import javafx.scene.Node;
import javafx.scene.SnapshotResult;
import javafx.stage.Stage;
import war.model.Army;
import war.model.ArmyList;
import war.view.NewArmyScreen;
import war.view.WelcomeScreen;

import java.io.*;


public class WelcomeController {

    public WelcomeController( ArmyList armyList) {
        this.welcomeScreen = new WelcomeScreen();
        this.armyList = armyList;
        initControllers();
        initChoiceBoxes();
    }

    public WelcomeController() {
        this.welcomeScreen = new WelcomeScreen();
        this.armyList = new ArmyList();
        getAllData();
        initControllers();
        initChoiceBoxes();
    }

    private void initControllers(){
        welcomeScreen.getNewArmyButton().setOnAction(e ->{
            //TODO
            NewArmyController newArmyController = new NewArmyController(armyList);
            NewArmyScreen newArmyScreen = newArmyController.getNewArmyScreen();
            Stage primaryStage = (Stage)((Node)e.getSource()).getScene().getWindow();
            primaryStage.setScene(newArmyScreen.getScene());
            primaryStage.setFullScreen(true);
        });
        welcomeScreen.getContinueButton().setOnAction(e ->{
            //TODO
        });

        welcomeScreen.getExitButton().setOnAction(e ->{
            saveAllData();
            Stage primaryStage = (Stage)((Node)e.getSource()).getScene().getWindow();
            primaryStage.close();

        });

    }

    private void initChoiceBoxes(){
        for(Army army: armyList.getArmyList()){
            welcomeScreen.getArmy1ChoiceBox().getItems().add(army.getName());
            welcomeScreen.getArmy2ChoiceBox().getItems().add(army.getName());
        }
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
     * Getter for welcomeScreen
     *
     * @return welcomeScreen
     */
    public WelcomeScreen getWelcomeScreen() {
        return welcomeScreen;
    }

    /**
     * Setter for welcomeScreen
     *
     * @param welcomeScreen - welcomeScreen
     */
    public void setWelcomeScreen(WelcomeScreen welcomeScreen) {
        this.welcomeScreen = welcomeScreen;
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

    private WelcomeScreen welcomeScreen;
    private ArmyList armyList;
    private String FILE_PATH = "./resources/armies.dat";
}
