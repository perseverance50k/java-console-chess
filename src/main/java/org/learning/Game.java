package org.learning;

import org.learning.board.Board;
import org.learning.board.BoardConsoleRenderer;
import org.learning.pieces.Piece;

import java.util.Set;

public class Game {
    private final Board board;
    private final BoardConsoleRenderer renderer;
    private final InputCoordinates inputCoordinates;

    public Game(Board board) {
        this.board = board;
        this.renderer = new BoardConsoleRenderer();
        this.inputCoordinates = new InputCoordinates();
    }

    public void gameLoop() {
        boolean isWhiteTurnToMove = true;

        while (true) {
            renderer.render(board);

            if (isWhiteTurnToMove) System.out.println("White's turn");
            else System.out.println("Black's turn");

            Coordinates sourceCoordinates = InputCoordinates.readInputPieceCoordinatesForColor(
                    isWhiteTurnToMove ? Color.WHITE : Color.BLACK, board
            );

            Piece piece = board.getPiece(sourceCoordinates);
            Set<Coordinates> availableMoveSquares = piece.getAvailableSquaresToMove(board);

            Coordinates targetCoordinates = InputCoordinates.inputAvailableSquares(availableMoveSquares);

            board.movePiece(sourceCoordinates, targetCoordinates);
        }
    }
}
