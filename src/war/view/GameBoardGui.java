package war.view;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import war.components.*;
import war.model.Unit;



public class GameBoardGui extends Gui{

    public GameBoardGui() {
        initComponents();
        layoutComponents();
    }

    public void initComponents(){
        this.armyTable = new ArmyTableView();
        this.boardPane = new BoardPane();
        this.unitPane = new UnitPane();
        board = new BorderPane(boardPane);
        scene = new Scene(board, 800 , 600);
        armyTable.addNameColumn();
    }

    public void layoutComponents(){
        board.setLeft(armyTable);
        board.setRight(unitPane);
    }

    public void highLightOpenSpots(){
        Tile[][] board = boardPane.getBoard();
        for(int i =0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                Tile tile = board[i][j];
                    if(!tile.hasPiece() && i >= 4){
                        tile.setBorder(Color.LIMEGREEN);
                } else {
                        tile.setBorder(Color.RED);
                    }
            }
        }
    }

    public void unHighLightOpenSpots() {
        Tile[][] board = boardPane.getBoard();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                Tile tile = board[i][j];
                tile.setBorder((i+j) % 2 == 0 ? Color.valueOf("#feb") : Color.valueOf("#582"));

            }
        }
    }



    /**
     * Getter for board
     *
     * @return board
     */
    public BorderPane getBoard() {
        return board;
    }

    /**
     * Setter for board
     *
     * @param board - board
     */
    public void setBoard(BorderPane board) {
        this.board = board;
    }

    /**
     * Getter for boardPane
     *
     * @return boardPane
     */
    public BoardPane getBoardPane() {
        return boardPane;
    }

    /**
     * Setter for boardPane
     *
     * @param boardPane - boardPane
     */
    public void setBoardPane(BoardPane boardPane) {
        this.boardPane = boardPane;
    }

    /**
     * Getter for armyTable
     *
     * @return armyTable
     */
    public ArmyTableView getArmyTable() {
        return armyTable;
    }

    /**
     * Setter for armyTable
     *
     * @param armyTable - armyTable
     */
    public void setArmyTable(ArmyTableView armyTable) {
        this.armyTable = armyTable;
    }

    /**
     * Getter for unitPane
     *
     * @return unitPane
     */
    public UnitPane getUnitPane() {
        return unitPane;
    }

    /**
     * Setter for unitPane
     *
     * @param unitPane - unitPane
     */
    public void setUnitPane(UnitPane unitPane) {
        this.unitPane = unitPane;
    }

    private BorderPane board;
    private BoardPane boardPane;
    private ArmyTableView armyTable;
    private UnitPane unitPane;
}
