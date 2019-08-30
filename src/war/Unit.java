package war;

public class Unit {

    private String name;
    private int power;
    // TODO: Type, flying. archers, levies... make ENUM
    public Unit(){
        name = "";
        power = -1;
    }

    public Unit (String name, int power){
        this.name = name;
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String toString(){
        return name;
    }
}
