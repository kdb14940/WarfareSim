package war.controller;

import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import war.*;
import war.enums.Equipment;
import war.enums.Experience;
import war.enums.Type;
import war.model.Army;
import war.model.ArmyList;
import war.model.Unit;
import war.view.NewArmyScreen;
import war.view.NewUnitScreen;

public class NewUnitController {

    public NewUnitController(ArmyList armyList, Army army) {
        this.armyList = armyList;
        newUnitScreen = new NewUnitScreen();
        this.army = army;
        initControllers();
    }

    private void initControllers(){
        newUnitScreen.getSaveButton().setOnAction(e -> {
            saveUnit();

            NewArmyController newArmyController = new NewArmyController(armyList, army);
            NewArmyScreen newArmyScreen = newArmyController.getNewArmyScreen();
            Stage primaryStage = (Stage)((Node)e.getSource()).getScene().getWindow();
            primaryStage.setScene(newArmyScreen.getScene());
            primaryStage.setFullScreen(true);
        });
    }

    private void saveUnit(){
        StringBuilder name = new StringBuilder();
        TextField nameField = newUnitScreen.getNameField();
        TextField strengthField = newUnitScreen.getStrengthField();
        TextField powerField = newUnitScreen.getPowerField();
        TextField defenseField = newUnitScreen.getDefenseField();
        TextField toughnessField = newUnitScreen.getToughnessField();
        TextField moraleField = newUnitScreen.getMoraleField();

        ChoiceBox<Type> typeChoiceBox = newUnitScreen.getTypeChoiceBox();
        ChoiceBox<Experience> experienceChoiceBox = newUnitScreen.getExperienceChoiceBox();
        ChoiceBox<Equipment> equipmentChoiceBox = newUnitScreen.getEquipmentChoiceBox();
        ChoiceBox<Integer> sizeChoiceBox = newUnitScreen.getSizeChoiceBox();

        if(!nameField.getText().equals("Enter Name Here")) {
            name.append(nameField.getText());
            name.append(" ");
        }
        if(typeChoiceBox.getValue() != Type.SPECIAL)
        {
            name.append(experienceChoiceBox.getValue() + " " + equipmentChoiceBox.getValue()
                    + " " + typeChoiceBox.getValue());
        }
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

        //add correct number of units from user inputted number of copies
        int numUnits = InputBox.display();
        for(int i = 0; i < numUnits; i++){
            army.addUnit(new Unit(name.toString(), tempType, tempEquipment,
                    tempExperience, size, additionalModifiers));
        }

    }

    /**
     * Getter for army
     *
     * @return army
     */
    public Army getArmy() {
        return army;
    }

    /**
     * Setter for army
     *
     * @param army - army
     */
    public void setArmy(Army army) {
        this.army = army;
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

    /**
     * Getter for newUnitScreen
     *
     * @return newUnitScreen
     */
    public NewUnitScreen getNewUnitScreen() {
        return newUnitScreen;
    }

    /**
     * Setter for newUnitScreen
     *
     * @param newUnitScreen - newUnitScreen
     */
    public void setNewUnitScreen(NewUnitScreen newUnitScreen) {
        this.newUnitScreen = newUnitScreen;
    }

    /**
     * Getter for unit
     *
     * @return unit
     */
    public Unit getUnit() {
        return unit;
    }

    /**
     * Setter for unit
     *
     * @param unit - unit
     */
    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    private Army army;
    private ArmyList armyList;
    private NewUnitScreen newUnitScreen;
    private Unit unit;
}
