package org.example.boardgame;

import org.example.chess.ChessPosition;

public class Board {

    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board() {

    }

    public Board(int rows, int columns) {
        if (rows < 1 || columns < 1) {
            throw new BoardException("Error creating board: A board needs to have at least 1 row and 1 column");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public Piece piece(int row, int column) {
        if (!positionExist(row, column)) {
            throw new BoardException("This position doesn't exist.");
        }
        return pieces[row][column];
    }

    public Piece piece(Position position) {
        if (!positionExist(position)) {
            throw new BoardException("This position doesn't exist.");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position) {
        if (thereIsAPiece(position)) {
            throw new BoardException("There is already a piece on position " + position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    public Piece removePiece(Position position) {
        if (!positionExist(position)) {
            throw new BoardException("This position doesn't exist.");
        }
        if (piece(position) == null) {
            return null;
        } else {
            Piece aux = piece(position);
            aux.position = null;
            pieces[position.getRow()][position.getColumn()] = null;
            return aux;
        }
    }

    public boolean positionExist(int row, int column) {
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    public boolean positionExist(Position position) {
        return positionExist(position.getRow(), position.getColumn());
    }

    public boolean thereIsAPiece(Position position) {
        if (!positionExist(position)) {
            throw new BoardException("This position doesn't exist.");
        }
        return piece(position) != null;
    }



    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

}
