package org.example.chess.pieces;

import org.example.boardgame.Board;
import org.example.boardgame.Position;
import org.example.chess.ChessPiece;
import org.example.chess.Color;

public class Bishop extends ChessPiece {
    public Bishop(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "B";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0, 0);

        // possible directions to bishop move
        int[][] dimensions = {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

        // check possible positions to bishop move
        for (int[] dimension : dimensions) {
            p.setValues(position.getRow() + dimension[0], position.getColumn()+ dimension[1]);
            while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
                p.setValues(p.getRow() + dimension[0], p.getColumn() + dimension[1]);
            }
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }
        }


        return mat;
    }
}