package war.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import war.enums.Equipment;
import war.enums.Experience;
import war.enums.Type;

public class NewUnitScreen {

    public NewUnitScreen() {
        initComponents();
        layoutComponents();
    }

    private void initComponents(){
        saveButton = new Button("Save");
        nameField = new TextField("Enter Name Here");
        
        typeChoiceBox = createTypeChoiceBox();
        equipmentChoiceBox = createEquipmentChoiceBox();
        experienceChoiceBox = createExperienceChoiceBox();
        sizeChoiceBox = createSizeChoiceBox();

         additionalLabel = new Label("Additional Modifiers");
         strengthLabel = new Label("Strength: ");
         powerLabel = new Label("Power: ");
         defenseLabel = new Label("Defense: ");
         toughnessLabel = new Label("Toughness: ");
         moraleLabel = new Label("Morale: ");

         blankLabel = new Label("    ");
         strengthField = new TextField("0");
         powerField = new TextField("0");
         defenseField = new TextField("0");
         toughnessField = new TextField("0");
         moraleField = new TextField("0");

        layout = new HBox(30);
        nameLayout = new VBox();
        typeLayout = new VBox();
        equipmentLayout = new VBox();
        experienceLayout = new VBox();
        sizeLayout = new VBox();
        modifierLabelsLayout = new VBox();
        modifierFieldsLayout = new VBox();

        scene = new Scene(layout, 800,600);
    }

    private void layoutComponents(){
        nameLayout.getChildren().add(nameField);
        typeLayout.getChildren().add(typeChoiceBox);
        equipmentLayout.getChildren().add(equipmentChoiceBox);
        experienceLayout.getChildren().add(experienceChoiceBox);
        sizeLayout.getChildren().add(sizeChoiceBox);
        modifierLabelsLayout.getChildren().addAll(additionalLabel, strengthLabel, powerLabel,
                defenseLabel, toughnessLabel, moraleLabel);
        modifierFieldsLayout.getChildren().addAll(blankLabel, strengthField, powerField, defenseField,
                toughnessField, moraleField);
        layout.getChildren().addAll(nameLayout, typeLayout, equipmentLayout, experienceLayout,
                sizeLayout, modifierLabelsLayout, modifierFieldsLayout, saveButton);
    }

    public ChoiceBox<Type> createTypeChoiceBox(){
        ChoiceBox<Type> typeChoiceBox = new ChoiceBox<>();
        typeChoiceBox.getItems().addAll(Type.LEVIES, Type.INFANTRY, Type.CAVALRY, Type.SIEGE_ENGINE, Type.ARCHERS, Type.FLYING, Type.SPECIAL);
        return typeChoiceBox;
    }

    public ChoiceBox<Equipment> createEquipmentChoiceBox(){
        ChoiceBox<Equipment> equipmentChoiceBox = new ChoiceBox<>();
        equipmentChoiceBox.getItems().addAll(Equipment.LIGHT, Equipment.MEDIUM, Equipment.HEAVY, Equipment.SUPER_HEAVY);
        return equipmentChoiceBox;
    }

    public ChoiceBox<Experience> createExperienceChoiceBox(){
        ChoiceBox<Experience> experienceChoiceBox = new ChoiceBox<>();
        experienceChoiceBox.getItems().addAll(Experience.GREEN, Experience.REGULAR, Experience.SEASONED, Experience.VETERAN,
                Experience.ELITE, Experience.SUPER_ELITE);
        return experienceChoiceBox;
    }

    public ChoiceBox<Integer> createSizeChoiceBox(){
        ChoiceBox<Integer> sizeChoiceBox = new ChoiceBox<Integer>();
        sizeChoiceBox.getItems().addAll(4,6,8,10,12);
        return sizeChoiceBox;
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
     * Getter for nameField
     *
     * @return nameField
     */
    public TextField getNameField() {
        return nameField;
    }

    /**
     * Setter for nameField
     *
     * @param nameField - nameField
     */
    public void setNameField(TextField nameField) {
        this.nameField = nameField;
    }

    /**
     * Getter for typeChoiceBox
     *
     * @return typeChoiceBox
     */
    public ChoiceBox<Type> getTypeChoiceBox() {
        return typeChoiceBox;
    }

    /**
     * Setter for typeChoiceBox
     *
     * @param typeChoiceBox - typeChoiceBox
     */
    public void setTypeChoiceBox(ChoiceBox<Type> typeChoiceBox) {
        this.typeChoiceBox = typeChoiceBox;
    }

    /**
     * Getter for equipmentChoiceBox
     *
     * @return equipmentChoiceBox
     */
    public ChoiceBox<Equipment> getEquipmentChoiceBox() {
        return equipmentChoiceBox;
    }

    /**
     * Setter for equipmentChoiceBox
     *
     * @param equipmentChoiceBox - equipmentChoiceBox
     */
    public void setEquipmentChoiceBox(ChoiceBox<Equipment> equipmentChoiceBox) {
        this.equipmentChoiceBox = equipmentChoiceBox;
    }

    /**
     * Getter for experienceChoiceBox
     *
     * @return experienceChoiceBox
     */
    public ChoiceBox<Experience> getExperienceChoiceBox() {
        return experienceChoiceBox;
    }

    /**
     * Setter for experienceChoiceBox
     *
     * @param experienceChoiceBox - experienceChoiceBox
     */
    public void setExperienceChoiceBox(ChoiceBox<Experience> experienceChoiceBox) {
        this.experienceChoiceBox = experienceChoiceBox;
    }

    /**
     * Getter for sizeChoiceBox
     *
     * @return sizeChoiceBox
     */
    public ChoiceBox<Integer> getSizeChoiceBox() {
        return sizeChoiceBox;
    }

    /**
     * Setter for sizeChoiceBox
     *
     * @param sizeChoiceBox - sizeChoiceBox
     */
    public void setSizeChoiceBox(ChoiceBox<Integer> sizeChoiceBox) {
        this.sizeChoiceBox = sizeChoiceBox;
    }

    /**
     * Getter for strengthField
     *
     * @return strengthField
     */
    public TextField getStrengthField() {
        return strengthField;
    }

    /**
     * Setter for strengthField
     *
     * @param strengthField - strengthField
     */
    public void setStrengthField(TextField strengthField) {
        this.strengthField = strengthField;
    }

    /**
     * Getter for powerField
     *
     * @return powerField
     */
    public TextField getPowerField() {
        return powerField;
    }

    /**
     * Setter for powerField
     *
     * @param powerField - powerField
     */
    public void setPowerField(TextField powerField) {
        this.powerField = powerField;
    }

    /**
     * Getter for defenseField
     *
     * @return defenseField
     */
    public TextField getDefenseField() {
        return defenseField;
    }

    /**
     * Setter for defenseField
     *
     * @param defenseField - defenseField
     */
    public void setDefenseField(TextField defenseField) {
        this.defenseField = defenseField;
    }

    /**
     * Getter for toughnessField
     *
     * @return toughnessField
     */
    public TextField getToughnessField() {
        return toughnessField;
    }

    /**
     * Setter for toughnessField
     *
     * @param toughnessField - toughnessField
     */
    public void setToughnessField(TextField toughnessField) {
        this.toughnessField = toughnessField;
    }

    /**
     * Getter for moraleField
     *
     * @return moraleField
     */
    public TextField getMoraleField() {
        return moraleField;
    }

    /**
     * Setter for moraleField
     *
     * @param moraleField - moraleField
     */
    public void setMoraleField(TextField moraleField) {
        this.moraleField = moraleField;
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

    private Button saveButton;
    private TextField nameField;

    //choice boxes
    private ChoiceBox<Type> typeChoiceBox;
    private ChoiceBox<Equipment> equipmentChoiceBox;
    private ChoiceBox<Experience> experienceChoiceBox;
    private ChoiceBox<Integer> sizeChoiceBox;

    //additional modifiers label
    private Label additionalLabel;
    private Label strengthLabel;
    private Label powerLabel;
    private Label defenseLabel ;
    private Label toughnessLabel;
    private Label moraleLabel;

    // additional modifiers Text Fields
    private Label blankLabel;
    private TextField strengthField;
    private TextField powerField;
    private TextField defenseField;
    private TextField toughnessField;
    private TextField moraleField;

    //layouts
    private Scene scene;
    private HBox layout;
    private VBox nameLayout;
    private VBox typeLayout;
    private VBox equipmentLayout;
    private VBox experienceLayout;
    private VBox sizeLayout;
    private VBox modifierLabelsLayout;
    private VBox modifierFieldsLayout;
}
