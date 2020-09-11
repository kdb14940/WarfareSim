package war.enums;

import java.io.Serializable;
import java.security.SecureRandom;

public enum Equipment implements Serializable {


    LIGHT(1, "Light", new int[] {0,1,1,0,0}),
    MEDIUM(2, "Medium",  new int[] {0,2,2,0,0}),
    HEAVY(3, "Heavy",  new int[] {0,4,4,0,0}),
    SUPER_HEAVY(4, "Super-Heavy",  new int[] {0,6,6,0,0});



    private int num;
    private String label;
    int [] modifierArray;

    Equipment(int num, String label, int [] modifierArray)
    {
        this.num = num;
        this.label = label;
        this.modifierArray = modifierArray;
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
