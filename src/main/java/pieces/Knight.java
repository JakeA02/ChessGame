package pieces;

import board.OccupiedSquares;
import board.Square;

import java.util.*;

public class Knight extends Piece {

    private PieceColor color;
    public Knight(Square position, PieceColor color) {
        super(position, color);

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
        List < Integer > xOffsetList = Arrays.asList(-1, 1, -2, 2, -1, 1, -2, 2);
        List < Integer > yOffsetList = Arrays.asList(2, 2, 1, 1, -2, -2, -1, -1);

        List < Square > moves = new ArrayList < > ();

        for (int i = 0; i < xOffsetList.size(); i++) {
            int xOffset = xOffsetList.get(i);
            int yOffset = yOffsetList.get(i);
            moves.addAll(getMoves(xOffset, yOffset));
        }

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
    public List < Square > getHorizontalMoves() {
        return null;
    }

    @Override
    public List < Square > getVerticalMoves() {
        return null;
    }
    @Override
    public PieceColor getColor() {
        return color;
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

    private List < Square > getMoves(int keyOffset, int valueOffset) {
        int keyAsInt = currentPosition.getPosition().getKey();
        char newKey = (char)(keyAsInt + keyOffset);
        int newValue = currentPosition.getValue() + valueOffset;

        Square move = new Square(Map.entry(newKey, newValue));

        List < Square > moves = new ArrayList < > ();

        if (isValidMove(move)) {

            moves.add(move);
        }

        return moves;
    }

    @Override
    public void outputAvailableMoves() {
        System.out.println("Knight moves: ");

        List < Square > moves = new ArrayList < > (getAvailableMoves());

        for (Square move: moves) {
            System.out.print(move.getKey().toString() + move.getValue() + " ");
        }
        System.out.println(" ");
    }
}