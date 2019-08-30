package war;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Army {

    String name; // TODO name the army for display
    LinkedList<Unit> units;
    int basePower;                          // power based on amount of units
    //TODO: morale

    public Army(){
        units = new LinkedList<>();
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

    public void addArmmiesFromFile(String filePath) throws FileNotFoundException{
        File inFile = new File(filePath);
        if(!inFile.exists())
        {
            throw new FileNotFoundException();
        }
        Scanner fileReader = new Scanner(inFile);
        name = fileReader.nextLine();
        while(fileReader.hasNextLine())
        {
            Unit tempUnit = new Unit();
            tempUnit.setName(fileReader.nextLine());
            tempUnit.setPower(Integer.parseInt(fileReader.nextLine()));
            units.add(tempUnit);
        }
        updateBasePower();
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

    public void updateBasePower(){
        basePower = 0;
        for(Unit unit : units){
            basePower += unit.getPower();
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
