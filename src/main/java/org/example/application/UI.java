package org.example.application;

import org.example.chess.ChessMatch;
import org.example.chess.ChessPiece;
import org.example.chess.ChessPosition;
import org.example.chess.Color;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UI {

    // https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    public static void clearScreen() {
        System.out.println("\033[h\033[2j");
        System.out.flush();
    }

    public static void printMatch(ChessMatch chessMatch,List<ChessPiece> captured) {
        printBoard(chessMatch.getPieces());
        System.out.println();
        capturedChessPiecesList(captured);
        System.out.println();
        System.out.println("Turn: " + chessMatch.getTurn());
        if (!chessMatch.isCheckMate()) {
            System.out.println("Current player: " + chessMatch.getCurrentPlayer());
            if (chessMatch.getCheck()) {
                System.out.print(ANSI_RED);
                System.out.println("CHECK!");
                System.out.print(ANSI_RESET);
            }
        }else {
            System.out.println("CHECKMATE!!!!!");
            System.out.print(ANSI_GREEN);
            System.out.println("Winner: " + chessMatch.getCurrentPlayer());
            System.out.print(ANSI_RESET);
        }
    }

    public static void printBoard(ChessPiece[][] pieces) {

        for (int i = 0; i < pieces.length; i++) {
            System.out.print((8 - i) + " ");

            for (int j = 0; j < pieces.length; j++) {
                UI.printPiece(pieces[i][j], false);

            }
            System.out.println();

        }
        System.out.println("  a b c d e f g h");
    }

    public static void printBoard(ChessPiece[][] pieces, boolean[][] possibleMoves) {

        for (int i = 0; i < pieces.length; i++) {
            System.out.print((8 - i) + " ");

            for (int j = 0; j < pieces.length; j++) {
                UI.printPiece(pieces[i][j], possibleMoves[i][j]);
            }
            System.out.println();

        }
        System.out.println("  a b c d e f g h");
    }


    // add background colour to possible moves and  colour pieces
    public static void printPiece(ChessPiece piece, boolean background) {
        if (background) {
            System.out.print(ANSI_BLUE_BACKGROUND);
        }
        if (piece == null) {
            System.out.print("-" + ANSI_RESET);
        } else if (piece.getColor() == Color.WHITE) {
            System.out.print(ANSI_WHITE + piece + ANSI_RESET);
        } else {
            System.out.print(ANSI_YELLOW + piece + ANSI_RESET);
        }
        System.out.print(" ");
    }

    public static ChessPosition readChessPosition(Scanner sc) {
        try {
            String s = sc.nextLine();

            char column = s.charAt(0);
            int row = Integer.parseInt(s.substring(1));

            return new ChessPosition(column, row);
        } catch (RuntimeException e) {
            throw new InputMismatchException("Error reading ChessPosition. Valid values are from a1 to h8");
        }
    }

    public static void capturedChessPiecesList(List<ChessPiece> chessPieces) {
        List<ChessPiece> white = chessPieces.stream().filter(x -> x.getColor() == (Color.WHITE)).collect(Collectors.toList());
        List<ChessPiece> black = chessPieces.stream().filter(x -> x.getColor() == (Color.BLACK)).collect(Collectors.toList());

        System.out.println("Captured pieces: ");
        System.out.print("White: ");
        System.out.print(ANSI_WHITE);
        System.out.println(Arrays.toString(white.toArray()));
        System.out.print(ANSI_RESET);
        System.out.print("Black: ");
        System.out.print(ANSI_YELLOW);
        System.out.println(Arrays.toString(black.toArray()));
        System.out.print(ANSI_RESET);
    }
}
