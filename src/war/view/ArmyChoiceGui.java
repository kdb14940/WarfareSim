package war.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import war.model.Army;


public class ArmyChoiceGui {


    public ArmyChoiceGui() {
        initComponents();
        layoutComponents();
    }

    private void initComponents(){
        layout = new HBox(10);
        army1Choice = new VBox(20);
        army2Choice = new VBox(20);
        newArmyButton = new Button("New Army");
        continueButton = new Button("Continue");
        exitButton = new Button("Exit");
        army1ComboBox = new ComboBox<>();
        army2ComboBox = new ComboBox<>();
        army1Label = new Label("Army 1");
        army2Label = new Label("Army 2");

        scene = new Scene(layout);
    }

    private void layoutComponents(){
        army1Choice.getChildren().addAll(army1Label, army1ComboBox);
        army2Choice.getChildren().addAll(army2Label, army2ComboBox);
        layout.getChildren().addAll(army1Choice, army2Choice, newArmyButton, continueButton, exitButton);
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
     * Getter for army1Choice
     *
     * @return army1Choice
     */
    public VBox getArmyChoice1() {
        return army1Choice;
    }

    /**
     * Setter for army1Choice
     *
     * @param army1Choice - army1Choice
     */
    public void setArmyChoice1(VBox army1Choice) {
        this.army1Choice = army1Choice;
    }

    /**
     * Getter for army2Choice
     *
     * @return army2Choice
     */
    public VBox getArmyChoice2() {
        return army2Choice;
    }

    /**
     * Setter for army2Choice
     *
     * @param army2Choice - army2Choice
     */
    public void setArmyChoice2(VBox army2Choice) {
        this.army2Choice = army2Choice;
    }

    /**
     * Getter for newArmyButton
     *
     * @return newArmyButton
     */
    public Button getNewArmyButton() {
        return newArmyButton;
    }

    /**
     * Setter for newArmyButton
     *
     * @param newArmyButton - newArmyButton
     */
    public void setNewArmyButton(Button newArmyButton) {
        this.newArmyButton = newArmyButton;
    }

    /**
     * Getter for continueButton
     *
     * @return continueButton
     */
    public Button getContinueButton() {
        return continueButton;
    }

    /**
     * Setter for continueButton
     *
     * @param continueButton - continueButton
     */
    public void setContinueButton(Button continueButton) {
        this.continueButton = continueButton;
    }

    /**
     * Getter for army1ComboBox
     *
     * @return army1ComboBox
     */
    public ComboBox<Army> getArmy1ComboBox() {
        return army1ComboBox;
    }

    /**
     * Setter for army1ComboBox
     *
     * @param army1ComboBox - army1ComboBox
     */
    public void setArmy1ComboBox(ComboBox<Army> army1ComboBox) {
        this.army1ComboBox = army1ComboBox;
    }

    /**
     * Getter for army2ComboBox
     *
     * @return army2ComboBox
     */
    public ComboBox<Army> getArmy2ComboBox() {
        return army2ComboBox;
    }

    /**
     * Setter for army2ComboBox
     *
     * @param army2ComboBox - army2ComboBox
     */
    public void setArmy2ComboBox(ComboBox<Army> army2ComboBox) {
        this.army2ComboBox = army2ComboBox;
    }

    /**
     * Getter for exitButton
     *
     * @return exitButton
     */
    public Button getExitButton() {
        return exitButton;
    }

    /**
     * Setter for exitButton
     *
     * @param exitButton - exitButton
     */
    public void setExitButton(Button exitButton) {
        this.exitButton = exitButton;
    }

    private Scene scene;
    private HBox layout;
    private VBox army1Choice;
    private VBox army2Choice;
    private Button newArmyButton;
    private Button continueButton;
    private Button exitButton;
    private ComboBox<Army> army1ComboBox;
    private ComboBox<Army> army2ComboBox;
    private Label army1Label;
    private Label army2Label;
}
