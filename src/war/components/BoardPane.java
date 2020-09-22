package war.components;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BoardPane extends GridPane {

    public BoardPane() {
        final int row = 8;
        final int col = 5;
        fillPane(row, col);
    }

    public BoardPane(int rows, int cols){
        fillPane(rows, cols);
    }


    public void fillPane(int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                Rectangle square = new Rectangle();
                Color color;
                if ((row + col) % 2 == 0) {
                    color = Color.WHITE;
                } else {
                    color = Color.LIGHTGRAY;
                }
                square.setFill(color);
                this.add(square, col, row);
                square.widthProperty().bind(this.widthProperty().divide(cols));
                square.heightProperty().bind(this.heightProperty().divide(rows));

            }
        }
    }

}
