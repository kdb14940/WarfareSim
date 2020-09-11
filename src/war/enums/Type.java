package war.enums;

import java.io.Serializable;

public enum Type implements Serializable {


    FLYING(1, "Flying", new int[] {0,0,0,0,3}, 2),
    ARCHERS(2, "Archers",  new int[] {0,1,0,0,1}, 1.75),
    CAVALRY(3, "Cavalry",  new int[] {1,1,0,0,2}, 1.5),
    LEVIES(4, "Levies",  new int[] {0,0,0,0,-1}, 0.75),
    INFANTRY(5, "Infantry",  new int[] {0,0,1,1,0} , 1),
    SIEGE_ENGINE(6, "Siege Engine",  new int[] {1,1,0,1,0}, 1.5),
    SPECIAL(7, "Special", new int[] {3, 3, 3, 3, 5}, 2.5);



    private int num;
    private String label;
    int [] modifierArray;
    double costModifier;

    Type(int num, String label, int [] modifierArray, double costModifier)
    {
        this.num = num;
        this.label = label;
        this.modifierArray = modifierArray;
        this.costModifier = costModifier;
    }

    // getters
    public double getCostModifier() {
        return costModifier;
    }

    public int getNum() {
        return num;
    }

    public int[] getModifierArray() {
        return modifierArray;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return label;
    }
}
