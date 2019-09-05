package war;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

import static war.Type.*;

public class Army {


    private final String LISTPATH = System.getProperty("user.dir")+"/resources/listOfArmies";
    String name;
    String armyFilePath;
    LinkedList<Unit> units;
    int basePower;                          // power based on amount of units
    //TODO: morale

    public Army(){
        units = new LinkedList<>();
        basePower = 0;
        name = "";
        setFilePath();
        updateBasePower();
    }

    public int getBasePower() {
        return basePower;
    }

    public String getName() {
        return name;
    }

    public String getArmyFilePath(){
        return armyFilePath;
    }

    public LinkedList<Unit> getUnits() {
        return units;
    }

    public void setName(String name) {
        this.name = name;
        setFilePath();
    }

    private void setFilePath(){
        armyFilePath = (System.getProperty("user.dir") + "/resources/" + name);
    }


    //TODO clean this up, make the file readable by humans
    // FIX BUG WITH ADDING MODIFIERS TWICE AFTER INITIAL SAVE
    // DUE TO SAVING THE INFO IN THE ARRAY AND ALSO GETTING THEM ADDED FROM TYPE, ETC
    public void saveArmyToFile() throws IOException{
        File file = new File(armyFilePath);
        if(file.createNewFile()){
            FileWriter listWriter = new FileWriter(LISTPATH,true);
            listWriter.write(name + "\n");
            listWriter.close();
        }
        FileWriter writer = new FileWriter(file);

        writer.write(name + "\n");
        for(Unit unit : units){
            writer.write(unit.getName() + "\n");
            writer.write(unit.getUnitType().getNum() + "\n");
            writer.write(unit.getUnitEquipment().getNum() + "\n");
            writer.write(unit.getUnitExperience().getNum() + "\n");
            writer.write(unit.getSize() + "\n");
            writer.write(unit.getAdditionalBonuses()[0] + "\n");
            writer.write(unit.getAdditionalBonuses()[1] + "\n");
            writer.write(unit.getAdditionalBonuses()[2] + "\n");
            writer.write(unit.getAdditionalBonuses()[3] + "\n");
            writer.write(unit.getAdditionalBonuses()[4] + "\n");
        }
        writer.close();
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
            } else if (unit.getUnitType() == SIEGE_ENGINE && winner) {
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
            } else if (unit.getUnitType() == SIEGE_ENGINE && winner) {
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
            } else if (unit.getUnitType() == SIEGE_ENGINE && winner) {
                totalCasualties += unit.rollSizeDie();
            }
        }
        return totalCasualties;
    }

    public LinkedList<Unit> inflictCasualties(int casualtiesInflicted){
        LinkedList<Unit> deathList = new LinkedList<>();
        while(casualtiesInflicted > 0 ){
            for(int i = 0 ; i < 6; i++){
                for(int j = 0; j < units.size();j++) {

                    if (casualtiesInflicted <= 0) {
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
