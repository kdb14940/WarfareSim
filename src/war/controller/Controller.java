package war.controller;

import javafx.event.ActionEvent;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.stage.Screen;
import javafx.stage.Stage;
import war.view.Gui;

public class Controller {

    public Controller(){

    }

    public void passControl(Controller controller, ActionEvent e){
        Gui newGui = controller.getGui();
        Stage primaryStage = (Stage)((Node)e.getSource()).getScene().getWindow();
        primaryStage.setScene(newGui.getScene());

        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        primaryStage.setWidth(bounds.getWidth());
        primaryStage.setHeight(bounds.getHeight());
        primaryStage.setMaximized(true);
    }

    /**
     * Getter for gui
     *
     * @return gui
     */
    public Gui getGui() {
        return gui;
    }

    /**
     * Setter for gui
     *
     * @param gui - gui
     */
    public void setGui(Gui gui) {
        this.gui = gui;
    }

    protected Gui gui;

}
