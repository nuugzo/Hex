package com.hexgame;


public class GameModel {
    private int size;
    private String[][] board;
    private boolean isPlayerOneTurn;
    private String playerOneSymbol = "X";
    private String playerTwoSymbol = "O";
    private String playerOneColor = "#FF0000";
    private String playerTwoColor = "#0000FF";

    public GameModel(int size) {
        this.size = size;
        board = new String[size][size];
        isPlayerOneTurn = true;
    }

    public boolean makeMove(int row, int col) {
        if (board[row][col] == null) {
            board[row][col] = isPlayerOneTurn ? playerOneSymbol : playerTwoSymbol;
            return true;
        }
        return false;
    }

    public void switchPlayer() {
        isPlayerOneTurn = !isPlayerOneTurn;
    }

    public boolean checkForWinner() {
        // Kazanan kontrolünü yap (bağlantıyı kontrol et)
        return false;
    }

    public int getSize() {
        return size;
    }

    public String getCurrentPlayerSymbol() {
        return isPlayerOneTurn ? playerOneSymbol : playerTwoSymbol;
    }

    public String getCurrentPlayerColor() {
        return isPlayerOneTurn ? playerOneColor : playerTwoColor;
    }
}
