package org.example.application;

import org.example.chess.ChessMatch;

public class Main {
    public static void main(String[] args) {

        ChessMatch match = new ChessMatch();
        UI.printBoard(match.getPieces());
    }
}
