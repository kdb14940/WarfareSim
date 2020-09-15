package war.controller;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import war.model.Unit;
import war.view.BattleGui;
import war.model.Army;

import java.util.ArrayList;

public class BattleController {

    public BattleController(Army army1, Army army2) {
        this.battleGui = new BattleGui();
        this.army1 = army1;
        this.army2 = army2;
        initControllers();

    }

    private void initControllers(){
        battleGui.getSaveButton().setOnAction(e ->{

        });

        battleGui.getNextRoundButton().setOnAction(e ->{

        });
        displayArmyTable(army1, battleGui.getArmy1Table());
        displayArmyTable(army2, battleGui.getArmy2Table());
        setChart(army1, army2, battleGui.getBattleChart());

    }

    private void displayArmyTable(Army army, TableView<Unit> tableView){
        //columns
        TableColumn<Unit, String> nameColumn = new TableColumn<>("Name");
        //TableColumn<Unit, Integer> attackColumn = new TableColumn<>("Attack");
        //TableColumn<Unit, Integer> powerColumn = new TableColumn<>("Power");
        //TableColumn<Unit, Integer> defenseColumn = new TableColumn<>("Defense");
        //TableColumn<Unit, Integer> toughnessColumn = new TableColumn<>("Toughness");
        //TableColumn<Unit, Integer> moraleColumn = new TableColumn<>("Morale");
        //TableColumn<Unit, Integer> sizeColumn = new TableColumn<>("Size");
        TableColumn<Unit, Integer> costColumn = new TableColumn<>("Cost");

        nameColumn.setMinWidth(200);
        //attackColumn.setMinWidth(20);
        //powerColumn.setMinWidth(20);
        //defenseColumn.setMinWidth(20);
        //toughnessColumn.setMinWidth(20);
        //moraleColumn.setMinWidth(20);
        //sizeColumn.setMinWidth(20);
        costColumn.setMinWidth(20);

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        //attackColumn.setCellValueFactory(new PropertyValueFactory<>("attackBonus"));
        //powerColumn.setCellValueFactory(new PropertyValueFactory<>("powerBonus"));
        //defenseColumn.setCellValueFactory(new PropertyValueFactory<>("defenseBonus"));
        //toughnessColumn.setCellValueFactory(new PropertyValueFactory<>("toughnessBonus"));
        //moraleColumn.setCellValueFactory(new PropertyValueFactory<>("moraleBonus"));
        //sizeColumn.setCellValueFactory(new PropertyValueFactory<>("size"));
        costColumn.setCellValueFactory(new PropertyValueFactory<>("cost"));

        updateArmyTable(army, tableView);
        tableView.getColumns().addAll(nameColumn, costColumn);

    }

    private void updateArmyTable(Army army, TableView<Unit> tableView){
        tableView.getItems().clear();
        ArrayList<Unit> unitList = army.getUnits();
        for(Unit unit : unitList){
            tableView.getItems().add(unit);
        }
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
