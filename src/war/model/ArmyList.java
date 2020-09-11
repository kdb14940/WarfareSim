package war.model;

import java.io.Serializable;
import java.util.ArrayList;

public class ArmyList implements Serializable {

    public ArmyList() {
        armyList = new ArrayList<>();
    }

    public void addArmy(Army army){
        armyList.add(army);
    }

    /**
     * Getter for armyList
     *
     * @return armyList
     */
    public ArrayList<Army> getArmyList() {
        return armyList;
    }

    /**
     * Setter for armyList
     *
     * @param armyList - armyList
     */
    public void setArmyList(ArrayList<Army> armyList) {
        this.armyList = armyList;
    }

    private ArrayList<Army> armyList;
}
