package com.hexgame;

import javafx.application.Application;
import javafx.stage.Stage;

import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;

public class BoardView {
    private GridPane board;

    public BoardView(GridPane board) {
        this.board = board;
    }

    public void addCell(int row, int col, Button cell) {
        board.add(cell, col, row);
    }
}
