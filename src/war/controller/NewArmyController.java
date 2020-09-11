package war.controller;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import war.model.Unit;
import war.model.Army;
import war.model.ArmyList;
import war.view.NewArmyScreen;
import war.view.NewUnitScreen;
import war.view.WelcomeScreen;


public class NewArmyController {


    public NewArmyController(ArmyList armyList) {
        this.armyList = armyList;
        newArmyScreen = new NewArmyScreen();
        army = new Army();
        initControllers();
    }

    public NewArmyController(ArmyList armyList, Army army) {
        this.armyList = armyList;
        newArmyScreen = new NewArmyScreen();
        this.army = army;
        initControllers();
    }


    private void initControllers(){
        newArmyScreen.getNewUnitButton().setOnAction(e ->{
            army.setName(newArmyScreen.getArmyName().getText());
            NewUnitController newUnitController = new NewUnitController(armyList, army);
            NewUnitScreen newArmyScreen = newUnitController.getNewUnitScreen();
            Stage primaryStage = (Stage)((Node)e.getSource()).getScene().getWindow();
            primaryStage.setScene(newArmyScreen.getScene());
            primaryStage.setFullScreen(true);
        });
        newArmyScreen.getSaveButton().setOnAction(e->{
            saveArmy();
            armyList.addArmy(army);

            WelcomeController welcomeController = new WelcomeController(armyList);
            WelcomeScreen welcomeScreen = welcomeController.getWelcomeScreen();
            Stage primaryStage = (Stage)((Node)e.getSource()).getScene().getWindow();
            primaryStage.setScene(welcomeScreen.getScene());
            primaryStage.setFullScreen(true);
        });

        fillUnitsView();
        updateArmyName();

    }

    private void updateArmyName() {
        if(!army.getName().equals("")){
            newArmyScreen.getArmyName().setText(army.getName());
        }
    }

    private void saveArmy(){
        TextField armyName = newArmyScreen.getArmyName();
        if(!armyName.getText().equals("Enter Army Name Here")){
            army.setName(armyName.getText());
        }
        else{
            army.setName(army.getUnits().get(0).getName());
        }
    }

    private void fillUnitsView(){
        VBox unitsView = newArmyScreen.getUnitsView();
        unitsView.getChildren().clear();
        for(Unit unit : army.getUnits()){
            Label temp = new Label(unit.getName());
            unitsView.getChildren().add(temp);
        }
    }

    /**
     * Getter for newArmyScreen
     *
     * @return newArmyScreen
     */
    public NewArmyScreen getNewArmyScreen() {
        return newArmyScreen;
    }

    /**
     * Setter for newArmyScreen
     *
     * @param newArmyScreen - newArmyScreen
     */
    public void setNewArmyScreen(NewArmyScreen newArmyScreen) {
        this.newArmyScreen = newArmyScreen;
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

    private NewArmyScreen newArmyScreen;
    private ArmyList armyList;
    private Army army;
}
