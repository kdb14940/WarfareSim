package war.model;

import war.enums.Equipment;
import war.enums.Experience;
import war.enums.Type;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import static war.enums.Type.*;

public class Army implements Serializable {

    public Army(){
        units = new ArrayList<>();
        basePower = 0;
        name = "";
        updateBasePower();
    }

    public int getBasePower() {
        return basePower;
    }

    public String getName() {
        return name;
    }


    public ArrayList<Unit> getUnits() {
        return units;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getPyrrhicCasualties(boolean winner){
        int totalCasualties = 0;
        for(Unit unit : units){
            if(unit.getUnitType() == Type.LEVIES){
                totalCasualties += unit.rollSizeDie();
            }
            else if(unit.getUnitType() == INFANTRY && winner){
                totalCasualties += unit.rollSizeDie();
            }
        }
        return totalCasualties;
    }

    public int getMinorCasualties(boolean winner){
        int totalCasualties = 0;
        for(Unit unit : units){
            if(unit.getUnitType() == Type.LEVIES && winner){
                totalCasualties += unit.rollSizeDie();
            }
            else if(unit.getUnitType() == INFANTRY ){
                totalCasualties += unit.rollSizeDie();
            }
            else if(unit.getUnitType() == ARCHERS ){
                totalCasualties += unit.rollSizeDie();
            }
        }
        return totalCasualties;
    }

    public int getClearCasualties(boolean winner) {
        int totalCasualties = 0;
        for (Unit unit : units) {
            if (unit.getUnitType() == Type.LEVIES && winner) {
                totalCasualties += unit.rollSizeDie();
            } else if (unit.getUnitType() == INFANTRY && winner) {
                totalCasualties += unit.rollSizeDie();
            } else if (unit.getUnitType() == ARCHERS) {
                totalCasualties += unit.rollSizeDie();
            } else if (unit.getUnitType() == Type.CAVALRY) {
                totalCasualties += unit.rollSizeDie();
            } else if (unit.getUnitType() == FLYING) {
                totalCasualties += unit.rollSizeDie();
            } else if ((unit.getUnitType() == SIEGE_ENGINE || unit.getUnitType() == SPECIAL) && winner) {
                totalCasualties += unit.rollSizeDie();
            }
        }
        return totalCasualties;
    }

    public int getMajorCasualties(boolean winner) {
        int totalCasualties = 0;
        for (Unit unit : units) {
            if (unit.getUnitType() == Type.LEVIES && winner) {
                totalCasualties += unit.rollSizeDie();
            } else if (unit.getUnitType() == INFANTRY && winner) {
                totalCasualties += unit.rollSizeDie();
            } else if (unit.getUnitType() == ARCHERS && winner) {
                totalCasualties += unit.rollSizeDie();
                totalCasualties += unit.rollSizeDie();
            } else if (unit.getUnitType() == ARCHERS && !winner){
                totalCasualties += unit.rollSizeDie();
            } else if (unit.getUnitType() == Type.CAVALRY && winner) {
                totalCasualties += unit.rollSizeDie();
            } else if (unit.getUnitType() == FLYING && winner) {
                totalCasualties += unit.rollSizeDie();
            } else if ((unit.getUnitType() == SIEGE_ENGINE || unit.getUnitType() == SPECIAL) && winner) {
                totalCasualties += unit.rollSizeDie();
            }
        }
        return totalCasualties;
    }

    public int getRoutCasualties(boolean winner) {
        int totalCasualties = 0;
        for (Unit unit : units) {
            if (unit.getUnitType() == Type.LEVIES && winner) {
                totalCasualties += unit.rollSizeDie();
                totalCasualties += unit.rollSizeDie();
            } else if (unit.getUnitType() == INFANTRY && winner) {
                totalCasualties += unit.rollSizeDie();
                totalCasualties += unit.rollSizeDie();
            } else if (unit.getUnitType() == ARCHERS && winner) {
                totalCasualties += unit.rollSizeDie();
                totalCasualties += unit.rollSizeDie();
            } else if (unit.getUnitType() == Type.CAVALRY ) {
                totalCasualties += unit.rollSizeDie();
            } else if (unit.getUnitType() == FLYING ) {
                totalCasualties += unit.rollSizeDie();
            } else if ((unit.getUnitType() == SIEGE_ENGINE || unit.getUnitType() == SPECIAL) && winner) {
                totalCasualties += unit.rollSizeDie();
            }
        }
        return totalCasualties;
    }

    public LinkedList<Unit> inflictCasualties(int casualtiesInflicted){
        LinkedList<Unit> deathList = new LinkedList<>();
        while(casualtiesInflicted > 0 && units.size() > 0 ){
            for(int i = 0 ; i < 7; i++){
                for(int j = 0; j < units.size();j++) {

                    if (casualtiesInflicted <= 0 && j >= 0) {
                        break;
                    } else {
                        if(i == 0 && units.get(j).getUnitType() == LEVIES)
                        {
                            casualtiesInflicted -= units.get(j).getSize();
                            deathList.add(units.get(j));
                            removeUnit(j);
                            j--;
                        }
                        else if(i == 1 && units.get(j).getUnitType() == INFANTRY)
                        {
                            casualtiesInflicted -= units.get(j).getSize();
                            deathList.add(units.get(j));
                            removeUnit(j);
                            j--;
                        }
                        else if(i == 2 && units.get(j).getUnitType() == ARCHERS)
                        {
                            casualtiesInflicted -= units.get(j).getSize();
                            deathList.add(units.get(j));
                            removeUnit(j);
                            j--;
                        }
                        else if(i == 3 && units.get(j).getUnitType() == CAVALRY)
                        {
                            casualtiesInflicted -= units.get(j).getSize();
                            deathList.add(units.get(j));
                            removeUnit(j);
                            j--;
                        }
                        else if(i ==4 && units.get(j).getUnitType() == FLYING)
                        {
                            casualtiesInflicted -= units.get(j).getSize();
                            deathList.add(units.get(j));
                            removeUnit(j);
                            j--;
                        }
                        else if(i == 5 && units.get(j).getUnitType() == SIEGE_ENGINE)
                        {
                            casualtiesInflicted -= units.get(j).getSize();
                            deathList.add(units.get(j));
                            removeUnit(j);
                            j--;
                        }
                        else if (i == 6 && units.get(j).getUnitType() == SPECIAL){
                            casualtiesInflicted -= units.get(j).getSize();
                            deathList.add(units.get(j));
                            removeUnit(j);
                            j--;
                        }
                    }
                }
            }
        }
        return deathList;
    }

    public void addUnit(Unit tempUnit){
        units.add(tempUnit);
        updateBasePower();
    }

    public void removeUnit(Unit tempUnit){
        units.remove(tempUnit);
        updateBasePower();
    }

    public void removeUnit(int index) {
        if(index < 0 || index >= units.size()){
            throw new IndexOutOfBoundsException();
        }
        units.remove(index);
        updateBasePower();
    }

    public String getNameAtIndex(int index){
        if(index < 0 || index >= units.size()){
            throw new IndexOutOfBoundsException();
        }
        return units.get(index).getName();
    }

    public Unit getUnitAtIndex(int index){
        if(index < 0 || index >= units.size()){
            throw new IndexOutOfBoundsException();
        }
        return units.get(index);
    }


    public void updateBasePower(){
        basePower = 0;
        for(Unit unit : units){
            basePower += unit.getCost();
        }
    }

    public int size(){
        return units.size();
    }


    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append(name + "\n");
        for(Unit unit : units){
            str.append(unit + "\n");
        }
        return str.toString();
    }

    private String name;
    private ArrayList<Unit> units;
    private int basePower;                          // power based on amount of units

}
