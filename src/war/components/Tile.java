package war.components;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;


import static javafx.scene.paint.Color.WHITE;

public class Tile extends StackPane {

    public Tile(boolean light){
        border = new Rectangle();
        innerTile = new Rectangle();
        border.setFill(Color.valueOf("#ffff"));
        innerTile.setFill(light ? Color.valueOf("#feb") : Color.valueOf("#582"));

        bindInnerTile();

        getChildren().addAll(border, innerTile);

    }

    public void bindInnerTile(){
        innerTile.xProperty().bind(border.xProperty().add(border.widthProperty().multiply(0.05)));
        innerTile.yProperty().bind(border.yProperty().add(border.heightProperty().multiply(0.05)));
        innerTile.widthProperty().bind(border.widthProperty().multiply(0.95));
        innerTile.heightProperty().bind(border.heightProperty().multiply(0.95));
    }

    /**
     * Getter for piece
     *
     * @return piece
     */
    public Piece getPiece() {
        return piece;
    }

    /**
     * Setter for piece
     *
     * @param piece - piece
     */
    public void setPiece(Piece piece) {
        this.piece = piece;
        if(piece == null){
            hasPiece = false;
        }
        else{
            hasPiece = true;
        }
    }

    /**
     * Getter for hasPiece
     *
     * @return hasPiece
     */
    public boolean hasPiece() {
        return hasPiece;
    }

    /**
     * Setter for hasPiece
     *
     * @param hasPiece - hasPiece
     */
    public void setHasPiece(boolean hasPiece) {
        this.hasPiece = hasPiece;
    }

    /**
     * Getter for hasPiece
     *
     * @return hasPiece
     */
    public boolean isHasPiece() {
        return hasPiece;
    }

    /**
     * Getter for innerTile
     *
     * @return innerTile
     */
    public Rectangle getInnerTile() {
        return innerTile;
    }

    /**
     * Setter for innerTile
     *
     * @param innerTile - innerTile
     */
    public void setInnerTile(Rectangle innerTile) {
        this.innerTile = innerTile;
    }

    /**
     * Getter for border
     *
     * @return border
     */
    public Rectangle getBg() {
        return border;
    }

    /**
     * Setter for border
     *
     * @param border - border
     */
    public void setBg(Rectangle border) {
        this.border = border;
    }

    public double getX(){
        return border.getX();
    }

    public double getY(){
        return border.getY();
    }

    public void setBorder(Paint paint){
        border.setFill(paint);
    }

    private Piece piece;
    private boolean hasPiece;
    private Rectangle innerTile;
    private Rectangle border;

}
