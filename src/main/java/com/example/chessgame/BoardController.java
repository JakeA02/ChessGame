package com.example.chessgame;

import board.Chessboard;
import board.OccupiedSquares;
import board.Position;
import board.Square;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.effect.BlurType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Shape;
import javafx.scene.input.*;
import pieces.*;

import java.util.ArrayList;
import java.util.List;


public class BoardController {
    @FXML
    private GridPane chessBoardGrid;
    private Shape[][] chessPieces;

    @FXML private Shape whitePawn1, whitePawn2, whitePawn3, whitePawn4, whitePawn5, whitePawn6, whitePawn7, whitePawn8;
    @FXML private Shape blackPawn1, blackPawn2, blackPawn3, blackPawn4, blackPawn5, blackPawn6, blackPawn7, blackPawn8;
    @FXML private Shape whiteRook1, whiteKnight1, whiteRook2, whiteKnight2, whiteBishop1, whiteBishop2, whiteQueen, whiteKing;
    @FXML private Shape blackRook1, blackKnight1, blackRook2, blackKnight2, blackBishop1, blackBishop2, blackQueen, blackKing;
    private Pawn wp1, wp2, wp3, wp4, wp5, wp6, wp7, wp8;
    private Pawn bp1, bp2, bp3, bp4, bp5, bp6, bp7, bp8;
    private Rook wr1, wr2, br1, br2;
    private Knight wk1, wk2, bk1, bk2;
    private Bishop wb1, wb2, bb1, bb2;
    private Queen wq, bq;
    private King wk, bk;



    private OccupiedSquares occupiedSquares;

    private Chessboard chessboard;



        @FXML
        private void initialize() {
            // Perform initialization tasks here
            createChessBoard();
            initializeChessPieces();

        }

        private void createChessBoard() {

            occupiedSquares = new OccupiedSquares();
            chessboard = new Chessboard();

            Pawn wp1 = new Pawn(chessboard.getSquare(Position.A2), Color.WHITE);
            Pawn wp2 = new Pawn(chessboard.getSquare(Position.B2), Color.WHITE);
            Pawn wp3 = new Pawn(chessboard.getSquare(Position.C2), Color.WHITE);
            Pawn wp4 = new Pawn(chessboard.getSquare(Position.D2), Color.WHITE);
            Pawn wp5 = new Pawn(chessboard.getSquare(Position.E2), Color.WHITE);
            Pawn wp6 = new Pawn(chessboard.getSquare(Position.F2), Color.WHITE);
            Pawn wp7 = new Pawn(chessboard.getSquare(Position.G2), Color.WHITE);
            Pawn wp8 = new Pawn(chessboard.getSquare(Position.H2), Color.WHITE);

            Pawn bp1 = new Pawn(chessboard.getSquare(Position.A7), Color.BLACK);
            Pawn bp2 = new Pawn(chessboard.getSquare(Position.B7), Color.BLACK);
            Pawn bp3 = new Pawn(chessboard.getSquare(Position.C7), Color.BLACK);
            Pawn bp4 = new Pawn(chessboard.getSquare(Position.D7), Color.BLACK);
            Pawn bp5 = new Pawn(chessboard.getSquare(Position.E7), Color.BLACK);
            Pawn bp6 = new Pawn(chessboard.getSquare(Position.F7), Color.BLACK);
            Pawn bp7 = new Pawn(chessboard.getSquare(Position.G7), Color.BLACK);
            Pawn bp8 = new Pawn(chessboard.getSquare(Position.H7), Color.BLACK);


            Rook wr1 = new Rook(chessboard.getSquare(Position.A1), Color.WHITE);
            Rook wr2 = new Rook(chessboard.getSquare(Position.H1), Color.WHITE);
            Rook br1 = new Rook(chessboard.getSquare(Position.A8), Color.BLACK);
            Rook br2 = new Rook(chessboard.getSquare(Position.H8), Color.BLACK);

            Knight wk1 = new Knight(chessboard.getSquare(Position.B1), Color.WHITE);
            Knight wk2 = new Knight(chessboard.getSquare(Position.G1), Color.WHITE);
            Knight bk1 = new Knight(chessboard.getSquare(Position.B8), Color.BLACK);
            Knight bk2 = new Knight(chessboard.getSquare(Position.G8), Color.BLACK);

            Bishop wb1 = new Bishop(chessboard.getSquare(Position.C1), Color.WHITE);
            Bishop wb2 = new Bishop(chessboard.getSquare(Position.F1), Color.WHITE);
            Bishop bb1 = new Bishop(chessboard.getSquare(Position.C8), Color.BLACK);
            Bishop bb = new Bishop(chessboard.getSquare(Position.F8), Color.BLACK);

            Queen wq = new Queen(chessboard.getSquare(Position.D1), Color.WHITE);
            Queen bq = new Queen(chessboard.getSquare(Position.D8), Color.BLACK);

            King wk = new King(chessboard.getSquare(Position.E1), Color.WHITE);
            King bK = new King(chessboard.getSquare(Position.E8), Color.BLACK);

        }

        private void initializeChessPieces() {
            // Initialize the chess pieces and their initial positions
            chessPieces = new Shape[8][8];
            // Store the references to the pieces in the chessPieces array
            chessPieces[7][0] = whiteRook1;
            chessPieces[7][1] = whiteKnight1;
            chessPieces[7][2] = whiteBishop1;

            chessPieces[7][3] = whiteKing;
            chessPieces[7][4] = whiteQueen;

            chessPieces[7][5] = whiteBishop2;
            chessPieces[7][6] = whiteKnight2;
            chessPieces[7][7] = whiteRook2;

            chessPieces[6][0] = whitePawn1;
            chessPieces[6][1] = whitePawn2;
            chessPieces[6][2] = whitePawn3;
            chessPieces[6][3] = whitePawn4;
            chessPieces[6][4] = whitePawn5;
            chessPieces[6][5] = whitePawn6;
            chessPieces[6][6] = whitePawn7;
            chessPieces[6][7] = whitePawn8;

            chessPieces[0][0] = blackRook1;
            chessPieces[0][1] = blackKnight1;
            chessPieces[0][2] = blackBishop1;

            chessPieces[0][3] = blackKing;
            chessPieces[0][4] = blackQueen;

            chessPieces[0][5] = blackBishop2;
            chessPieces[0][6] = blackKnight2;
            chessPieces[0][7] = blackRook2;

            chessPieces[1][0] = blackPawn1;
            chessPieces[1][1] = blackPawn2;
            chessPieces[1][2] = blackPawn3;
            chessPieces[1][3] = blackPawn4;
            chessPieces[1][4] = blackPawn5;
            chessPieces[1][5] = blackPawn6;
            chessPieces[1][6] = blackPawn7;
            chessPieces[1][7] = blackPawn8;

        }

        private void setPieceLocation(int row, int column, Shape piece) {
            // Update the position of the piece on the chessboard
            GridPane.setRowIndex(piece, row);
            GridPane.setColumnIndex(piece, column);

            Shape[] whitePawns = {whitePawn1, whitePawn2, whitePawn3, whitePawn4, whitePawn5, whitePawn6, whitePawn7, whitePawn8};
            Pawn[] whitePawnsArray = {wp1, wp2, wp3, wp4, wp5, wp6, wp7, wp8};

            Shape[] blackPawns = {blackPawn1, blackPawn2, blackPawn3, blackPawn4, blackPawn5, blackPawn6, blackPawn7, blackPawn8};
            Pawn[] blackPawnsArray = {bp1, bp2, bp3, bp4, bp5, bp6, bp7, bp8};

            Shape[] whiteKnights = {whiteKnight1, whiteKnight2};
            Knight[] whiteKnightsArray = {wk1, wk2};

            Shape[] blackKnights = {blackKnight1, blackKnight2};
            Knight[] blackKnightsArray = {bk1, bk2};

            Shape[] whiteBishops = {whiteBishop1, whiteBishop2};
            Bishop[] whiteBishopsArray = {wb1, wb2};

            Shape[] blackBishops = {blackBishop1, blackBishop2};
            Bishop[] blackBishopsArray = {bb1, bb2};

            Shape[] whiteRooks = {whiteRook1, whiteRook2};
            Rook[] whiteRooksArray = {wr1, wr2};

            Shape[] blackRooks = {blackRook1, blackRook2};
            Rook[] blackRooksArray = {br1, br2};

            for (int i = 0; i < whitePawns.length; i++) {
                if (piece.equals(whitePawns[i])) {
                    whitePawnsArray[i].setPosition(chessboard.getSquare(row, column), whitePawnsArray[i]);
                    break;
                } else if (piece.equals(blackPawns[i])) {
                    blackPawnsArray[i].setPosition(chessboard.getSquare(row, column), blackPawnsArray[i]);
                    break;
                } else if (piece.equals(whiteKnights[i])) {
                    whiteKnightsArray[i].setPosition(chessboard.getSquare(row, column), whiteKnightsArray[i]);
                    break;
                } else if (piece.equals(blackKnights[i])) {
                    blackKnightsArray[i].setPosition(chessboard.getSquare(row, column), blackKnightsArray[i]);
                    break;
                } else if (piece.equals(whiteBishops[i])) {
                    whiteBishopsArray[i].setPosition(chessboard.getSquare(row, column), whiteBishopsArray[i]);
                    break;
                } else if (piece.equals(blackBishops[i])) {
                    blackBishopsArray[i].setPosition(chessboard.getSquare(row, column), blackBishopsArray[i]);
                    break;
                } else if (piece.equals(whiteRooks[i])) {
                    whiteRooksArray[i].setPosition(chessboard.getSquare(row, column), whiteRooksArray[i]);
                    break;
                } else if (piece.equals(blackRooks[i])) {
                    blackRooksArray[i].setPosition(chessboard.getSquare(row, column), blackRooksArray[i]);
                    break;
                } else if (piece.equals(whiteQueen)) {
                    wq.setPosition(chessboard.getSquare(row, column), wq);
                } else if (piece.equals(blackQueen)) {
                    bq.setPosition(chessboard.getSquare(row, column), bq);
                } else if (piece.equals(whiteKing)) {
                    wk.setPosition(chessboard.getSquare(row, column), wk);
                } else if (piece.equals(blackKing)) {
                    bk.setPosition(chessboard.getSquare(row, column), bk);
                }
            }
        }

        // Example usage:
        private void movePiece(int fromRow, int fromColumn, int toRow, int toColumn) {
            Shape piece = chessPieces[fromRow][fromColumn];
            if (piece != null) {
                setPieceLocation(toRow, toColumn, piece);
                chessPieces[fromRow][fromColumn] = null;
                chessPieces[toRow][toColumn] = piece;
            }
        }

        private List<Square> getAvailableMoves(Shape piece) {

            Shape[] whitePawns = {whitePawn1, whitePawn2, whitePawn3, whitePawn4, whitePawn5, whitePawn6, whitePawn7, whitePawn8};
            Pawn[] whitePawnsArray = {wp1, wp2, wp3, wp4, wp5, wp6, wp7, wp8};

            Shape[] blackPawns = {blackPawn1, blackPawn2, blackPawn3, blackPawn4, blackPawn5, blackPawn6, blackPawn7, blackPawn8};
            Pawn[] blackPawnsArray = {bp1, bp2, bp3, bp4, bp5, bp6, bp7, bp8};

            Shape[] whiteKnights = {whiteKnight1, whiteKnight2};
            Knight[] whiteKnightsArray = {wk1, wk2};

            Shape[] blackKnights = {blackKnight1, blackKnight2};
            Knight[] blackKnightsArray = {bk1, bk2};

            Shape[] whiteBishops = {whiteBishop1, whiteBishop2};
            Bishop[] whiteBishopsArray = {wb1, wb2};

            Shape[] blackBishops = {blackBishop1, blackBishop2};
            Bishop[] blackBishopsArray = {bb1, bb2};

            Shape[] whiteRooks = {whiteRook1, whiteRook2};
            Rook[] whiteRooksArray = {wr1, wr2};

            Shape[] blackRooks = {blackRook1, blackRook2};
            Rook[] blackRooksArray = {br1, br2};


            for (int i = 0; i < whitePawns.length; i++) {
                if (piece.equals(whitePawns[i])) {
                    return whitePawnsArray[i].getAvailableMoves();
                } else if (piece.equals(blackPawns[i])) {
                    return blackPawnsArray[i].getAvailableMoves();
                } else if (piece.equals(whiteKnights[i])) {
                    return whiteKnightsArray[i].getAvailableMoves();
                } else if (piece.equals(blackKnights[i])) {
                    return blackKnightsArray[i].getAvailableMoves();
                } else if (piece.equals(whiteBishops[i])) {
                    return whiteBishopsArray[i].getAvailableMoves();
                } else if (piece.equals(blackBishops[i])) {
                    return blackBishopsArray[i].getAvailableMoves();
                } else if (piece.equals(whiteRooks[i])) {
                    return whiteRooksArray[i].getAvailableMoves();
                } else if (piece.equals(blackRooks[i])) {
                    return blackRooksArray[i].getAvailableMoves();
                } else if (piece.equals(whiteQueen)) {
                    return wq.getAvailableMoves();
                } else if (piece.equals(blackQueen)) {
                    return bq.getAvailableMoves();
                } else if (piece.equals(whiteKing)) {
                    return wk.getAvailableMoves();
                } else if (piece.equals(blackKing)) {
                    return bk.getAvailableMoves();
                }
            }
            return null;
        }

        public List<String> getListOfGridMoves(List <Square> list){
        List<String> coordinates = new ArrayList<>();
            for (Square square: list) {
                int row = letterToInt(square.getKey());
                int column = square.getValue() - 1;

                String coordinate = "(" + row + ", " + column + ")";
                coordinates.add(coordinate);
            }

            return coordinates;
        }

        public Integer letterToInt(Character character){
            character = Character.toUpperCase(character);
            switch (character){
                case 'A':
                    return 0;
                case 'B':
                    return 1;
                case 'C':
                    return 2;
                case 'D':
                    return 3;
                case 'E':
                    return 4;
                case 'F':
                    return 5;
                case 'G':
                    return 6;
                default:
                    return 7;
            }
        }

    @FXML
    private void handlePieceDragDetected(MouseEvent event) {
        // Get the source of the event, which is the piece being dragged
        Shape piece = (Shape) event.getSource();

        // Start drag-and-drop gesture
        Dragboard dragboard = piece.startDragAndDrop(TransferMode.MOVE);

        // Set the drag data to the piece
        ClipboardContent content = new ClipboardContent();
        content.putString(piece.getId()); // Store the piece's ID as the drag data
        dragboard.setContent(content);

        event.consume();
    }

    @FXML
    private void handlePieceDragOver(DragEvent event) {
        if (event.getGestureSource() != event.getTarget() && event.getDragboard().hasString()) {
            // Allow the piece to be moved to the new target
            event.acceptTransferModes(TransferMode.MOVE);
        }

        event.consume();
    }

    @FXML
    private void handlePieceDragDropped(DragEvent event) {
        Shape target = (Shape) event.getTarget();

        // Retrieve the piece's ID from the dragboard
        String pieceId = event.getDragboard().getString();

        // Perform the necessary actions for the dropped piece
        // ...

        event.setDropCompleted(true);
        event.consume();
    }

    @FXML
    private void handlePieceDragDone(DragEvent event) {
        if (event.getTransferMode() == TransferMode.MOVE) {
            // Remove the piece from the previous position or perform other necessary actions
            // ...
        }

        event.consume();
    }

    // Rest of the controller code...

}

        // Other methods and event handlers...

