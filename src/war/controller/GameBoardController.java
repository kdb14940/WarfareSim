package war.controller;

import javafx.beans.property.DoubleProperty;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableRow;
import javafx.scene.paint.Color;
import war.components.BoardPane;
import war.components.Piece;
import war.components.Tile;
import war.model.Army;
import war.model.Unit;
import war.view.GameBoardGui;

import java.util.ArrayList;


public class GameBoardController extends Controller {

    public GameBoardController(Army army1, Army army2) {
        this.gui = new GameBoardGui();
        this.gameBoardGui = (GameBoardGui)gui;
        this.army1 = army1;
        this.army2 = army2;
        this.reservesList = army1.getUnits();
        initControllers();
    }

    public void initControllers(){
        gameBoardGui.getArmyTable().setUnits(reservesList);

        gameBoardGui.getArmyTable().setRowFactory( e->{
            TableRow<Unit> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                selectedUnit = row.getItem();
                gameBoardGui.unHighLightOpenSpots();
                gameBoardGui.highLightOpenSpots();
                gameBoardGui.getUnitPane().setUnit(selectedUnit);
            });
            return row ;
        });

        gameBoardGui.getBoardPane().setOnMouseClicked(e ->{
            double xPos = e.getX();
            double yPos = e.getY();
            BoardPane boardPane = (BoardPane)(e.getSource());
            Tile[][] board = boardPane.getBoard();
            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board[0].length; j++){
                    if(isInBounds(xPos, yPos, board[i][j]) && selectedUnit != null && i >= 4){
                        board[i][j].setBorder(Color.YELLOW);
                        //TODO This is where you place a piece
                        //TODO needs code cleanup
                        Piece piece = new Piece();
                        piece.setUnit(selectedUnit);
                        boardPane.getPieceGroup().getChildren().add(piece);
                        reservesList.remove(selectedUnit);
                        gameBoardGui.getArmyTable().setUnits(reservesList);

                        piece.layoutXProperty().bind(boardPane.widthProperty().divide(board[0].length).multiply(j).
                                add(board[i][j].widthProperty().divide(4)));
                        piece.layoutYProperty().bind(boardPane.heightProperty().divide(board.length).multiply(i).
                                add(board[i][j].heightProperty().divide(4)));

                        piece.getBg().radiusXProperty().bind(boardPane.widthProperty().divide(board[0].length).divide(4));
                        piece.getBg().radiusYProperty().bind(boardPane.heightProperty().divide(board.length).divide(4));
                        
                        board[i][j].setPiece(piece);
                        piece.setTile(board[i][j]);
                        selectedUnit = null;

                    }

                }
            }

            setPieceMovement();

        });

    }


    public boolean isInBounds(double xPos, double yPos, Tile tile ){
        if(tile.getX() < xPos && xPos < tile.getX() + tile.getWidth()){
            if(tile.getY() < yPos && yPos < tile.getY() + tile.getHeight()){
                return true;
            }
        }
        return false;

    }

    public void setPieceMovement(){
        for(Node node : gameBoardGui.getBoardPane().getPieceGroup().getChildren()){
            Piece piece = (Piece)node;
            piece.setOnMousePressed(e->{
                piece.layoutXProperty().unbind();
                piece.layoutYProperty().unbind();
                mouseX = e.getSceneX();
                mouseY = e.getSceneY();
                oldX = piece.getLayoutX();
                oldY = piece.getLayoutY();
            });

            piece.setOnMouseDragged(e ->{
                piece.relocate(e.getSceneX() - mouseX + oldX, e.getSceneY() - mouseY + oldY);
            });

            piece.setOnMouseReleased(e ->{
                double xPos = piece.getLayoutX();
                double yPos = piece.getLayoutY();

                //double initialX = piece.getOldX();
                //double initialY = piece.getOldY();

                BoardPane boardPane = gameBoardGui.getBoardPane();
                Tile[][] board = boardPane.getBoard();
                for(int i = 0; i < board.length; i++){
                    for(int j = 0; j < board[0].length; j++){
                        if(isInBounds(xPos, yPos, board[i][j])) {
                            if (board[i][j].getPiece() == null) {
                                board[i][j].setBorder(Color.YELLOW);
                                //TODO This is where you place a piece
                                //TODO needs code cleanup

                                piece.layoutXProperty().bind(boardPane.widthProperty().divide(board[0].length).multiply(j).
                                        add(board[i][j].widthProperty().divide(4)));
                                piece.layoutYProperty().bind(boardPane.heightProperty().divide(board.length).multiply(i).
                                        add(board[i][j].heightProperty().divide(4)));

                                Tile oldTile = piece.getTile();
                                oldTile.setPiece(null);
                                board[i][j].setPiece(piece);
                                piece.setTile(board[i][j]);
                                selectedUnit = null;
                            } else {
                                piece.setLayoutX(oldX);
                                piece.setLayoutY(oldY);
                                System.out.println("test");
                            }
                        }

                    }
                }
            });
        }
    }

    private GameBoardGui gameBoardGui;
    private Army army1;
    private Army army2;
    private Unit selectedUnit;
    private ArrayList<Unit> reservesList;
    private double mouseX;
    private double mouseY;
    private double oldX;
    private double oldY;
}
