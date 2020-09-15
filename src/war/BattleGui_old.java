package war;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import war.model.Army;
import war.model.Unit;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;


public class BattleGui_old extends Application{

    private final String LISTPATH = System.getProperty("user.dir")+"/resources/listOfArmies"; // gets the path of the resources folder
    private Stage window;
    private Scene welcomeScene, battleScene, advantageScene;
    private Army army1;
    private Army army2;
    private int stratAdvantage1 = 0;            // strategic advantage for army 1
    private int stratAdvantage2 = 0;            // strategic advantage for army 2
    private ListView<Unit> deathList;
    private LinkedList<String> loadedChoices;
    private Label winnerLabel, army1Casualties, army2Casualties;

    public static void main(String[] args){
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;

        army1 = new Army();
        army2 = new Army();
        welcomeScreen();

    }


    /**
     * Welcome Screen - used to pick armies or create a new one
     */
    private void welcomeScreen(){

        loadedChoices = new LinkedList<>();
        VBox army1Choices = new VBox(20);
        VBox army2Choices = new VBox(20);
        Button continueButton = new Button("Continue");

        Button newArmy = new Button ("Create New Army");
        Label army1Label = new Label("Army 1");
        Label army2Label = new Label("Army 2");

        //Choiceboxes
        ChoiceBox<String> army1Choicebox = new ChoiceBox<>();
        ChoiceBox<String> army2Choicebox = new ChoiceBox<>();
        try {
            loadedChoices = loadArmyChoices();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Armies list not found!");
        }
        for(String name : loadedChoices){
            army1Choicebox.getItems().add(name);
            army2Choicebox.getItems().add(name);
        }

        army1Choices.getChildren().addAll(army1Label, army1Choicebox);
        army2Choices.getChildren().addAll(army2Label, army2Choicebox);

        HBox welcomeLayout = new HBox(10);
        welcomeLayout.getChildren().addAll(army1Choices, army2Choices, newArmy, continueButton);
        welcomeScene = new Scene(welcomeLayout, 800, 600);

        continueButton.setOnAction(e -> {
        });

        // button for creating a new army
        newArmy.setOnAction(e->{
            // get new army from NewArmyGUI
            Army tempArmy = NewArmyGui.display();
            /**
            try {
                tempArmy.saveArmyToFile();
            }
            catch(IOException err){
                System.out.println("Error writing army to file");
            }
             */
            // Reset army choice box options before going back to previos Scene
            try {
                loadedChoices = loadArmyChoices();
            }
            catch(FileNotFoundException err)
            {
                System.out.println("Armies list not found!");
            }
            //clear choice boxes
            army1Choicebox.getItems().clear();
            army2Choicebox.getItems().clear();
            //refill choice boxes
            for(String name : loadedChoices){
                army1Choicebox.getItems().add(name);
                army2Choicebox.getItems().add(name);
            }
            window.setScene(welcomeScene);
        });

        window.setScene(welcomeScene);
        window.show();
    }

    /**
     * Screen for the battle simulation
     */
    private void battle(){
        //buttons
        Button nextButton = new Button("Next Round");
        Button advantageButton = new Button("Advantages");
        Button editButton1 = new Button("Edit " + army1.getName());
        Button editButton2 = new Button("Edit " + army2.getName());

        // layouts
        VBox layout1 = new VBox();
        VBox layout2 = new VBox();
        VBox layout3 = new VBox();
        VBox buttons = new VBox();
        deathList = new ListView<>();
        winnerLabel = new Label();
        army1Casualties = new Label();
        army2Casualties = new Label();

        Label deathLabel = new Label("Deaths");
        buttons.getChildren().addAll(nextButton, advantageButton, editButton1, editButton2);
        layout3.getChildren().addAll(deathLabel, deathList);

        //create bar chart
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        BarChart<String, Number> chart = new BarChart(xAxis,yAxis);
        setChart(army1,army2,chart);

        displayArmy(army1,layout1);
        displayArmy(army2,layout2);

        // button for advatnages. Opens Advantage Scene
        advantageButton.setOnAction(
                e -> {
                    applyStrategicAdvantage();
                });

        // button for editing army 1
        editButton1.setOnAction(e->{
            //EditArmyGui.display(army1);
            displayArmy(army1,layout1);
        });

        // button for editing army 2
        editButton2.setOnAction(e->{
           // EditArmyGui.display(army2);
            displayArmy(army2,layout2);
        });

        // button for going to next round
        nextButton.setOnAction(e -> {
            deathList.getItems().clear();
            chart.getData().clear();
            battle(army1,army2);
            stratAdvantage1 = 0;
            stratAdvantage2 = 0;
            displayArmy(army1,layout1);
            displayArmy(army2,layout2);
            setChart(army1,army2,chart);
        } );

        //layouts
        HBox hBox = new HBox(15);
        hBox.getChildren().addAll(layout1,layout2,layout3, buttons,chart);
        battleScene = new Scene(new StackPane(hBox),800, 800);
        window.setScene(battleScene);
        window.show();
    }

    /**
     * Scene for manually applying a strategic advantage to the battle
     */
    private void applyStrategicAdvantage(){
        Button backButton = new Button("Back");
        HBox army1Advantage = new HBox();
        HBox army2Advantage = new HBox();
        Label name1 = new Label(army1.getName());
        Label name2 = new Label(army2.getName());
        VBox advantages = new VBox(10);

        TextField text1 = new TextField(Integer.toString(stratAdvantage1));
        TextField text2 = new TextField(Integer.toString(stratAdvantage2));
        //save text if enter is pressed
        text1.setOnAction(e -> stratAdvantage1 = Integer.parseInt(text1.getText()));
        text2.setOnAction(e -> stratAdvantage2 = Integer.parseInt(text2.getText()));

        //set layouts
        army1Advantage.getChildren().addAll(name1, text1);
        army2Advantage.getChildren().addAll(name2, text2);
        advantages.getChildren().addAll(army1Advantage,army2Advantage, backButton);
        Scene advantageScene = new Scene(advantages, 800,600);

        // button to go back
        // saves the text in each box to respected stratAdvantages
        backButton.setOnAction(e -> {
            stratAdvantage1 = Integer.parseInt(text1.getText());
            stratAdvantage2 = Integer.parseInt(text2.getText());
            window.setScene(battleScene);
        });
        //set scene
        window.setScene(advantageScene);
    }


    /**
     * Loads the choices of different armies from the LISTPATH directory
     * @return - returns a Linked List of different names of armies
     * @throws FileNotFoundException
     */
    private LinkedList<String> loadArmyChoices() throws FileNotFoundException{

        File inFile = new File(LISTPATH);
        if(!inFile.exists())
        {
            throw new FileNotFoundException();
        }

        Scanner fileReader = new Scanner(inFile);
        LinkedList<String> armiesList = new LinkedList<>();
        while(fileReader.hasNextLine()){
            armiesList.add(fileReader.nextLine());
        }
        return armiesList;
    }

    /**
     * Sets the Chart with data from army 1 and army 2
     * @param army1 - army 1
     * @param army2 = army 2
     * @param chart = chart
     */
    public void setChart(Army army1, Army army2, BarChart chart){
        chart.setTitle("Power Levels");
        chart.setMaxWidth(250);
        chart.getXAxis().setLabel("Army");
        chart.getYAxis().setLabel("Power");
        XYChart.Series series1 = new XYChart.Series();
        XYChart.Series series2 = new XYChart.Series();
        series1.setName(army1.getName());
        series2.setName(army2.getName());
        series1.getData().add(new XYChart.Data<String,Number>(army1.getName(), army1.getBasePower()));
        series2.getData().add(new XYChart.Data<String,Number>(army2.getName(), army2.getBasePower()));
        chart.getData().addAll(series1,series2);
    }

    /**
     * Updates box with the name of the army and a listView of all the units
     * @param army - army to be displayed
     * @param box - VBox where the data is held
     */
    public void displayArmy(Army army, VBox box){
        box.getChildren().clear();
        Label armyName = new Label(army.getName());
        box.getChildren().add(armyName);
        ListView<Unit> armyView = new ListView<>();
        for(int i = 0; i < army.size(); i++){
            armyView.getItems().add(army.getUnitAtIndex(i));
        }
        box.getChildren().addAll(armyView, winnerLabel, army1Casualties, army2Casualties);
    }

    /**
     * Method for doing the math to each battle
     * TODO NOTE - should be renamed, maybe even moved into its own static class????
     * TODO along with all other associated battle methods
     * @param army1
     * @param army2
     */
    public void battle(Army army1, Army army2){
        Random rand = new Random();
        int army1Advantage = 0;
        int army2Advantage = 0;
        // apply force advantage
        army1Advantage += applyForceAdvantage(army1, army2);
        army2Advantage += applyForceAdvantage(army2, army1);
        // apply strategic advantage
        army1Advantage += stratAdvantage1;
        army2Advantage += stratAdvantage2;
        int roll1 = rand.nextInt(99) + 1 + army1Advantage;
        int roll2 = rand.nextInt(99) + 1 + army2Advantage;

        calculateCasualties(roll1, roll2, army1, army2);
    }


    /**
     * Calculates the force Advantage that primary gains from battling secondary
     * Force Advantage is the percentage difference of costs of each army
     * @param primary - primary army that gets the advatnage applied
     * @param secondary - secondary army that does not get altered
     * @return - the amount of advantage gained
     */
    public int applyForceAdvantage(Army primary, Army secondary){
        if(primary.getBasePower() <= secondary.getBasePower()){
            return 0;
        }
        else{
            int powerDifference = primary.getBasePower() - secondary.getBasePower();
            double forceAdvantage = (double)powerDifference / (double)primary.getBasePower();
            return (int)forceAdvantage;
        }
    }

    /**
     * Helper function to find out which army won the round then calles applyCasualties with the proper winner
     * and the totalDifferennce for the round
     * @param total1 - total amount rolled for the round for army 1
     * @param total2 - total amount rolled for the round for army 2
     * @param army1 - army 1
     * @param army2 - army 2
     */
    private void calculateCasualties(int total1, int total2, Army army1, Army army2){
        if(total1 > total2){
            int totalDifference = total1 - total2;
            applyCasualties(army1, totalDifference, army2);
        }
        else if(total2> total1)
        {
            int totalDifference = total2 - total1;
            applyCasualties(army2, totalDifference, army1);
        }

    }

    /**
     * Uses MCDM's forumla to apply casualties to each army
     * Depending on the win difference the casualty amount differs
     * @param winner - army that won
     * @param totalDifference - difference in rolls for the rounds
     * @param loser - army that lost
     */
    private void applyCasualties(Army winner, int totalDifference, Army loser) {
        int winnerCasualtiesInflicted;
        int loserCasualtiesInflicted;
        LinkedList<Unit> deathListWinner;
        LinkedList<Unit> deathListLoser;

        // check which type of victory
        if(totalDifference <= 10){
            winnerCasualtiesInflicted = winner.getPyrrhicCasualties(true);
            loserCasualtiesInflicted = loser.getPyrrhicCasualties(false);
            winnerLabel.setText("Pyrrhic Victory for " + winner.getName());
        }else if(totalDifference <= 50){
            winnerCasualtiesInflicted = winner.getMinorCasualties(true);
            loserCasualtiesInflicted = loser.getMinorCasualties(false);
            winnerLabel.setText("Minor Victory for " + winner.getName());
        }else if(totalDifference <= 100){
            winnerCasualtiesInflicted = winner.getClearCasualties(true);
            loserCasualtiesInflicted = loser.getClearCasualties(false);
            winnerLabel.setText("Clear Victory for " + winner.getName());
        }else if(totalDifference <= 200){
            winnerCasualtiesInflicted = winner.getMajorCasualties(true);
            loserCasualtiesInflicted = loser.getMajorCasualties(false);
            winnerLabel.setText("Major Victory for " + winner.getName());
        }else{
            winnerCasualtiesInflicted = winner.getRoutCasualties(true);
            loserCasualtiesInflicted = loser.getRoutCasualties(false);
            winnerLabel.setText("Rout Victory for " + winner.getName());
        }
        army1Casualties.setText(winner.getName() + " inflicted " + winnerCasualtiesInflicted + " casualties!");
        army2Casualties.setText(loser.getName() + " inflicted " + loserCasualtiesInflicted + " casualties!");

        deathListWinner = winner.inflictCasualties(loserCasualtiesInflicted);
        deathListLoser = loser.inflictCasualties((winnerCasualtiesInflicted));
        //NOTE : get rid of this next line to not wipe the deathList every round
        deathList.getItems().clear();

        //update deathList with all the fallen soldiers for this round
        for(Unit death : deathListLoser){
            deathList.getItems().add(death);
        }
        for(Unit death : deathListWinner){
            deathList.getItems().add(death);
        }
    }




    private void applyCasualtiesSimple(Army army,int lossTotal, int opposingSize, VBox deaths){
        Random rand = new Random();
        deaths.getChildren().removeAll();
        for (int i = 0; i < opposingSize; i++) {
            if (army.size() <= 0)
                return;
            int index = rand.nextInt(army.size());
            int deathRoll = rand.nextInt(99) + 1;

            if (lossTotal <= 10) {
                //do nothing... no casualties inflicted
            } else if (lossTotal <= 40) {
                if (deathRoll < 20) {
                    Label deathLabel = new Label(army.getNameAtIndex(index) + " was killed!");
                    deaths.getChildren().add(deathLabel);
                    army.removeUnit(index);
                }

            } else if (lossTotal <= 70) {
                if (deathRoll < 35) {
                    Label deathLabel = new Label(army.getNameAtIndex(index) + " was killed!");
                    deaths.getChildren().add(deathLabel);
                    army.removeUnit(index);
                }
            } else if (lossTotal <= 100) {
                if (deathRoll < 50) {
                    Label deathLabel = new Label(army.getNameAtIndex(index) + " was killed!");
                    deaths.getChildren().add(deathLabel);
                    army.removeUnit(index);
                }

            } else {
                if (deathRoll < lossTotal / 2) {
                    Label deathLabel = new Label(army.getNameAtIndex(index) + " was killed!");
                    deaths.getChildren().add(deathLabel);
                    army.removeUnit(index);
                }
            }
        }

    }
}


// TODO change LinkedList in Army into separate list to separate each army type
// TODO input validation. Create an alert box to alert user when their input is bad and handle it
// DONE display message on battle window after each round to display who won and what type of victory
// TODO fix window sizes and where they display
// TODO make everything look nicer

