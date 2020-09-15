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


    private final String LISTPATH = System.getProperty("user.dir")+"/resources/listOfArmies";
    private String name;
    ArrayList<Unit> units;
    int basePower;                          // power based on amount of units


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


    public void addArmiesFromFile(String filePath) throws FileNotFoundException{
        File inFile = new File(filePath);
        if(!inFile.exists())
        {
            throw new FileNotFoundException();
        }
        Scanner fileReader = new Scanner(inFile);
        setName(fileReader.nextLine());
        while(fileReader.hasNextLine())
        {
            String tempName;
            int typeNum, equipNum, expNum;
            Type tempType;
            Equipment tempEquipment;
            Experience tempExperience;
            int tempSize;
            int [] tempModifierArray = new int[5];
            //TODO integer input validation
                tempName = fileReader.nextLine();
                typeNum = Integer.parseInt(fileReader.nextLine());
                equipNum = Integer.parseInt(fileReader.nextLine());
                expNum = Integer.parseInt(fileReader.nextLine());
                tempSize = Integer.parseInt(fileReader.nextLine());
                tempModifierArray[0] = Integer.parseInt(fileReader.nextLine());
                tempModifierArray[1] = Integer.parseInt(fileReader.nextLine());
                tempModifierArray[2] = Integer.parseInt(fileReader.nextLine());
                tempModifierArray[3] = Integer.parseInt(fileReader.nextLine());
                tempModifierArray[4] = Integer.parseInt(fileReader.nextLine());

            switch(typeNum){
                case 1 :    tempType = FLYING;
                    break;
                case 2 :    tempType = ARCHERS;
                    break;
                case 3 :    tempType = CAVALRY;
                    break;
                case 4 :    tempType = LEVIES;
                    break;
                case 5 :    tempType = INFANTRY;
                    break;
                case 6 :    tempType = SIEGE_ENGINE;
                    break;
                case 7 :    tempType = SPECIAL;
                    break;
                default:    tempType = LEVIES;
                    break;
            }
            switch(equipNum){
                case 1 : tempEquipment = Equipment.LIGHT;
                    break;
                case 2 : tempEquipment = Equipment.MEDIUM;
                    break;
                case 3 : tempEquipment = Equipment.HEAVY;
                    break;
                case 4 : tempEquipment = Equipment.SUPER_HEAVY;
                    break;
                default : tempEquipment = Equipment.LIGHT;
                    break;
            }
            switch(expNum){
                case 1 : tempExperience = Experience.GREEN;
                    break;
                case 2 : tempExperience = Experience.REGULAR;
                    break;
                case 3 : tempExperience = Experience.SEASONED;
                    break;
                case 4 : tempExperience = Experience.VETERAN;
                    break;
                case 5 : tempExperience = Experience.ELITE;
                    break;
                case 6 : tempExperience = Experience.SUPER_ELITE;
                    break;
                default: tempExperience = Experience.GREEN;
                    break;
            }
            Unit tempUnit = new Unit(tempName, tempType, tempEquipment, tempExperience, tempSize, tempModifierArray);
            units.add(tempUnit);
        }
        updateBasePower();
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


}
