package org.example.chess.pieces;


import org.example.boardgame.Board;
import org.example.chess.ChessPiece;
import org.example.chess.Color;

public class Hook extends ChessPiece {


    public Hook(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "H";
    }
}
