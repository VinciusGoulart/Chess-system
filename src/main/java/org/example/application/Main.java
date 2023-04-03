package org.example.application;

import org.example.chess.ChessException;
import org.example.chess.ChessMatch;
import org.example.chess.ChessPiece;
import org.example.chess.ChessPosition;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        ChessMatch match = new ChessMatch();
        List<ChessPiece> captured = new ArrayList<>();


        while (!match.isCheckMate()) {
            try {
                UI.clearScreen();
                UI.printMatch(match, captured);

                System.out.println();

                System.out.print("Choose a piece: ");
                ChessPosition source = UI.readChessPosition(sc);

                boolean[][] possibleMoves = match.possibleMoves(source);
                UI.clearScreen();
                UI.printBoard(match.getPieces(), possibleMoves);
                System.out.print("Choose a target: ");
                ChessPosition target = UI.readChessPosition(sc);

                ChessPiece capturedPiece = match.performChessMove(source, target);

                if (capturedPiece != null){
                    captured.add(capturedPiece);
                }

                if (match.getPromoted() != null) {
                    String type;
                    do {
                        System.out.print("Enter piece for promotion (B/N/R/Q): ");
                        type = sc.nextLine().toUpperCase();
                    }while (!type.equals("N") && !type.equals("B") && !type.equals("Q") && !type.equals("R"));

                    match.replacePromotedPiece(type);
                }

            } catch (ChessException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }

        }
        UI.clearScreen();
        UI.printMatch(match,captured);
        sc.close();

    }
}

