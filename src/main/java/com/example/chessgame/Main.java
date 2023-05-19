package com.example.chessgame;

import board.Chessboard;
import board.OccupiedSquares;
import board.Position;
import pieces.*;

public class Main {
    public static void main(String[] args) {
        Chessboard chessboard = new Chessboard();
        OccupiedSquares occupiedSquares = new OccupiedSquares();

        Rook myRook = new Rook(chessboard.getSquare(Position.A1), Color.WHITE);

        Queen myQueen = new Queen(chessboard.getSquare(Position.B1), Color.BLACK);

        Knight myKnight = new Knight(chessboard.getSquare(Position.B3), Color.BLACK);


        myRook.outputAvailableMoves();
        myQueen.outputAvailableMoves();
        myKnight.outputAvailableMoves();

    }
}

