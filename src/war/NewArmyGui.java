package war;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import war.model.Army;
import war.model.Unit;

import java.util.LinkedList;

public class NewArmyGui{
    static Army army;
    static LinkedList<Unit> listOfUnits;

    public static Army display(){
        army = new Army();
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("New Army Creation");

        //variables
        listOfUnits = new LinkedList<>();
        VBox unitsView = new VBox();
        Button newUnitButton = new Button("Add New Unit");
        Button saveButton = new Button("Save Army");
        Label unitsLabel = new Label("Units");
        TextField armyName = new TextField("Enter Army Name Here");
        unitsView.getChildren().add(armyName);
        unitsView.getChildren().add(unitsLabel);

        //layout
        HBox layout = new HBox(50);
        layout.getChildren().addAll(unitsView, newUnitButton, saveButton);
        Scene scene = new Scene(layout, 800, 600);

        // Button for adding a new unit
        newUnitButton.setOnAction(e->{
            Unit[] units = NewUnitGui.display();
            for(Unit unit : units){
                listOfUnits.add(unit);
            }
            unitsView.getChildren().clear();
            updateVBoxList(unitsView);
            window.setScene(scene);
        });

        //button to save army to file and exit screen
        saveButton.setOnAction(e->
        {
            if(!armyName.getText().equals("Enter Army Name Here")){
                army.setName(armyName.getText());
            }
            else{
                army.setName(listOfUnits.get(0).getName());
            }
            for(Unit unit : listOfUnits){
                army.addUnit(unit);
            }
            window.close();
        });

        window.setScene(scene);
        window.showAndWait();
        return army;
    }

    private static void updateVBoxList(VBox vbox){
        Label unitsLabel = new Label("Units");
        vbox.getChildren().add(unitsLabel);
        for(Unit unit : listOfUnits){
            Label temp = new Label(unit.getName());
            vbox.getChildren().add(temp);
        }
    }

}
