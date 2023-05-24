package com.example.chessgame;

import board.Chessboard;
import board.OccupiedSquares;
import board.Position;
import pieces.*;

public class Main {
    public static void main(String[] args) {
        Chessboard chessboard = new Chessboard();
        OccupiedSquares occupiedSquares = new OccupiedSquares();



        Knight myKnight = new Knight(chessboard.getSquare(Position.B3), PieceColor.BLACK);

        myKnight.outputAvailableMoves();
    }
}

