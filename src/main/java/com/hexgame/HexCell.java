package com.hexgame;

import javafx.application.Application;
import javafx.stage.Stage;


public class HexCell {
    private int row;
    private int col;
    private String player;

    public HexCell(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }
}
