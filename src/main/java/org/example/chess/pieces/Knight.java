package org.example.chess.pieces;

import org.example.boardgame.Board;
import org.example.boardgame.Position;
import org.example.chess.ChessPiece;
import org.example.chess.Color;

public class Knight extends ChessPiece {
    public Knight(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "N";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0, 0);

        int[][] directions = {{2, 1}, {2, -1}, {-2, 1}, {-2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2}};
        for (int[] direction : directions) {
                p.setValues(position.getRow() + direction[0],position.getColumn() + direction[1]);
                if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
                    mat[p.getRow()][p.getColumn()] = true;

                }
                if (getBoard().positionExists(p) && isThereOpponentPiece(p)){
                    mat[p.getRow()][p.getColumn()] = true;
                }
        }
        return mat;
    }
}
