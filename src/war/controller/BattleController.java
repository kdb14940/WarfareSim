package war.controller;

import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import war.battle.BattleSimulator;
import war.model.Unit;
import war.view.ArmyChoiceGui;
import war.view.BattleGui;
import war.model.Army;

import java.util.ArrayList;

public class BattleController extends Controller{

    public BattleController(Army army1, Army army2) {
        gui = new BattleGui();
        this.battleGui = (BattleGui)gui;
        this.army1 = army1;
        this.army2 = army2;
        initControllers();

    }

    private void initControllers(){
        battleGui.getSaveButton().setOnAction(e ->{
            //TODO write the changes to file?
            passControl(new ArmyChoiceController(), e);
        });

        battleGui.getNextRoundButton().setOnAction(e ->{
            BattleSimulator.battle(army1, army2);
        });

        battleGui.getExitButton().setOnAction(e ->{
            passControl(new ArmyChoiceController(), e);
        });

        battleGui.getArmy1Table().setArmy(army1);
        battleGui.getArmy2Table().setArmy(army2);
        setChart(army1, army2, battleGui.getBattleChart());

    }

    private void setChart(Army army1, Army army2, BarChart chart){
        chart.setTitle("Power Levels");
        chart.setMaxWidth(250);
        chart.getXAxis().setLabel("Army");
        chart.getYAxis().setLabel("Power");
        XYChart.Series series1 = new XYChart.Series();
        XYChart.Series series2 = new XYChart.Series();
        series1.setName(army1.getName());
        series2.setName(army2.getName());
        series1.getData().add(new XYChart.Data<String,Number>(army1.getName(), army1.getBasePower()));
        series2.getData().add(new XYChart.Data<String,Number>(army2.getName(), army2.getBasePower()));
        chart.getData().addAll(series1,series2);
    }

    /**
     * Getter for battleGui
     *
     * @return battleGui
     */
    public BattleGui getBattleGui() {
        return battleGui;
    }

    /**
     * Setter for battleGui
     *
     * @param battleGui - battleGui
     */
    public void setBattleGui(BattleGui battleGui) {
        this.battleGui = battleGui;
    }

    /**
     * Getter for army1
     *
     * @return army1
     */
    public Army getArmy1() {
        return army1;
    }

    /**
     * Setter for army1
     *
     * @param army1 - army1
     */
    public void setArmy1(Army army1) {
        this.army1 = army1;
    }

    /**
     * Getter for army2
     *
     * @return army2
     */
    public Army getArmy2() {
        return army2;
    }

    /**
     * Setter for army2
     *
     * @param army2 - army2
     */
    public void setArmy2(Army army2) {
        this.army2 = army2;
    }

    private BattleGui battleGui;
    private Army army1;
    private Army army2;
}
