package org.example.application;

import org.example.chess.ChessException;
import org.example.chess.ChessMatch;
import org.example.chess.ChessPiece;
import org.example.chess.ChessPosition;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        ChessMatch match = new ChessMatch();

        while (true) {
            try {
                UI.clearScreen();
                UI.printBoard(match.getPieces());

                System.out.println();

                System.out.print("Choose a piece: ");
                ChessPosition source = UI.readChessPosition(sc);

                System.out.print("Choose a target: ");
                ChessPosition target = UI.readChessPosition(sc);

                match.performChessMove(source, target);

            } catch (ChessException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }

        }

    }
}
