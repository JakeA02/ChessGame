package pieces;

import board.*;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;

public class Pawn extends Piece {

    private Color color;

    public Pawn(Square position, Color color) {
        super(position, color);
    }

    @Override
    public boolean isValidMove(Square move) {

        boolean isOccupied = OccupiedSquares.isOccupied(move);

        boolean isWithinBoundary = (move.getPosition().getKey() <= 'h' && move.getPosition().getKey() >= 'a') &&
                (move.getPosition().getValue() < 9 && move.getPosition().getValue() > 0);

        return ((!isOccupied && isWithinBoundary));
    }
    @Override
    public List < Square > getAvailableMoves() {
        List < Square > moves = new ArrayList <> ();

        moves.addAll(getDiagonalMoves());
        moves.addAll(getVerticalMoves());

        return moves;
    }
    public List<Square> getDiagonalMoves() {
        List<Square> moves = new ArrayList<>();

        char rightKey = (char) (currentPosition.getKey() - 1);
        char leftKey = (char) (currentPosition.getKey() + 1);
        int yOffset = (this.color == Color.BLACK) ? -1 : 1;

        Square rightDiagonal = new Square(Map.entry(rightKey, currentPosition.getValue() + yOffset));
        Square leftDiagonal = new Square(Map.entry(leftKey, currentPosition.getValue() + yOffset));

        if (OccupiedSquares.isOccupied(rightDiagonal)) {
            if(!OccupiedSquares.getOccupantColor(rightDiagonal).equals(this.color)) {

                moves.add(rightDiagonal);
            }
        }

        if (OccupiedSquares.isOccupied(leftDiagonal)) {
            if (!OccupiedSquares.getOccupantColor(leftDiagonal).equals(this.color)) {
                moves.add(leftDiagonal);
            }
        }

        return moves;
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
        String position = currentPosition.getKey().toString() + currentPosition.getValue().toString();
        boolean startingPosition = false;

        List < Square > moves = new ArrayList < > ();

        EnumSet < WhiteStartingPawnPositions > startingPawnPositions;

        startingPawnPositions = EnumSet.allOf(WhiteStartingPawnPositions.class);

        for (Enum < ? > enumValue : startingPawnPositions) {
            if (position.equalsIgnoreCase(enumValue.name())) {
                startingPosition = true;
                break;
            }
        }

        if (startingPosition && canDoubleJump()) {
            moves.add(new Square(Map.entry(currentPosition.getPosition().getKey(),
                    currentPosition.getPosition().getValue() + (color.equals(Color.WHITE) ? 1 : -1))));
            moves.add(new Square(Map.entry(currentPosition.getPosition().getKey(),
                    currentPosition.getPosition().getValue() + (color.equals(Color.WHITE) ? 2 : -2))));
        } else {
            if (canSingleJump()) {
                moves.add(new Square(Map.entry(currentPosition.getPosition().getKey(), currentPosition.getPosition().getValue() + (color.equals(Color.WHITE) ? 1 : -1))));
            }
        }

        return moves;
    }

    public boolean canDoubleJump() {
        Square twoJumpPosition;

        if (color.equals(Color.WHITE)) {
            twoJumpPosition = new Square(Map.entry(currentPosition.getPosition().getKey(), currentPosition.getPosition().getValue() + 2));
            return (currentPosition.getPosition().getValue() + 2) < 9 && !OccupiedSquares.isOccupied(twoJumpPosition) && canSingleJump();

        } else {
            twoJumpPosition = new Square(Map.entry(currentPosition.getPosition().getKey(), currentPosition.getPosition().getValue() - 2));
            return currentPosition.getPosition().getValue() - 2 > 0 && !OccupiedSquares.isOccupied(twoJumpPosition) && canSingleJump();
        }
    }

    private boolean canSingleJump() {
        Square oneJumpPosition;

        if (color.equals(Color.WHITE)) {
            oneJumpPosition = new Square(Map.entry(currentPosition.getPosition().getKey(), currentPosition.getPosition().getValue() + 1));
            return (currentPosition.getPosition().getValue() + 2) < 9 && !OccupiedSquares.isOccupied(oneJumpPosition);

        } else {
            oneJumpPosition = new Square(Map.entry(currentPosition.getPosition().getKey(), currentPosition.getPosition().getValue() - 1));
            return currentPosition.getPosition().getValue() - 2 > 0 && !OccupiedSquares.isOccupied(oneJumpPosition);
        }
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
    public Color getColor() {
        return this.color;
    }

    @Override
    public Square getPosition() {
        return currentPosition;
    }

    @Override
    public void outputAvailableMoves() {
        System.out.println("Pawn moves: ");
        List < Square > moves = new ArrayList < > (getAvailableMoves());

        for (Square move: moves) {
            System.out.print(move.getPosition().getKey().toString() + move.getPosition().getValue() + " ");
        }
        System.out.println(" ");
    }
}