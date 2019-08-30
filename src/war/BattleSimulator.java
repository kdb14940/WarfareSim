package war;

import java.util.Random;
import java.util.Scanner;

public class BattleSimulator {



    public static void main(String [] args)
    {
        Army kingsford = new Army();
        Army dust = new Army();

        Scanner input = new Scanner(System.in);
        boolean cont = true;
        try {
            kingsford.addArmmiesFromFile("resources/kingsford");
            dust.addArmmiesFromFile("resources/dust");
        }
        catch(Exception e)
        {
            System.out.println("File not found");
        }
        while(cont){
            battle(kingsford, dust);
            displayArmy(kingsford);
            displayArmy(dust);
            System.out.println("Continue Battle (y/n)");
            String ans = input.nextLine();
            if(ans.equals("n"))
            {
                cont = false;
            }
        }
    }


    public static void battle(Army army1, Army army2){
        Random rand = new Random();
        int army1Advantage = 0;
        int army2Advantage = 0;
        // apply force advantage
        army1Advantage += applyForceAdvantage(army1, army2);
        army2Advantage += applyForceAdvantage(army2, army1);
        // apply strategic advantage
        army1Advantage += applyStrategicAdvantages( 0 );
        army2Advantage += applyStrategicAdvantages( 0 );
        int roll1 = rand.nextInt(99) + 1 + army1Advantage;
        int roll2 = rand.nextInt(99) + 1 + army2Advantage;

        calculateCasualties(roll1, roll2, army1, army2);
    }

    public static void displayArmy(Army army){
        System.out.println(army);
    }

    public static int applyStrategicAdvantages(int advantage){
        return advantage;
    }

    public static int applyForceAdvantage(Army primary, Army secondary){
        if(primary.getBasePower() <= secondary.getBasePower()){
            return 0;
        }
        else{
            int powerDifference = primary.getBasePower() - secondary.getBasePower();
            double forceAdvantage = (double)powerDifference / (double)primary.getBasePower();
            return (int)forceAdvantage;
        }
    }

    public static void calculateCasualties(int total1, int total2, Army army1, Army army2){
            if(total1 > total2){
                int lossTotal = total1 - total2;
                applyCasualties(army2, lossTotal, army1.size());
            }
            else if(total2> total1)
            {
                int lossTotal = total2 - total1;
                applyCasualties(army1, lossTotal, army2.size());
            }

    }

    private static void applyCasualties(Army army, int lossTotal, int opposingSize){
        Random rand = new Random();
        for(int i = 0; i < opposingSize; i++)
        {
            if(army.size() <= 0)
                return;
            int index = rand.nextInt(army.size());
            int deathRoll = rand.nextInt(99) + 1;

            if(lossTotal <= 10){
                //do nothing... no casualties inflicted
            } else if(lossTotal <= 40){
                if(deathRoll < 20)
                {
                    System.out.println(army.getNameAtIndex(index) + " was killed!");
                    army.removeUnit(index);
                }

            }else if(lossTotal <= 70){
                if(deathRoll < 35)
                {
                    System.out.println(army.getNameAtIndex(index) + " was killed!");
                    army.removeUnit(index);
                }
            }else if(lossTotal <= 100){
                if(deathRoll < 50)
                {
                    System.out.println(army.getNameAtIndex(index) + " was killed!");
                    army.removeUnit(index);
                }

            }else{
                if(deathRoll < lossTotal / 2){
                    System.out.println(army.getNameAtIndex(index) + " was killed!");
                    army.removeUnit(index);
                }
            }
        }

    }
}
