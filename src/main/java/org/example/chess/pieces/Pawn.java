package org.example.chess.pieces;

import org.example.boardgame.Board;
import org.example.boardgame.Position;
import org.example.chess.ChessPiece;
import org.example.chess.Color;

public class Pawn extends ChessPiece {

    public Pawn(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "P";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0, 0);

        // possible directions to capture a opponent piece
        int[][] captureDimensions = {{1, 1}, {1, -1}};

        // possible directions to pawn move
        int[][] moveDimensions = {{1, 0},{-1,0}};

        // check possible positions to capture a opponent piece
        for (int[] dimension : captureDimensions) {
            p.setValues(position.getRow() + dimension[0], position.getColumn() + dimension[1]);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
                p.setValues(p.getRow() + dimension[0], p.getColumn() + dimension[1]);
            }
        }

        // check possible positions to pawn move
        for (int[] dimension : moveDimensions) {
            p.setValues(position.getRow() + dimension[0], position.getColumn() + dimension[1]);
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
                p.setValues(p.getRow() + dimension[0], p.getColumn() + dimension[1]);
            }
        }

        return mat;
    }

}
