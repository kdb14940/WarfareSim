package war;

import java.util.Random;

public class Unit {

    private String name;
    private int cost;
    private Type unitType;
    private Equipment unitEquipment;
    private Experience unitExperience;
    private int[] additionalBonuses;

    private int attackBonus;
    private int powerBonus;
    private int defenseBonus;
    private int toughnessBonus;
    private int moraleBonus;

    private int size;

    public Unit(){
        name = "";
        cost = -1;
    }

    public Unit (String name, int power){
        this.name = name;
        this.cost = power;
    }

    public Unit(String name, Type unitType, Equipment unitEquipment, Experience unitExperience, int size, int [] additionalBonuses){
        this.name = name;
        this.unitType = unitType;
        this.unitEquipment = unitEquipment;
        this.unitExperience = unitExperience;
        this.size = size;
        this.additionalBonuses = additionalBonuses;
        calculateAdditionalBonuses(this.unitType.getModifierArray());
        calculateAdditionalBonuses(this.unitEquipment.getModifierArray());
        calculateAdditionalBonuses(this.unitExperience.getModifierArray());
        calculateAdditionalBonuses(additionalBonuses);
        cost = 0;
        calculateCost();
    }


    public void calculateAdditionalBonuses(int [] additionalBonuses){
        if(additionalBonuses.length != 5){
            throw new IllegalArgumentException();
        }
        attackBonus += additionalBonuses[0];
        powerBonus += additionalBonuses[1];
        defenseBonus += additionalBonuses[2];
        toughnessBonus += additionalBonuses[3];
        moraleBonus += additionalBonuses[4];
    }

    /**
     * Calculating Cost :: MCDM forumla
     * add bonus for attack, power, defense, toughness
     * add 2 * bonus for morale
     * Multiply by specified amount according to size
     * Multiply by cost modifier for type
     * multiply by 10
     * add 30
     */
    public void calculateCost(){
        //additions
        cost = 0;
        double doubleCost = 0;
        doubleCost = attackBonus + powerBonus + defenseBonus + toughnessBonus + (2 * moraleBonus);

        //multipliers
        switch(size){
            case 4 : doubleCost *= .66;
                break;
            case 6 : doubleCost *= 1;
                break;
            case 8 : doubleCost *= 1.33;
                break;
            case 10 : doubleCost *= 1.66;
                break;
            case 12 : doubleCost *= 2;
                break;
            default:  System.out.println("Error multiplying size for " + name);
                break;
        }
        doubleCost *= unitType.getCostModifier();
        doubleCost *= 10;
        doubleCost += 30;
        cost = (int) doubleCost;
    }

    public int rollSizeDie(){
        Random rand = new Random();
        return rand.nextInt(size) + 1;
    }

    public String getName() {
        return name;
    }
    public int getCost() {
        return cost;
    }

    public int getAttackBonus() {
        return attackBonus;
    }

    public int getDefenseBonus() {
        return defenseBonus;
    }

    public int getToughnessBonus() {
        return toughnessBonus;
    }

    public int getMoraleBonus() {
        return moraleBonus;
    }

    public int getPowerBonus() {
        return powerBonus;
    }

    public int getSize() {
        return size;
    }

    public Equipment getUnitEquipment() {
        return unitEquipment;
    }

    public Experience getUnitExperience() {
        return unitExperience;
    }

    public Type getUnitType() {
         return unitType;
    }

    public int[] getAdditionalBonuses() {
        return additionalBonuses;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPower(int power) {
        this.cost = power;
    }

    public void setAttackBonus(int attackBonus) {
        this.attackBonus = attackBonus;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setDefenseBonus(int defenseBonus) {
        this.defenseBonus = defenseBonus;
    }

    public void setMoraleBonus(int moraleBonus) {
        this.moraleBonus = moraleBonus;
    }

    public void setPowerBonus(int powerBonus) {
        this.powerBonus = powerBonus;
    }

    public void setToughnessBonus(int toughnessBonus) {
        this.toughnessBonus = toughnessBonus;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setUnitEquipment(Equipment unitEquipment) {
        this.unitEquipment = unitEquipment;
    }

    public void setUnitExperience(Experience unitExperience) {
        this.unitExperience = unitExperience;
    }

    public void setUnitType(Type unitType) {
        this.unitType = unitType;
    }

    public void setAdditionalBonuses(int[] additionalBonuses) {
        this.additionalBonuses = additionalBonuses;
    }

    public String toString(){
        return name;
    }
}
