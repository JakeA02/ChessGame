package pieces;

import board.OccupiedSquares;
import board.Square;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Rook extends Piece {

    public Rook(Square position, PieceColor color) {
        super(position, color);

    }
    @Override
    public PieceColor getColor() {
        return this.color;
    }

    @Override
    public boolean isValidMove(Square move) {
        boolean isOccupied = OccupiedSquares.isOccupied(move);
        boolean isOccupiedByAlly = isOccupied && OccupiedSquares.getOccupantColor(move).equals(this.color);
        boolean isWithinBoundary = (move.getValue() < 9 && move.getValue() > 0) &&
                (move.getKey() <= 'h' && move.getKey() >= 'a');

        return (!isOccupied && isWithinBoundary) || (isOccupied && !isOccupiedByAlly && isWithinBoundary);
    }

    @Override
    public List < Square > getAvailableMoves() {
        List < Square > moves = new ArrayList < > ();
        moves.addAll(getHorizontalMoves());
        moves.addAll(getVerticalMoves());
        return moves;

    }

    @Override
    public List < Square > getDiagonalMoves() {
        return null;
    }

    @Override
    public void setColor(PieceColor color) {
        this.color = color;
    }

    @Override
    public List < Square > getVerticalMoves() {
        Square move = currentPosition;
        Square newMove = new Square(Map.entry(move.getKey(), move.getValue() + 1));
        move = newMove;
        List < Square > moves = new ArrayList < > ();

        while (isValidMove(move)) { //up
            int newValue = move.getValue() + 1;
            newMove = new Square(Map.entry(move.getKey(), newValue));
            moves.add(move);


            if (OccupiedSquares.isOccupied(move)) {
                if(enemySquare(move)){
                    break;
                }
            }
            move = newMove;
        }

        move = currentPosition;
        newMove = new Square(Map.entry(move.getKey(), move.getValue() - 1));
        move = newMove;

        while (isValidMove(move)) { //down
            int newValue = move.getValue() - 1;
            newMove = new Square(Map.entry(move.getKey(), newValue));
            moves.add(move);

            if (OccupiedSquares.isOccupied(move)) {
                if(enemySquare(move)){
                    break;
                }
            }
            move = newMove;
        }

        return moves;
    }

    @Override
    public List < Square > getHorizontalMoves() {
        Square move = currentPosition;
        int keyAsInt = move.getKey();
        char newKey = (char)(keyAsInt - 1);

        move = new Square(Map.entry(newKey, move.getValue()));

        List < Square > moves = new ArrayList < > ();

        while (isValidMove(move)) {
            keyAsInt = move.getKey(); // Convert character to integer
            newKey = (char)(keyAsInt - 1); // Increment the integer and convert it back to character
            moves.add(move);

            if (OccupiedSquares.isOccupied(move)) {
                if(enemySquare(move)){
                    break;
                }
            }

            move = new Square(Map.entry(newKey, move.getValue()));
        }

        move = currentPosition;
        keyAsInt = move.getKey(); // Convert character to integer
        newKey = (char)(keyAsInt + 1);
        move = new Square(Map.entry(newKey, move.getValue()));

        while (isValidMove(move)) {
            keyAsInt = move.getKey(); // Convert character to integer
            newKey = (char)(keyAsInt + 1); // Increment the integer and convert it back to character
            moves.add(move);

            if (OccupiedSquares.isOccupied(move)) {
                if(enemySquare(move)){
                    break;
                }
            }

            move = new Square(Map.entry(newKey, move.getValue()));

        }

        return moves;

    }

    public boolean enemySquare(Square square){
        return !OccupiedSquares.getOccupantColor(square).equals(this.color);
    }
    @Override
    public void setPosition(Square position, Piece piece) {

        if (currentPosition != null) {
            OccupiedSquares.removeOccupiedSquare(currentPosition);
        }
        this.currentPosition = position;
        OccupiedSquares.addOccupiedSquare(position, piece);
    }
    @Override
    public Square getPosition() {
        return currentPosition;
    }

    @Override
    public void outputAvailableMoves() {
        System.out.println("Rook moves: ");
        List < Square > moves = new ArrayList < > (getAvailableMoves());

        for (Square move: moves) {
            System.out.print(move.getKey().toString() + move.getValue() + " ");
        }
        System.out.println(" ");
    }


}