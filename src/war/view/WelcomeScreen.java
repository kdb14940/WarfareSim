package war.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class WelcomeScreen {


    public WelcomeScreen() {
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
        army1ChoiceBox = new ChoiceBox<>();
        army2ChoiceBox = new ChoiceBox<>();
        army1Label = new Label("Army 1");
        army2Label = new Label("Army 2");

        scene = new Scene(layout);
    }

    private void layoutComponents(){
        army1Choice.getChildren().addAll(army1Label, army1ChoiceBox);
        army2Choice.getChildren().addAll(army2Label, army2ChoiceBox);
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
     * Getter for army1ChoiceBox
     *
     * @return army1ChoiceBox
     */
    public ChoiceBox<String> getArmy1ChoiceBox() {
        return army1ChoiceBox;
    }

    /**
     * Setter for army1ChoiceBox
     *
     * @param army1ChoiceBox - army1ChoiceBox
     */
    public void setArmy1ChoiceBox(ChoiceBox<String> army1ChoiceBox) {
        this.army1ChoiceBox = army1ChoiceBox;
    }

    /**
     * Getter for army2ChoiceBox
     *
     * @return army2ChoiceBox
     */
    public ChoiceBox<String> getArmy2ChoiceBox() {
        return army2ChoiceBox;
    }

    /**
     * Setter for army2ChoiceBox
     *
     * @param army2ChoiceBox - army2ChoiceBox
     */
    public void setArmy2ChoiceBox(ChoiceBox<String> army2ChoiceBox) {
        this.army2ChoiceBox = army2ChoiceBox;
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
    private ChoiceBox<String> army1ChoiceBox;
    private ChoiceBox<String> army2ChoiceBox;
    private Label army1Label;
    private Label army2Label;
}
