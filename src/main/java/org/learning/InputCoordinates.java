package org.learning;

import org.learning.board.Board;
import org.learning.pieces.Piece;

import java.util.Scanner;
import java.util.Set;

public class InputCoordinates {
    private static final Scanner scanner = new Scanner(System.in);

    public static Coordinates readInput() {
        while (true) {
            System.out.println("Please, enter coordinates (ex. A1)");
            String input = scanner.nextLine();

            if (input.length() != 2) {
                System.out.println("Invalid format");
                continue;
            }

            char fileChar = input.charAt(0);
            char rankChar = input.charAt(1);

            if (!Character.isLetter(fileChar)) {
                System.out.println("Invalid format");
                continue;
            }
            if (!Character.isDigit(rankChar)) {
                System.out.println("Invalid format");
                continue;
            }

            if (!(fileChar >= 'A' && fileChar <= 'H')) {
                System.out.println("Invalid format");
                continue;
            }
            if (!(parseCharToInteger(rankChar) > 0 && parseCharToInteger(rankChar) < 9)) {
                System.out.println("Invalid format");
                continue;
            }

            return new Coordinates(File.fromChar(fileChar),  parseCharToInteger(rankChar));
        }
    }

    public static Coordinates readInputPieceCoordinatesForColor(Color color, Board board) {
        while (true) {
            System.out.println("Enter coordinates for a piece to move");
            Coordinates coordinates = readInput();

            if (board.isSquareEmpty(coordinates)) {
                System.out.println("Empty square");
                continue;
            }

            Piece piece = board.getPiece(coordinates);

            if (piece.color != color) {
                System.out.println("Wrong color");
                continue;
            }

            Set<Coordinates> availableSquares = piece.getAvailableSquaresToMove(board);

            if (availableSquares.isEmpty()) {
                System.out.println("No available squares to move");
                continue;
            }

            return coordinates;
        }
    }

    public static Coordinates inputAvailableSquares(Set<Coordinates> coordinates) {
        while (true) {
            System.out.println("Please, enter your move for a selected piece");
            Coordinates input = readInput();
            if (!coordinates.contains(input)) {
                System.out.println("No available squares");
                continue;
            }

            return input;
        }
    }

    private static int parseCharToInteger(char c) {
        return Integer.parseInt(String.valueOf(c));
    }
}
