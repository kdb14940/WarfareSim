package war.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import war.components.ArmyTableView;

public class NewArmyGui {

    public NewArmyGui(){
        initComponents();
        layoutComponents();
    }

    private void initComponents(){
        layout = new HBox(50);
        unitsView = new ArmyTableView();
        unitsColumn = new VBox(20);
        newUnitButton = new Button("Add New Unit");
        saveButton = new Button("Save Army");
        unitsLabel = new Label("Units");
        armyName = new TextField("Enter Army Name Here");
    }

    private void layoutComponents(){
        unitsColumn.getChildren().add(armyName);
        unitsColumn.getChildren().add(unitsLabel);
        unitsColumn.getChildren().add(unitsView);

        layout.getChildren().addAll(unitsColumn, newUnitButton, saveButton);
        scene = new Scene(layout);
    }

    /**
     * Getter for scene
     *
     * @return scene
     */
    public Scene getScene() {
        return scene;
    }

    /**
     * Setter for scene
     *
     * @param scene - scene
     */
    public void setScene(Scene scene) {
        this.scene = scene;
    }

    /**
     * Getter for layout
     *
     * @return layout
     */
    public HBox getLayout() {
        return layout;
    }

    /**
     * Setter for layout
     *
     * @param layout - layout
     */
    public void setLayout(HBox layout) {
        this.layout = layout;
    }

    /**
     * Getter for unitsView
     *
     * @return unitsView
     */
    public ArmyTableView getUnitsView() {
        return unitsView;
    }

    /**
     * Setter for unitsView
     *
     * @param unitsView - unitsView
     */
    public void setUnitsView(ArmyTableView unitsView) {
        this.unitsView = unitsView;
    }

    /**
     * Getter for newUnitButton
     *
     * @return newUnitButton
     */
    public Button getNewUnitButton() {
        return newUnitButton;
    }

    /**
     * Setter for newUnitButton
     *
     * @param newUnitButton - newUnitButton
     */
    public void setNewUnitButton(Button newUnitButton) {
        this.newUnitButton = newUnitButton;
    }

    /**
     * Getter for saveButton
     *
     * @return saveButton
     */
    public Button getSaveButton() {
        return saveButton;
    }

    /**
     * Setter for saveButton
     *
     * @param saveButton - saveButton
     */
    public void setSaveButton(Button saveButton) {
        this.saveButton = saveButton;
    }

    /**
     * Getter for unitsLabel
     *
     * @return unitsLabel
     */
    public Label getUnitsLabel() {
        return unitsLabel;
    }

    /**
     * Setter for unitsLabel
     *
     * @param unitsLabel - unitsLabel
     */
    public void setUnitsLabel(Label unitsLabel) {
        this.unitsLabel = unitsLabel;
    }

    /**
     * Getter for armyName
     *
     * @return armyName
     */
    public TextField getArmyName() {
        return armyName;
    }

    /**
     * Setter for armyName
     *
     * @param armyName - armyName
     */
    public void setArmyName(TextField armyName) {
        this.armyName = armyName;
    }

    /**
     * Getter for unitsColumn
     *
     * @return unitsColumn
     */
    public VBox getUnitsColumn() {
        return unitsColumn;
    }

    /**
     * Setter for unitsColumn
     *
     * @param unitsColumn - unitsColumn
     */
    public void setUnitsColumn(VBox unitsColumn) {
        this.unitsColumn = unitsColumn;
    }

    private Scene scene;
    private HBox layout;
    private ArmyTableView unitsView;
    private VBox unitsColumn;
    private Button newUnitButton;
    private Button saveButton;
    private Label unitsLabel;
    private TextField armyName;

}
