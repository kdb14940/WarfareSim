package war.components;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;


import static javafx.scene.paint.Color.WHITE;

public class Tile extends StackPane {

    public Tile(boolean light){
        bg = new Rectangle();
        innerTile = new Rectangle();
        bg.setFill(Color.valueOf("#ffff"));
        innerTile.setFill(light ? Color.valueOf("#feb") : Color.valueOf("#582"));



        innerTile.xProperty().bind(bg.xProperty().add(bg.widthProperty().multiply(0.05)));
        innerTile.yProperty().bind(bg.yProperty().add(bg.heightProperty().multiply(0.05)));
        innerTile.widthProperty().bind(bg.widthProperty().multiply(0.95));
        innerTile.heightProperty().bind(bg.heightProperty().multiply(0.95));

        getChildren().addAll(bg, innerTile);

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
     * Getter for bg
     *
     * @return bg
     */
    public Rectangle getBg() {
        return bg;
    }

    /**
     * Setter for bg
     *
     * @param bg - bg
     */
    public void setBg(Rectangle bg) {
        this.bg = bg;
    }

    public double getX(){
        return bg.getX();
    }

    public double getY(){
        return bg.getY();
    }

    public void setBorder(Paint paint){
        bg.setFill(paint);
    }

    private Piece piece;
    private boolean hasPiece;
    private Rectangle innerTile;
    private Rectangle bg;

}
