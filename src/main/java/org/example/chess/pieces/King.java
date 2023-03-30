package org.example.chess.pieces;

import org.example.boardgame.Board;
import org.example.boardgame.Position;
import org.example.chess.ChessPiece;
import org.example.chess.Color;

public class King extends ChessPiece {
    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {

        return "K";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0, 0);
        // check all possible positions around the king
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) { // skip the king's current position
                    continue;
                }
                p.setValues(position.getRow() + i, position.getColumn() + j);
                if (getBoard().positionExists(p)) {
                    ChessPiece piece = (ChessPiece) getBoard().piece(p);
                    if (piece == null || piece.getColor() != getColor()) {
                        mat[p.getRow()][p.getColumn()] = true;
                    }
                }
            }
        }
        return mat;
    }
}
