package war;

public enum Experience {


    GREEN(1, "Green", new int[] {0,0,0,0,0}),
    REGULAR(2, "Regular",  new int[] {1,0,0,1,1}),
    SEASONED(3, "Seasoned",  new int[] {1,0,0,1,2}),
    VETERAN(4, "Veteran",  new int[] {1,0,0,1,3}),
    ELITE(5, "Elite",  new int[] {2,0,0,2,4}),
    SUPER_ELITE(6, "Super-Elite",  new int[] {2,0,0,2,5});



    private int num;
    private String label;
    int [] modifierArray;

    Experience(int num, String label, int [] modifierArray)
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
