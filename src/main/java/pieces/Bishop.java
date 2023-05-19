package pieces;

import board.OccupiedSquares;
import board.Square;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class Bishop extends Piece {

    public Bishop(Square position, Color color) {
        super(position, color);
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
        System.out.println("Bishop moves: ");
        List < Square > moves = new ArrayList < > (getAvailableMoves());

        for (Square move: moves) {
            System.out.print(move.getKey().toString() + move.getValue() + " ");
        }
        System.out.println(" ");

    }
    @Override
    public List < Square > getAvailableMoves() {
        List < Square > moves = new ArrayList <> ();

        moves.addAll(getUpperRightMoves());
        moves.addAll(getLowerRightMoves());

        moves.addAll(getUpperLeftMoves());
        moves.addAll(getLowerLeftMoves());

        return moves;
    }

    @Override
    public List < Square > getDiagonalMoves() {
        return getAvailableMoves();
    }
    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public List < Square > getHorizontalMoves() {
        return null;
    }

    @Override
    public List < Square > getVerticalMoves() {
        return null;
    }

    private Collection<? extends Square> getMoves(int keyOffset, int valueOffset) {
        Square move = currentPosition;
        char newKey = (char) (move.getKey() + keyOffset);
        move = new Square(Map.entry(newKey, move.getValue() + valueOffset));

        List<Square> moves = new ArrayList<>();

        while (isValidMove(move)) {
            newKey = (char) (move.getKey() + keyOffset);
            moves.add(move);

            if (OccupiedSquares.isOccupied(move)) {
                if(!OccupiedSquares.getOccupantColor(move).equals(this.color)){
                    break;
                }
            }

            move = new Square(Map.entry(newKey, move.getValue() + valueOffset));
        }

        return moves;
    }

    @Override
    public boolean isValidMove(Square move) {
        boolean isOccupied = OccupiedSquares.isOccupied(move);
        boolean isOccupiedByAlly = isOccupied && OccupiedSquares.getOccupantColor(move).equals(this.color);
        boolean isWithinBoundary = (move.getValue() < 9 && move.getValue() > 0) &&
                (move.getKey() <= 'h' && move.getKey() >= 'a');

        return (!isOccupied && isWithinBoundary) || (isOccupied && !isOccupiedByAlly && isWithinBoundary);
    }


    private Collection < ? extends Square > getUpperLeftMoves() {
        return getMoves(-1, 1);
    }

    private Collection < ? extends Square > getLowerLeftMoves() {
        return getMoves(-1, -1);
    }

    private Collection < ? extends Square > getLowerRightMoves() {
        return getMoves(1, -1);
    }

    private Collection < ? extends Square > getUpperRightMoves() {
        return getMoves(1, 1);
    }


    @Override
    public Color getColor() {
        return this.color;
    }

}