package com.example.chessgame;

import board.*;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.scene.input.*;
import pieces.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class BoardController {
    @FXML
    private GridPane chessBoardGrid;
    private Shape[][] chessPieces;

    @FXML
    private Shape whitePawn1, whitePawn2, whitePawn3, whitePawn4, whitePawn5, whitePawn6, whitePawn7, whitePawn8;
    @FXML
    private Shape blackPawn1, blackPawn2, blackPawn3, blackPawn4, blackPawn5, blackPawn6, blackPawn7, blackPawn8;
    @FXML
    private Shape whiteRook1, whiteKnight1, whiteRook2, whiteKnight2, whiteBishop1, whiteBishop2, whiteQueen, whiteKing;
    @FXML
    private Shape blackRook1, blackKnight1, blackRook2, blackKnight2, blackBishop1, blackBishop2, blackQueen, blackKing;
    private Pawn wp1, wp2, wp3, wp4, wp5, wp6, wp7, wp8;
    private  Pawn bp1, bp2, bp3, bp4, bp5, bp6, bp7, bp8;
    private  Rook wr1, wr2, br1, br2;
    private Knight wk1, wk2, bk1, bk2;
    private  Bishop wb1, wb2, bb1, bb2;
    private Queen wq, bq;
    private King wk, bk;

    @FXML
    private Shape indicatorA1, indicatorB1, indicatorC1, indicatorD1, indicatorE1, indicatorF1, indicatorG1, indicatorH1;
    @FXML
    private Shape indicatorA2, indicatorB2, indicatorC2, indicatorD2, indicatorE2, indicatorF2, indicatorG2, indicatorH2;
    @FXML
    private Shape indicatorA3, indicatorB3, indicatorC3, indicatorD3, indicatorE3, indicatorF3, indicatorG3, indicatorH3;
    @FXML
    private Shape indicatorA4, indicatorB4, indicatorC4, indicatorD4, indicatorE4, indicatorF4, indicatorG4, indicatorH4;
    @FXML
    private Shape indicatorA5, indicatorB5, indicatorC5, indicatorD5, indicatorE5, indicatorF5, indicatorG5, indicatorH5;
    @FXML
    private Shape indicatorA6, indicatorB6, indicatorC6, indicatorD6, indicatorE6, indicatorF6, indicatorG6, indicatorH6;
    @FXML
    private Shape indicatorA7, indicatorB7, indicatorC7, indicatorD7, indicatorE7, indicatorF7, indicatorG7, indicatorH7;
    @FXML
    private Shape indicatorA8, indicatorB8, indicatorC8, indicatorD8, indicatorE8, indicatorF8, indicatorG8, indicatorH8;

    private  Shape[] indicatorsRow1 = new Shape[8];
    private  Shape[] indicatorsRow2 = new Shape[8];
    private Shape[] indicatorsRow3 = new Shape[8];
    private  Shape[] indicatorsRow4 = new Shape[8];
    private  Shape[] indicatorsRow5 = new Shape[8];
    private  Shape[] indicatorsRow6 = new Shape[8];
    private  Shape[] indicatorsRow7 = new Shape[8];
    private  Shape[] indicatorsRow8 = new Shape[8];


    private Shape[] whitePawns =  new Shape[8];
    private Pawn[] whitePawnsArray = new Pawn[8];

    private Shape[] blackPawns =  new Shape[8];
    private Pawn[] blackPawnsArray = new Pawn[8];

    private Shape[] whiteKnights =  new Shape[2];
    Knight[] whiteKnightsArray = new Knight[2];

    private  Shape[] blackKnights = new Shape[2];
    Knight[] blackKnightsArray = new Knight[2];

    private Shape[] whiteBishops =  new Shape[2];
    Bishop[] whiteBishopsArray = new Bishop[2];

    private  Shape[] blackBishops =  new Shape[2];
    Bishop[] blackBishopsArray = new Bishop[2];

    private  Shape[] whiteRooks =  new Shape[2];
    Rook[] whiteRooksArray = new Rook[2];

    private  Shape[] blackRooks =  new Shape[2];
    Rook[] blackRooksArray = new Rook[2];

    private Shape currentlySelectedShape;
    private Chessboard chessboard;

    private boolean whitesTurn;




    @FXML
    private void initialize() {
        // Perform initialization tasks here
        createChessBoard();
        createArrays();
        addImages();
        whitesTurn = true;
    }

    private void createArrays() {
        indicatorsRow1 = new Shape[]{indicatorA1, indicatorB1, indicatorC1, indicatorD1, indicatorE1, indicatorF1, indicatorG1, indicatorH1};
        indicatorsRow2 = new Shape[]{indicatorA2, indicatorB2, indicatorC2, indicatorD2, indicatorE2, indicatorF2, indicatorG2, indicatorH2};
        indicatorsRow3 = new Shape[]{indicatorA3, indicatorB3, indicatorC3, indicatorD3, indicatorE3, indicatorF3, indicatorG3, indicatorH3};
        indicatorsRow4 = new Shape[]{indicatorA4, indicatorB4, indicatorC4, indicatorD4, indicatorE4, indicatorF4, indicatorG4, indicatorH4};
        indicatorsRow5 = new Shape[]{indicatorA5, indicatorB5, indicatorC5, indicatorD5, indicatorE5, indicatorF5, indicatorG5, indicatorH5};
        indicatorsRow6 = new Shape[]{indicatorA6, indicatorB6, indicatorC6, indicatorD6, indicatorE6, indicatorF6, indicatorG6, indicatorH6};
        indicatorsRow7 = new Shape[]{indicatorA7, indicatorB7, indicatorC7, indicatorD7, indicatorE7, indicatorF7, indicatorG7, indicatorH7};
        indicatorsRow8 = new Shape[]{indicatorA8, indicatorB8, indicatorC8, indicatorD8, indicatorE8, indicatorF8, indicatorG8, indicatorH8};

        whitePawns = new Shape[]{whitePawn1, whitePawn2, whitePawn3, whitePawn4, whitePawn5, whitePawn6, whitePawn7, whitePawn8};
        blackPawns = new Shape[]{blackPawn1, blackPawn2, blackPawn3, blackPawn4, blackPawn5, blackPawn6, blackPawn7, blackPawn8};
        whiteKnights = new Shape[]{whiteKnight1, whiteKnight2};
        blackKnights = new Shape[]{blackKnight1, blackKnight2};
        whiteBishops = new Shape[]{whiteBishop1, whiteBishop2};
        blackBishops = new Shape[]{blackBishop1, blackBishop2};
        whiteRooks = new Shape[]{whiteRook1, whiteRook2};
        blackRooks = new Shape[]{blackRook1, blackRook2};


        whitePawnsArray = new Pawn[]{wp1, wp2, wp3, wp4, wp5, wp6, wp7, wp8};

        blackPawnsArray = new Pawn[]{bp1, bp2, bp3, bp4, bp5, bp6, bp7, bp8};

        whiteKnightsArray = new Knight[]{wk1, wk2};

        blackKnightsArray = new Knight[]{bk1, bk2};

        whiteBishopsArray = new Bishop[]{wb1, wb2};

        blackBishopsArray = new Bishop[]{bb1, bb2};

        whiteRooksArray = new Rook[]{wr1, wr2};

        blackRooksArray = new Rook[]{br1, br2};

    }

    private void addImages(){
        Image blackPawnImage = new Image("C:\\Users\\jakea\\IdeaProjects\\Chess-Game\\src\\main\\resources\\com\\example\\chessgame\\blackPawnImage.png");
        Image whitePawnImage = new Image("C:\\Users\\jakea\\IdeaProjects\\Chess-Game\\src\\main\\resources\\com\\example\\chessgame\\whitePawnImage.png");
        Image whiteKnightImage = new Image("C:\\Users\\jakea\\IdeaProjects\\Chess-Game\\src\\main\\resources\\com\\example\\chessgame\\whiteKnightImage.png");
        Image blackKnightImage = new Image("C:\\Users\\jakea\\IdeaProjects\\Chess-Game\\src\\main\\resources\\com\\example\\chessgame\\blackKnightImage.png");
        Image whiteBishopImage = new Image("C:\\Users\\jakea\\IdeaProjects\\Chess-Game\\src\\main\\resources\\com\\example\\chessgame\\whiteBishopImage.png");
        Image blackBishopImage = new Image("C:\\Users\\jakea\\IdeaProjects\\Chess-Game\\src\\main\\resources\\com\\example\\chessgame\\blackBishopImage.png");
        Image blackRookImage = new Image("C:\\Users\\jakea\\IdeaProjects\\Chess-Game\\src\\main\\resources\\com\\example\\chessgame\\blackRookImage.png");
        Image whiteRookImage = new Image("C:\\Users\\jakea\\IdeaProjects\\Chess-Game\\src\\main\\resources\\com\\example\\chessgame\\whiteRookImage.png");

        Image whiteQueenImage = new Image("C:\\Users\\jakea\\IdeaProjects\\Chess-Game\\src\\main\\resources\\com\\example\\chessgame\\whiteQueenImage.png");
        Image blackQueenImage = new Image("C:\\Users\\jakea\\IdeaProjects\\Chess-Game\\src\\main\\resources\\com\\example\\chessgame\\blackQueenImage.png");
        Image blackKingImage = new Image("C:\\Users\\jakea\\IdeaProjects\\Chess-Game\\src\\main\\resources\\com\\example\\chessgame\\blackKingImage.png");
        Image whiteKingImage = new Image("C:\\Users\\jakea\\IdeaProjects\\Chess-Game\\src\\main\\resources\\com\\example\\chessgame\\whiteKingImage.png");


        for (Shape pawn: whitePawns ) {
            pawn.setFill(new ImagePattern(whitePawnImage));
        }
        for (Shape pawn: blackPawns ) {
            pawn.setFill(new ImagePattern(blackPawnImage));
        }
        for (Shape knight: whiteKnights) {
            knight.setFill(new ImagePattern(whiteKnightImage));
        }
        for (Shape knight: blackKnights) {
            knight.setFill(new ImagePattern(blackKnightImage));
        }
        for(Shape bishop: whiteBishops) {
            bishop.setFill(new ImagePattern(whiteBishopImage));
        }

        for(Shape bishop: blackBishops){
            bishop.setFill(new ImagePattern(blackBishopImage));
        }
        for(Shape rook: whiteRooks) {
            rook.setFill(new ImagePattern(whiteRookImage));
        }
        for(Shape rook: blackRooks) {
            rook.setFill(new ImagePattern(blackRookImage));
        }
        whiteQueen.setFill(new ImagePattern(whiteQueenImage));
        blackQueen.setFill(new ImagePattern(blackQueenImage));
        whiteKing.setFill(new ImagePattern(whiteKingImage));
        blackKing.setFill(new ImagePattern(blackKingImage));

    }

    private void createChessBoard() {


        OccupiedSquares occupiedSquares = new OccupiedSquares();
        chessboard = new Chessboard();
        clearIndicators();





        wp1 = new Pawn(chessboard.getSquare(Position.A2), PieceColor.WHITE);
        wp2 = new Pawn(chessboard.getSquare(Position.B2), PieceColor.WHITE);
        wp3 = new Pawn(chessboard.getSquare(Position.C2), PieceColor.WHITE);
        wp4 = new Pawn(chessboard.getSquare(Position.D2), PieceColor.WHITE);
        wp5 = new Pawn(chessboard.getSquare(Position.E2), PieceColor.WHITE);
        wp6 = new Pawn(chessboard.getSquare(Position.F2), PieceColor.WHITE);
        wp7 = new Pawn(chessboard.getSquare(Position.G2), PieceColor.WHITE);
        wp8 = new Pawn(chessboard.getSquare(Position.H2), PieceColor.WHITE);

        bp1 = new Pawn(chessboard.getSquare(Position.A7), PieceColor.BLACK);
        bp2 = new Pawn(chessboard.getSquare(Position.B7), PieceColor.BLACK);
        bp3 = new Pawn(chessboard.getSquare(Position.C7), PieceColor.BLACK);
        bp4 = new Pawn(chessboard.getSquare(Position.D7), PieceColor.BLACK);
        bp5 = new Pawn(chessboard.getSquare(Position.E7), PieceColor.BLACK);
        bp6 = new Pawn(chessboard.getSquare(Position.F7), PieceColor.BLACK);
        bp7 = new Pawn(chessboard.getSquare(Position.G7), PieceColor.BLACK);
        bp8 = new Pawn(chessboard.getSquare(Position.H7), PieceColor.BLACK);


        wr1 = new Rook(chessboard.getSquare(Position.A1), PieceColor.WHITE);
        wr2 = new Rook(chessboard.getSquare(Position.H1), PieceColor.WHITE);
        br1 = new Rook(chessboard.getSquare(Position.A8), PieceColor.BLACK);
        br2 = new Rook(chessboard.getSquare(Position.H8), PieceColor.BLACK);

        wk1 = new Knight(chessboard.getSquare(Position.B1), PieceColor.WHITE);
        wk2 = new Knight(chessboard.getSquare(Position.G1), PieceColor.WHITE);
        bk1 = new Knight(chessboard.getSquare(Position.B8), PieceColor.BLACK);
        bk2 = new Knight(chessboard.getSquare(Position.G8), PieceColor.BLACK);

        wb1 = new Bishop(chessboard.getSquare(Position.C1), PieceColor.WHITE);
        wb2 = new Bishop(chessboard.getSquare(Position.F1), PieceColor.WHITE);
        bb1 = new Bishop(chessboard.getSquare(Position.C8), PieceColor.BLACK);
        bb2 = new Bishop(chessboard.getSquare(Position.F8), PieceColor.BLACK);

        wq = new Queen(chessboard.getSquare(Position.D1), PieceColor.WHITE);
        bq = new Queen(chessboard.getSquare(Position.D8), PieceColor.BLACK);

        wk = new King(chessboard.getSquare(Position.E1), PieceColor.WHITE);
        bk = new King(chessboard.getSquare(Position.E8), PieceColor.BLACK);




    }
    private void clearIndicators() {

        setIndicatorVisibility(indicatorA1, indicatorA2, indicatorA3, indicatorA4, indicatorA5, indicatorA6, indicatorA7, indicatorA8, indicatorB1, indicatorB2, indicatorB3, indicatorB4, indicatorB5, indicatorB6, indicatorB7, indicatorB8, indicatorC1, indicatorC2, indicatorC3, indicatorC4, indicatorC5, indicatorC6, indicatorC7, indicatorC8, indicatorD1, indicatorD2, indicatorD3, indicatorD4, indicatorD5, indicatorD6, indicatorD7, indicatorD8, false);
        setIndicatorVisibility(indicatorE1, indicatorE2, indicatorE3, indicatorE4, indicatorE5, indicatorE6, indicatorE7, indicatorE8, indicatorF1, indicatorF2, indicatorF3, indicatorF4, indicatorF5, indicatorF6, indicatorF7, indicatorF8, indicatorG1, indicatorG2, indicatorG3, indicatorG4, indicatorG5, indicatorG6, indicatorG7, indicatorG8, indicatorH1, indicatorH2, indicatorH3, indicatorH4, indicatorH5, indicatorH6, indicatorH7, indicatorH8, false);


    }

    private void setIndicatorVisibility(Shape indicatorE1, Shape indicatorE2, Shape indicatorE3, Shape indicatorE4, Shape indicatorE5, Shape indicatorE6, Shape indicatorE7, Shape indicatorE8, Shape indicatorF1, Shape indicatorF2, Shape indicatorF3, Shape indicatorF4, Shape indicatorF5, Shape indicatorF6, Shape indicatorF7, Shape indicatorF8, Shape indicatorG1, Shape indicatorG2, Shape indicatorG3, Shape indicatorG4, Shape indicatorG5, Shape indicatorG6, Shape indicatorG7, Shape indicatorG8, Shape indicatorH1, Shape indicatorH2, Shape indicatorH3, Shape indicatorH4, Shape indicatorH5, Shape indicatorH6, Shape indicatorH7, Shape indicatorH8, Boolean visibility) {
        setVisibility(indicatorE1, indicatorE2, indicatorE3, indicatorE4, indicatorE5, indicatorE6, indicatorE7, indicatorE8, visibility);
        setVisibility(indicatorF1, indicatorF2, indicatorF3, indicatorF4, indicatorF5, indicatorF6, indicatorF7, indicatorF8, visibility);
        setVisibility(indicatorG1, indicatorG2, indicatorG3, indicatorG4, indicatorG5, indicatorG6, indicatorG7, indicatorG8, visibility);
        setVisibility(indicatorH1, indicatorH2, indicatorH3, indicatorH4, indicatorH5, indicatorH6, indicatorH7, indicatorH8, visibility);
    }

    private void setVisibility(Shape i1, Shape i2, Shape i3, Shape i4, Shape i5, Shape i6, Shape i7, Shape i8, Boolean visibility) {
        i1.setVisible(visibility);
        i2.setVisible(visibility);
        i3.setVisible(visibility);
        i4.setVisible(visibility);
        i5.setVisible(visibility);
        i6.setVisible(visibility);
        i7.setVisible(visibility);
        i8.setVisible(visibility);
    }

    private void setPieceLocation(int row, int column, Shape piece) {
        boolean found = false;

        row = 7 - row;

        while (!found) {
            for (int i = 0; i < whitePawns.length; i++) {
                if (piece.equals(whitePawns[i])) {
                    whitePawnsArray[i].setPosition(chessboard.getSquare(row, column), whitePawnsArray[i]);
                    move(whitePawns[i], row, column);
                    found = true;

                }
            }
            for (int i = 0; i < blackPawns.length; i++) {
                if (piece.equals(blackPawns[i])) {
                    blackPawnsArray[i].setPosition(chessboard.getSquare(row, column), blackPawnsArray[i]);
                    move(blackPawns[i], row, column);
                    found = true;
                }
            }
            for (int i = 0; i < whiteKnights.length; i++) {
                if (piece.equals(whiteKnights[i])) {
                    whiteKnightsArray[i].setPosition(chessboard.getSquare(row, column), whiteKnightsArray[i]);
                    move(whiteKnights[i], row, column);
                    found = true;

                }
            }
            for (int i = 0; i < blackKnights.length; i++) {
                if (piece.equals(blackKnights[i])) {
                    blackKnightsArray[i].setPosition(chessboard.getSquare(row, column), blackKnightsArray[i]);
                    move(blackKnights[i], row, column);
                    found = true;
                }
            }
            for (int i = 0; i < whiteBishops.length; i++) {
                if (piece.equals(whiteBishops[i])) {
                    whiteBishopsArray[i].setPosition(chessboard.getSquare(row, column), whiteBishopsArray[i]);
                    move(whiteBishops[i], row, column);
                    found = true;
                }
            }
            for (int i = 0; i < blackBishops.length; i++) {
                if (piece.equals(blackBishops[i])) {
                    blackBishopsArray[i].setPosition(chessboard.getSquare(row, column), blackBishopsArray[i]);
                    move(blackBishops[i], row, column);
                    found = true;
                }
            }
            for (int i = 0; i < whiteRooks.length; i++) {
                if (piece.equals(whiteRooks[i])) {
                    whiteRooksArray[i].setPosition(chessboard.getSquare(row, column), whiteRooksArray[i]);
                    move(whiteRooks[i], row, column);
                    found = true;
                }
            }
            for (int i = 0; i < blackRooks.length; i++) {
                if (piece.equals(blackRooks[i])) {
                    blackRooksArray[i].setPosition(chessboard.getSquare(row, column), blackRooksArray[i]);
                    move(blackRooks[i], row, column);
                    found = true;

                }
            }
            if (piece.equals(whiteQueen)) {
                wq.setPosition(chessboard.getSquare(row, column), wq);

                wq.outputAvailableMoves();
                move(whiteQueen, row, column);
                found = true;
            } else if (piece.equals(blackQueen)) {
                bq.setPosition(chessboard.getSquare(row, column), bq);
                move(blackQueen, row, column);
                found = true;
            } else if (piece.equals(whiteKing)) {
                wk.setPosition(chessboard.getSquare(row, column), wk);
                move(whiteKing, row, column);
                found = true;
            } else if (piece.equals(blackKing)) {
                bk.setPosition(chessboard.getSquare(row, column), bk);
                move(blackKing, row, column);
                found = true;
            }
        }
    }

    private void move(Shape piece, int row, int column) {
        chessBoardGrid.getChildren().remove(piece);
        chessBoardGrid.add(piece, column, row);

    }

    private void movePiece(int fromRow, int fromColumn, int toRow, int toColumn) {
        Shape piece = chessPieces[fromRow][fromColumn];
        if (piece != null) {
            setPieceLocation(toRow, toColumn, piece);
            chessPieces[fromRow][fromColumn] = null;
            chessPieces[toRow][toColumn] = piece;
        }
    }

    private List<Square> getAvailableMoves(Shape piece) {

        List<Square> blankMoves = new ArrayList<>();
        if(whitesTurn) {
            for (int i = 0; i < whitePawns.length; i++) {
                if (piece.equals(whitePawns[i])) {
                    return whitePawnsArray[i].getAvailableMoves();
                }
            }
            for (int i = 0; i < whiteKnights.length; i++) {
                if (piece.equals(whiteKnights[i])) {
                    return whiteKnightsArray[i].getAvailableMoves();
                }
            }

            for (int i = 0; i < whiteBishops.length; i++) {
                if (piece.equals(whiteBishops[i])) {
                    return whiteBishopsArray[i].getAvailableMoves();
                }
            }
            for (int i = 0; i < whiteRooks.length; i++) {
                if (piece.equals(whiteRooks[i])) {
                    return whiteRooksArray[i].getAvailableMoves();
                }
            }
            if (piece.equals(whiteQueen)) {
                return wq.getAvailableMoves();
            } else if (piece.equals(whiteKing)) {
                return wk.getAvailableMoves();
            }
        }
        else {
            for (int i = 0; i < blackPawns.length; i++) {
                if (piece.equals(blackPawns[i])) {
                    return blackPawnsArray[i].getAvailableMoves();
                }
            }

            for (int i = 0; i < blackKnights.length; i++) {
                if (piece.equals(blackKnights[i])) {
                    return blackKnightsArray[i].getAvailableMoves();
                }
            }

            for (int i = 0; i < blackBishops.length; i++) {
                if (piece.equals(blackBishops[i])) {
                    return blackBishopsArray[i].getAvailableMoves();
                }
            }

            for (int i = 0; i < blackRooks.length; i++) {
                if (piece.equals(blackRooks[i])) {
                    return blackRooksArray[i].getAvailableMoves();
                }
            }

            if (piece.equals(blackQueen)) {
                return bq.getAvailableMoves();
            } else if (piece.equals(blackKing)) {
                return bk.getAvailableMoves();
            }
        }

        return blankMoves; //necessary in case player clicks on piece when it is not their turn

    }

    public ArrayList<Tuple> getListOfGridMoves(List<Square> list) {

        ArrayList<Tuple> coordinates = new ArrayList<>();

        for (Square square : list) {
            int row = letterToInt(square.getKey());
            int column = square.getValue() - 1;

            Tuple coordinate = new Tuple(row, column);
            coordinates.add(coordinate);
        }


        return coordinates;
    }

    private void showMoves(ArrayList<Tuple> coordinates) {

        clearIndicators();

        for (Tuple coordinate: coordinates) {
            if(coordinate.getRow() == 0){
                indicatorsRow1[coordinate.getColumn()].setVisible(true);
            }
            else if(coordinate.getRow() == 1){
                indicatorsRow2[coordinate.getColumn()].setVisible(true);
            }
            else if(coordinate.getRow() == 2){
                indicatorsRow3[coordinate.getColumn()].setVisible(true);
            }
            else if(coordinate.getRow() == 3){
                indicatorsRow4[coordinate.getColumn()].setVisible(true);
            }
            else if(coordinate.getRow() == 4){
                indicatorsRow5[coordinate.getColumn()].setVisible(true);
            }
            else if(coordinate.getRow() == 5){
                indicatorsRow6[coordinate.getColumn()].setVisible(true);
            }
            else if(coordinate.getRow() == 6){
                indicatorsRow7[coordinate.getColumn()].setVisible(true);
            }
            else if(coordinate.getRow() == 7){
                indicatorsRow8[coordinate.getColumn()].setVisible(true);
            }
        }
    }

    public Integer letterToInt(Character character) {
        character = Character.toUpperCase(character);
        switch (character) {
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
    private void handleShapeClick(MouseEvent event){

        showMoves(getListOfGridMoves(getAvailableMoves((Shape) event.getSource())));
        currentlySelectedShape = (Shape) event.getSource();
    }
    @FXML
    private void handleIndicatorClick(MouseEvent event){

        Node eventNode = (Node) event.getSource();
        int row = GridPane.getRowIndex(eventNode);
        int column = GridPane.getColumnIndex(eventNode);

        checkIfCapture(row, column, eventNode);


        setPieceLocation(7- row, column, currentlySelectedShape);
        clearIndicators();
        whitesTurn = !whitesTurn; //flips turn
    }

    private void checkIfCapture(int row, int column, Node indicator) {



        for (Node child: chessBoardGrid.getChildren()) {

            if (GridPane.getRowIndex(child) != null && GridPane.getColumnIndex(child) != null && child != null) {
                int rowOfChild = GridPane.getRowIndex(child);
                int columnOfChild = GridPane.getColumnIndex(child);

                if (rowOfChild == row && columnOfChild == column && child != indicator && !child.isDisabled() ) {
                    chessBoardGrid.getChildren().remove(child);
                    OccupiedSquares.removeOccupiedSquare(chessboard.getSquare(row, column));
                    if(child.equals(whiteKing) || child.equals(blackKing)){
                        checkmate();
                    }
                    break;
                }
            }
        }
    }

    private void checkmate() {


    }
}
