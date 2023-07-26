package org.learning.pieces;

import org.learning.Color;
import org.learning.Coordinates;
import org.learning.CoordinatesShift;

import java.util.Set;

public class Rook extends Piece {
    public Rook(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }

    @Override
    protected Set<CoordinatesShift> getPieceMoves() {
        return null;
    }
}
