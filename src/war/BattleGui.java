package war;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;


public class BattleGui extends Application{

    private final String LISTPATH = "C://warfare/listOfArmies";
    private Stage window;
    private Army army1;
    private Army army2;
    private int stratAdvantage1 = 0;
    private int stratAdvantage2 = 0;
    LinkedList<String> loadedChoices;

    public static void main(String[] args){
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;

        welcomeScreen();
        /**
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
        Scene welcomeScene = new Scene(welcomeLayout, 800, 600);

        continueButton.setOnAction(e -> {
            if(army1Label.getText() != null && army2Label.getText() != null)
            {
                // create filepath from user choice
                StringBuilder filePath1 = new StringBuilder("C://warfare/");
                StringBuilder filePath2 = new StringBuilder("C://warfare/");
                filePath1.append(army1Choicebox.getValue());
                filePath2.append(army2Choicebox.getValue());
                // add armies from the designated file paths
                try{
                    army1.addArmiesFromFile(filePath1.toString());
                    army2.addArmiesFromFile(filePath2.toString());
                }
                catch(FileNotFoundException e2){
                    System.out.println("Army file not found!");
                }
                // TODO continue to next scene, EXCEPTION HANDLING
            }
        });

        newArmy.setOnAction(e->{
            Army tempArmy = NewArmyGui.display();
            try {
                tempArmy.saveArmyToFile();
            }
            catch(IOException err){
                System.out.println("Error writing army to file");
            }
            try {
                loadedChoices = loadArmyChoices();
            }
            catch(FileNotFoundException err)
            {
                System.out.println("Armies list not found!");
            }
            for(String name : loadedChoices){
                army1Choicebox.getItems().add(name);
                army2Choicebox.getItems().add(name);
            }
            window.setScene(welcomeScene);
        });

        window.setScene(welcomeScene);
        window.show();
         */



        /**
        //create armies
        try {
            //army1.addArmiesFromFile(FILEPATH1);
            army2.addArmiesFromFile(FILEPATH2);
        }
        catch(Exception e)
        {
            System.out.println("File not found");
        }


        Button nextButton = new Button("Next Round");
        Button advantageButton = new Button("Advantages");


        VBox layout1 = new VBox();
        VBox layout2 = new VBox();
        VBox layout3 = new VBox();
        VBox buttons = new VBox();
        buttons.getChildren().addAll(nextButton, advantageButton);

        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        BarChart<String, Number> chart = new BarChart(xAxis,yAxis);

        setChart(army1,army2,chart);

        displayArmy(army1,layout1);
        displayArmy(army2,layout2);

        //stuff for button 2
        Button backButton = new Button("Back");
        HBox army1Advantage = new HBox();
        HBox army2Advantage = new HBox();
        Label name1 = new Label(army1.getName());
        Label name2 = new Label(army2.getName());

        TextField text1 = new TextField(Integer.toString(stratAdvantage1));
        TextField text2 = new TextField(Integer.toString(stratAdvantage2));
        text1.setOnAction(e -> stratAdvantage1 = Integer.parseInt(text1.getText()));
        text2.setOnAction(e -> stratAdvantage2 = Integer.parseInt(text2.getText()));

        army1Advantage.getChildren().addAll(name1, text1);
        army2Advantage.getChildren().addAll(name2, text2);

        VBox advantages = new VBox(10);
        advantages.getChildren().addAll(army1Advantage,army2Advantage, backButton);
        Scene advantageScene = new Scene(advantages, 800,800);
        advantageButton.setOnAction(
                e -> {
                    text1.setText(Integer.toString(stratAdvantage1));
                    text2.setText(Integer.toString(stratAdvantage2));
                    window.setScene(advantageScene);
                });

        nextButton.setOnAction(e -> {
            layout1.getChildren().clear();
            layout2.getChildren().clear();
            layout3.getChildren().clear();
            chart.getData().clear();
            Label deathsLabel = new Label("Deaths");
            layout3.getChildren().add(deathsLabel);
            battle(army1,army2,layout3);
            stratAdvantage1 = 0;
            stratAdvantage2 = 0;
            displayArmy(army1,layout1);
            displayArmy(army2,layout2);
            setChart(army1,army2,chart);
        } );

        HBox hBox = new HBox(15);
        hBox.getChildren().addAll(layout1,layout2,layout3,buttons,chart);
        Scene start = new Scene(new StackPane(hBox),800, 800);

        backButton.setOnAction(e -> {
            stratAdvantage1 = Integer.parseInt(text1.getText());
            stratAdvantage2 = Integer.parseInt(text2.getText());
            window.setScene(start);
        });

        window.setScene(start);
        window.show();
         */
    }


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
        Scene welcomeScene = new Scene(welcomeLayout, 800, 600);

        continueButton.setOnAction(e -> {
            if(army1Label.getText() != null && army2Label.getText() != null)
            {
                // create filepath from user choice
                StringBuilder filePath1 = new StringBuilder("C://warfare/");
                StringBuilder filePath2 = new StringBuilder("C://warfare/");
                filePath1.append(army1Choicebox.getValue());
                filePath2.append(army2Choicebox.getValue());
                // add armies from the designated file paths
                try{
                    army1.addArmiesFromFile(filePath1.toString());
                    army2.addArmiesFromFile(filePath2.toString());
                }
                catch(FileNotFoundException e2){
                    System.out.println("Army file not found!");
                }
                // TODO continue to next scene, EXCEPTION HANDLING
                return;
            }
        });

        newArmy.setOnAction(e->{
            Army tempArmy = NewArmyGui.display();
            try {
                tempArmy.saveArmyToFile();
            }
            catch(IOException err){
                System.out.println("Error writing army to file");
            }
            try {
                loadedChoices = loadArmyChoices();
            }
            catch(FileNotFoundException err)
            {
                System.out.println("Armies list not found!");
            }
            for(String name : loadedChoices){
                army1Choicebox.getItems().add(name);
                army2Choicebox.getItems().add(name);
            }
            window.setScene(welcomeScene);
        });

        window.setScene(welcomeScene);
        window.show();
    }


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

    public void setChart(Army army1, Army army2, BarChart chart){
        chart.setTitle("Power Levels");
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

    public void displayArmy(Army army, VBox box){
        box.getChildren().removeAll();
        Label armyName = new Label(army.getName());
        box.getChildren().add(armyName);
        for(int i = 0; i < army.size(); i++){
            Label temp = new Label(army.getNameAtIndex(i));
            box.getChildren().add(temp);
        }
    }

    public void battle(Army army1, Army army2, VBox deaths){
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

        calculateCasualties(roll1, roll2, army1, army2, deaths);
    }


    public  int applyStrategicAdvantages(int advantage){
        return advantage;
    }

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

    public void calculateCasualties(int total1, int total2, Army army1, Army army2, VBox deaths){
        if(total1 > total2){
            int lossTotal = total1 - total2;
            applyCasualties(army2, lossTotal, army1.size(), deaths);
        }
        else if(total2> total1)
        {
            int lossTotal = total2 - total1;
            applyCasualties(army1, lossTotal, army2.size(), deaths);
        }

    }

    private void applyCasualties(Army army, int lossTotal, int opposingSize, VBox deaths){
        Random rand = new Random();
        deaths.getChildren().removeAll();
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
                    Label deathLabel = new Label(army.getNameAtIndex(index) + " was killed!");
                    deaths.getChildren().add(deathLabel);
                    army.removeUnit(index);
                }

            }else if(lossTotal <= 70){
                if(deathRoll < 35)
                {
                    Label deathLabel = new Label(army.getNameAtIndex(index) + " was killed!");
                    deaths.getChildren().add(deathLabel);
                    army.removeUnit(index);
                }
            }else if(lossTotal <= 100){
                if(deathRoll < 50)
                {
                    Label deathLabel = new Label(army.getNameAtIndex(index) + " was killed!");
                    deaths.getChildren().add(deathLabel);
                    army.removeUnit(index);
                }

            }else{
                if(deathRoll < lossTotal / 2){
                    Label deathLabel = new Label(army.getNameAtIndex(index) + " was killed!");
                    deaths.getChildren().add(deathLabel);
                    army.removeUnit(index);
                }
            }
        }

    }

}


// TODO
// Add proper death rules
// Add remove
// Add screen to add units
// Add way to save armies
// Add way to load armies
