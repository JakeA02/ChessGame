package pieces;

import board.OccupiedSquares;
import board.Square;

import java.util.*;

public class King extends Piece {

    public King(Square position, Color color) {
        super(position, color);
    }

    @Override
    public boolean isValidMove(Square move) {

        boolean isOccupied = OccupiedSquares.isOccupied(move);
        boolean isWithinBoundary = (move.getPosition().getKey() <= 'h' && move.getPosition().getKey() >= 'a') &&
                (move.getPosition().getValue() < 9 && move.getPosition().getValue() > 0);
        boolean isOccupiedByEnemy = false;

        if(isOccupied){
            isOccupiedByEnemy = !OccupiedSquares.getOccupantColor(move).equals(this.color);
        }

        return ((!isOccupied && isWithinBoundary) || isOccupied && isWithinBoundary && isOccupiedByEnemy);
    }

    @Override
    public List < Square > getAvailableMoves() {
        List < Square > moves = new ArrayList < > ();

        moves.addAll(getDiagonalMoves());
        moves.addAll(getHorizontalMoves());
        moves.addAll(getVerticalMoves());

        return moves;

    }

    @Override
    public List < Square > getDiagonalMoves() {
        List < Square > moves = new ArrayList < > ();

        moves.addAll(getLowerRightMoves());
        moves.addAll(getUpperRightMoves());
        moves.addAll(getUpperLeftMoves());
        moves.addAll(getLowerLeftMoves());

        return moves;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public List < Square > getHorizontalMoves() {

        List < Square > moves = new ArrayList < > ();

        int keyAsInt = currentPosition.getPosition().getKey();
        char leftKey = (char)(keyAsInt - 1);
        char rightKey = (char)(keyAsInt + 1);

        Square leftMove = new Square(Map.entry(leftKey, currentPosition.getPosition().getValue()));
        Square rightMove = new Square(Map.entry(rightKey, currentPosition.getPosition().getValue()));

        if (isValidMove(leftMove)) {
            moves.add(leftMove);
        }
        if (isValidMove(rightMove)) {
            moves.add(rightMove);
        }
        return moves;
    }

    @Override
    public List < Square > getVerticalMoves() {

        List < Square > moves = new ArrayList < > ();

        Square upOne = new Square(Map.entry(currentPosition.getPosition().getKey(), currentPosition.getPosition().getValue() + 1));
        Square downOne = new Square(Map.entry(currentPosition.getPosition().getKey(), currentPosition.getPosition().getValue() - 1));

        if (isValidMove(upOne)) {
            moves.add(upOne);
        }
        if (isValidMove(downOne)) {
            moves.add(upOne);
        }

        return moves;

    }

    private Collection < ? extends Square > getDiagonalMoves(int keyOffset, int valueOffset) {

        Square move = currentPosition;

        char newKey = (char)(move.getPosition().getKey() + keyOffset);
        move = new Square(Map.entry(newKey, move.getPosition().getValue() + valueOffset));

        List < Square > moves = new ArrayList < > ();

        if (isValidMove(move)) {
            moves.add(move);
        }

        return moves;
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

        System.out.println("King moves: ");

        List < Square > moves = new ArrayList < > (getAvailableMoves());

        for (Square move: moves) {
            System.out.print(move.getKey().toString() + move.getValue() + " ");
        }
        System.out.println(" ");
    }

    private Collection < ? extends Square > getUpperLeftMoves() {

        return getDiagonalMoves(-1, 1);
    }

    private Collection < ? extends Square > getLowerLeftMoves() {
        return getDiagonalMoves(-1, -1);
    }

    private Collection < ? extends Square > getLowerRightMoves() {
        return getDiagonalMoves(1, -1);
    }

    private Collection < ? extends Square > getUpperRightMoves() {
        return getDiagonalMoves(1, 1);
    }

}