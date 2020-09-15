package war.view;

import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import war.components.ArmyTableView;
import war.model.Unit;

public class BattleGui {

    public BattleGui(){
        initComponents();
        layoutComponents();
    }

    private void initComponents(){
        saveButton = new Button("Save");
        nextRoundButton = new Button("Next Round");
        army1Table = new ArmyTableView();
        army2Table = new ArmyTableView();
        setTableColumns(army1Table);
        setTableColumns(army2Table);

        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        battleChart = new BarChart(xAxis,yAxis);

        hLayout = new HBox(20);
        buttonLayout = new VBox(10);

        scene = new Scene(hLayout, 800, 600);
    }

    private void layoutComponents(){
        buttonLayout.getChildren().addAll(nextRoundButton,saveButton);
        hLayout.getChildren().addAll(army1Table, army2Table, battleChart, buttonLayout);
    }

    private void setTableColumns(ArmyTableView table){
        table.addNameColumn();
        table.addCostColumn();
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
     * Getter for nextRoundButton
     *
     * @return nextRoundButton
     */
    public Button getNextRoundButton() {
        return nextRoundButton;
    }

    /**
     * Setter for nextRoundButton
     *
     * @param nextRoundButton - nextRoundButton
     */
    public void setNextRoundButton(Button nextRoundButton) {
        this.nextRoundButton = nextRoundButton;
    }

    /**
     * Getter for army1Table
     *
     * @return army1Table
     */
    public ArmyTableView getArmy1Table() {
        return army1Table;
    }

    /**
     * Setter for army1Table
     *
     * @param army1Table - army1Table
     */
    public void setArmy1Table(ArmyTableView army1Table) {
        this.army1Table = army1Table;
    }

    /**
     * Getter for army2Table
     *
     * @return army2Table
     */
    public ArmyTableView getArmy2Table() {
        return army2Table;
    }

    /**
     * Setter for army2Table
     *
     * @param army2Table - army2Table
     */
    public void setArmy2Table(ArmyTableView army2Table) {
        this.army2Table = army2Table;
    }

    /**
     * Getter for battleChart
     *
     * @return battleChart
     */
    public BarChart<String, Number> getBattleChart() {
        return battleChart;
    }

    /**
     * Setter for battleChart
     *
     * @param battleChart - battleChart
     */
    public void setBattleChart(BarChart<String, Number> battleChart) {
        this.battleChart = battleChart;
    }

    private Scene scene;
    private Button saveButton;
    private Button nextRoundButton;
    private ArmyTableView army1Table;
    private ArmyTableView army2Table;
    private BarChart<String, Number> battleChart;


    //layouts
    private HBox hLayout;
    private VBox buttonLayout;

}
