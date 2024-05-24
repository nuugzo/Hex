package com.hexgame;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

public class HexGameController {

    @FXML
    private GridPane board;

    @FXML
    private Label currentPlayerLabel;

    @FXML
    private RadioButton size5x5;

    @FXML
    private RadioButton size11x11;

    @FXML
    private RadioButton size17x17;

    private GameModel gameModel;

    @FXML
    public void initialize() {
        ToggleGroup group = new ToggleGroup();
        size5x5.setToggleGroup(group);
        size11x11.setToggleGroup(group);
        size17x17.setToggleGroup(group);
        size11x11.setSelected(true);

        createBoard(11); // Default board size
    }

    private void createBoard(int size) {
        board.getChildren().clear();
        gameModel = new GameModel(size);
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                Button cell = new Button();
                cell.setPrefSize(40, 40);
                int finalRow = row;
                int finalCol = col;
                cell.setOnAction(event -> handleCellClick(finalRow, finalCol));
                board.add(cell, col, row);
            }
        }
    }

    private void handleCellClick(int row, int col) {
        if (gameModel.makeMove(row, col)) {
            Button cell = (Button) getNodeByRowColumnIndex(row, col, board);
            cell.setText(gameModel.getCurrentPlayerSymbol());
            cell.setStyle("-fx-background-color: " + gameModel.getCurrentPlayerColor());
            if (gameModel.checkForWinner()) {
                currentPlayerLabel.setText("Winner: " + gameModel.getCurrentPlayerSymbol());
            } else {
                gameModel.switchPlayer();
                currentPlayerLabel.setText("Current Player: " + gameModel.getCurrentPlayerSymbol());
            }
        }
    }

    private javafx.scene.Node getNodeByRowColumnIndex(final int row, final int column, GridPane gridPane) {
        for (javafx.scene.Node node : gridPane.getChildren()) {
            if (GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == column) {
                return node;
            }
        }
        return null;
    }

    @FXML
    private void handleReset() {
        createBoard(gameModel.getSize());
        currentPlayerLabel.setText("Current Player: X");
    }

    @FXML
    private void handleStartGame() {
        if (size5x5.isSelected()) {
            createBoard(5);
        } else if (size11x11.isSelected()) {
            createBoard(11);
        } else if (size17x17.isSelected()) {
            createBoard(17);
        }
        currentPlayerLabel.setText("Current Player: X");
    }
}
