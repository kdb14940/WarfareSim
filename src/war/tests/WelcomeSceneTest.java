package war.tests;

import javafx.application.Application;
import javafx.stage.Stage;
import war.view.WelcomeScreen;

import static javafx.application.Application.launch;

public class WelcomeSceneTest extends Application {
    public static void main(String[] args){
        launch(args);
    }


    public void start(Stage primaryStage) throws Exception{
        Stage window = primaryStage;
        WelcomeScreen screen = new WelcomeScreen();
        window.setScene(screen.getScene());
        window.setFullScreen(true);
        window.show();

    }
}
