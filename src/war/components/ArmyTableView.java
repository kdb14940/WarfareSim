package war.components;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import war.model.Army;
import war.model.Unit;



public class ArmyTableView extends TableView {


    public ArmyTableView(){
        super();
        createColumns();
    }
    public ArmyTableView(Army army) {
        super();
        this.army = army;
        this.obArmy = FXCollections.observableArrayList(army.getUnits());
        createColumns();
        fillTable();
    }

    public void createColumns(){
        nameColumn = new TableColumn<>("Name");
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

        //fillTable();
        //tableView.getColumns().addAll(nameColumn, costColumn);
    }

    public void fillTable(){
        this.getItems().clear();
        //this.obArmy = FXCollections.observableArrayList(army.getUnits());
        this.getItems().addAll(obArmy);
    }
    
    public void addNameColumn(){
        this.getColumns().add(nameColumn);
    }
    
    public void addAttackColumn(){
        this.getColumns().add(attackColumn);
    }
    
    public void addDefenseColumn(){
        this.getColumns().add(defenseColumn);
    }
    
    public void addCostColumn(){
        this.getColumns().add(costColumn);
    }
    
    public void addPowerColumn(){
        this.getColumns().add(powerColumn);
    }
    
    public void addMoraleColumn(){
        this.getColumns().add(moraleColumn);
    }
    
    public void addToughnessColumn(){
        this.getColumns().add(toughnessColumn);
    }

    public void removeNameColumn(){
        this.getColumns().remove(nameColumn);
    }

    public void removeAttackColumn(){
        this.getColumns().remove(attackColumn);
    }

    public void removeDefenseColumn(){
        this.getColumns().remove(defenseColumn);
    }

    public void removeCostColumn(){
        this.getColumns().remove(costColumn);
    }

    public void removePowerColumn(){
        this.getColumns().remove(powerColumn);
    }

    public void removeMoraleColumn(){
        this.getColumns().remove(moraleColumn);
    }

    public void removeToughnessColumn(){
        this.getColumns().remove(toughnessColumn);
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

    private Army army;
    private ObservableList<Unit> obArmy;
    private TableColumn<Unit, String> nameColumn;
    private TableColumn<Unit, Integer> attackColumn;
    private TableColumn<Unit, Integer> powerColumn;
    private TableColumn<Unit, Integer> defenseColumn;
    private TableColumn<Unit, Integer> toughnessColumn;
    private TableColumn<Unit, Integer> moraleColumn;
    private TableColumn<Unit, Integer> sizeColumn;
    private TableColumn<Unit, Integer> costColumn;

}
