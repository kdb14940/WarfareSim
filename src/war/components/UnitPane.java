package war.components;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import war.model.Unit;

public class UnitPane extends Pane {

    public UnitPane(){
        initComponents();
        layoutComponents();

    }

    public UnitPane(Unit unit){
        this.unit = unit;
        initComponents();
        layoutComponents();
        updateValues();
    }

    public void initComponents(){
        nameLabel = new Label("Name");
        attackLabel = new Label("Attack");
        defenseLabel = new Label("Defense");
        powerLabel = new Label("Power");
        toughnessLabel = new Label("Toughness");
        moraleLabel = new Label("Morale");
        costLabel = new Label("Cost");
        commandLabel = new Label("Command");
        sizeLabel = new Label("Size");

        nameValue = new Label("0");
        attackValue = new Label("0");
        defenseValue = new Label("0");
        powerValue = new Label("0");
        toughnessValue = new Label("0");
        moraleValue = new Label("0");
        costValue = new Label("0");
        commandValue = new Label("0");
        sizeValue = new Label("0");

        layout = new HBox(20);
    }

    private void layoutComponents(){
        VBox col1 = new VBox(5);
        VBox col2 = new VBox(5);
        col1.getChildren().addAll(nameLabel, attackLabel, defenseLabel, powerLabel,
                toughnessLabel, moraleLabel, commandLabel, costLabel, sizeLabel);
        col2.getChildren().addAll(nameValue, attackValue, defenseValue, powerValue,
                toughnessValue, moraleValue, commandValue, costValue, sizeValue);
        layout.getChildren().addAll(col1, col2);
        getChildren().add(layout);
    }

    private void updateValues(){
        if(unit != null){
            nameValue.setText(unit.getName());
            attackValue.setText(Integer.toString(unit.getAttackBonus()));
            defenseValue.setText(Integer.toString(unit.getDefenseBonus()));
            powerValue.setText(Integer.toString(unit.getPowerBonus()));
            toughnessValue.setText(Integer.toString(unit.getToughnessBonus()));
            moraleValue.setText(Integer.toString(unit.getMoraleBonus()));
            costValue.setText(Integer.toString(unit.getCost()));
            commandValue.setText(Integer.toString(unit.getCommandBonus()));
            sizeValue.setText(Integer.toString(unit.getSize()));
        }
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
        updateValues();
    }

    private Label nameLabel;
    private Label attackLabel;
    private Label defenseLabel;
    private Label powerLabel;
    private Label moraleLabel;
    private Label toughnessLabel;
    private Label costLabel;
    private Label commandLabel;
    private Label sizeLabel;

    private Label nameValue;
    private Label attackValue;
    private Label defenseValue;
    private Label powerValue;
    private Label moraleValue;
    private Label toughnessValue;
    private Label costValue;
    private Label commandValue;
    private Label sizeValue;

    private HBox layout;
    private Unit unit;
}
