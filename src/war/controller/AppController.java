package war.controller;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import war.model.ArmyList;

import java.io.*;

public class AppController extends Application {


    public static void main(String[] args){
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        ArmyChoiceController armyChoiceController = new ArmyChoiceController();
        window.setScene(armyChoiceController.getArmyChoiceGui().getScene());
        window.setMaximized(true);
        window.show();
    }


    private Stage window;





}
