package war.components;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import war.model.Unit;

public class Piece extends StackPane {

    private double mouseX, mouseY;
    private double oldX, oldY;


    public double getOldX() {
        return oldX;
    }

    public double getOldY() {
        return oldY;
    }

    public Piece(int x, int y) {

        move(x, y);

        bg = new Ellipse(TILE_SIZE * 0.3125, TILE_SIZE * 0.26);
        bg.setFill(Color.BLACK);

        bg.setStroke(Color.BLACK);
        bg.setStrokeWidth(TILE_SIZE * 0.03);

        bg.setTranslateX((TILE_SIZE - TILE_SIZE * 0.3125 * 2) / 2);
        bg.setTranslateY((TILE_SIZE - TILE_SIZE * 0.26 * 2) / 2 + TILE_SIZE * 0.07);

        /**
        Ellipse ellipse = new Ellipse(TILE_SIZE * 0.3125, TILE_SIZE * 0.26);

        ellipse.setStroke(Color.BLACK);
        ellipse.setStrokeWidth(TILE_SIZE * 0.03);

        ellipse.setTranslateX((TILE_SIZE - TILE_SIZE * 0.3125 * 2) / 2);
        ellipse.setTranslateY((TILE_SIZE - TILE_SIZE * 0.26 * 2) / 2);
         */

        getChildren().addAll(bg);

        setOnMousePressed(e -> {
            mouseX = e.getSceneX();
            mouseY = e.getSceneY();
        });

        setOnMouseDragged(e -> {
            relocate(e.getSceneX() - mouseX + oldX, e.getSceneY() - mouseY + oldY);
        });
    }

    public void move(int x, int y) {
        oldX = x * TILE_SIZE;
        oldY = y * TILE_SIZE;
        relocate(oldX, oldY);
    }

    public void abortMove() {
        relocate(oldX, oldY);
    }

    /**
     * Getter for bg
     *
     * @return bg
     */
    public Ellipse getBg() {
        return bg;
    }

    /**
     * Setter for bg
     *
     * @param bg - bg
     */
    public void setBg(Ellipse bg) {
        this.bg = bg;
    }

    /**
     * Getter for unit
     *
     * @return unit
     */
    public Unit getUnit() {
        return unit;
    }

    /**
     * Setter for unit
     *
     * @param unit - unit
     */
    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    private final int TILE_SIZE = 60;
    private Ellipse bg;
    private Unit unit;
}
