package war.components;

import javafx.scene.Group;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BoardPane extends Pane {

    public BoardPane() {
        final int row = 8;
        final int col = 5;
        board = new Tile[row][col];
        tileGroup = new Group();
        pieceGroup = new Group();
        getChildren().addAll(tileGroup, pieceGroup);
        fillPane(row, col);
    }

    public BoardPane(int row, int col){

        tileGroup = new Group();
        pieceGroup = new Group();
        board = new Tile[row][col];
        getChildren().addAll(tileGroup, pieceGroup);
        fillPane(row, col);

    }


    public void fillPane(int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                Tile tile = new Tile((row+col) % 2 == 0);
                board[row][col] = tile;
                tileGroup.getChildren().add(tile);

                tile.layoutXProperty().bind(this.widthProperty().divide(cols).multiply(col));
                tile.layoutYProperty().bind(this.heightProperty().divide(rows).multiply(row));

                //TODO Clean this into its own function
                tile.getBg().xProperty().bind(this.widthProperty().divide(cols).multiply(col));
                tile.getBg().yProperty().bind(this.heightProperty().divide(rows).multiply(row));
                tile.getBg().widthProperty().bind(this.widthProperty().divide(cols));
                tile.getBg().heightProperty().bind(this.heightProperty().divide(rows));

            }
        }
    }

    /**
     * Getter for tileGroup
     *
     * @return tileGroup
     */
    public Group getTileGroup() {
        return tileGroup;
    }

    /**
     * Setter for tileGroup
     *
     * @param tileGroup - tileGroup
     */
    public void setTileGroup(Group tileGroup) {
        this.tileGroup = tileGroup;
    }

    /**
     * Getter for pieceGroup
     *
     * @return pieceGroup
     */
    public Group getPieceGroup() {
        return pieceGroup;
    }

    /**
     * Setter for pieceGroup
     *
     * @param pieceGroup - pieceGroup
     */
    public void setPieceGroup(Group pieceGroup) {
        this.pieceGroup = pieceGroup;
    }

    /**
     * Getter for board
     *
     * @return board
     */
    public Tile[][] getBoard() {
        return board;
    }

    /**
     * Setter for board
     *
     * @param board - board
     */
    public void setBoard(Tile[][] board) {
        this.board = board;
    }

    private Group tileGroup;
    private Group pieceGroup;
    private Tile[][] board;
}
