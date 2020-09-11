package war.tests;

import javafx.application.Application;
import javafx.stage.Stage;
import war.view.NewArmyScreen;
import war.view.WelcomeScreen;

public class NewArmySceneTest extends Application {
    public static void main(String[] args){
        launch(args);
    }


    public void start(Stage primaryStage) throws Exception{
        Stage window = primaryStage;
        NewArmyScreen screen = new NewArmyScreen();
        window.setScene(screen.getScene());
        window.setFullScreen(true);
        window.show();

    }
}
