package war.components;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import war.model.Army;
import war.model.Unit;

import java.util.ArrayList;


public class ArmyTableView extends TableView {


    public ArmyTableView(){
        super();
        this.setColumnResizePolicy(CONSTRAINED_RESIZE_POLICY);
        createColumns();
    }
    public ArmyTableView(Army army) {
        super();
        this.army = army;
        this.obArmy = FXCollections.observableArrayList(army.getUnits());
        this.setColumnResizePolicy(CONSTRAINED_RESIZE_POLICY);
        createColumns();
        fillTable();
    }

    /**
    public void createRows(){
        setRowFactory( e->{
            TableRow<Unit> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                selectedUnit = row.getItem();
            });
            return row ;
        });
    }
     */

    public void createColumns(){
        titleColumn = new TableColumn<>();
        nameColumn = new TableColumn<>("Unit Name");
        attackColumn = new TableColumn<>("Attack");
        powerColumn = new TableColumn<>("Power");
        defenseColumn = new TableColumn<>("Defense");
        toughnessColumn = new TableColumn<>("Toughness");
        moraleColumn = new TableColumn<>("Morale");
        sizeColumn = new TableColumn<>("Size");
        costColumn = new TableColumn<>("Cost");

        nameColumn.setMinWidth(200);
        attackColumn.setMinWidth(20);
        powerColumn.setMinWidth(20);
        defenseColumn.setMinWidth(20);
        toughnessColumn.setMinWidth(20);
        moraleColumn.setMinWidth(20);
        sizeColumn.setMinWidth(20);
        costColumn.setMinWidth(20);

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        attackColumn.setCellValueFactory(new PropertyValueFactory<>("attackBonus"));
        powerColumn.setCellValueFactory(new PropertyValueFactory<>("powerBonus"));
        defenseColumn.setCellValueFactory(new PropertyValueFactory<>("defenseBonus"));
        toughnessColumn.setCellValueFactory(new PropertyValueFactory<>("toughnessBonus"));
        moraleColumn.setCellValueFactory(new PropertyValueFactory<>("moraleBonus"));
        sizeColumn.setCellValueFactory(new PropertyValueFactory<>("size"));
        costColumn.setCellValueFactory(new PropertyValueFactory<>("cost"));
        
        this.getColumns().add(titleColumn);
    }

    public void fillTable(){
        this.getItems().clear();
        //this.obArmy = FXCollections.observableArrayList(army.getUnits());
        this.getItems().addAll(obArmy);
    }
    
    public void addNameColumn(){
        titleColumn.getColumns().add(nameColumn);
    }
    
    public void addAttackColumn(){
        titleColumn.getColumns().add(attackColumn);
    }
    
    public void addDefenseColumn(){
        titleColumn.getColumns().add(defenseColumn);
    }
    
    public void addCostColumn(){
        titleColumn.getColumns().add(costColumn);
    }
    
    public void addPowerColumn(){
        titleColumn.getColumns().add(powerColumn);
    }
    
    public void addMoraleColumn(){
        titleColumn.getColumns().add(moraleColumn);
    }
    
    public void addToughnessColumn(){
        titleColumn.getColumns().add(toughnessColumn);
    }

    public void removeNameColumn(){
        titleColumn.getColumns().remove(nameColumn);
    }

    public void removeAttackColumn(){
        titleColumn.getColumns().remove(attackColumn);
    }

    public void removeDefenseColumn(){
        titleColumn.getColumns().remove(defenseColumn);
    }

    public void removeCostColumn(){
        titleColumn.getColumns().remove(costColumn);
    }

    public void removePowerColumn(){
        titleColumn.getColumns().remove(powerColumn);
    }

    public void removeMoraleColumn(){
        titleColumn.getColumns().remove(moraleColumn);
    }

    public void removeToughnessColumn(){
        titleColumn.getColumns().remove(toughnessColumn);
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
        this.obArmy = FXCollections.observableArrayList(army.getUnits());
        fillTable();
        titleColumn.setText(army.getName());
    }

    /**
     * Getter for obArmy
     *
     * @return obArmy
     */
    public ObservableList<Unit> getObArmy() {
        return obArmy;
    }

    /**
     * Setter for obArmy
     *
     * @param obArmy - obArmy
     */
    public void setObArmy(ObservableList<Unit> obArmy) {
        this.obArmy = obArmy;
    }

    /**
     * Getter for nameColumn
     *
     * @return nameColumn
     */
    public TableColumn<Unit, String> getNameColumn() {
        return nameColumn;
    }

    /**
     * Setter for nameColumn
     *
     * @param nameColumn - nameColumn
     */
    public void setNameColumn(TableColumn<Unit, String> nameColumn) {
        this.nameColumn = nameColumn;
    }

    /**
     * Getter for attackColumn
     *
     * @return attackColumn
     */
    public TableColumn<Unit, Integer> getAttackColumn() {
        return attackColumn;
    }

    /**
     * Setter for attackColumn
     *
     * @param attackColumn - attackColumn
     */
    public void setAttackColumn(TableColumn<Unit, Integer> attackColumn) {
        this.attackColumn = attackColumn;
    }

    /**
     * Getter for powerColumn
     *
     * @return powerColumn
     */
    public TableColumn<Unit, Integer> getPowerColumn() {
        return powerColumn;
    }

    /**
     * Setter for powerColumn
     *
     * @param powerColumn - powerColumn
     */
    public void setPowerColumn(TableColumn<Unit, Integer> powerColumn) {
        this.powerColumn = powerColumn;
    }

    /**
     * Getter for defenseColumn
     *
     * @return defenseColumn
     */
    public TableColumn<Unit, Integer> getDefenseColumn() {
        return defenseColumn;
    }

    /**
     * Setter for defenseColumn
     *
     * @param defenseColumn - defenseColumn
     */
    public void setDefenseColumn(TableColumn<Unit, Integer> defenseColumn) {
        this.defenseColumn = defenseColumn;
    }

    /**
     * Getter for toughnessColumn
     *
     * @return toughnessColumn
     */
    public TableColumn<Unit, Integer> getToughnessColumn() {
        return toughnessColumn;
    }

    /**
     * Setter for toughnessColumn
     *
     * @param toughnessColumn - toughnessColumn
     */
    public void setToughnessColumn(TableColumn<Unit, Integer> toughnessColumn) {
        this.toughnessColumn = toughnessColumn;
    }

    /**
     * Getter for moraleColumn
     *
     * @return moraleColumn
     */
    public TableColumn<Unit, Integer> getMoraleColumn() {
        return moraleColumn;
    }

    /**
     * Setter for moraleColumn
     *
     * @param moraleColumn - moraleColumn
     */
    public void setMoraleColumn(TableColumn<Unit, Integer> moraleColumn) {
        this.moraleColumn = moraleColumn;
    }

    /**
     * Getter for sizeColumn
     *
     * @return sizeColumn
     */
    public TableColumn<Unit, Integer> getSizeColumn() {
        return sizeColumn;
    }

    /**
     * Setter for sizeColumn
     *
     * @param sizeColumn - sizeColumn
     */
    public void setSizeColumn(TableColumn<Unit, Integer> sizeColumn) {
        this.sizeColumn = sizeColumn;
    }

    /**
     * Getter for costColumn
     *
     * @return costColumn
     */
    public TableColumn<Unit, Integer> getCostColumn() {
        return costColumn;
    }

    /**
     * Setter for costColumn
     *
     * @param costColumn - costColumn
     */
    public void setCostColumn(TableColumn<Unit, Integer> costColumn) {
        this.costColumn = costColumn;
    }

    /**
     * Getter for selectedUnit
     *
     * @return selectedUnit
     */
    public Unit getSelectedUnit() {
        return selectedUnit;
    }

    /**
     * Setter for selectedUnit
     *
     * @param selectedUnit - selectedUnit
     */
    public void setSelectedUnit(Unit selectedUnit) {
        this.selectedUnit = selectedUnit;
    }

    public void setUnits(ArrayList<Unit> units){
        this.obArmy = FXCollections.observableArrayList(units);
        fillTable();
        titleColumn.setText("Reserves");
    }

    private Army army;
    private Unit selectedUnit;
    private ObservableList<Unit> obArmy;
    private TableColumn<Unit, String> nameColumn;
    private TableColumn<Unit, Integer> attackColumn;
    private TableColumn<Unit, Integer> powerColumn;
    private TableColumn<Unit, Integer> defenseColumn;
    private TableColumn<Unit, Integer> toughnessColumn;
    private TableColumn<Unit, Integer> moraleColumn;
    private TableColumn<Unit, Integer> sizeColumn;
    private TableColumn<Unit, Integer> costColumn;
    private TableColumn<Unit, String> titleColumn;

}
