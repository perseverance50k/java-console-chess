package org.learning;

import org.learning.board.Board;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        board.setupDefaultPiecePositions();

        Game game = new Game(board);
        game.gameLoop();
    }
}